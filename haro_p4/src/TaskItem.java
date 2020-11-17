import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
public class TaskItem implements Serializable {
    boolean completed;
    String title;
    String description;
    String due_date;
    TaskItem(boolean completedInput, String titleInput, String descriptionInput, String due_dateInput)
    {
        completed        =   completedInput;
        title           =   titleInput;
        description     =   descriptionInput;
        due_date        =   due_dateInput;
    }


    public static boolean Check_Date(String date)
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        try {
            dateFormat.parse(date.trim());
            return(true);
        } catch (ParseException pe) {
            return(false);
        }

    }
    public static void Check_Title(String title)
    {
        if(title == null || title.isEmpty()){
            throw new IllegalArgumentException("Title cannot be empty");
        }
    }


}
