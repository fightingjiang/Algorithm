package com.hnu.jiang;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Teacher {
    @Autowired
    Student student;
    public void teach(){
        student.fun();
    }
}
