import java.io.*;
import java.text.Format;
import java.text.Normalizer;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;

public class TaskList implements Serializable {


    public static ArrayList<TaskItem> tasks = new ArrayList();

    public static void editTask(int index, String title, String description, LocalDate dueDate) {
        if(title.length() > 0) {
            tasks.get(index).setTitle(title);
        }
        tasks.get(index).setDescription(description);
        tasks.get(index).setDueDate(dueDate);


    }

    public static void removeTask(int index) {
            tasks.remove(index);
    }

    public static void saveTasks(String fileName) {

            try{
                ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(fileName + ".bin"));
                    os.writeObject(tasks);
                    os.close();
            } catch(Exception e){
                System.out.println("Could not save task");
                e.printStackTrace();
                e.getCause();
            }

    }

    public static void loadTask(String fileName) {
        try {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream(fileName + ".bin"));
            tasks = (ArrayList)is.readObject();
            TaskApp.createTaskMenu();
            is.close();
        } catch (IOException | ClassNotFoundException e) {
            e.getCause();
        }catch (ClassCastException e)
        {
            e.getCause();
        }
    }

    public void add(TaskItem ob) {
        tasks.add(ob);
    }


    public ArrayList<TaskItem> getList() {
        System.out.println(tasks.toString());
        return tasks;
    }


    public static void printTasks() {
        System.out.println("Current Tasks:");

        for (int i = 0; i < tasks.size(); i++) {
            if(tasks.get(i).isCompleted())
            {
                System.out.printf("****Completed****%n");
                System.out.printf("%d)", i);
                System.out.println(tasks.get(i).getTitle());
            }
            else {
                System.out.printf("%d)", i);
                System.out.println(tasks.get(i).getTitle());
            }
            System.out.println(tasks.get(i).getDescription());
            System.out.println(tasks.get(i).getDueDate());
            System.out.println();
        }

    }

    public static void markComplete(int index)
    {
        tasks.get(index).setCompleted(true);
    }
    public static void markUncomplete(int index)
    {
        tasks.get(index).setUncompleted();
    }

    public int getSize() {
        return tasks.size();
    }

    public void clear() {
        tasks.clear();
    }

    public TaskItem getObject(int index) {
        return tasks.get(index);
    }
}
