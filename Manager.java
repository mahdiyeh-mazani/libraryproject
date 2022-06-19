package librarykargah;

import java.io.*;
import java.util.Scanner;

public class Manager extends person {

    public Manager(String name, int national_code) {
        super(name, national_code);
    }



    public static Manager getManager(int national_code) {
        Manager manager = null;
        for (Manager a : Managers) {
            if (a.getNational_code() == national_code) {
                manager = a;
                break;
            }
        }
        return manager;
    }

    public static void addmanager() {

        Scanner inputName = new Scanner(System.in);
        Scanner inputNum = new Scanner(System.in);
        try {
            System.out.println("Enter name:");
            String name = inputName.nextLine();
            System.out.println("Enter nationalCode:");
            int nationalCode = inputNum.nextInt();


            Manager manager = new Manager(name, nationalCode);

            manager.save();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public  void remove() {
        MyFile.remove(this);

    }


    public void write() {
        try {
            FileOutputStream fout = new FileOutputStream(managerpath);
            ObjectOutputStream out = new ObjectOutputStream(fout);
            for (Manager p : Managers) {
                out.writeObject(p);
            }

            out.close();
            System.out.println("success");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    public static void read() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(managerpath));) {

            while (true) {
                Manager p = (Manager) in.readObject();
                Managers.add(p);
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
        for (Manager manager : Managers) {
            System.out.println(manager.tos());
        }
    }


    @Override
    public String tos() {
        String q = getName() + " : " + getNational_code();
        return q;
    }
}
