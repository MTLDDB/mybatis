package com.mybatis.controller;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mybatis.model.PageModel;
import com.mybatis.model.Student;
import com.mybatis.service.DBService;
import com.mybatis.service.tableReviewServe;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;



import java.util.List;

@Controller
public class pageController {

//    @Autowired
//    private DBService dbService;
//    @Autowired
//    private tableReviewServe tableReview;
//
//    @RequestMapping("/login")
//    public String login(){
//
//        return "login";
//    }
//    @RequestMapping("/name")
//    public String hello(Model model) {
//        List<Student> list1=dbService.findAll();
//        String list= JSON.toJSONString(list1);
//        model.addAttribute("list", list);
//        return "index";
//    }
//    @RequestMapping("/text1")
//    public String text1(Model model) {
//        List<Student> list1=dbService.findAll();
//        //String list= JSON.toJSONString(list1);
//        model.addAttribute("list", list1);
//        return "text1";
//    }
//    @RequestMapping("/updataTable")
//    public @ResponseBody String index(@RequestParam("pageSize") String pageSize, @RequestParam("offset") String offset){
//        List<Student> list1=dbService.findAll();
//        String list= JSON.toJSONString(list1);
//        return list;
//    }
//    @RequestMapping("/updataTable1")
//    @ResponseBody
//    PageModel<Student> getJson(@RequestParam("pageSize") String pageSize, @RequestParam("offset") String offset) {
//        PageModel<Student> pageModel = new PageModel<>();
//        List<Student> list1=tableReview.getManualReview(Integer.parseInt(pageSize),Integer.parseInt(offset));
//        pageModel.setTotal(tableReview.getNum());
//        pageModel.setRows(list1);
//        return pageModel;
//    }
//
////    @RequestMapping("/hello")
////    @ResponseBody
////    public List<Student> findAll(){
////        List<Student> list=dbService.findAll();
////        return list;
////    }
//
//
////    @RequestMapping("all")
////    public List<Student> findAll(){
////        List<Student> list=dbService.findAll();
////        return list;
////    }
//    @RequestMapping(value="/hello")
//    public @ResponseBody String  findUserById(@Param("id")Integer id){
//        Student stu= dbService.findUserById(id);
//        String student =JSON.toJSONString(stu);
//        return student;
//    }
//    @RequestMapping(value="/hello1")
//        public @ResponseBody String  findUserByName(@Param("id") String id){
//        Student stu= dbService.findUserByName(id);
//        String student =JSON.toJSONString(stu);
//        return student;
//    }
//    @RequestMapping(value="/insert1")
//    public @ResponseBody boolean  insertStu(@Param("student") String  student){
//        try {
//            JSONObject student1 = JSONObject.parseObject(student);
//            Student student2=JSONObject.toJavaObject(student1,Student.class);
//            dbService.insertStu(student2);
//            return true;
//        }catch (Exception e){
//            return false;
//        }
//    }
//    @RequestMapping(value="/delete")
//    public @ResponseBody boolean  deleteById(@Param("id") Integer id){
//
//        try {
//            dbService.deleteById(id);
//            return true;
//        }catch (Exception e){
//            return false;
//        }
//    }
}
