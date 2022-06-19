package librarykargah;

import java.util.ArrayList;

public class MyFile {
    static String managerpath = "D:\\programming\\kargahproject\\Manager.txt";
    static ArrayList<Manager> Managers = new ArrayList<>();
    static String memberpath = "D:\\programming\\kargahproject\\Member.txt";
    static ArrayList<Member> Members = new ArrayList<>();
    static String bookpath = "D:\\programming\\kargahproject\\Book.txt";
    static ArrayList<Book> Books = new ArrayList<>();
    static String rentpath = "D:\\programming\\kargahproject\\Rent.txt";
    static ArrayList<Rent> Rents = new ArrayList<>();

    public static void save(Manager manager) {
        Managers.add(manager);
        manager.write();

    }

    public static void save(Member member) {
        Members.add(member);
        member.write();

    }

    public static void save(Book book) {
        Books.add(book);
        book.write();

    }

    public static void save(Rent rent) {
        Rents.add(rent);
        rent.write();

    }

    public  static void remove(Manager manager) {
        Managers.remove(manager);
        manager.write();

    }

    public static void remove(Member member) {
        Members.remove(member);
        member.write();
        for (Rent rent: Rents){
            if (rent.getMember().equals(member))
                Rent.remove(rent);
        }

    }

    public static void remove(Book book) {
        Books.remove(book);
       book.write();
        for (Rent rent: Rents){
            if (rent.getBook().equals(book))
            {
                Rent.remove(rent);
                book.setBorrow(false);
            }

        }

    }

    public static void remove(Rent rent) {
        Rents.remove(rent);
        rent.write();
    }


}
