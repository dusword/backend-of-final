package com.dusword.schedule;

import com.dusword.Service.PredictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class PredictSchedule {
    @Autowired
    PredictService predictService;

    @Scheduled(fixedRate = 10000)
    private void doTask(){
        predictService.predictTaskPic();
    }
}
