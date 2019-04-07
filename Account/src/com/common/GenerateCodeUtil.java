package com.common;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GenerateCodeUtil {

    public static String generateCode(String currentCode){
        String nextCode =null;
        //当天时间
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        //格式化当天时间
        String formatCurrentDate = simpleDateFormat.format(date);
        //当天时间，没有编号，新生成一个
        //如果有，编号自增
        if(null ==currentCode){
            nextCode =Long.parseLong(formatCurrentDate)+"001";
        }
        else{
            nextCode= String.valueOf((Long.parseLong(currentCode.substring(1))+1));
        }
        return nextCode;
    }
}
