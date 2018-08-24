package com.spider;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.commons.lang3.StringUtils;

import com.util.SpiderFormateFile;
import com.util.SpiderPropertiesUtil;

@WebListener
public class SpiderGo implements ServletContextListener{
	static {
		try {
        	String a,b,c;
        	a=SpiderPropertiesUtil.class.getResource("").getPath();
        	System.out.println("·��3="+a);
        	b=StringUtils.substringBeforeLast(a, "class");
        	System.out.println("·��b="+b);
        	c=b+"classes/";
        	String name="application2";
        	String fulName=name+".properties";
//        	String address="e:\\application2.properties";
        	String address=c+fulName;
        	System.out.println("·��address="+address);
			SpiderRetrivePage.downloadPage("http://localhost:8000/"+name+"-dev.properties",address);
			File src = new File(address);
			System.out.println("�ļ�·��2"+src.getCanonicalFile());
			String cont = SpiderFormateFile.read(address);
			 System.out.println(cont);
			  //�Եõ������ݽ��д���
			  cont = cont.replaceAll(": ", "=");
			  System.out.println(cont);
			  //����Դ�ļ�
			  System.out.println(SpiderFormateFile.write(cont, src));
			  
			  SpiderPropertiesUtil.prop = new Properties();
          
//             prop.load(new FileInputStream(new File("E:\\application2.properties")));
             
            SpiderPropertiesUtil.prop.load(SpiderPropertiesUtil.class.getClassLoader().getResourceAsStream(fulName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
 
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
		
	}
	

}
