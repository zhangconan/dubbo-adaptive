package com.apache.dubbo.validation;


import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.ExtensionLoader;
import org.apache.dubbo.validation.Validation;
import org.apache.dubbo.validation.Validator;

/**
 * @author zkn
 * @date 2018/7/21 14:49
 **/
public class Validation$Adaptive implements Validation {
    @Override
    public Validator getValidator(URL arg0) {
        if (arg0 == null) throw new IllegalArgumentException("url == null");
        URL url = arg0;
        String extName = url.getParameter("validation", "jvalidation");
        if (extName == null)
            throw new IllegalStateException("Fail to get extension(com.apache.dubbo.validation.Validation) name from url(" + url.toString() + ") use keys([validation])");
        Validation extension = (Validation) ExtensionLoader.getExtensionLoader(Validation.class).getExtension(extName);
        return extension.getValidator(arg0);
    }
}
