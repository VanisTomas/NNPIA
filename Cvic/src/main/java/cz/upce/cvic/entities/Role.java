package cz.upce.cvic.entities;

import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Role {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;
  private String name;
  @ManyToMany
  @JoinTable(name = "appUserRole", joinColumns = @JoinColumn(name = "roleId"), inverseJoinColumns = @JoinColumn(name = "appUserId"))
  private Set<AppUser> appUsers;
}
