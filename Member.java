package librarykargah;

import java.io.*;
import java.util.Scanner;

public class Member extends person {

    private static int static_member_id =1;
    private int Member_id;

    public Member(String name, int national_code) {
        super(name, national_code);
        this.Member_id = static_member_id;
        static_member_id++;
    }

    public int getMember_id() {
        return Member_id;
    }

    public void setMember_id(int member_id) {
        Member_id = member_id;
    }

    public static Member getMember(int member_id) {
        Member member = null;
        for (Member a : Members) {
            if (a.getMember_id() == member_id) {
                member = a;
                break;
            }
        }
        return member;
    }

    public static void addmember() {

        Scanner inputName = new Scanner(System.in);
        Scanner inputNum = new Scanner(System.in);
        try {
            System.out.println("Enter name:");
            String name = inputName.nextLine();
            System.out.println("Enter nationalCode:");
            int nationalCode = inputNum.nextInt();
            Member member = new Member(name, nationalCode);
            member.save();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public  void remove() {
        MyFile.remove(this);

    }


    public void save() {
        MyFile.save(this);
    }


    public void write() {
        try {
            FileOutputStream fout = new FileOutputStream(memberpath);
            ObjectOutputStream out = new ObjectOutputStream(fout);
            for (Member p : Members) {
                out.writeObject(p);
            }

            out.close();
            System.out.println("success");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    public static void read() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(memberpath));) {

            while (true) {
                Member p = (Member) in.readObject();
                Members.add(p);
            }


        } catch (EOFException eof) {
            System.out.println("Reached end of MyFile");
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }finally {
            if (Members.size()!=0){
                int n= Members.size()-1;
                Member.static_member_id = Members.get(n).Member_id+1;
            }
        }
    }

    public static void show() {
        for (Member member : Members) {
            System.out.println(member.tos());
        }
    }

    @Override
    public String tos() {
        String q = getName() + " : national code: " + getNational_code() + "  id: " + getMember_id();
        return q;
    }
}
