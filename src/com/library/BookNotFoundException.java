package com.library;

//BookNotFoundException.java
//Custom checked exception - thrown when a book ID is not found in the library
public class BookNotFoundException extends Exception {
 public BookNotFoundException(String message) {
     super(message);
 }
}
