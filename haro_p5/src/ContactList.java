import java.io.*;
import java.util.ArrayList;

public class ContactList {
    public static ArrayList <ContactItem> contacts = new ArrayList<>();

    public static void loadContact(String fileName) {
        try {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream(fileName + ".bin"));
            contacts = (ArrayList)is.readObject();
            ContactApp.createContactMenu();
            is.close();
        } catch (IOException | ClassNotFoundException e) {
            e.getCause();
        }catch (ClassCastException e)
        {
            e.getCause();
        }
    }


    public static void add(ContactItem contact) {
        contacts.add(contact);
    }


    public static void printContacts() {
        for (int i = 0; i < contacts.size(); i++) {

            System.out.printf("%d)", i);
            System.out.println(contacts.get(i).getFirstName());
            System.out.println(contacts.get(i).getLastName());
            System.out.println(contacts.get(i).getPhoneNumber());
            System.out.println(contacts.get(i).getEmail());
            System.out.println();
        }

    }


    public static void editContact(int index, String firstName, String lastName, String number, String email) {
        if(firstName != "" || lastName != "" || number != "" || email != "") {
            contacts.get(index).setFirstName(firstName);
            contacts.get(index).setLastName(lastName);
            contacts.get(index).setPhoneNumber(number);
            contacts.get(index).setEmail(email);
        }
    }

    public static void removeContact(int index) {
        contacts.remove(index);
    }

    public static void saveContacts(String fileName) {
        try{
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(fileName + ".bin"));
            os.writeObject(contacts);
            os.close();
        } catch(Exception e){
            System.out.println("Could not save contact");
            e.printStackTrace();
            e.getCause();
        }

    }

    public int getSize() {
        return contacts.size();
    }

    public void clear() {
        contacts.clear();
    }


}
