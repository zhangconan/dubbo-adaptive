package com.apache.dubbo.rpc.cluster;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.ExtensionLoader;
import org.apache.dubbo.rpc.cluster.Configurator;
import org.apache.dubbo.rpc.cluster.ConfiguratorFactory;

/**
 * @author zkn
 * @date 2018/7/21 14:44
 **/
public class ConfiguratorFactory$Adaptive implements ConfiguratorFactory {
    @Override
    public Configurator getConfigurator(URL arg0) {
        if (arg0 == null) throw new IllegalArgumentException("url == null");
        URL url = arg0;
        String extName = url.getProtocol();
        if (extName == null)
            throw new IllegalStateException("Fail to get extension(com.apache.dubbo.rpc.cluster.ConfiguratorFactory) name from url(" + url.toString() + ") use keys([protocol])");
        ConfiguratorFactory extension = (ConfiguratorFactory) ExtensionLoader.getExtensionLoader(ConfiguratorFactory.class).getExtension(extName);
        return extension.getConfigurator(arg0);
    }
}