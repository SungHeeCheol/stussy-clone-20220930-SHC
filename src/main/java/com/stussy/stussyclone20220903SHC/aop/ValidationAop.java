package com.stussy.stussyclone20220903SHC.aop;

import com.stussy.stussyclone20220903SHC.exception.CustomValidationException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Aspect
@Component
public class ValidationAop {

//    @Pointcut("execution(* com.stussy.stussyclone20220903SHC..*Api.*(..))")
//    private void executionPointCut(){}
    @Pointcut("@annotation(com.stussy.stussyclone20220903SHC.aop.annotation.ValidAspect)")
    private  void annotationPointCut(){}

    @Around("annotationPointCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable{

        Object[] args = joinPoint.getArgs(); //getArgs()는 Object배열형식이다.

        BeanPropertyBindingResult bindingResult = null;

        for(Object arg : args){
            if(arg.getClass() == BeanPropertyBindingResult.class){
                bindingResult = (BeanPropertyBindingResult) arg;
                break;
            }
        }

        if(bindingResult.hasErrors()){
            Map<String, String> errorMap = new HashMap<String, String>();

            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            for(FieldError fieldError : fieldErrors){
                errorMap.put(fieldError.getField(), fieldError.getDefaultMessage());
            }

            throw new CustomValidationException("Validation Error", errorMap);
        }

        Object result = null;
        result = joinPoint.proceed();

        return result;
    }
}
