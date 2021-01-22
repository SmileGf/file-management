package com.fia.file.common;

import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * response util
 * @author 10268
 * @date 2021/1/14 9:23
 *
 * private static final Logger logger = LoggerFactory.getLogger(ResponseUtil.class);
 */
@Slf4j
public class ResponseUtil {

    public static ResponseEntity successResponse(Object o){
        ResponseEntity responseEntity = new ResponseEntity();
        responseEntity.setCode("200");
        responseEntity.setMessage("success");
        responseEntity.setResponseDate(getNowTime());
        responseEntity.setData(o);
        log.info("response : {}",responseEntity);
        return responseEntity;
    }

    public static ResponseEntity failResponse(Object o){
        ResponseEntity responseEntity = new ResponseEntity();
        responseEntity.setCode("999999");
        responseEntity.setMessage("fail");
        responseEntity.setResponseDate(getNowTime());
        responseEntity.setData(o);
        log.info("response : {}",responseEntity);
        return responseEntity;
    }

    public static ResponseEntity errorResponse(String code,String message,Object o){
        ResponseEntity responseEntity = new ResponseEntity();
        code = null != code && !"".equals(code) ? code : "000000";
        responseEntity.setCode(code);
        message = null != message ? message : "error";
        responseEntity.setMessage(message);
        responseEntity.setResponseDate(getNowTime());
        responseEntity.setData(o);
        log.info("response : {}",responseEntity);
        return responseEntity;
    }

    private static String getNowTime(){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(new Date());
    }
}
