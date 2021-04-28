package com.xinhua.geng.until;

import com.roncoo.common.MyException;
import com.roncoo.fastdfs.StorageClient;
import com.xinhua.geng.config.FastDfsConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;

/**
 * @Author: geng
 * @Date: 2021/4/6 11:50
 */

public class FastDfsUrlToHttp {

    private static final   String  storage_nginx_server = "192.168.112.145:8888" ;

    private static StorageClient storageClient;
    static {

            try {
                storageClient = FastDfsConfig.storageClientBuild();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (MyException e) {
                e.printStackTrace();
            }

    }

    public static String FastDfsUrlToHttp(MultipartFile file) throws IOException, MyException {
        String[] fasts = storageClient.upload_file(file.getBytes(),"jpeg",null);
        String imgUrl = "http://"+storage_nginx_server+"/"+ Arrays.toString(fasts).replace("[","").replace(" ","").replace("]","").replace(",","/");

        return imgUrl;
    }
}
