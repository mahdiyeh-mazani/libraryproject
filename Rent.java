package librarykargah;

import java.io.*;
import java.util.Scanner;

public class Rent extends MyFile implements tostring,Serializable {

    private Book book;
    private Member member;
    private  int date;

    public Rent(Book book, Member member, int date) {
        this.book = book;
        this.member = member;
        this.date = date;
    }
    public static Rent getRent(int date) {
        Rent rent = null;
        for (Rent h : Rents) {
            if (h.getDate() == date) {
                rent = h;
                break;
            }
        }
        return rent;
    }
    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public  int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public static void addrent() {

        Scanner inputName = new Scanner(System.in);
        Scanner inputNum = new Scanner(System.in);
        try {


            System.out.println("Enter  book idi:");
            int idibook = inputNum.nextInt();
            Book book = Book.getBook(idibook);

            System.out.println("Enter  member idi:");
            int idimember = inputNum.nextInt();
            Member member = Member.getMember(idimember);
            System.out.println("Enter date:");
            int date = inputNum.nextInt();
            book.setBorrow(true);
            Rent rent = new Rent(book, member, date);
            rent.save();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void remove() {
        MyFile.remove(this);
    }


    public void write() {
        try {
            FileOutputStream fout = new FileOutputStream(rentpath);
            ObjectOutputStream out = new ObjectOutputStream(fout);
            for (Rent p : Rents) {
                out.writeObject(p);
            }

            out.close();
            System.out.println("success");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    public static void read() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(rentpath));) {

            while (true) {
                Rent p = (Rent) in.readObject();
                Rents.add(p);
            }


        } catch (EOFException eof) {
            System.out.println("Reached end of MyFile");
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }


    public void save() {
        MyFile.save(this);
    }

    public static void show() {
        for (Rent rent : Rents) {
            System.out.println(rent.tos());
        }
    }

    @Override
    public String tos() {
        String Q = getBook().tos() + " " + getMember().tos() + " " + getDate();
        return Q;
    }
}
