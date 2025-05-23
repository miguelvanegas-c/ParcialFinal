package com.example.demo.controller;

import com.example.demo.exception.DateException;
import com.example.demo.model.Date;
import com.example.demo.model.Specialty;
import com.example.demo.response.ApiResponse;
import com.example.demo.service.DateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController()
@RequestMapping("/date")
public class DateController {
    @Autowired
    private DateService dateService;
    @GetMapping()
    public ResponseEntity<ApiResponse<List<Specialty>>> getSpecialty(){
        List<Specialty> specialties = dateService.getSpecialties();
        ApiResponse<List<Specialty>> response = new ApiResponse<>(
                200,
                "especialidades retornadas",
                specialties
        );
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    @PostMapping()
    public ResponseEntity<ApiResponse<Date>> addDate(@RequestBody Date date) throws DateException {
        dateService.addDate(date);
        ApiResponse<Date> response = new ApiResponse<>(
                200,
                "",
                date
        );
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    @GetMapping("/status")
    public ResponseEntity<ApiResponse<List<Date>>> getSpecialty(@RequestParam String status) {
        List<Date> specialties = dateService.getDate(status);
        ApiResponse<List<Date>> response = new ApiResponse<>(
                200,
                "citas retornadas",
                specialties
        );
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    @PutMapping()
    public ResponseEntity<ApiResponse<String>> cancelDate(Date date){
        dateService.cancelDate(date);
        ApiResponse<String> response = new ApiResponse<>(
                200,
                "citas retornadas",
                null
        );
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
