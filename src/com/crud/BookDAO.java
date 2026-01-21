package com.crud;

import java.sql.*;

public class BookDAO {

    // Add Book
    public void addBook(Book book) {
        try (Connection con = DBConnection.getConnection()) {

            String sql = "INSERT INTO books(title, author, price, total_copies, available_copies) " +
                         "VALUES (?, ?, ?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, book.getTitle());
            ps.setString(2, book.getAuthor());
            ps.setDouble(3, book.getPrice());
            ps.setInt(4, book.getTotalCopies());
            ps.setInt(5, book.getTotalCopies());

            ps.executeUpdate();
            System.out.println("Book added successfully!");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // View Books
    public void viewBooks() {
        try (Connection con = DBConnection.getConnection()) {

            String sql = "SELECT * FROM books";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            System.out.println("\nID | Title | Author | Price | Available/Total");
            System.out.println("-----------------------------------------------");

            while (rs.next()) {
                System.out.println(
                        rs.getInt("book_id") + " | " +
                        rs.getString("title") + " | " +
                        rs.getString("author") + " | " +
                        rs.getDouble("price") + " | " +
                        rs.getInt("available_copies") + "/" +
                        rs.getInt("total_copies")
                );
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Issue Book
    public void issueBook(int id) {
        try (Connection con = DBConnection.getConnection()) {

            String sql = "UPDATE books SET available_copies = available_copies - 1 " +
                         "WHERE book_id = ? AND available_copies > 0";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Book issued successfully!");
            } else {
                System.out.println("No copies available!");
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Return Book
    public void returnBook(int id) {
        try (Connection con = DBConnection.getConnection()) {

            String sql = "UPDATE books SET available_copies = available_copies + 1 " +
                         "WHERE book_id = ? AND available_copies < total_copies";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Book returned successfully!");
            } else {
                System.out.println("All copies already available!");
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Delete Book
    public void deleteBook(int id) {
        try (Connection con = DBConnection.getConnection()) {

            String sql = "DELETE FROM books WHERE book_id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Book deleted successfully!");
            } else {
                System.out.println("Book not found!");
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    
    public void updateBook(int id, String title, String author, double price, int totalCopies) {
        try (Connection con = DBConnection.getConnection()) {

            String sql = "UPDATE books SET title = ?, author = ?, price = ?, total_copies = ? " +
                         "WHERE book_id = ?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, title);
            ps.setString(2, author);
            ps.setDouble(3, price);
            ps.setInt(4, totalCopies);
            ps.setInt(5, id);

            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Book updated successfully!");
            } else {
                System.out.println("Book not found!");
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
