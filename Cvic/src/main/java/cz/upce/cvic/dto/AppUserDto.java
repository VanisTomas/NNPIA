package cz.upce.cvic.dto;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppUserDto {
  private String username;
  private String password;
  private Boolean active;
  private LocalDateTime creationDate;
  private LocalDateTime updateDate;
}
