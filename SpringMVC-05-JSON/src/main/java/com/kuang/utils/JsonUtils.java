package com.kuang.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import sun.java2d.pipe.SpanShapeRenderer;

import java.text.SimpleDateFormat;

public class JsonUtils {

    public static String getJson(Object object) {
        //直接调用另一个重载方法，不要重复造轮子，实现代码的复用————记住这个思想
        return getJson(object,"yyyy-MM-dd HH:mm:ss");
    }

    public static String getJson(Object object,String dateFormat){

        ObjectMapper mapper=new ObjectMapper();

        //不使用默认的时间戳格式
        mapper.configure(SerializationFeature.WRITE_DURATIONS_AS_TIMESTAMPS,false);
        //自定义日期格式
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        //使用自定义日期格式
        mapper.setDateFormat(sdf);

        try {
            return mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
