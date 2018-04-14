package com.zls.im.common;

import com.zls.im.common.exception.*;
import com.zls.im.util.ResponseUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AjaxExceptionHandler
{
    
    private static final Logger logger = Logger.getLogger(new Throwable().getStackTrace()[0].getClassName());
    
    @Autowired
    private ResponseUtil responseUtil;
    
    @ExceptionHandler(RecordExistException.class)
    @ResponseBody
    public String recordExistException(HttpServletRequest request, HttpServletResponse response, RecordExistException e)
    {
        logger.info("", e);
        return responseUtil.responseJson(ResponseUtil.ResponseCode.RECORD_EXISTS, e.getMessage());
    }
    
    @ExceptionHandler(NotFoundException.class)
    @ResponseBody
    public String notFoundException(HttpServletRequest request, HttpServletResponse response, NotFoundException e)
    {
        logger.info("", e);
        return responseUtil.responseJson(ResponseUtil.ResponseCode.NOT_FOUND, e.getMessage());
    }
    
    @ExceptionHandler(WrongParameterException.class)
    @ResponseBody
    public String wrongParameterException(HttpServletRequest request, HttpServletResponse response,
                                          WrongParameterException e)
    {
        logger.info("", e);
        return responseUtil.responseJson(ResponseUtil.ResponseCode.WRONG_PARAMETER, e.getMessage());
    }
    
    @ExceptionHandler(SessionTimeoutException.class)
    @ResponseBody
    public String sessionTimeoutException(HttpServletRequest request, HttpServletResponse response,
                                          SessionTimeoutException e)
    {
        logger.info("", e);
        return responseUtil.responseJson(ResponseUtil.ResponseCode.SESSION_TIME_OUT, e.getMessage());
    }
    
    @ExceptionHandler(NumberFormatException.class)
    @ResponseBody
    public String numberFormatException(HttpServletRequest request, HttpServletResponse response,
                                        NumberFormatException e)
    {
        logger.info("", e);
        return responseUtil.responseJson(ResponseUtil.ResponseCode.FAIL);
    }
    
    @ExceptionHandler(StoreException.class)
    @ResponseBody
    public String storeException(HttpServletRequest request, HttpServletResponse response, StoreException e)
    {
        logger.info("", e);
        return responseUtil.responseJson(ResponseUtil.ResponseCode.STORE_EXCEPTION, e.getMessage());
    }
    
    @ExceptionHandler(CodeOutOfRangeException.class)
    @ResponseBody
    public String codeOutOfRangeException(HttpServletRequest request, HttpServletResponse response,
                                          CodeOutOfRangeException e)
    {
        logger.info("", e);
        return responseUtil.responseJson(ResponseUtil.ResponseCode.STORE_EXCEPTION, e.getMessage());
    }
    
    @ExceptionHandler(DataOutOfDateException.class)
    @ResponseBody
    public String dataOutOfDateException(HttpServletRequest request, HttpServletResponse response,
                                         DataOutOfDateException e)
    {
        logger.info("", e);
        return responseUtil.responseJson(ResponseUtil.ResponseCode.REFRESH_DATAS, e.getMessage());
    }
    
    @ExceptionHandler(NoPermissionException.class)
    @ResponseBody
    public String noPermissionException(HttpServletRequest request, HttpServletResponse response,
                                        DataOutOfDateException e)
    {
        logger.info("", e);
        return responseUtil.responseJson(ResponseUtil.ResponseCode.NO_PERMISSION, e.getMessage());
    }
    
    @ExceptionHandler(WrongFileException.class)
    @ResponseBody
    public String wrongFileException(HttpServletRequest request, HttpServletResponse response, WrongFileException e)
    {
        logger.info("", e);
        return responseUtil.responseJson(ResponseUtil.ResponseCode.WRONG_FILE_EXCEPTION, e.getMessage());
    }
    
    @ExceptionHandler(FileRowErrorException.class)
    @ResponseBody
    public String fileRowErrorException(HttpServletRequest request, HttpServletResponse response,
                                        FileRowErrorException e)
    {
        logger.info("", e);
        return responseUtil.responseJson(ResponseUtil.ResponseCode.FILE_ROW_ERROR_EXCEPTION, e.getMessage());
    }
    
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public String exception(HttpServletRequest request, HttpServletResponse response, Exception e)
    {
        logger.info("", e);
        return responseUtil.responseJson(ResponseUtil.ResponseCode.FAIL);
    }
    
}
