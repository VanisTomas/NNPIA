package cz.upce.cvic.entities;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Task {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;
  private String title;
  private String description;
  private LocalDateTime creationDate;
  private LocalDateTime updateDate;
  private int authorId;
  @ManyToOne
  @JoinColumn(name = "authorId", insertable = false, updatable = false)
  private AppUser appUser;
}
