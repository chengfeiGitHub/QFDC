package com.QFDC.service;

import com.QFDC.bean.YanData;
import com.QFDC.mapper.YanMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataBaseService {

    private final static Logger logger = LogManager.getLogger(DataBaseService.class);

//    public final static long ONE_DAY = 1*2*60*1000;
//    @Scheduled(fixedDelay = ONE_DAY)
    //每小时执行一次
    @Autowired
    private YanMapper yanMapper;
    static int i=0;

    //    @Scheduled(cron = "0 0 * * * ?")
    public final static long ONE_DAY = 1*1*60*1000;
    @Scheduled(fixedDelay = ONE_DAY)
    public void writeDataBase(){
        logger.info("循环第" + i + "次");
        i++;
    }
    public List<YanData> getData(){
        return yanMapper.getData();
    }
}
