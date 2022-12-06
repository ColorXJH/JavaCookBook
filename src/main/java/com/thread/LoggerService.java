package com.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;

/**
 * @author ColorXJH
 * @version 1.0
 * @description:
 * @date 2022/12/2 15:06
 */
public class LoggerService {

    private static final LoggerService SERVICE=new LoggerService();
    private final Logger logger;
    private final List<Logger> loggerList;
    private LoggerService(){
        ServiceLoader<Logger> loader=ServiceLoader.load(Logger.class);
        List<Logger> list=new ArrayList<>();
        for(Logger logger:loader){
            list.add(logger);
        }
        loggerList=list;
        if(!list.isEmpty()){
            logger=list.get(0);
        }else{
            logger=null;
        }
    }

    public static LoggerService getService(){
        return SERVICE;
    }
    public void info(String msg) {
        if (logger == null) {
            System.out.println("info 中没有发现 Logger 服务提供者");
        } else {
            logger.info(msg);
        }
    }

    public void debug(String msg) {
        if (loggerList.isEmpty()) {
            System.out.println("debug 中没有发现 Logger 服务提供者");
        }
        loggerList.forEach(log -> log.debug(msg));
    }
}
