package com.dusword.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dusword.entity.PredictedFile;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface PredictedFileMapper extends BaseMapper<PredictedFile> {
}
