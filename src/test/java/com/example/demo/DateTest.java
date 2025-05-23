package com.example.demo;

import com.example.demo.exception.DateException;
import com.example.demo.model.Date;
import com.example.demo.repository.DateRepository;
import com.example.demo.repository.SpecialtyRepository;
import com.example.demo.service.DateService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest

public class DateTest {
    @InjectMocks
    private DateService dateService;
    @Mock
    private DateRepository dateRepository;
    @Mock
    private SpecialtyRepository specialtyRepository;


    @Test
    public void dateServiceIncorrectDateOne(){
        try {
            Date date = new Date();
            date.setCC("");
            date.setUserEmail("");
            dateService.addDate(date);
        }catch(DateException e){
            assertEquals(e.getMessage(),DateException.NotOptions);
        }
    }
    @Test
    public void dateServiceIncorrectDateTwo(){
        try {
            Date date = new Date();
            date.setCC("");
            date.setUserName("");
            dateService.addDate(date);
        }catch(DateException e){
            assertEquals(e.getMessage(),DateException.NotOptions);
        }
    }
    @Test
    public void dateServiceIncorrectDateThree(){
        try {
            Date date = new Date();
            date.setUserName("");
            date.setUserEmail("");
            dateService.addDate(date);
        }catch(DateException e){
            assertEquals(e.getMessage(),DateException.NotOptions);
        }
    }
    @Test
    public void dateServiceIncorrectDate(){
        try {
            Date date = new Date();
            date.setUserName("");
            date.setUserEmail("");
            date.setCC("");
            date.setDate("");
            dateService.addDate(date);
            when(dateRepository.findByDate(date.getDate())).thenReturn(List.of(date));
        }catch(DateException e){
            assertEquals(e.getMessage(),DateException.InvalidDate);
        }
    }

}
