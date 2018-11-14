package com.springmvc.service.serviceImpl;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.apache.http.annotation.Obsolete;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.springmvc.service.MyTestSpringTimer;

@Service("myTestSpringTimer")
public class MyTestSpringTimerImpl implements MyTestSpringTimer {
 
    
    private int k = 0 ;


    //@Scheduled(cron="0/3 * *  * * ? ")   //每3秒执行一次
    @Override
    public void testTimer() {
       k++;
       System.out.println("第"+k+"执行定时任务");
        
    }

    @Override
    public void getInfo() {
       System.out.println("--------------Get------------------");
    }
    
    @PostConstruct
    public void doAfterInit(){
        System.out.println(this.getClass().getName());
        System.out.println("************* Bean 初始化后执行********************");
    }
    
    @PreDestroy
    public void doBeforeDestroy(){
        System.out.println(this.getClass().getName());
        System.out.println("************* Bean销毁之前执行********************");
    }

}
