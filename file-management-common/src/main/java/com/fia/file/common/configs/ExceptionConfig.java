package com.fia.file.common.configs;

import com.fia.file.common.ResponseEntity;
import com.fia.file.common.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * exception
 * @author 10268
 * @date 2021/1/14 11:47
 */
@ControllerAdvice
@Slf4j
@ResponseBody
public class ExceptionConfig {

    @ExceptionHandler
    public ResponseEntity handlerException(Exception e){
        log.error("exception : {}",e);
        return ResponseUtil.errorResponse("",e.getMessage(),"");
    }
}
