package com.spring_mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * 使用@Controller注解申明这是一个基于Annotation的控制器类
 * 使用@RequestMapping()注解申明请求url及方法
 * 使用@RequestMapping(value="/\*\/pathAnt")注解申明这是一个ant风格的url请求
 */
@Controller
@RequestMapping(value = "/user")
public class HelloController {

    //创建ModelAndView对象，该对象返回视图名，模型名称及模型对象
    @RequestMapping("/hello")
    public ModelAndView hello(){
        System.out.println("这是我的基于Annotation注解的请求" + "\n");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg", "11111");
        modelAndView.setViewName("index");
        return modelAndView;
    }

    //创建ModelAndView对象，该对象返回视图名，模型名称及模型对象
    @RequestMapping(value = "/resSuccess")
    public ModelAndView resSuccess(){
        System.out.println("这是我的基于Annotation注解的成功请求返回结果" + "\n");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg", "成功返回页");
        modelAndView.setViewName("success");
        return modelAndView;
    }

    //创建ModelAndView对象，该对象返回视图名，模型名称及模型对象
    @RequestMapping(value = "/resFalse")
    public ModelAndView resFalse(){
        System.out.println("这是我的基于Annotation注解的失败请求返回结果" + "\n");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg", "失败返回页");
        modelAndView.setViewName("false");
        return modelAndView;
    }

    //
    @RequestMapping(value = "/*/pathAnt")
    public String pathAnt(){
        System.out.println("Path Ant" + "\n");
        return "redirect:/user/resSuccess";
    }

    //添加restGet()方法，处理GET方式的请求
    @RequestMapping(value = "/rest/{id}", method = RequestMethod.GET)
    public String restGet(@PathVariable("id") Integer id){
        System.out.println("Rest GET: " + id + "\n");
        return "redirect:/user/resSuccess";
    }

    //添加restPost()方法，处理POST方式的请求
    @RequestMapping(value = "/rest", method = RequestMethod.POST)
    public String restPost(){
        System.out.println("Rest POST" + "\n");
        return "redirect:/user/resFalse";
    }

    //添加restDelete()方法，处理DELETE方式的请求
    @RequestMapping(value = "/rest/{id}", method = RequestMethod.DELETE)
    public String restDelete(@PathVariable("id") Integer id){
        System.out.println("Rest DELETE: " + id + "\n");
        return "redirect:/user/doTransfer";
    }

    //restDelete()方法返回重定向地址，所以添加请求为/user/Transfer的方法
    @RequestMapping(value = "/doTransfer")
    public String doTransfer(){
        return "redirect:/user/resSuccess";
    }

    //restPut()方法，处理PUT方式的请求
    @RequestMapping(value = "/rest/{id}", method = RequestMethod.PUT)
    public String restPut(@PathVariable("id") Integer id){
        System.out.println("Rest PUT: " + id + "\n");
        return "redirect:/user/doTransfer";
    }

    //绑定控制器类方法处理方法入参
    //1.映射URL绑定的占位符到方法入参,使用@PathVariable()方式
    @RequestMapping(value = "/pathVariable/{name}")
    public String pathVariable(@PathVariable("name") String name){
        System.out.println("Path Variable: " + name + "\n");
        return "redirect:/user/resSuccess";
    }

    //2.绑定请求参数到控制器方法参数,控制器方法入参处使用@RequestParam注解将请求参数传递给方法
    @RequestMapping(value = "/requestParam")
    public String requestParam(
            @RequestParam(value = "loginName") String loginName,
            @RequestParam(value = "password") String password
    ){
        System.out.println("Request Param: " + loginName + " " + password);
        return "redirect:/user/resSuccess";
    }

    //3.将请求参数绑定到控制器方法的表单对象，见UserController类

}
