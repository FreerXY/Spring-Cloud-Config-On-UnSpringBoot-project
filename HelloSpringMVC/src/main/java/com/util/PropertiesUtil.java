package com.util;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
 
/**
 *	Properties�����ļ�������
 * @author wdy
 */
public class PropertiesUtil {
    // ��̬���в����зǾ�̬���ԣ����Լ�static
    private static Properties prop = null;
 
    //��̬���е����ݻ��������ص�ʱ���ȱ�ִ��
    static {
        try {
            prop = new Properties();
//             prop.load(new FileInputStream(new File("E:\\application.properties")));
            prop.load(PropertiesUtil.class.getClassLoader().getResourceAsStream("application.properties"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
 
    //��̬�������Ա�����ֱ�ӵ���
    public static String getValue(String key) {
        return prop.getProperty(key);
    }
}