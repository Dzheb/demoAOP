package ru.dzheb.aop.demo;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;


@Component
@AllArgsConstructor
//@Timer
public class MyServiceBean {
    @RecoverException(noRecoverFor = {IllegalArgumentException.class,
            NoSuchElementException.class})
//@Timer
    public String method1(String arg) {
        if (arg == null) {
            throw new NoSuchElementException("StackOverflowError");
        }
        return arg;
    }

    @Timer
    public String method2(String arg) {
        return arg;
    }

}
