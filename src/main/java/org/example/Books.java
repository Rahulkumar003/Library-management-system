package org.example;

import java.time.LocalTime;

public class Books
{
    private  String Book_title;
    private  String Author;
    private  int Book_Id=1;
    private boolean availability=true;
    private LocalTime issue_time=null;
    private LocalTime issue_time1=null;
    Books(String Book_title,String Author)
    {
    this.Book_title=Book_title;
    this.Author=Author;
    }

    public String getBook_title() {
        return Book_title;
    }

    public String getAuthor() {
        return Author;
    }

    public int getBook_Id() {
        return Book_Id;
    }

    public void setBook_title(String book_title) {
        this.Book_title = book_title;
    }

    public void setAuthor(String author) {
        this.Author = author;
    }

    public void setBook_Id(int book_Id) {
        this.Book_Id = book_Id;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public LocalTime getIssue_time() {
        return issue_time;
    }

    public void setIssue_time() {
        this.issue_time = LocalTime.now();
    }

    public void setIssue_time1() {
        this.issue_time = LocalTime.now();
    }

    public LocalTime getIssue_time1() {
        return issue_time1;
    }

    public void setIssue_time1(LocalTime issue_time1) {
        this.issue_time1 = issue_time1;
    }
}
