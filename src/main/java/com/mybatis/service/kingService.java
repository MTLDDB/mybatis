package com.mybatis.service;

import com.mybatis.mapper.kingMapper;
import com.mybatis.model.testkingshard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
@Service
public class kingService {
    @Autowired
    private kingMapper kMapper;
    public List<testkingshard> All(int pageSize, int offset) {
        return kMapper.All(pageSize, offset);
    }

    public void insertSk(testkingshard sk2) {
        kMapper.insertSk(sk2);
    }

    public void deleteById(Integer id) {
        kMapper.deleteById(id);
    }
}
