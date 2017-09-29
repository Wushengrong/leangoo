package com.team6.leangoo.util;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


/**
 * Created by AgZou on 2017/9/22.
 */
@Component
@Aspect
public class ControllerAOP {
    private static Logger logger= LoggerFactory.getLogger(ControllerAOP.class);
    @Pointcut("execution(public com.team6.leangoo.util.AjaxResult *(..))")
    public void excudeService(){}
    @Around("excudeService()")
    public Object handlerControllerMethod(ProceedingJoinPoint pjp){
        AjaxResult ajaxResult=null;
        try {
            ajaxResult= (AjaxResult) pjp.proceed();
        } catch (Throwable e) {
            ajaxResult=handlerException(pjp,e);
        }
        return ajaxResult;
    }
    private AjaxResult handlerException(ProceedingJoinPoint pjp,Throwable e){
        AjaxResult ajaxResult=new AjaxResult();
        ajaxResult.seterrcode(AjaxResult.ERRCODE_SYSTEM_ERROR);
        ajaxResult.setinfo("请求失败");
        logger.error(pjp.getSignature()+"error",e);
        return ajaxResult;
    }
}
