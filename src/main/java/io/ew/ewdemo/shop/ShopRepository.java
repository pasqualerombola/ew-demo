package io.ew.ewdemo.shop;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.UUID;

@Repository
public interface ShopRepository extends PagingAndSortingRepository<Shop, UUID> {

   @RestResource(rel = "name-contains", path = "name-contains")
   Page<Shop> findByNameContaining(@Param("name") String name, Pageable page);

   @RestResource(rel = "opening-between", path = "opening-between")
   Page<Shop> findByOpenDateBetween(@Param("dateStart") @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate dateStart, 
                                    @Param("dateEnd") @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate dateEnd, Pageable page);

   @RestResource(rel = "closing-between", path="closing-between")
   Page<Shop> findByCloseDateBetween(@Param("dateStart") @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate dateStart, 
                                     @Param("dateEnd") @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate dateEnd, Pageable page);

   @RestResource(rel = "shops-in-state", path = "shops-in-state")
   @Query("SELECT S FROM Address A INNER JOIN Shop S ON A.id = S.address.id WHERE A.state = :state")
   Page<Shop> findByState(@Param("state") String state, Pageable page);
}
