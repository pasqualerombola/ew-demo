package io.ew.ewdemo.address;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class AddressRepositoryTests {
   
   @Autowired
   private AddressRepository repo;

   @Test
   public void testFindByStateContaining() {
      Page<Address> page = repo.findByStateContaining("SomeState1", Pageable.unpaged());
      assertEquals(1, page.getNumberOfElements());
   }

   @Test
   public void testFindByCityContaining() {
      Page<Address> page = repo.findByCityContaining("SomeCity1", Pageable.unpaged());
      assertEquals(1, page.getNumberOfElements());
   }

   @Test
   public void testFindByPostalCode() {
      Page<Address> page = repo.findByPostalCode("71001", Pageable.unpaged());
      assertEquals(1, page.getNumberOfElements());
   }

   @Test
   public void testFindByStreetContaining() {
      Page<Address> page = repo.findByStreetContaining("SomeStreet", Pageable.unpaged());
      assertEquals(1, page.getNumberOfElements());
   }

   @Test
   public void testAddressPagination() {
      Page<Address> page = repo.findAll(PageRequest.of(0, 2));
      //there are 7 elements in TEST, therefore: 4 pages in total with size = 2
      assertEquals(4, page.getTotalPages());
   }
}
