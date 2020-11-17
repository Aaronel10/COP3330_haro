import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
public class App {
    public static void main(String[] args)
    {
        int userinput = 0;
        userinput = takeinput(3);
        if(userinput == 1){
            //create a new list
            Processinput();
        }
        else if(userinput == 2) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter a filename.");
            String filename = sc.nextLine();
            TaskList.Loadfile(filename);
            Processinput();

        }
    }

    private static void Processinput()
    {
        int userinput = 0;
        while(userinput != 8)
        {
            userinput = takeinput(8);
            if(userinput == 1){
                TaskList.Print_All_Tasks();
            }
            else if(userinput == 2){
                String[] input = Inputfornewtask();
                TaskList.Create_New_Task(input[0], input[1], input[2]);
            }
            else if(userinput == 3){
                TaskList.Print_All_Tasks();
                System.out.println("Pick a task from the list above.");
                int pos = Task_Input("edit");
                String[] input = Inputfornewtask();
                TaskList.Edit_Task(pos, input[0], input[1], input[2]);
            }
            else if(userinput == 4){
                TaskList.Print_All_Tasks();
                System.out.println("Pick a task from the list above.");
                int pos = Task_Input("remove");
                TaskList.Remove_Task(pos);
            }
            else if(userinput == 5){
                TaskList.Print_All_Tasks();
                System.out.println("Pick a task from the list above.");
                int pos = Task_Input("mark complete");
                TaskList.Mark_Task(pos, true);
            }
            else if(userinput == 6){
                TaskList.Print_All_Tasks();
                System.out.println("Pick a task from the list above.");
                int pos = Task_Input("unmark");
                TaskList.Mark_Task(pos, false);
            }
            else if(userinput == 7){
                Scanner sc = new Scanner(System.in);
                System.out.println("Enter a filename.");
                String filename = sc.nextLine();
                TaskList.Savefile(filename);
            }
        }
    }
    private static int takeinput(int menulen) {
        int flag = -1;
        int userinput = 0;
        int check = 0;
        while (flag == -1){
            try
            {
                Scanner sc = new Scanner(System.in);
                if(menulen == 3)
                {
                    outputMenu();
                }
                else if(menulen == 8)
                {
                    secondMenu();
                }
                userinput = sc.nextInt();
                for(int i = 1; i<=menulen;i++)
                {
                    if(userinput == i)
                    {
                        check = 1;
                        break;
                    }
                }
                if(check == 1){
                    flag = 0;
                    break;
                }
                else{
                    System.out.println("Incorrect input. Please choose the available values from the menu.");
                }
            }
            catch (InputMismatchException exception)
            {
                System.out.println("Incorrect input. Only integer value is accepted.");
            }
        }
        if(userinput == menulen)
        {
            System.out.println("GoodBye.");
            System.exit(0);
        }
        return(userinput);
    }
    private static void outputMenu() {
        System.out.println("-----------------");
        System.out.println("1) Create a new list");
        System.out.println("2) Load an existing list");
        System.out.println("3) Quit");
    }

    private static void secondMenu() {
        System.out.println("-----------------");
        System.out.println("1) View a list.");
        System.out.println("2) Add an item");
        System.out.println("3) Edit an item");
        System.out.println("4) Remove an item");
        System.out.println("5) Mark an item as complete");
        System.out.println("6) Unmark an item as completed");
        System.out.println("7) Save the current list.");
        System.out.println("8) Quit");
    }

    private static String[] Inputfornewtask()
    {
        Scanner sc = new Scanner(System.in);
        String title;
        String description;
        String due_date;
        System.out.println("Task title: ");
        title = sc.nextLine();
        System.out.println("Task description: ");
        description = sc.nextLine();
        System.out.println("Task due date (YYYY-MM-DD):");
        while(true) {
            due_date = sc.next();
            if(TaskItem.Check_Date(due_date))
                break;
            else
                System.out.println("Date must be in the format of YYYY-MM-DD");
        }

        return(new String[]{title, description, due_date});
    }

    private static int Task_Input(String option)
    {
        System.out.printf("Which task will you %s?", option);
        System.out.println();
        int size = TaskList.List.size();
        int userinput = 0;
        int check = 0;
        while (true){
            try
            {
                Scanner sc = new Scanner(System.in);
                userinput = sc.nextInt();
                for(int i = 1; i<=size+1;i++)
                {
                    if(userinput == i)
                    {
                        check = 1;
                        break;
                    }
                }
                if(check == 1){
                    break;
                }
                else{
                    System.out.println("Incorrect input. Please choose the available values from the menu.");
                }
            }
            catch (InputMismatchException exception)
            {
                System.out.println("Incorrect input. Only integer value is accepted.");
            }
        }
        return(userinput-1);
    }
}
