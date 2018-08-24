package com.util;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;

import com.spider.SpiderRetrivePage;
 
/**
 *	Properties配置文件处理工具
 * @author wdy
 */
public class SpiderPropertiesUtil {
    // 静态块中不能有非静态属性，所以加static
    public static Properties prop = null;

 
 
    //静态方法可以被类名直接调用
    public static String getValue(String key) {
        return prop.getProperty(key);
    }
}