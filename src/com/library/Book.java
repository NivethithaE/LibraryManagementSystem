package com.library;

public class Book {

	private int bookId;
    private String bookName;
    private String authorName;
    private boolean isIssued;

    // Constructor to initialize a Book object
    public Book(int bookId, String bookName, String authorName) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.authorName = authorName;
        this.isIssued = false; // New books are not issued by default
    }
    // Getters and Setters (Encapsulation)
    public int getBookId() {
        return bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public boolean isIssued() {
        return isIssued;
    }

    public void setIssued(boolean issued) {
        isIssued = issued;
    }

    // Display book details in a readable format
    @Override
    public String toString() {
        return "ID: " + bookId +
               " | Name: " + bookName +
               " | Author: " + authorName +
               " | Status: " + (isIssued ? "Issued" : "Available");
    }
}
