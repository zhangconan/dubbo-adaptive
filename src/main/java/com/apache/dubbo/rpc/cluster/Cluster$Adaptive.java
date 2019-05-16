package com.apache.dubbo.rpc.cluster;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.ExtensionLoader;
import org.apache.dubbo.rpc.Invoker;
import org.apache.dubbo.rpc.RpcException;
import org.apache.dubbo.rpc.cluster.Cluster;
import org.apache.dubbo.rpc.cluster.Directory;

/**
 * @author zkn
 * @date 2018/7/21 14:40
 **/
public class Cluster$Adaptive implements Cluster {
    public Invoker join(Directory arg0) throws RpcException {
        if (arg0 == null)
            throw new IllegalArgumentException("com.apache.dubbo.rpc.cluster.Directory argument == null");
        if (arg0.getUrl() == null)
            throw new IllegalArgumentException("com.apache.dubbo.rpc.cluster.Directory argument getUrl() == null");
        URL url = arg0.getUrl();
        String extName = url.getParameter("cluster", "failover");
        if (extName == null)
            throw new IllegalStateException("Fail to get extension(com.apache.dubbo.rpc.cluster.Cluster) name from url(" + url.toString() + ") use keys([cluster])");
        Cluster extension = (Cluster) ExtensionLoader.getExtensionLoader(Cluster.class).getExtension(extName);
        return extension.join(arg0);
    }
}
