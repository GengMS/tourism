package com.xinhua.geng;

import com.alibaba.fastjson.JSON;
import com.xinhua.geng.util.EmailUtil;
import org.springframework.data.redis.connection.stream.MapRecord;
import org.springframework.data.redis.stream.StreamListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: geng
 * @Date: 2021/5/31 8:27
 */
@Component
public class ListenerMessage implements StreamListener<String, MapRecord<String, String, String>> {
    @Override
    public void onMessage(MapRecord<String, String, String> message) {
        // TODO 自动生成的方法存根
        List<String> to = JSON.parseArray(message.getValue().get("addres"),String.class);
        Pattern p=Pattern.compile( "(?<=\").*?(?=\")");
        System.out.println(to.get(1).replaceAll(",",""));
        Matcher m=p.matcher(to.get(1).replaceAll(",",""));
        List<String> toArray = new ArrayList<>();
        Integer index = 1;
        while (m.find()){
            if(index %2 == 1){
                toArray.add(m.group());
            }
            index++;
        }
        String[] go = new String[toArray.size()];
        go = toArray.toArray(go);
        System.out.println(Arrays.toString(go));
        EmailUtil.sendSimpleMail(go,message.getValue().get("theme"),message.getValue().get("content"));
    }
}