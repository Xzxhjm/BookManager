package com.Element;
public class BorrowBook
{
    private int borrowID;
    private String ISBN;
    private String bookName;
    private String borrowerName;
    private String borrowDate;
    private String ddl;
    private String returnDate;
    private int status;
    public BorrowBook(int borrowID, String ISBN, String bookName, String borrowerName, String borrowDate, String ddl, String returnDate, int status)
    {
        this.borrowID = borrowID;
        this.ISBN = ISBN;
        this.bookName = bookName;
        this.borrowerName = borrowerName;
        this.borrowDate = borrowDate;
        this.ddl = ddl;
        this.returnDate = returnDate;
        this.status = status;
    }
    public BorrowBook(int borrowID, String ISBN, String bookName, String borrowerName, String borrowDate, String ddl)
    {
        this.borrowID = borrowID;
        this.ISBN = ISBN;
        this.bookName = bookName;
        this.borrowerName = borrowerName;
        this.borrowDate = borrowDate;
        this.ddl = ddl;
        this.returnDate = "";
        this.status = 0;
    }
    public int getBorrowID()
    {
        return borrowID;
    }
    public String getISBN()
    {
        return ISBN;
    }
    public String getBookName(){return bookName;}
    public String getBorrowerName()
    {
        return borrowerName;
    }
    public String getBorrowDate()
    {
        return borrowDate;
    }
    public String getDdl()
    {
        return ddl;
    }
    public String getReturnDate()
    {
        return returnDate;
    }
    public int getStatus()
    {
        return status;
    }
    public void setBorrowID(int borrowID)
    {
        this.borrowID = borrowID;
    }
    public void setISBN(String ISBN)
    {
        this.ISBN = ISBN;
    }
    public void setBookName(String bookName){this.bookName = bookName;}
    public void setBorrowerName(String borrowerName)
    {
        this.borrowerName = borrowerName;
    }
    public void setBorrowDate(String borrowDate)
    {
        this.borrowDate = borrowDate;
    }
    public void setDdl(String ddl)
    {
        this.ddl = ddl;
    }
    public void setReturnDate(String returnDate)
    {
        this.returnDate = returnDate;
    }
    public void setStatus(int status)
    {
        this.status = status;
    }
}
