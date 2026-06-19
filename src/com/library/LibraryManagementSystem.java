package com.library;

//LibraryManagementSystem.java
//Main class - handles user interaction via console menu
import java.util.Scanner;
import java.util.InputMismatchException;

public class LibraryManagementSystem {
 public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);
     Library library = new Library(); // OBJECT creation
     int choice = -1;

     // Add a few sample books to start with
     library.addBook(new Book(101, "Java Fundamentals", "James Gosling"));
     library.addBook(new Book(102, "Effective Java", "Joshua Bloch"));
     library.addBook(new Book(103, "Clean Code", "Robert Martin"));

     while (choice != 6) {
         System.out.println("\n===== Library Management System =====");
         System.out.println("1. Add Book");
         System.out.println("2. Display All Books");
         System.out.println("3. Search Book by ID");
         System.out.println("4. Issue Book");
         System.out.println("5. Return Book");
         System.out.println("6. Exit");
         System.out.print("Enter your choice: ");

         try {
             choice = sc.nextInt();

             switch (choice) {
                 case 1:
                     System.out.print("Enter Book ID: ");
                     int id = sc.nextInt();
                     sc.nextLine(); // consume leftover newline
                     System.out.print("Enter Book Name: ");
                     String name = sc.nextLine();
                     System.out.print("Enter Author Name: ");
                     String author = sc.nextLine();
                     library.addBook(new Book(id, name, author));
                     break;

                 case 2:
                     library.displayAllBooks();
                     break;

                 case 3:
                     System.out.print("Enter Book ID to search: ");
                     int searchId = sc.nextInt();
                     try {
                         Book found = library.searchBookById(searchId);
                         System.out.println("Book Found -> " + found);
                     } catch (BookNotFoundException e) {
                         System.out.println("Error: " + e.getMessage());
                     }
                     break;

                 case 4:
                     System.out.print("Enter Book ID to issue: ");
                     int issueId = sc.nextInt();
                     try {
                         library.issueBook(issueId);
                     } catch (BookNotFoundException | BookAlreadyIssuedException e) {
                         System.out.println("Error: " + e.getMessage());
                     }
                     break;

                 case 5:
                     System.out.print("Enter Book ID to return: ");
                     int returnId = sc.nextInt();
                     try {
                         library.returnBook(returnId);
                     } catch (BookNotFoundException e) {
                         System.out.println("Error: " + e.getMessage());
                     }
                     break;

                 case 6:
                     System.out.println("Exiting... Thank you!");
                     break;

                 default:
                     System.out.println("Invalid choice! Please enter a number between 1 and 6.");
             }
         } catch (InputMismatchException e) {
             System.out.println("Invalid input! Please enter a valid number.");
             sc.nextLine(); // clear invalid input from scanner buffer
             choice = -1; // reset so loop continues
         }
     }
     sc.close();
 }
}
