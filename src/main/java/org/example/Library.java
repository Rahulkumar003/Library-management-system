package org.example;

import java.util.*;
import java.time.LocalTime;
import java.time.Duration;
import java.time.*;
import java.time.temporal.ChronoUnit;
public class Library {
    private static List<Books> books = new ArrayList<>();
    private static List<Member> members = new ArrayList<>();
    private static int nextMemberId = 1000; // Initialize the counter for Member IDs
    private static int nextBookId = 1;      // Initialize the counter for Book IDs

    public static void add_book(Books book) {
        book.setBook_Id(nextBookId);
        nextBookId++; // Increment the Book ID counter
        books.add(book);
    }

    public static boolean remove_bookById(int Book_id) {
        for (Books book : books) {
            if (book.getBook_Id() == Book_id) {
                books.remove(book);
                return true; // book removed successfully
            }
        }
        return false; // book with the specified ID not found
    }

    public static void register_member(Member member) {
        // Assign the next available Member ID
        member.setMemberId(nextMemberId);
        nextMemberId++; // Increment the Member ID counter
        members.add(member);
    }

    public static boolean removeMemberById(int memberId) {
        for (Member member : members) {
            if (member.getMemberId() == memberId) {
                members.remove(member);
                return true; // Member removed successfully
            }
        }
        return false; // Member with the specified ID not found


    }

    public static List<Books> getallbook() {
        return books;
    }

    public static List<Member> getallmember() {
        return members;
    }

    public static boolean ismemberpresent(String name, String phone_no) {
        boolean found = false;
        for (Member mem : members) {
            if (mem.getName().equals(name) && mem.getPhoneNumber().equals(phone_no)) {
                found = true;
                break;
            }
        }
        return found;
    }

    public static void available_books() {
        for (Books book : books) {
            if (book.isAvailability()) {
                System.out.println("Book Id: " + book.getBook_Id());
                System.out.println("Book title: " + book.getBook_title());
                System.out.println("Author: " + book.getAuthor());
            }
        }
    }
    public static boolean check_if_fine(Member m1) {
        boolean base=true;
            // The member has already issued a book
            // Calculate the time difference between the two issuances
            LocalTime current_time = LocalTime.now();
            Duration duration = Duration.between(m1.getIssue1().getIssue_time(), current_time);
            int secondsDifference = Math.toIntExact(duration.getSeconds());

            if (secondsDifference > 10) {
                base= false;
            }
        return base;
    }
    public static boolean check_if_fine2(Member m1) {
        boolean base = true;
        // The member has already issued a book
        // Calculate the time difference between the two issuances
        LocalTime current_time = LocalTime.now();
        Duration duration = Duration.between(m1.getIssue2().getIssue_time(), current_time);
        int secondsDifference = Math.toIntExact(duration.getSeconds());

        if (secondsDifference > 10) {
            base = false;
        }
        return base;
    }
    public static void second_issue(String Book_title2, int Book_ID2, Member mem1){
        for (Books book : Library.books) {
            if (book.getBook_Id() == (Book_ID2) && (book.getBook_title().equals(Book_title2))) {
                // Allow issuing the second book
                book.setAvailability(false);
                System.out.println("Book Issued Successfully!");
                mem1.setIssue2(book);
                book.setIssue_time1();
                break;
            }
        }
    }
    public static void Issue_book(String Book_title2, int Book_ID2, Member m1) {
        for (Books book : books) {
            if (book.getBook_Id() == (Book_ID2) && (book.getBook_title().equals(Book_title2))) {
                    // Check if the member has already issued a book
                    book.setAvailability(false);
                    System.out.println("Book Issued Successfully!");
                    m1.setIssue1(book);
                    book.setIssue_time();
                    break;
            }
        }
        System.out.println("book does not exist");
    }

    public static Member member_phone_no(String phone_no) {
        Member mem = null;
        for (Member member :members)
        {
            if (member.getPhoneNumber().equals(phone_no) )
            {
                mem=member;
               break;
            }
        }
        return mem;
    }
    public static int calculateFine(LocalTime time1, LocalTime time2) {
        int secondsDifference = Math.toIntExact(time1.until(time2, ChronoUnit.SECONDS));
        int late=secondsDifference-10;
        // Calculate the fine (3 rupees per day late)
        int fine;
        fine = late * 3;

        // Ensure the fine is non-negative
        if (fine < 0) {
            fine = 0;
        }

        return fine;
    }
}