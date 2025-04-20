package com.app.controller;

import com.app.dto.ItemsDto;
import com.app.dto.StatusDto;
import com.app.exception.MyAppException;
import com.app.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/items")
public class ItemsController {

    @Autowired
    private ItemsService itemService;

    @GetMapping("/get")
    public List<ItemsDto> getAllItems() throws MyAppException {
        return itemService.getAllItems();
    }

    @PutMapping("/updateStatus")
    public int updateStatus(@RequestBody List<StatusDto> list) throws MyAppException {
        int totalRowEffected = itemService.updateStatus(list);
        return totalRowEffected;
    }
}