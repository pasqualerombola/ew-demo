package io.ew.ewdemo.shop;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.time.LocalDate;
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
public class ShopRepositoryTests {

   @Autowired
   private ShopRepository repo;

   @Test
   public void testFindByNameContaining() {
      Page<Shop> page = repo.findByNameContaining("SomePlanet1", Pageable.unpaged());
      assertEquals(1, page.getNumberOfElements());
   }

   @Test
   public void testFindByOpenDateBetween() {
      Page<Shop> page = repo.findByOpenDateBetween(LocalDate.of(1970, 1, 1), 
                                                   LocalDate.of(1970, 2, 1), Pageable.unpaged());
      assertEquals(6, page.getNumberOfElements());
   }

   @Test
   public void testFindByCloseDateBetween() {
      Page<Shop> page = repo.findByCloseDateBetween(LocalDate.of(1970, 1, 1), 
                                                    LocalDate.of(1970, 2, 1), Pageable.unpaged());
      assertEquals(2, page.getNumberOfElements());
   }

   @Test
   public void testFindByState() {
      Page<Shop> page = repo.findByState("SomeState1", Pageable.unpaged());
      assertEquals(1, page.getNumberOfElements());
   }

   @Test
   public void testShopPagination() {
      Page<Shop> page = repo.findAll(PageRequest.of(0, 2));
      //there are 7 elements in TEST, therefore: 4 pages in total with size = 2
      assertEquals(4, page.getTotalPages());
   }
}
