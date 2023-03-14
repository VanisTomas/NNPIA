package cz.upce.cvic.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppUserQLController {

  @GetMapping("/graphql")
  public ResponseEntity<Void> getGraphQL() {
    return ResponseEntity.ok().build();
  }

  @PostMapping("/graphql")
  public ResponseEntity<Void> postGraphQL() {
    return ResponseEntity.ok().build();
  }

  @GetMapping("/graphiql")
  public ResponseEntity<Void> getGraphiQL() {
    return ResponseEntity.ok().build();
  }

  @PostMapping("/graphiql")
  public ResponseEntity<Void> postGraphiQL() {
    return ResponseEntity.ok().build();
  }
}
