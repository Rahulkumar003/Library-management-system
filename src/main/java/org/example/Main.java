package org.example;
import java.awt.print.Book;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.time.LocalTime;

public class Main {
        private static final Scanner scanner = new Scanner(System.in);

            public static void main(String[] args) {
                boolean isTrue = true;

                while (isTrue) {
                    // Display the main menu
                    System.out.println("Library Portal Initialized….");
                    System.out.println("1. Librarian");
                    System.out.println("2. Member");
                    System.out.println("3. Exit");
                    System.out.print("Enter your choice: ");
                    int choice = scanner.nextInt();
                    scanner.nextLine();
                    switch (choice) {
                        case 1:
                            LibrarianMenu();
                            break;
                        case 2:
                            System.out.println("Name: ");
                            String name = scanner.nextLine();
                            System.out.println("Phone no: ");
                            String phone_no=scanner.nextLine();
                            if (Library.ismemberpresent(name,phone_no)) {
                                System.out.println("Welcome "+name);
                                MemberMenu(phone_no);
                            }
                            else
                            {
                                System.out.println("Error , member does not exist");
                            }
                            break;
                        case 3:
                            isTrue = false; // Exit the program
                            break;
                        default:
                            System.out.println("Invalid choice. Try again.");
                    }
                }
            }

            private static void LibrarianMenu() {
                // librarian menu here
                boolean notback=true;
                while (notback) {
                    System.out.println("""
                            Librarian Menu:
                            1.Register a member
                            2.Remove a member
                            3.Add a book
                            4.Remove a book
                            5.View all members along with their books and fines to be paid
                            6.View all books
                            7.Back
                            """);
                    int choice1 = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character
                    switch (choice1) {
                        case 1:
                            //Register a member
                            System.out.println("Name: ");
                            String name;
                            name = scanner.nextLine();
                            System.out.println("Age: ");
                            int Age = scanner.nextInt();
                            scanner.nextLine(); // Consume newline character
                            System.out.println("Phone no: ");
                            String phone_no=scanner.nextLine();
                            Member m1=new Member(name,Age,phone_no);
                            Library.register_member(m1);
                            System.out.println(name+" Successfully Registered with "+m1.getMemberId());
                            break;
                        case 2:
                            //.Remove a member
//                            System.out.println("Name: ");
//                            String name2=scanner.nextLine();
                            System.out.println("Member Id: ");
                            int member_id = scanner.nextInt();
                            scanner.nextLine(); // Consume newline character
                            boolean removed=Library.removeMemberById(member_id);
                            if (removed) {
                                System.out.println("Member with ID " + member_id + " removed successfully.");
                            } else {
                                System.out.println("Member with ID " + member_id + " not found.");
                            }
                            break;
                        case 3:
                            //Add a book
                            System.out.println("Book title: ");
                            String Book_title=scanner.nextLine();
                            System.out.println("Author: ");
                            String Author=scanner.nextLine();
                            System.out.println("Copies: ");
                            int Copies = scanner.nextInt();
                            scanner.nextLine(); // Consume newline character
                            for (int i=0;i<Copies;i++) {
                                Books book=new Books(Book_title,Author);
                                Library.add_book(book);
                            }
                            System.out.println("Book Added Successfully!");
                            break;
                        case 4:
                            //Remove a book
                            System.out.println("Book_Id: ");
                            int Book_ID=scanner.nextInt();
                            scanner.nextLine(); // Consume newline character
                            boolean remove =Library.remove_bookById(Book_ID);
                            if (remove) {
                                System.out.println("Book with ID " + Book_ID + " removed successfully.");
                            } else {
                                System.out.println("Book with ID " + Book_ID + " not found.");
                            }
                            break;

                        case 5:
                            // View all members along with their books and fines to be paid
                            List<Member>Allmember= Library.getallmember();
                            for (Member mem:Allmember)
                            {
                                System.out.println("Member Id: "+mem.getMemberId());
                                System.out.println("Name: "+mem.getName());
                                System.out.println("Age: "+mem.getAge());
                                System.out.println("Phone no: "+mem.getPhoneNumber());
                                int fines=0;
                                int fines2=0;
                                if (mem.getIssue1()!=null)
                                {
                                    Books book1=mem.getIssue1();
                                    System.out.println("Issued books: ");
                                    System.out.println(book1.getBook_Id());
                                    System.out.println(book1.getBook_title());
                                    System.out.println(book1.getAuthor());
                                    LocalTime current = LocalTime.now();
                                    fines=Library.calculateFine(book1.getIssue_time(),current);

                                }
                                if (mem.getIssue2()!=null)
                                {
                                    Books book2=mem.getIssue2();
                                    System.out.println("Book Id: "+book2.getBook_Id());
                                    System.out.println("Book Title "+book2.getBook_title());
                                    System.out.println("Author" +book2.getAuthor());
                                    LocalTime current = LocalTime.now();
                                    fines2=Library.calculateFine(book2.getIssue_time(),current);
                                }
                                if (mem.getFines()>fines+fines2){
                                    mem.setFines(mem.getFines());
                                }
                                else{
                                    mem.setFines(fines+fines2);
                                }
                                System.out.println("Fine: "+ mem.getFines());
                                System.out.println("--------------------------------------------------");

                            }

                            break;
                        case 6:
                            // View all books
                            List<Books>books=Library.getallbook();
                            for (Books book1:books)
                            {
                                System.out.println("Book Id: "+book1.getBook_Id());
                                System.out.println("Book title: "+book1.getBook_title());
                                System.out.println("Author: "+book1.getAuthor());
                            }
                            break;
                        case 7:
                            notback=false;
                            break;
                        default:
                            System.out.println("Invalid choice. Try again.");
                    }
                }
            }

            private static void MemberMenu(String phone_no) {
                // member menu here
                boolean notback=true;
                while (notback) {
                    System.out.println("""                                
                            Member Menu
                            1.List Available Books
                            2.List My Books
                            3.Issue book
                            4.Return book
                            5.Pay Fine
                            6.Back
                            """);
                    int choice2 = scanner.nextInt();
                    scanner.nextLine();//next line
                    switch (choice2) {
                        case 1:
                            Library.available_books();
                            break;
                        case 2:
                            //List My Books
                            Member mem2=Library.member_phone_no(phone_no);
                            Books my_book=mem2.getIssue1();
                            Books my_book2=mem2.getIssue2();
                            if (my_book!=null) {
                                System.out.println("Book Id:"+my_book.getBook_Id());
                                System.out.println("Book title: " + my_book.getBook_title());
                                System.out.println("Author: " + my_book.getAuthor());
                            }
                            if (my_book2!=null) {
                                System.out.println("Book Id:"+my_book2.getBook_Id());
                                System.out.println("Book title: " + my_book2.getBook_title());
                                System.out.println("Author: " + my_book2.getAuthor());
                            }
                            break;
                        case 3:
                            // Issue book
                            Member mem1=Library.member_phone_no(phone_no);
                            if(mem1.getIssue1() == null) {
                                Library.available_books();
                                System.out.println("Issue Book here ");
                                System.out.println("Book title: ");
                                String Book_title2 = scanner.nextLine();
                                System.out.println("Book_Id: ");
                                int Book_ID2 = scanner.nextInt();
                                scanner.nextLine();
                                Library.Issue_book(Book_title2, Book_ID2, mem1);//issues book and set there availability false by checking book id and name
                                break;
                            }
                            if (Library.check_if_fine(mem1)) {
                                Library.available_books();
                                System.out.println("Issue Book here ");
                                System.out.println("Book title: ");
                                String Book_title2 = scanner.nextLine();
                                System.out.println("Book_Id: ");
                                int Book_ID2 = scanner.nextInt();
                                scanner.nextLine();
                                Library.second_issue(Book_title2,Book_ID2,mem1);
                            }
                            else {System.out.println("Pay fine and return your book You are not allowed to issue before that.");}
                            break;
                        case 4:
                            // 4.Return book
                            Member mem_ret=Library.member_phone_no(phone_no);
                            Books my_book_ret=mem_ret.getIssue1();
                            Books my_book2_ret=mem_ret.getIssue2();
                            LocalTime time2 = LocalTime.now();
                            if (my_book_ret==null &&my_book2_ret==null)
                            {
                                System.out.println("No book issued");
                            } else if (my_book_ret!=null &&my_book2_ret==null)
                            {
                                System.out.println("Issued book: \n Book Id:"+my_book_ret.getBook_Id());
                                System.out.println("Book title: " + my_book_ret.getBook_title());
                                System.out.println("Author: " + my_book_ret.getAuthor());
                                if (Library.check_if_fine(mem_ret))
                                {
                                    System.out.println("Book returned successfully");
                                    my_book_ret.setAvailability(true);
                                    mem_ret.setIssue1(null);
                                }
                                else
                                {
                                    LocalTime current = LocalTime.now();
                                    int fines=Library.calculateFine(my_book_ret.getIssue_time(),current);
                                    mem_ret.setFines(fines);
                                    int secondsDifference = Math.toIntExact(my_book_ret.getIssue_time().until(current, ChronoUnit.SECONDS));
                                    int late=secondsDifference-10;
                                    System.out.println("Book ID: "+my_book_ret.getBook_Id()+ " successfully returned."+ mem_ret.getFines()+" Rupees has been charged for a delay of "+ late+" days");
                                    my_book_ret.setAvailability(true);
                                    mem_ret.setIssue1(null);
                                }


                            } else if (my_book_ret!=null && my_book2_ret!=null) {
                                System.out.println("Book Id:" + my_book_ret.getBook_Id());
                                System.out.println("Book title: " + my_book_ret.getBook_title());
                                System.out.println("Author: " + my_book_ret.getAuthor());
                                System.out.println("Book Id:" + my_book2_ret.getBook_Id());
                                System.out.println("Book title: " + my_book2_ret.getBook_title());
                                System.out.println("Author: " + my_book2_ret.getAuthor());
                                System.out.println("Book_Id: ");
                                int Book_ID=scanner.nextInt();
                                scanner.nextLine(); // Consume newline character
                                if (Book_ID==my_book_ret.getBook_Id())
                                {
                                    if (Library.check_if_fine(mem_ret))//book1
                                    {
                                        System.out.println("Book returned successfully");
                                        my_book_ret.setAvailability(true);
                                        mem_ret.setIssue1(null);
                                    }
                                    else
                                    {
                                        LocalTime current = LocalTime.now();
                                        int fines=Library.calculateFine(my_book_ret.getIssue_time(),current);
                                        mem_ret.setFines(fines);
                                        int secondsDifference = Math.toIntExact(my_book_ret.getIssue_time().until(current, ChronoUnit.SECONDS));
                                        int late=secondsDifference-10;
                                        System.out.println("Book ID: "+my_book_ret.getBook_Id()+ " successfully returned. "+ mem_ret.getFines()+" Rupees has been charged for a delay of "+ late+" days");
                                        my_book_ret.setAvailability(true);
                                        mem_ret.setIssue1(my_book2_ret);
                                        mem_ret.setIssue2(null);
                                    }
                                }
                                else
                                {

                                    if (Library.check_if_fine2(mem_ret))
                                    {
                                        System.out.println("Book returned successfully");
                                        my_book2_ret.setAvailability(true);
                                        mem_ret.setIssue2(null);
                                    }
                                    else
                                    {
                                        LocalTime current = LocalTime.now();
                                        int fines=Library.calculateFine(my_book2_ret.getIssue_time(),current);
                                        mem_ret.setFines(fines);
                                        int secondsDifference = Math.toIntExact(my_book2_ret.getIssue_time().until(current, ChronoUnit.SECONDS));
                                        int late=secondsDifference-10;
                                        System.out.println("Book ID: "+my_book2_ret.getBook_Id()+ "successfully returned."+ mem_ret.getFines()+"Rupees has been charged for a delay of "+ late+"days");
                                        my_book2_ret.setAvailability(true);
                                        mem_ret.setIssue2(null);
                                    }
                                }
                            }
                            break;
                        case 5:
                            // 5.Pay Fine
                            Member mem_fined=Library.member_phone_no(phone_no);
                            System.out.println("Total fine has been payed !!");
                            mem_fined.setFines(0);
                            break;
                        case 6:
                            notback=false;
                            break;
                        default:
                            System.out.println("Invalid choice. Try again.");
                    }
                }
            }
}