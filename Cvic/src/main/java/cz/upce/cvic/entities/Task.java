package cz.upce.cvic.entities;

import java.sql.Date;

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
  private Date creation_date;
  private Date update_date;
  private int authod_id;
  @ManyToOne
  @JoinColumn(name = "authod_id", insertable = false, updatable = false)
  private AppUser app_user;
}
