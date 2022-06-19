package librarykargah;

import java.io.*;
import java.util.Scanner;

public class Book extends MyFile implements tostring,Serializable {

    private  String name;
    private  String author;
    private static int static_book_id =1;
    private int Book_id;
    private  boolean borrow = false;

    public Book(String name, String author, boolean borrow) {
        this.name = name;
        this.author = author;
        this.Book_id = static_book_id;
        this.borrow = borrow;
        static_book_id++;

    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public  int getBook_id() {
        return Book_id;
    }

    public void setBook_id(int book_id) {
        Book_id = book_id;
    }

    public boolean isBorrow() {
        return borrow;
    }

    public void setBorrow(boolean borrow) {
        this.borrow = borrow;
    }

    public static Book getBook(int book_id) {
        Book book = null;
        for (Book a : Books) {
            if (a.getBook_id() == book_id) {
                book = a;
                break;
            }
        }
        return book;
    }

    public static void addbook() {

        Scanner inputName = new Scanner(System.in);
        Scanner inputNum = new Scanner(System.in);
        try {
            System.out.println("Enter name:");
            String name = inputName.nextLine();
            System.out.println("Enter author:");
            String author = inputName.nextLine();
            Book book = new Book(name, author, false);

            book.save();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void remove() {
        MyFile.remove(this);
    }


    public void write() {
        try {
            FileOutputStream fout = new FileOutputStream(bookpath);
            ObjectOutputStream out = new ObjectOutputStream(fout);
            for (Book p : Books) {
                out.writeObject(p);
            }

            out.close();
            System.out.println("success");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    public static void read() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(bookpath));) {

            while (true) {
                Book p = (Book) in.readObject();
                Books.add(p);
            }


        } catch (EOFException eof) {
            System.out.println("Reached end of MyFile");
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        finally {
            if (Books.size()!=0){
                int n= Books.size()-1;
                Book.static_book_id = Books.get(n).Book_id+1;
            }
        }
    }


    public void save() {
        MyFile.save(this);
    }

    public static void show() {
        for (Book book : Books) {
            System.out.println(book.tos());
        }
    }

    @Override
    public String tos() {
        String q = getName() + " : " + getAuthor() + " " + getBook_id();
        return q;
    }
}
