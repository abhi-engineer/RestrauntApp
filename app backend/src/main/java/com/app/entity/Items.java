package com.app.entity;

import com.app.dto.ItemsDto;
import com.app.utility.ItemStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Items {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(unique = true)
    private String itemName;
    private String description;
    private long price;
    @Enumerated(EnumType.STRING)
    private ItemStatus status;

    public ItemsDto toDto(){
        return new ItemsDto(this.id, this.itemName, this.description, this.price, this.status);
    }
}
