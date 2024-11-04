package com.example.LibrarayManagement.controller;

import com.example.LibrarayManagement.dto.CreateAdminRequest;
import com.example.LibrarayManagement.service.AdminService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    AdminService adminService;

    @PostMapping("/create")
    public ResponseEntity<String> createAdmin(@RequestBody @Valid CreateAdminRequest createAdminRequest) {
        // create admin

        try {
            adminService.createAdmin(createAdminRequest.to());
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body("Admin got created successfully");
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(e.getMessage());
        }


    }

}


