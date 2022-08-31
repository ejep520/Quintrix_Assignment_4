package com.quintrix.jepsen.erik.fourth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * A controller for the demo.
 * 
 * @author Erik Jepsen
 *
 */
@RestController
public class HelloController {
  @GetMapping("/hello-world")
  @ResponseBody
  public Person helloWorld(@RequestParam String name, @RequestParam Person personName) {
    personName.setFirstName(name);
    return personName;
  }

  @PostMapping("/post-example")
  @ResponseBody
  public Person postHello(@RequestParam String fName, @RequestParam Person lName) {
    lName.setFirstName(fName);
    return lName;
  }
}
