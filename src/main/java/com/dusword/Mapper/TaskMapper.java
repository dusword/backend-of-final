package com.dusword.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dusword.entity.Task;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface TaskMapper extends BaseMapper<Task> {
}
