package com.test;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.util.PropertiesUtil;

 
@Controller
public class HelloSpringController {
    String message = "Welcome to Spring MVC!";
//    @Value("${profile}")
     String profile=PropertiesUtil.getValue("profile");
//     String profile;
    @RequestMapping("/profile")
    public ModelAndView getProfile(){
    	 ModelAndView mv = new ModelAndView("testProperties");//ָ����ͼ
    	//����ͼ�������Ҫչʾ��ʹ�õ����ݣ�����ҳ����ʹ��
    	        mv.addObject("profile", profile);
    	        System.out.println("profile="+profile);
    	        System.out.println("PropertiesUtil.getValue(profile)="+PropertiesUtil.getValue("profile"));
    	        return mv;
    }
    
    @RequestMapping("/hello")
    public ModelAndView showMessage(@RequestParam(value = "name", required = false, defaultValue = "Spring") String name) {
 
        ModelAndView mv = new ModelAndView("hellospring");//ָ����ͼ
//����ͼ�������Ҫչʾ��ʹ�õ����ݣ�����ҳ����ʹ��
        mv.addObject("message", message);
        mv.addObject("name", name);
        return mv;
    }
}
