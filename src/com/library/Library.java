package com.library;

//Library.java
//Manages a collection of books - demonstrates COLLECTIONS (ArrayList) and business logic
import java.util.ArrayList;

public class Library {
 // ArrayList to store all Book objects (Collections Framework)
 private ArrayList<Book> books;

 public Library() {
     books = new ArrayList<>();
 }

 // Add a new book to the library
 public void addBook(Book book) {
     books.add(book);
     System.out.println("Book added successfully: " + book.getBookName());
 }

 // Display all books in the library
 public void displayAllBooks() {
     if (books.isEmpty()) {
         System.out.println("No books available in the library.");
         return;
     }
     System.out.println("\n----- List of All Books -----");
     for (Book book : books) {
         System.out.println(book);
     }
 }

 // Search for a book by ID; throws exception if not found
 public Book searchBookById(int bookId) throws BookNotFoundException {
     for (Book book : books) {
         if (book.getBookId() == bookId) {
             return book;
         }
     }
     throw new BookNotFoundException("Book with ID " + bookId + " not found.");
 }

 // Issue a book - throws exceptions if not found or already issued
 public void issueBook(int bookId) throws BookNotFoundException, BookAlreadyIssuedException {
     Book book = searchBookById(bookId); // reuse search logic
     if (book.isIssued()) {
         throw new BookAlreadyIssuedException("Book \"" + book.getBookName() + "\" is already issued.");
     }
     book.setIssued(true);
     System.out.println("Book issued successfully: " + book.getBookName());
 }

 // Return a previously issued book
 public void returnBook(int bookId) throws BookNotFoundException {
     Book book = searchBookById(bookId);
     if (!book.isIssued()) {
         System.out.println("This book was not issued: " + book.getBookName());
         return;
     }
     book.setIssued(false);
     System.out.println("Book returned successfully: " + book.getBookName());
 }
}
