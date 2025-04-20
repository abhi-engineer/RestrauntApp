package com.app.service;

import com.app.dto.AdminDto;
import com.app.dto.LoginDto;
import com.app.exception.MyAppException;
import com.app.repo.AdminRepo;
import org.springframework.stereotype.Service;

@Service
public interface AdminService {
    public AdminDto registerAdmin(AdminDto adminDto) throws MyAppException;
    public AdminDto loginAdmin(LoginDto loginDto) throws MyAppException;
}