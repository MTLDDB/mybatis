package com.mybatis.mapper;


import com.mybatis.model.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface DBMapper {
    Student findUserById(Integer id);
    Student findUserByName(String name);
    List<Student> findAll();
    void insertStu(@Param("student") Student student);
    void deleteById(@Param("id") Integer id);
    int getNum();
    @Select("select * from student  order by student_id asc limit #{offset},#{pageSize} ")
    List<Student> getTableReview(@Param("pageSize") int pageSize, @Param("offset") int offset);
}
