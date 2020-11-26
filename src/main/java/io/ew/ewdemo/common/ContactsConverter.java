package io.ew.ewdemo.common;

import java.util.Arrays;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Converter
public class ContactsConverter implements AttributeConverter<Contact[], String>  {
                     //AttributeConverter<EntityAttributeType, DatabaseColumnType>

   private static final Logger log = LoggerFactory.getLogger(ContactsConverter.class);
   
   @Override
   public String convertToDatabaseColumn(Contact[] attribute) {
      return Arrays.toString(attribute);
   }

   @Override
   public Contact[] convertToEntityAttribute(String dbData) {
      if (dbData == null)
         return null;
      Contact[] attribute = null;
      ObjectMapper mapper = new ObjectMapper();
      try {
         attribute = mapper.readValue(dbData, Contact[].class);
      }
      catch (JsonMappingException e) {
         log.error("JsonMappingException in ContactsConverter", e);
      }
      catch (JsonProcessingException e) {
         log.error("JsonProcessingException in ContactsConverter", e);
      }
      return attribute;
   }
}
