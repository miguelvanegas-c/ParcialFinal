package com.example.demo.service;

import com.example.demo.exception.DateException;
import com.example.demo.model.Date;
import com.example.demo.model.Specialty;
import com.example.demo.repository.DateRepository;
import com.example.demo.repository.SpecialtyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DateService {
    @Autowired
    private DateRepository dateRepository;
    @Autowired
    private SpecialtyRepository specialtyRepository;

    public List<Specialty> getSpecialties(){
        return specialtyRepository.findAll();
    }

    public void addDate(Date date) throws DateException {
        String userEmail = date.getUserEmail();
        String userName = date.getUserName();
        String cc = date.getCC();
        String dateTime = date.getDate();
        if(userEmail == null || userName == null || cc == null|| dateTime==null){
            throw new DateException(DateException.NotOptions);
        }
        List<Date> dates = dateRepository.findByDate(dateTime);
        if(!dateTime.isEmpty()){
            throw  new DateException(DateException.InvalidDate);
        }
        dateRepository.save(date);
    }
    public List<Date> getDate(String status){
        return dateRepository.findByStatus(status);
    }
    public void cancelDate(Date date){
        date.setStatus("Cancelada");
        dateRepository.save(date);
    }

}
