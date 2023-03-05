package cz.upce.cvic.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import cz.upce.cvic.entities.AppUser;
import cz.upce.cvic.repositories.AppUserRepository;

@RestController
public class AppUserController {
  @Autowired
  private AppUserRepository repository;

  @GetMapping("/user/{active}")
  public List<AppUser> findByActive(@PathVariable boolean active) {
    return repository.findByActive(active);
  }

  @GetMapping("/user_role/{name}")
  public List<AppUser> findByActive(@PathVariable String name) {
    return repository.findByRole(name);
  }
}
