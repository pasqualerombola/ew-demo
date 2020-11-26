package io.ew.ewdemo.address;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface AddressRepository extends PagingAndSortingRepository<Address, UUID> {
   
   @RestResource(rel = "state-contains", path="state-contains")
   Page<Address> findByStateContaining(@Param("state") String state, Pageable page);

   @RestResource(rel = "city-contains", path="city-contains")
   Page<Address> findByCityContaining(@Param("city") String city, Pageable page);
   
   @RestResource(rel = "postal-code", path="postal-code")
   Page<Address> findByPostalCode(@Param("pcode") String pcode, Pageable page);
   
   @RestResource(rel = "street-contains", path="street-contains")
   Page<Address> findByStreetContaining(@Param("street") String street, Pageable page);
}
