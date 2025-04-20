package com.app.dto;

import com.app.entity.Admin;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminDto {
    private Long id;
    private String email;
    private String password;

    public Admin toEntity(){
        Admin admin = new Admin();
        return new Admin(this.id,this.email, this.password);
    }
}
