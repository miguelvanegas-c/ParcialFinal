package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document
public class Date {
    @Id
    private String id;
    private String userEmail;
    private String userName;
    private String CC;
    private Specialty specialty;
    private String status;
    private String date;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String email) {
        this.userEmail = email;
    }

    public Specialty getSpecialtyName() {
        return specialty;
    }

    public void setSpecialtyName(Specialty specialtyName) {
        this.specialty = specialtyName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDate(){
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCC() {
        return CC;
    }

    public void setCC(String CC) {
        this.CC = CC;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
