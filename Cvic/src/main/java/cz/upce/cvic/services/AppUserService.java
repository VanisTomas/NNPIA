package cz.upce.cvic.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cz.upce.cvic.entities.AppUser;
import cz.upce.cvic.repositories.AppUserRepository;

@Service
public class AppUserService {
  @Autowired
  private AppUserRepository repository;

  public Optional<AppUser> findById(int id) {
    return repository.findById(id);
  }

  public List<AppUser> findByActive() {
    return repository.findByActive(true);
  }

  public List<AppUser> findByRole(String name) {
    return repository.findByRole(name);
  }

  public AppUser create(AppUser appUser) {
    return repository.save(appUser);
  }

  public AppUser update(AppUser appUser) {
    return repository.save(appUser);
  }

  public void delete(int id) {
    repository.deleteById(id);
  }
}
