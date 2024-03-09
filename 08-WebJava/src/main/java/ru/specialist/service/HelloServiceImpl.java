package ru.specialist.service;

import java.time.LocalTime;

import org.springframework.stereotype.Service;

@Service("helloService")
public class HelloServiceImpl implements HelloService {

    @Override
    public String getHelloMsg() {
        int h = LocalTime.now().getHour();

        if (h >= 0 && h<6) return "header_good_night";
        if (h >= 6 && h<12) return "header_good_morning";
        if (h >= 12 && h<18) return "header_good_day";
        return "header_good_evening";
    }
}
