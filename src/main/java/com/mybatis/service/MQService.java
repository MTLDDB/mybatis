package com.mybatis.service;

        import com.mybatis.mapper.MQMapper;
        import com.mybatis.model.Student;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;

        import java.util.List;

@Service
public class MQService {
    @Autowired
    private MQMapper mqMapper;
    public List<Student> getTaskList(int task_count) {
        List<Student> tasks = mqMapper.getTask(task_count);
        return tasks;
    }
}
