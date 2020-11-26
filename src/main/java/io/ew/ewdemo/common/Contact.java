package io.ew.ewdemo.common;

import java.io.Serializable;

public class Contact implements Serializable{
   
   private static final long serialVersionUID = -3390486397593203871L;

   String contactType;
   String contactInformation;

   public String getContactType() {
      return contactType;
   }

   public void setContactType(String contactType) {
      this.contactType = contactType;
   }

   public String getContactInformation() {
      return contactInformation;
   }

   public void setContactInformation(String contactInformation) {
      this.contactInformation = contactInformation;
   }

   @Override
   public String toString() {
      return "{\"contactInformation\": \"" + contactInformation + "\", \"contactType\": \"" + contactType + "\"}";
   }
}
