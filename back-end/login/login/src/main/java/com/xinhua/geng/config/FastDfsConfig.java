package com.xinhua.geng.config;

import com.roncoo.common.MyException;
import com.roncoo.fastdfs.*;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

/**
 * @Author: geng
 * @Date: 2021/4/6 11:44
 */
@Configuration
@RefreshScope
public class FastDfsConfig {

    public static StorageClient storageClientBuild() throws IOException, MyException {
        ClientGlobal.init("fastdfs.conf");
        TrackerClient trackerClient = new TrackerClient();
        TrackerServer trackerServer = trackerClient.getTrackerServer();
        StorageServer storageServer = trackerClient.getStoreStorage(trackerServer);
        //定义storage的客户端对象，需要使用这个对象来完成具体的文件上传 下载和删除操作
        StorageClient storageClient = new StorageClient(trackerServer,storageServer);
        return storageClient;
    }
}
