const request = require('request-promise')
const iconv = require('iconv-lite')
const cheerio = require('cheerio')
const md5 = require('md5')
const path = require('path')
const fs = require('fs')
const retry = require('async-retry')

const special = require('./special')

function sleep(time) {
	return new Promise(resolve => {
		console.log(`sleep: ${time}`)
		setTimeout(() => {
			resolve()
		}, time)
	})
}

async function getPage(url, returnMeta = false) {
	let content = ''
	let isCache = false
	const id = md5(url)
	const file = `./temp/${id}.html`
	if (fs.existsSync(file)) {
		content = fs.readFileSync(file, 'utf-8')
		isCache = true
	} else {

		await retry(async bail => {
			try {
				const rs = await request(url, {
					resolveWithFullResponse: true,
					encoding: null,
				})

				content = iconv.decode(rs.body, 'gb2312')
				fs.writeFileSync(file, content)
				return true
			} catch (e) {
				// bail(new Error('FAIL'))
			}
		}, {
			retries: 50,
			minTimeout: 5000,
			onRetry: function () {
				console.log('retry')
			}
		})

	}
	if (returnMeta) {
		return {
			isCache,
			content
		}
	} else {
		return content
	}
}

;
(async() => {
	try {

	} catch (e) {
		console.log(e)
	}
	const cityIds = []
	const rs = {
		'86': {}
	}
	const level0 = await getPage(
		'http://www.stats.gov.cn/tjsj/tjbz/tjyqhdmhcxhfdm/2019/index.html')
	const $ = cheerio.load(level0)
	const list = $('.provincetr td a')
	const provinces = []
	const urls = []
	list.each((index, el) => {
		const url =
			`http://www.stats.gov.cn/tjsj/tjbz/tjyqhdmhcxhfdm/2019/${$(el).attr('href')}`
		const data = {
			id: $(el).attr('href').split('.')[0] + '0000',
			name: $(el).text()
		}
		rs['86'][data.id] = data.name
		urls.push(url)
	})

	const specialProvinces = {
		"710000": "台湾省",
		"810000": "香港特别行政区",
		"820000": "澳门特别行政区"
	}

	Object.assign(rs['86'], specialProvinces)

	// 市
	for (const url of urls) {
		const level1 = await getPage(url)
		const $ = cheerio.load(level1)
		const list = $('.citytr td a')
		const countyUrls = []
		list.each(async(index, el) => {
			const url =
				`http://www.stats.gov.cn/tjsj/tjbz/tjyqhdmhcxhfdm/2019/${$(el).attr('href')}`
				// filter number
			const text = $(el).text()
			if (!/\d+/.test(text)) {
				const data = {
					id: $(el).attr('href').split('.')[0].slice(3) + '00',
					name: $(el).text()
				}

				const parentId = data.id.slice(0, 2) + '0000'
				if (!rs[parentId]) {
					rs[parentId] = {}
				}
				cityIds.push(data.id)
				rs[parentId][data.id] = data.name
			}
			countyUrls.push(url)
		})


		for (const url of countyUrls) {
			const level2 = await getPage(url)
			const $ = cheerio.load(level2)
			const list = $('.countytr td, .towntr td')
			let townUrls = []
			const currentUrl = url
			for (let index = 0; index < list.length; index++) {
				const { data, url } = processLinks($, list, index, currentUrl.split('/')[7] + '/')
				if (data.id) {
					console.log(data)
					if (data.isLink) {
						data.id = data.id.split('.')[0].split('/')[1]
					} else {
						data.id = data.id.replace(/0+$/g, '')
					}
					const parentId = data.id.slice(0, 4) + '00'
					if (!rs[parentId]) {
						rs[parentId] = {}
					}
					rs[parentId][data.id] = data.name
				}
				if (url) {
					townUrls.push(url)
				}
			}

			// console.log('街道数量', townUrls.length)
			// townUrls = Array.from(new Set(townUrls))
			// for (const town of townUrls) {
			// 	console.log('获取街道')
			// 	console.log('url', url, town)
			// 	console.log(url.split('/')[7])
			// 	const level3 = await getPage(town, true)
			// 	if (!level3.isCache) {
			// 		await sleep(2000)
			// 	}
			// 	const $ = cheerio.load(level3.content)
			// 	const list = $('.towntr td')
			//
			// 	for (let index = 0; index < list.length; index++) {
			// 		const { data, url } = processLinks($, list, index)
			// 		// data.id = data.id.split('/')[1].split('.')[0]
			// 		if (data.id) {
			// 			console.log(data)
			// 		}
			// 	}
			// }
		}

	}

	setInterval(() => {
		// return
		fs.writeFileSync('../data.json', JSON.stringify(Object.assign({}, rs,
			special), null, 2))
		fs.writeFileSync('./data.json', JSON.stringify(Object.assign({}, rs,
			special), null, 2))
		const _2levelCityIds = cityIds.filter(c => !Object.keys(rs[c] || {}).length)
		fs.writeFileSync('./only_2_level_city_id.json', JSON.stringify(
			_2levelCityIds, null, 2))
		console.log('done')
		// process.exit(0)
	}, 6000)
})()

function processLinks ($, list, index, linkPrefix = '') {
	const el = list[index]
	const link = $(el).find('a')
	let url
	if ($(link[0]).attr('href')) {
		url =
			`http://www.stats.gov.cn/tjsj/tjbz/tjyqhdmhcxhfdm/2019/${linkPrefix}${$(link[0]).attr('href')}`
	}
	let data = {}
	if (link.length) {
		if (!/\d+/.test($(el).text())) {
			data = {
				isLink: true,
				id: $(link[0]).attr('href'),
				name: $(el).text()
			}
		}
	} else {
		if (!/\d+/.test($(el).text())) {
			data = {
				isLink: false,
				id: $(list[index - 1]).text(),
				name: $(el).text()
			}
		}
	}
	// console.log(data, url)
	return {
		data,
		url,
	}


}
