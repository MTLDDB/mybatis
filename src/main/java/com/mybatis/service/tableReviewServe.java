package com.mybatis.service;

import com.mybatis.mapper.DBMapper;
import com.mybatis.mapper.kingMapper;
import com.mybatis.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class tableReviewServe {
    @Autowired
    private DBMapper dbMapper;
    @Autowired
    private kingMapper kMapper;
    public List<Student> getManualReview(int pageSize, int offset){
        return dbMapper.getTableReview(pageSize, offset);
    }
    public  int getNum(){return dbMapper.getNum();}
    public  int getKNum(){return kMapper.getNum();}
}
