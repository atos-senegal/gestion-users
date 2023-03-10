package com.example.demo.aop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.time.temporal.ChronoUnit;

import org.springframework.boot.logging.LogLevel;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface LogEntryExit {

	LogLevel value() default LogLevel.INFO;

	ChronoUnit unit() default ChronoUnit.SECONDS;

	boolean showArgs() default false;

	boolean showResult() default true;

	boolean showExecutionTime() default true;
}
