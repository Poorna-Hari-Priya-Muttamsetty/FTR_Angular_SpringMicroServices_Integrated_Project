package com.ftr.workitem.util;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.ftr.workitem.controller.WorkitemController;

@Component
@Aspect
public class LogginAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(WorkitemController.class);

	@AfterThrowing(pointcut = "execution(* com.ftr.workitem.*.*.*(..))", throwing = "exception")
	public void afterThrowing(Exception exception) {
		LOGGER.error(exception.getMessage());
	}
	
}

