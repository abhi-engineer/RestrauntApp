package com.app.controller;

import com.app.dto.AdminDto;
import com.app.dto.LoginDto;
import com.app.exception.MyAppException;
import com.app.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/register")
    public ResponseEntity<AdminDto> registerAdmin(@RequestBody AdminDto adminDto) throws MyAppException {
        adminDto = adminService.registerAdmin(adminDto);
        return new ResponseEntity<AdminDto>(adminDto, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<AdminDto> loginAdmin(@RequestBody LoginDto loginDto) throws MyAppException {
        AdminDto adminDto = adminService.loginAdmin(loginDto);
        return new ResponseEntity<AdminDto>(adminDto, HttpStatus.OK);
    }
}
