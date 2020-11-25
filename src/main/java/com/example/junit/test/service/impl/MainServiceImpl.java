package com.example.junit.test.service.impl;


import com.example.junit.test.service.MainService;
import org.springframework.stereotype.Service;


@Service
public class MainServiceImpl implements MainService {

    @Override
    public boolean checkString(String str) {
        boolean result = str.matches("[a-zA-Z0-9]+");
        return result;
    }
}
