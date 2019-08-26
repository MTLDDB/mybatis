package com.mybatis.mapper;

import com.mybatis.model.Student;
import com.mybatis.model.testkingshard;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface kingMapper {

    @Select("select * from test_shard_hash order by id asc limit #{offset},#{pageSize} ")
    List<testkingshard> All(@Param("pageSize") int pageSize, @Param("offset") int offset);

    int getNum();

    void insertSk(@Param("sk2") testkingshard sk2);


    //@Delete("delete * from test_shard_hash where id=#{id}")
    void deleteById(Integer id);
}
