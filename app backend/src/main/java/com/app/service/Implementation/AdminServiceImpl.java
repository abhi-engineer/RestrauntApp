package com.app.service.Implementation;

import com.app.dto.AdminDto;
import com.app.dto.LoginDto;
import com.app.entity.Admin;
import com.app.exception.MyAppException;
import com.app.repo.AdminRepo;
import com.app.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService {


    @Autowired
    private AdminRepo adminRepo;


    @Override
    public AdminDto registerAdmin(AdminDto adminDto) throws MyAppException {
        Optional<Admin> optional = adminRepo.findByEmail(adminDto.getEmail());
        if(optional.isPresent())
            throw new MyAppException("USER_FOUND");
        Admin admin = adminDto.toEntity();
        admin = adminRepo.save(admin);
        return admin.toDto();
    }

    @Override
    public AdminDto loginAdmin(LoginDto loginDto) throws MyAppException {
        Optional<Admin> optional = adminRepo.findByEmail(loginDto.getEmail());
        Admin admin = adminRepo.findByEmail(loginDto.getEmail()).orElseThrow(()-> new MyAppException("USER_NOT_FOUND"));
        if(!loginDto.getPassword().equals(admin.getPassword()))
            throw new MyAppException("WRONG_PASSWORD");
        return admin.toDto();
    }

}

