package com.crud;

import java.util.Scanner;

public class LibraryApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        BookDAO dao = new BookDAO();

        while (true) {
            System.out.println("\n--- Library Management System ---");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Delete Book");
            System.out.println("6. Update Book");   
            System.out.println("7. Exit");          
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    sc.nextLine();
                    System.out.print("Enter Book Title: ");
                    String title = sc.nextLine();

                    System.out.print("Enter Author Name: ");
                    String author = sc.nextLine();

                    System.out.print("Enter Price: ");
                    double price = sc.nextDouble();

                    System.out.print("Enter Total Copies: ");
                    int copies = sc.nextInt();

                    Book book = new Book(title, author, price, copies);
                    dao.addBook(book);
                    break;

                case 2:
                    dao.viewBooks();
                    break;

                case 3:
                    System.out.print("\nEnter Book ID to issue: ");
                    int issueId = sc.nextInt();
                    dao.issueBook(issueId);
                    break;

                case 4:
                    System.out.print("\nEnter Book ID to return: ");
                    int returnId = sc.nextInt();
                    dao.returnBook(returnId);
                    break;

                case 5:
                    System.out.print("\nEnter Book ID to delete: ");
                    int deleteId = sc.nextInt();
                    dao.deleteBook(deleteId);
                    break;

                case 6: 
                    sc.nextLine();
                    System.out.print("Enter Book ID to update: ");
                    int updateId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter New Title: ");
                    String newTitle = sc.nextLine();

                    System.out.print("Enter New Author: ");
                    String newAuthor = sc.nextLine();

                    System.out.print("Enter New Price: ");
                    double newPrice = sc.nextDouble();

                    System.out.print("Enter New Total Copies: ");
                    int newCopies = sc.nextInt();

                    dao.updateBook(updateId, newTitle, newAuthor, newPrice, newCopies);
                    break;

                case 7:
                    System.out.println("Thank you for using Library Management System!");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
