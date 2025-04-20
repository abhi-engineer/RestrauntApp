package com.app.repo;

import com.app.entity.Items;
import com.app.utility.ItemStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface ItemsRepo extends JpaRepository<Items,Long> {

    public Optional<Items> findByItemName(String name);

    @Transactional
    @Modifying
    @Query(value = "UPDATE items SET status = :status WHERE item_name = :itemName", nativeQuery = true)
    int updateStatusByItemName(@Param("itemName") String itemName, @Param("status") String status);



//    Spring Data JPA automatically returns the number of rows affected if your method returns int (or Integer).

}
