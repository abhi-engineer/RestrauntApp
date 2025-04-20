package com.app.dto;

import com.app.entity.Items;
import com.app.utility.ItemStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemsDto {
    private long id;
    private String itemName;
    private String description;
    private long price;
    @Enumerated(EnumType.STRING)
    private ItemStatus status;

    public Items toDto(){
        return new Items(this.id, this.itemName, this.description, this.price, this.status);
    }
}
