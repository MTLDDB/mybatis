package com.mybatis.controller;

import com.alibaba.fastjson.JSONObject;
import com.mybatis.model.PageModel;
import com.mybatis.model.testkingshard;
import com.mybatis.service.kingService;
import com.mybatis.service.tableReviewServe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class kingController {
    @Autowired
    private kingService kService;
    @Autowired
    private tableReviewServe tableReview;
    @RequestMapping("/king")
    public String test(){

        return "text1";
    }
    @RequestMapping("/insert")
    public String test1(){

        return "login";
    }

    @RequestMapping("/updataTable1")
    public @ResponseBody
    PageModel<testkingshard> king1(@RequestParam("pageSize") String pageSize, @RequestParam("offset") String offset){

        List<testkingshard> list=kService.All(Integer.parseInt(pageSize),Integer.parseInt(offset));
        //String list1= JSON.toJSONString(list);
        PageModel<testkingshard> pageModel = new PageModel<>();
        pageModel.setTotal(tableReview.getKNum());
        pageModel.setRows(list);
        return pageModel;
    }
    @RequestMapping("/insertSk")
    public @ResponseBody boolean insert(@RequestParam("sk") String sk){
        try {
            JSONObject student1 = JSONObject.parseObject(sk);
            testkingshard sk2=JSONObject.toJavaObject(student1,testkingshard.class);
            kService.insertSk(sk2);
            return true;
        }catch (Exception e){
            return false;
        }
    }
    @RequestMapping(value="/delete")
    public @ResponseBody boolean  deleteById(@RequestParam("id") String id){
System.out.println(id);
        try {
            kService.deleteById(Integer.parseInt(id));
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
