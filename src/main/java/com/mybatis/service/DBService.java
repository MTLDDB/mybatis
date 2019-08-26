package com.mybatis.service;

import com.mybatis.mapper.DBMapper;
import com.mybatis.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DBService {
    @Autowired
    private DBMapper dbMapper;

    public Student findUserById(Integer id) {
        return dbMapper.findUserById(id);
    }

    public Student findUserByName(String name) {
        return dbMapper.findUserByName(name);
    }

    public List<Student> findAll() {
        return dbMapper.findAll();
    }

    public void insertStu(Student student) {
        dbMapper.insertStu(student);
    }

    public void deleteById(Integer id) {
        dbMapper.deleteById(id);
    }


}
