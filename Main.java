package librarykargah;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        Scanner d = new Scanner(System.in);

        Manager.read();
        Member.read();
        Book.read();
        Rent.read();

        try {

            while (true) {

                System.out.println("Please Select Menu");
                System.out.println("1: Add Manager");
                System.out.println("2: Add Member");
                System.out.println("3: Add Book");
                System.out.println("4: Add Rent");
                System.out.println("5: show Manager");
                System.out.println("6: show Member");
                System.out.println("7: show Book");
                System.out.println("8: show Rent");
                System.out.println("9: remove Manager");
                System.out.println("10: remove Member");
                System.out.println("11: remove Book");
                System.out.println("12: remove Rent");
                System.out.println("13: exit");

                System.out.println("Enter a menu number:");
                int z = d.nextInt();

                switch (z) {

                    case 1:
                        Manager.addmanager();
                        break;

                    case 2:
                        Member.addmember();
                        break;

                    case 3:
                        Book.addbook();
                        break;

                    case 4:
                        Rent.addrent();
                        break;

                    case 5:
                        Manager.show();
                        break;
                    case 6:

                        Member.show();
                        break;
                    case 7:

                        Book.show();
                        break;
                    case 8:

                        Rent.show();
                        break;
                    case 9:
                        System.out.println("Enter nationalcode:");
                        int v = d.nextInt();
                        Manager manager= Manager.getManager(v);
                        manager.remove();

                        break;
                    case 10:
                        System.out.println("Enter idi:");
                        int b = d.nextInt();
                        Member member= Member.getMember(b);
                        member.remove();
                        break;
                    case 11:
                        System.out.println("Enter idi:");
                        int o= d.nextInt();
                        Book book= Book.getBook(o);

                        book.remove();
                        break;
                    case 12:
                        System.out.println("Enter date:");
                        int q = d.nextInt();
                        Rent rent= Rent.getRent(q);
                        rent.remove();

                        break;
                    case 13:
                        System.exit(0);
                        break;

                    default:
                        System.out.println("incorrect");

                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }


}

