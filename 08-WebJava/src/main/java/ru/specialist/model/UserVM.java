package ru.specialist.model;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Component;

import ru.specialist.service.HelloService;

@Component("userVM")
public class UserVM {

    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Value("#{messageSource}")
    private MessageSource messageSource;

    @Autowired
    private HelloService helloService;

    public String getHello() {
        String msg = helloService.getHelloMsg(); //"header_good_day"
        String hello;
        if (getUserName() == null || getUserName().isEmpty())
            hello = messageSource.getMessage(
                msg,
                null,
                Locale.getDefault());
        else
            hello = messageSource.getMessage(
                msg+"_username",
                new Object[] {getUserName()},
                Locale.getDefault());
        return hello;
    }


}
