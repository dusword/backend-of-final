package com.dusword.Service.Implement;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dusword.Mapper.TaskMapper;
import com.dusword.Service.TaskService;
import com.dusword.entity.Task;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImple extends ServiceImpl<TaskMapper, Task> implements TaskService {
}
