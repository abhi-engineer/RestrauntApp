package com.app.service;

import com.app.dto.ItemsDto;
import com.app.dto.StatusDto;
import com.app.exception.MyAppException;

import java.util.List;

public interface ItemsService {
    public List<ItemsDto> getAllItems() throws MyAppException;
    public int updateStatus(List <StatusDto> list) throws MyAppException;

}
