package com.mybatis.mapper;

import com.mybatis.model.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MQMapper {
    @Select("select * from student where status=1 limit #{task_count}")
    List<Student> getTask(@Param("task_count") int task_count);
}
