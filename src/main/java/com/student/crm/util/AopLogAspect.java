package com.student.crm.util;

import com.student.crm.domain.Employee;
import com.student.crm.domain.SystemLog;
import com.student.crm.service.ISystemLogService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Setter;
import org.apache.shiro.SecurityUtils;
import org.aspectj.lang.JoinPoint;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * Created by Administrator on 2017/9/28.
 */
public class AopLogAspect {
    @Setter
    private ISystemLogService systemLogService;
    public void write(JoinPoint jp) throws JsonProcessingException {
        // 创建一个systemLog 对象 设置属性
        SystemLog systemLog = new SystemLog();
        Employee current = (Employee) SecurityUtils.getSubject().getPrincipal();
        systemLog.setOpuser(current);
        systemLog.setOptime(new Date());
        // 设置访问的方法
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();


        systemLog.setOpip(request.getRemoteAddr());
        String function =jp.getTarget().getClass().getName() + ":" + jp.getSignature().getName();

        systemLog.setFunction(function);

        ObjectMapper objectMapper = new ObjectMapper();

        systemLog.setParams(objectMapper.writeValueAsString(jp.getArgs()));

        systemLogService.insert(systemLog);

    }



}
