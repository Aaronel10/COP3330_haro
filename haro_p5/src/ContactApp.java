import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ContactApp {

    private static Scanner input = new Scanner(System.in);

    public static void runMainContactMenu() {
        int response = 0;
        System.out.printf("1) create a new list %n" +
                "2) load an existing list %n" +
                "3) quit %n" +
                ":");
        do {
            try {
                response = input.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Answer must be an integer between 1 and 3 inclusive.");
            } finally {
                input.nextLine();
            }
        }while(response < 1 || response > 3);

        switch(response)
        {
            case 1 :
            {
                createContactMenu();
            }
            case 2 :
            {
                System.out.println("Enter the name of the file you're searching for");
                String fileName = input.next();
                ContactList.loadContact(fileName); //need to actually set this up to store contactlists
            }
            case 3 :
            {
                System.exit(1);
            }
        }
    }

    public static void createContactMenu() {
        int response = 0;

        System.out.printf("1) view the list %n" +
                "2) add an item %n" +
                "3) edit an item %n" +
                "4) remove an item %n" +
                "5) save the current list %n" +
                "6) quit to main menu %n:" );

        do{
            try{
                response = input.nextInt();
            }catch (InputMismatchException e )
            {
                System.out.println("Answer must be an integer between 1 and 8 inclusive");
            }finally {
                input.nextLine();
            }
        }while(response < 1 || response > 6);
        TaskList ob = new TaskList();
        switch (response)
        {
            case 1:
            {
                ContactList.printContacts();
                System.out.println("Press enter to go back to main menu");
                input.nextLine();
                createContactMenu();

            }
            case 2:
            {
                String firstName = "";
                try {
                    System.out.println("Enter a first name: ");
                     firstName = input.nextLine();

                }   catch (InputMismatchException e)
                {
                    System.out.println("Only characters can be used");
                }

                String lastName = "";
                try {
                    System.out.println("Enter a last name:");
                    lastName = input.nextLine();


                } catch (InputMismatchException e) {
                    System.out.println("only characters can be used");
                }

                System.out.println("Enter phone number:");
                String number = input.nextLine();

                System.out.println("Enter your email:");
                String email = input.nextLine();

                ContactItem contact = new ContactItem(firstName, lastName, number, email);
                ContactList.add(contact);

                createContactMenu();
            }
            case 3:
                ContactList.printContacts();
            {
                System.out.println("Enter the index for which contact you want to edit");
                int index = 0;
                try {
                    index = input.nextInt();
                } catch (InputMismatchException e)
                {
                    System.out.println("index must be an integer");
                }
                while (index > ContactList.contacts.size())
                {
                    System.out.println("index invalid, try again");
                    try {
                        index = input.nextInt();
                    } catch (InputMismatchException e)
                    {
                        System.out.println("index must be an integer");
                    }
                } // end while loop

                input.nextLine();
                String firstName = "";
                try {
                    System.out.println("Enter a first name: ");
                    firstName = input.nextLine();

                }   catch (InputMismatchException e)
                {
                    System.out.println("Only characters can be used");
                }

                String lastName = "";
                try {
                    System.out.println("Enter a last name:");
                    lastName = input.nextLine();

                } catch (InputMismatchException e) {
                    System.out.println("only characters can be used");
                }

                System.out.println("Enter phone number:");
                String number = input.nextLine();

                System.out.println("Enter your email:");
                String email = input.nextLine();

                ContactList.editContact(index, firstName, lastName, number, email);
                System.out.println("Edit failed, contact must have at least one of the 4 options");


                createContactMenu();
            }
            case 4:
            {
                ContactList.printContacts();
                System.out.println("Enter the index for which task you want to remove");
                int index = 0;
                try {
                    index = input.nextInt();
                } catch (InputMismatchException e)
                {
                    System.out.println("index must be an integer");
                }
                while (index > ContactList.contacts.size())
                {
                    System.out.println("index invalid, try again");
                    try {
                        index = input.nextInt();
                    } catch (InputMismatchException e)
                    {
                        System.out.println("index must be an integer");
                    }
                } // end while loop

                ContactList.removeContact(index);

                createContactMenu();
            }
            case 5:
            {
                System.out.println("Enter the file name you'd like to save it as:");
                String fileName = input.nextLine();
                ContactList.saveContacts(fileName);

            }
            case 6:
            {
                runMainContactMenu();
                break;
            }

        } // end of switch
    }

}
