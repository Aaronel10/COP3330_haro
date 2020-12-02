import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.InputMismatchException;

import static org.junit.jupiter.api.Assertions.*;

class TaskItemTest {

    @Test
    public void creatingTaskItemFailsWithInvalidDueDate(){
        assertThrows(Exception.class, () -> {
            TaskItem test = new TaskItem("Task 1", "beep boop", LocalDate.parse("2042-52-14"), false);
        } );
    }


    @Test
    public void creatingTaskItemFailsWithInvalidTitle(){
      TaskItem item = new TaskItem("", "desc", LocalDate.parse("2020-02-21"),false);
      TaskList list = new TaskList();
      list.add(item);
      assertEquals(null,list.getObject(0).getTitle());
    }



    @Test
    public void creatingTaskItemSucceedsWithValidDueDate() {
        TaskItem item = new TaskItem("test", "desc", LocalDate.parse("2020-02-21"),false);
        assertEquals(LocalDate.parse("2020-02-21"), item.getDueDate());
    }


    @Test
    public void creatingTaskItemSucceedsWithValidTitle(){
        TaskItem item = new TaskItem("test", "desc", LocalDate.parse("2020-02-21"),false);
        assertEquals("test", item.getTitle());
    }


    @Test
    public void settingTaskItemDueDateFailsWithInvalidDateFormat(){
        TaskItem item = new TaskItem("test", "desc", LocalDate.parse("2020-02-21"),false);
        assertThrows(DateTimeParseException.class, () -> {
            item.setDueDate(LocalDate.parse("2155215251"));
        } );
    }


    @Test
    public void settingTaskItemDueDateFailsWithInvalidDate(){
        TaskItem item = new TaskItem("test", "desc", LocalDate.parse("2020-02-21"),false);
        assertThrows(DateTimeParseException.class, () -> {
            item.setDueDate(LocalDate.parse("2020-52-24"));
        } );
    }

    @Test
    public void settingTaskItemDueDateSucceedsWithValidDate(){
        TaskItem item = new TaskItem("test", "desc", LocalDate.parse("2020-02-21"),false);
        item.setDueDate(LocalDate.parse("2020-02-24"));
        assertEquals(LocalDate.parse("2020-02-24"), item.getDueDate());
    }


    @Test
    public void settingTaskItemDescriptionSucceedsWithValidDesc(){
        TaskItem item = new TaskItem("Task 1", "desc", LocalDate.parse("2052-02-25"), false);
        item.setDescription("test plz work");
        assertEquals("test plz work", item.getDescription());
    }


    @Test
    public void settingTaskItemTitleFailsWithInvalidTitle(){
        TaskItem item = new TaskItem("Task 1", "desc", LocalDate.parse("2052-02-25"), false);
        item.setTitle("");
        assertEquals("Task 1",item.getTitle());
    }

    @Test
    public void settingTaskItemTitleSucceedsWithValidTitle(){
        TaskItem item = new TaskItem("Task 1", "desc", LocalDate.parse("2052-02-25"), false);
        item.setTitle("actual title");
        assertEquals("actual title",item.getTitle());
    }




}