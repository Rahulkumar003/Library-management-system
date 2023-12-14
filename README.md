
Library Management System
This is a Library Management System application developed using Object-Oriented Programming (OOP) principles. The system provides functionalities for both librarians and members/students.

Table of Contents

1.Features
2.How to Run
3.Input Validation
4.Error Handling
5.OOP Principles


1.Features
Add Book:
Allows librarians to add a new book to the library.
Takes input for book details (title, author, total copies).

Remove Book:
Allows librarians to remove a book from the library.
Takes input for book ID.

Register Member:
Allows librarians to add a new member to the library.
Takes input for member details (name, age, phone number).

Remove Member:
Allows librarians to remove a member from the library.
Takes input for member ID.

Enter as a Member:
Takes member name and phone number as input and logs in as the particular member.
If not registered, gives an error message.

Issue Book:
Allows a member to borrow a book from the library, given their penalty amount is zero.
Displays available books and takes input for book ID.

Return Book:
Allows a member to return a borrowed book.
Displays borrowed books and takes input for book ID.

List Books:
Displays a list of all available books in the library.

List Members:
Displays a list of all registered members of the library.

Calculate Fine:
Calculates and displays the fine amount for a book if it's returned after the due date (10 days).

Exit:
Terminates the application.

2.How to Run

To run the Library Management System:
Ensure that Maven is installed on your system.
Clone the repository: git clone <repository-url>
Navigate to the project directory.
Run the command: mvn clean compile exec:java

3.Input Validation
The system implements input validation to handle incorrect or invalid user inputs.
It checks for valid inputs during member registration, book addition, and various other interactions.

4.Error Handling
Proper error handling is implemented to display user-friendly error messages.
For example, when a member tries to log in and is not registered, an appropriate error message is shown.

5.OOP Principles
The code follows Object-Oriented Programming principles, including encapsulation, inheritance, and polymorphism.
