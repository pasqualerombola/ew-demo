package io.ew.ewdemo.shop;

import io.ew.ewdemo.address.Address;
import io.ew.ewdemo.common.EntityCommonCols;
import io.ew.ewdemo.common.Contact;
import io.ew.ewdemo.common.ContactsConverter;
import java.time.LocalDate; //PostgreSQL: date
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity @Table(name = "tb_shop")
public class Shop extends EntityCommonCols {

   @NotNull
   private String name;

   @NotNull
   private String status;

   @Column(name="open_date")
   private LocalDate openDate;

   @Column(name="close_date")
   private LocalDate closeDate;

   @OneToOne
   @JoinColumn(name = "address_id")
   private Address address;

   @Convert(converter = ContactsConverter.class)
   private Contact[] contacts;

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getStatus() {
      return status;
   }

   public void setStatus(String status) {
      this.status = status;
   }

   public LocalDate getOpenDate() {
      return openDate;
   }

   public void setOpenDate(LocalDate openDate) {
      this.openDate = openDate;
   }

   public LocalDate getCloseDate() {
      return closeDate;
   }

   public void setCloseDate(LocalDate closeDate) {
      this.closeDate = closeDate;
   }

   public Address getAddress() {
      return address;
   }

   public void setAddress(Address address) {
      this.address = address;
   }

   public Contact[] getContacts() {
      return contacts;
   }

   public void setContacts(Contact[] contacts) {
      this.contacts = contacts;
   }

   @Override
   public String toString() {
      return "Shop [address=" + address + ", closeDate=" + closeDate + ", contacts=" + contacts 
            + ", name=" + name + ", openDate=" + openDate + ", status=" + status + "]";
   }
}
