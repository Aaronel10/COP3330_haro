import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int response = getUserChoice();
        processResponse(response);

    }

    private static void processResponse(int response) {
        switch (response)
        {
            case 1:
            {
                TaskApp.runMainTaskMenu();
            }
            case 2:
            {
                ContactApp.runMainContactMenu();
            }
            case 3:
            {
                System.exit(1);
            }
        }
    }

    private static int getUserChoice() {
        int response = 0;
        do {
            try {
                System.out.printf("1) task list %n" +
                        "2) contact list %n" +
                        "3) quit%n");
                response = input.nextInt();
                if(response > 3 || response < 1){
                    continue;
                }
                break;

            } catch (InputMismatchException e) {
                System.out.println("response must be a integer between 1 and 3 inclusive");

            }
        }while(true);

        return response;
    }



}
