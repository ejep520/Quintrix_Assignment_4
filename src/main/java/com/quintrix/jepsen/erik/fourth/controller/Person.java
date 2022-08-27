package com.quintrix.jepsen.erik.fourth.controller;

class Person {
  private String firstName, lastName;

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public Person(String lastName) {
    this.lastName = lastName;
  }

  public String toString() {
    return firstName + " " + lastName;
  }
}
