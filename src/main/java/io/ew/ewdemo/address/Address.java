package io.ew.ewdemo.address;

import io.ew.ewdemo.common.EntityCommonCols;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity @Table(name = "tb_address")
public class Address extends EntityCommonCols {

   private String street;
   @Column(name="postal_code")
   private String postalCode;
   private String city;
   private String state;

   public String getStreet() {
      return street;
   }

   public void setStreet(String street) {
      this.street = street;
   }

   public String getPostalCode() {
      return postalCode;
   }

   public void setPostalCode(String postalCode) {
      this.postalCode = postalCode;
   }

   public String getCity() {
      return city;
   }

   public void setCity(String city) {
      this.city = city;
   }

   public String getState() {
      return state;
   }

   public void setState(String state) {
      this.state = state;
   }

   @Override
   public String toString() {
      return "Address [city=" + city + ", postalCode=" + postalCode + ", state=" + state + ", street=" + street + "]";
   }
}
