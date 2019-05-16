package com.apache.dubbo.remoting.zookeeper;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.ExtensionLoader;
import org.apache.dubbo.remoting.zookeeper.ZookeeperClient;
import org.apache.dubbo.remoting.zookeeper.ZookeeperTransporter;

/**
 * @author zkn
 * @date 2018/7/21 14:42
 **/
public class ZookeeperTransporter$Adaptive implements ZookeeperTransporter {

    @Override
    public ZookeeperClient connect(URL arg0) {
        if (arg0 == null) throw new IllegalArgumentException("url == null");
        URL url = arg0;
        String extName = url.getParameter("client", url.getParameter("transporter", "curator"));
        if (extName == null)
            throw new IllegalStateException("Fail to get extension(com.apache.dubbo.remoting.zookeeper.ZookeeperTransporter) name from url(" + url.toString() + ") use keys([client, transporter])");
        ZookeeperTransporter extension = (ZookeeperTransporter) ExtensionLoader.getExtensionLoader(ZookeeperTransporter.class).getExtension(extName);
        return extension.connect(arg0);
    }
}
