package com.app.service.Implementation;

import com.app.dto.ItemsDto;
import com.app.dto.StatusDto;
import com.app.entity.Items;
import com.app.exception.MyAppException;
import com.app.repo.ItemsRepo;
import com.app.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;


@Service
public class ItemsServiceImpl implements ItemsService {

    @Autowired
    private ItemsRepo itemsRepo;

    @Override
    public List<ItemsDto> getAllItems() throws MyAppException {
        List<Items> list = itemsRepo.findAll();
        if(list.isEmpty()) throw new MyAppException("NO_ITEM_AVAILABLE");

        // changin Items list to ItmemsDto list, mapping each object
        return list.stream()
                .map(items -> new ItemsDto(items.getId(),items.getItemName(),items.getDescription(), items.getPrice(),items.getStatus()))
                .collect(Collectors.toList());

    }

    @Transactional
    @Override
    public int updateStatus(List<StatusDto> list) throws MyAppException {
        if(list.isEmpty()) throw new MyAppException("UNABLE_TO_UPDATE");
        int totalRowEffected = 0;
        for(StatusDto statusDto : list) {
            int rowEffected = itemsRepo.updateStatusByItemName(statusDto.getItemName(), statusDto.getStatus().name());// converting enum to string, so that i can be save in the db
            totalRowEffected += rowEffected;
        }
        return totalRowEffected;
    }

}
