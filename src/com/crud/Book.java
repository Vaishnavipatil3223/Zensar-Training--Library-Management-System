package com.crud;

public class Book {

    private int bookId;
    private String title;
    private String author;
    private double price;
    private int totalCopies;
    private int availableCopies;

    
    public Book(String title, String author, double price, int totalCopies) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.totalCopies = totalCopies;
        this.availableCopies = totalCopies;
    }

    
    public int getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    public int getTotalCopies() {
        return totalCopies;
    }

    public int getAvailableCopies() {
        return availableCopies;
    }

   
    public void setBookId(int bookId) {
        this.bookId = bookId;
    }
}