package com.util;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;

import com.spider.SpiderRetrivePage;
 
/**
 *	Properties�����ļ�������
 * @author wdy
 */
public class SpiderPropertiesUtil {
    // ��̬���в����зǾ�̬���ԣ����Լ�static
    public static Properties prop = null;

 
 
    //��̬�������Ա�����ֱ�ӵ���
    public static String getValue(String key) {
        return prop.getProperty(key);
    }
}