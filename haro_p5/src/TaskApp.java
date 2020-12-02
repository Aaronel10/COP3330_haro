import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.*;

public class TaskApp {

    private static Scanner input = new Scanner(System.in);

    /*
    public static void main(String[] args) {
        runMainMenu();
    }
    comment out main method to put into App*/

    public static void runMainTaskMenu()
    {
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
                    createTaskMenu();
                }
                case 2 :
                {
                    System.out.println("Enter the name of the file you're searching for");
                    String fileName = input.next();
                    TaskList.loadTask(fileName);
                }
                case 3 :
                {
                    System.exit(1);
                }
            }
    }

    public static void createTaskMenu() {
        int response = 0;

        System.out.printf("1) view the list %n" +
                "2) add an item %n" +
                "3) edit an item %n" +
                "4) remove an item %n" +
                "5) mark item as completed %n" +
                "6) unmark an item as completed %n" +
                "7) save the current list %n" +
                "8) quit to main menu %n" +
                ":");

        do{
            try{
                response = input.nextInt();
            }catch (InputMismatchException e )
            {
                System.out.println("Answer must be an integer between 1 and 8 inclusive");
            }finally {
                input.nextLine();
            }
        }while(response < 1 || response > 8);
        TaskList ob = new TaskList();
        switch (response)
        {
            case 1:
            {
                TaskList.printTasks();
                System.out.println("Press enter to go back to main menu");
                input.nextLine();
                createTaskMenu();

            }
            case 2:
            {

                    System.out.println("Enter a title: ");
                    String title = input.nextLine();
                    LocalDate dueDate;
                    while (title.length() < 1) {
                        System.out.println("title must be at least 1 character in length");
                         title = input.nextLine();
                    }
                    String description = "";
                    try {
                        System.out.println("Enter a description");
                         description = input.nextLine();

                    } catch (InputMismatchException e) {
                        System.out.println("Description must be characters");
                    }
                do {
                    try {
                        System.out.println("Enter a date in YYYY-MM-DD:");
                         dueDate = LocalDate.parse(input.nextLine());
                        break;
                    } catch (InputMismatchException |DateTimeParseException e) {
                        System.out.println("Date must be in YYYY-MM-DD format: ");
                    }
                }while(true);
                TaskItem item = new TaskItem(title, description, dueDate, false);
                ob.add(item);
                createTaskMenu();
            }
            case 3:
                TaskList.printTasks();
            {
                System.out.println("Enter the index for which task you want to edit");
                int index = 0;
                try {
                     index = input.nextInt();
                } catch (InputMismatchException e)
                {
                    System.out.println("index must be an integer");
                }
                while (index > TaskList.tasks.size())
                {
                    System.out.println("index invalid, try again");
                    try {
                        index = input.nextInt();
                    } catch (InputMismatchException e)
                    {
                        System.out.println("index must be an integer");
                    }
            } // end while loop

                System.out.println("Enter a title: ");
                String title = input.nextLine();
                LocalDate dueDate;
                while (title.length() < 1) {
                    System.out.println("title must be at least 1 character in length");
                    title = input.nextLine();
                }
                String description = "";
                try {
                    System.out.println("Enter a description");
                    description = input.nextLine();

                } catch (InputMismatchException e) {
                    System.out.println("Description must be characters");
                }
                do {
                    try {
                        System.out.println("Enter a date in YYYY-MM-DD:");
                        dueDate = LocalDate.parse(input.nextLine());
                        break;
                    } catch (InputMismatchException |DateTimeParseException e) {
                        System.out.println("Date must be in YYYY-MM-DD format: ");
                    }
                }while(true);

                TaskList.editTask(index, title, description, dueDate);
                createTaskMenu();
            }
            case 4:
            {
                TaskList.printTasks();
                System.out.println("Enter the index for which task you want to remove");
                int index = 0;
                try {
                    index = input.nextInt();
                } catch (InputMismatchException e)
                {
                    System.out.println("index must be an integer");
                }
                while (index > TaskList.tasks.size())
                {
                    System.out.println("index invalid, try again");
                    try {
                        index = input.nextInt();
                    } catch (InputMismatchException e)
                    {
                        System.out.println("index must be an integer");
                    }
                } // end while loop

                TaskList.removeTask(index);

                createTaskMenu();
            }
            case 5:
            {
                TaskList.printTasks();
                System.out.println("Enter the index for which task you want to mark as completed");
                int index = 0;

                do {
                    try {
                        index = input.nextInt();
                        TaskList.markComplete(index);
                        break;
                    } catch (IndexOutOfBoundsException | InputMismatchException e) {
                        System.out.println("Invalid index, please try again and pick one from the list");
                        index = input.nextInt();
                    }

                }while(true);
                createTaskMenu();

            }
            case 6:
            {
                TaskList.printTasks();
                System.out.println("Enter the index for which task you want to unmark as completed");
                int index = 0;

                do {
                    try {
                        index = input.nextInt();
                        TaskList.markUncomplete(index);
                        break;
                    } catch (IndexOutOfBoundsException | InputMismatchException e) {
                        System.out.println("Invalid index, please try again and pick one from the list");
                        index = input.nextInt();
                    }

                }while(true);
                createTaskMenu();
            }
            case 7:
            {
                System.out.println("Enter the file name you'd like to save it as:");
                String fileName = input.nextLine();
                TaskList.saveTasks(fileName);
            }
            case 8:
            {
                runMainTaskMenu();
                break;
            }
        }


    }




}
