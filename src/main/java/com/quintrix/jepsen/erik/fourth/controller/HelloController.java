package com.quintrix.jepsen.erik.fourth.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

  @PostMapping("/post-request-body")
  @ResponseBody
  public String postRequestBody(@RequestBody byte[] data) {
    InputStream is = new ByteArrayInputStream(data);
    String output = "";
    String nextString;
    char nextChar;
    try {
      int forwardTo = is.available() - 5;
      while (is.available() > forwardTo)
        is.read();
      while (is.available() != 0) {
        nextChar = (char) is.read();
        switch (nextChar) {
          case '+':
            output += ' ';
            break;
          case '%':
            nextString = "%" + (char) is.read();
            nextString += (char) is.read();
            if (nextString.equals("%0A"))
              output += System.lineSeparator();
            else if (nextString.equals("%2C"))
              output += ',';
            else if (nextString.equals("%3F"))
              output += '?';
            else if (nextString.equals("%27"))
              output += '\'';
            else if (nextString.equals("%5B"))
              output += '[';
            else if (nextString.equals("%5D"))
              output += ']';
            else
              output += String.format("((I don't know what %s is!", nextString);
            break;
          default:
            output += nextChar;
            break;
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return output;
  }
}
