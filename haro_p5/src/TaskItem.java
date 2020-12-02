import java.io.Serializable;
import java.time.LocalDate;

public class TaskItem implements Serializable {
    private String title;
    private String description;
    private LocalDate dueDate;
    private static boolean completed;


    public TaskItem(String title, String description, LocalDate dueDate, boolean completed)
    {
        if(title.length() > 0) {
            this.title = title;
        }
        this.description = description;
        this.dueDate = dueDate;
        this.completed = completed;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if(title.length()> 0)
            this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public boolean isCompleted() {
        return completed;
    }

    public static void setCompleted(boolean status) {
        completed = status;
    }
    public static void setUncompleted()
    {
        completed = false;
    }
}
