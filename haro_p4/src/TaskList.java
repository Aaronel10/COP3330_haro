import java.io.*;
import java.util.ArrayList;


public class TaskList {
    public static ArrayList<TaskItem> List = new ArrayList<>();
    public static void Loadfile(String filename)
    {
        try
        {
            FileInputStream fis = new FileInputStream(filename);
            ObjectInputStream ois = new ObjectInputStream(fis);
            List = (ArrayList) ois.readObject();
            ois.close();
            fis.close();
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
        }
        catch (ClassNotFoundException c)
        {
            System.out.println("Class not found");
            c.printStackTrace();
        }
    }
    public static void Savefile(String filename)
    {
        try {
            FileOutputStream fos = new FileOutputStream(filename);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(List); // write MenuArray to ObjectOutputStream
            oos.close();
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void Create_New_Task(String titleInput, String descriptionInput, String due_dateInput)
    {
        TaskList.List.add(new TaskItem(false, titleInput,descriptionInput,due_dateInput));
        System.out.println("---New task list has been created.---");
    }

    public static void Edit_Task(int pos, String titleInput, String descriptionInput, String due_dateInput)
    {
        List.get(pos).title = titleInput;
        List.get(pos).description = descriptionInput;
        List.get(pos).due_date = due_dateInput;
        System.out.println("---Task edited.---");
    }

    public static void Remove_Task(int pos)
    {
        List.remove(pos);
        System.out.println("---Task Removed.---");
    }

    public static void Mark_Task(int pos, boolean completed)
    {
        List.get(pos).completed = completed;
    }

    public static int get_size() {
        return(List.size());

    }

    public static void Print_All_Tasks()
    {
        System.out.println("Current Tasks");
        System.out.println("-----------------");
        boolean completed;
        for(int i = 0; i<List.size(); i++)
        {
            String tempstr = "";
            if(List.get(i).completed)
            {
                tempstr = "*** ";
            }
            System.out.printf("%d) "+ tempstr+List.get(i).due_date + " " + List.get(i).title + " "  +List.get(i).description,i+1);
            System.out.println();
        }
    }



}
