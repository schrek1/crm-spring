package cz.schrek.spring.mvc.crm.aspect

import org.aspectj.lang.JoinPoint
import org.aspectj.lang.annotation.AfterReturning
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Before
import org.aspectj.lang.annotation.Pointcut
import org.springframework.stereotype.Component
import java.util.logging.Logger

@Aspect
@Component
class LoggingAspect {

    private val logger = Logger.getLogger(javaClass.name)

    @Pointcut("execution(* cz.schrek.spring.mvc.crm.controller.*.*(..))")
    private fun forControllerPackage() {
    }

    @Pointcut("execution(* cz.schrek.spring.mvc.crm.service.*.*(..))")
    private fun forServicePackage() {
    }

    @Pointcut("execution(* cz.schrek.spring.mvc.crm.dao.*.*(..))")
    private fun forDaoPackage() {
    }

    @Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
    private fun forAppFlow() {
    }


    @Before("forAppFlow()")
    fun before(joinPoint: JoinPoint) {
        val methodName = joinPoint.signature.toShortString() ?: ""
        val args = mutableListOf<String>()

        joinPoint.args?.forEach { arg ->
            if (arg != null) {
                args.add(arg.toString())
            }
        }

        logger.info("===> @Before calling method: $methodName args: $args")
    }

    @AfterReturning(pointcut = "forAppFlow()", returning = "result")
    fun afterReturning(joinPoint: JoinPoint, result: Any?) {
        val methodName = joinPoint.signature.toShortString() ?: ""

        val args = mutableListOf<String>()

        joinPoint.args?.forEach { arg ->
            if (arg != null) {
                args.add(arg.toString())
            }
        }

        logger.info("===> @AfterReturning method: $methodName args: $args\n return: $result")
    }

}