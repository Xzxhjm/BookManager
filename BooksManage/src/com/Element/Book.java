package com.Element;

public class Book
{
    private String ISBN;
    private String bookName;
    private String author;
    private String publisher;
    private String price;
    private String description;
    private int stock;
    public Book()
    {
        this.ISBN = "";
        this.bookName = "";
        this.author = "";
        this.publisher = "";
        this.price = "";
        this.description = "";
        this.stock = 0;
    }
    public Book(String ISBN, String bookName, String author, String publisher, String price, String description, int stock)
    {
        this.ISBN = ISBN;
        this.bookName = bookName;
        this.author = author;
        this.publisher = publisher;
        this.price = price;
        this.description = description;
        this.stock = stock;
    }
    public String getISBN()
    {
        return ISBN;
    }
    public String getBookName()
    {
        return bookName;
    }
    public String getAuthor()
    {
        return author;
    }
    public String getPublisher()
    {
        return publisher;
    }
    public String getPrice()
    {
        return price;
    }
    public String getDescription()
    {
        return description;
    }
    public int getStock()
    {
        return stock;
    }
    public void setISBN(String ISBN)
    {
        this.ISBN = ISBN;
    }
    public void setBookName(String bookName)
    {
        this.bookName = bookName;
    }
    public void setAuthor(String author)
    {
        this.author = author;
    }
    public void setPublisher(String publisher)
    {
        this.publisher = publisher;
    }
    public void setPrice(String price)
    {
        this.price = price;
    }
    public void setDescription(String description)
    {
        this.description = description;
    }
    public void setStock(int stock)
    {
        this.stock = stock;
    }
}
