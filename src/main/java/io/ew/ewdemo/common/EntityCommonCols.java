package io.ew.ewdemo.common;

import org.hibernate.annotations.Type;
import java.time.OffsetDateTime; //PostgreSQL: timestamptz
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@MappedSuperclass
public class EntityCommonCols {

   @Id @Type(type = "pg-uuid")
   private UUID id;

   @NotNull
   private OffsetDateTime created_at;
   
   @NotNull
   private OffsetDateTime updated_at;

   public UUID getId() {
      return id;
   }

   public void setId(UUID id) {
      this.id = id;
   }

   public OffsetDateTime getCreated_at() {
      return created_at;
   }

   public void setCreated_at(OffsetDateTime created_at) {
      this.created_at = created_at;
   }

   public OffsetDateTime getUpdated_at() {
      return updated_at;
   }

   public void setUpdated_at(OffsetDateTime updated_at) {
      this.updated_at = updated_at;
   }
}
