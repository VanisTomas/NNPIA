package cz.upce.cvic.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cz.upce.cvic.entities.HelloUser;

// @Controller definuje, ze se jedna o Spring Controller, ktery slouzi ke zpracovavani pozadavku
// @RestController je kompinaci @Controller a @ResponseBody, ktera nam rika, ze odpoved metody bude automaticky odeslana jako HTTP Response v JSON formatu

// JSON - syntaxe se sklada z JS objektu, kde se podrazene prvky srduzuji do slozenych zavorek
// YML - syntaxe podobna jako JSON, ale nepouzivame zavorky
// XML - znackovaci jazyk, podobna syntaxe jako HTML

@RestController
public class HelloController {
  @GetMapping("")
  public String helloWorld() {
    return "Hello world from Spring Boot application.";
  }

  @GetMapping("/hello/{name}")
  public String helloWorldPath(@PathVariable String name) {
    return "Hello " + name + ".";
  }

  @GetMapping("/hello")
  public String helloWorldQuery(@RequestParam("name") String name) {
    return "Hello " + name + ".";
  }

  @PostMapping("/hello")
  public String helloWorldRequestBody(@RequestBody HelloUser user) {
    return "Hello " + user.getForename() + " " + user.getSurname() + " you are " + user.getAge() + " years old.";
  }
}
