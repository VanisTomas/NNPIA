package cz.upce.cvic.entities;

import java.time.LocalDateTime;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class AppUser {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;
  @NotNull
  @NotEmpty
  @Max(255)
  private String username;
  private String password;
  private Boolean active;
  private LocalDateTime creationDate;
  private LocalDateTime updateDate;
  @OneToMany
  @JoinColumn(name = "author_id")
  private Set<Task> tasks;
  @ManyToMany
  @JoinTable(name = "app_user_role", joinColumns = @JoinColumn(name = "app_user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
  private Set<Role> roles;

  public AppUser(String username, String password, Boolean active, LocalDateTime creationDate, LocalDateTime updateDate) {
    this.username = username;
    this.password = password;
    this.active = active;
    this.creationDate = creationDate;
    this.updateDate = updateDate;
  }

}
