package com.lrving.aop;

import com.lrving.bean.DBContextHolder;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created by goodwuxuyang on 2019/7/5.
 */

@Aspect
@Component
public class DataSourceAop {

    @Pointcut("!@annotation(com.lrving.annotation.Master) " +
            "&& (execution(* com.lrving.service..*.select*(..)) " +
            "|| execution(* com.lrving.service..*.get*(..)))")
    public void readPointcut() {

    }

    @Pointcut("@annotation(com.lrving.annotation.Master) " +
            "|| execution(* com.lrving.service..*.insert*(..)) " +
            "|| execution(* com.lrving.service..*.add*(..)) " +
            "|| execution(* com.lrving.service..*.update*(..)) " +
            "|| execution(* com.lrving.service..*.edit*(..)) " +
            "|| execution(* com.lrving.service..*.delete*(..)) " +
            "|| execution(* com.lrving.service..*.remove*(..))")
    public void writePointcut() {

    }

    @Before("readPointcut()")
    public void read() {
        DBContextHolder.slave();
    }

    @Before("writePointcut()")
    public void write() {
        DBContextHolder.master();
    }


    /**
     * 另一种写法：if...else...  判断哪些需要读从数据库，其余的走主数据库
     */
//    @Before("execution(* com.lrving.service.impl.*.*(..))")
//    public void before(JoinPoint jp) {
//        String methodName = jp.getSignature().getName();
//
//        if (StringUtils.startsWithAny(methodName, "get", "select", "find")) {
//            DBContextHolder.slave();
//        }else {
//            DBContextHolder.master();
//        }
//    }
}
