package com.center.pmit.project.common.constant;

/**
 * redis的key值和过期时间设置的常量值,用于值查询配置
 * @author Administrator
 */
public class RedisKeyAndTimeConstants {


    /**
     * 过期时间 12小时
     */
    public static  final long REDIS_VALUE_OUT_OF_TIME_HALF_DAY = 43200;


    /**
     * 过期时间 1小时
     */
    public static  final long REDIS_VALUE_OUT_OF_TIME_ONE_HOUR= 3600;

    public static final String ITS_UPLOAD_PAPER = "its:upload:paper:";

    public static final String ITS_RELEASE_CONFIG = "its:release:config:";
}
