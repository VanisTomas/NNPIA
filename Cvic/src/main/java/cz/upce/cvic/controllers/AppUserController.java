package cz.upce.cvic.controllers;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import cz.upce.cvic.dto.AppUserDto;
import cz.upce.cvic.entities.AppUser;
import cz.upce.cvic.exceptions.ResourceNotFoundException;
import cz.upce.cvic.services.AppUserService;

@RestController
@RequestMapping("/app-user")
public class AppUserController {
  @Autowired
  private AppUserService service;

  @GetMapping("/active")
  public List<AppUser> findByActive() {
    return service.findByActive();
  }

  @GetMapping("/role/{name}")
  public List<AppUser> findByRole(@PathVariable String name) {
    return service.findByRole(name);
  }

  @GetMapping("/{id}")
  public ResponseEntity<AppUserDto> findById(@PathVariable int id) throws ResourceNotFoundException {
    var result = service.findById(id);
    if (result.isEmpty()) {
      throw new ResourceNotFoundException();
    }
    return ResponseEntity.ok(toDto(result.get()));
  }

  @PostMapping("")
  public ResponseEntity<AppUserDto> create(@Valid @RequestBody AppUserDto dto) {
    var result = service.create(toEntity(dto));
    return ResponseEntity.status(HttpStatus.CREATED).body(toDto(result));
  }

  @PutMapping("/{id}")
  public ResponseEntity<AppUserDto> update(@PathVariable int id, @Valid @RequestBody AppUserDto dto) throws ResourceNotFoundException {
    var result = service.findById(id);
    if (result.isEmpty()) {
      throw new ResourceNotFoundException();
    }
    AppUser appUser = result.get();
    appUser.setUsername(dto.getUsername());
    appUser.setPassword(dto.getPassword());
    appUser.setActive(dto.getActive());
    appUser.setCreationDate(dto.getCreationDate());
    appUser.setUpdateDate(dto.getUpdateDate());
    appUser = service.update(appUser);
    return ResponseEntity.status(HttpStatus.CREATED).body(toDto(appUser));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable int id) {
    service.delete(id);
    return ResponseEntity.ok().build();
  }

  private static AppUserDto toDto(AppUser appUser) {
    return new AppUserDto(appUser.getUsername(), appUser.getPassword(), appUser.getActive(), appUser.getCreationDate(), appUser.getUpdateDate());
  }

  private static AppUser toEntity(AppUserDto dto) {
    return new AppUser(dto.getUsername(), dto.getPassword(), dto.getActive(), dto.getCreationDate(), dto.getUpdateDate());
  }
}
