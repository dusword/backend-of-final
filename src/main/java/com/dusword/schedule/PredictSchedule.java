package com.dusword.schedule;

import com.dusword.Service.PredictService;
import com.dusword.controller.TaskController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import javax.annotation.Resource;

@Configuration
@EnableScheduling
public class PredictSchedule {
    @Resource
    PredictService predictService;

    protected static final Logger logger = LoggerFactory.getLogger(PredictSchedule.class);

    @Scheduled(fixedRate = 10000)
    private void doTask(){
        predictService.predictTaskPic();
    }
}
