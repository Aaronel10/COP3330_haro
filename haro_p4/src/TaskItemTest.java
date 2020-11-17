import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.jupiter.api.Assertions.*;
import java.io.IOException;

import java.util.*;

public class TaskItemTest{

    @Test
    public void creatingTaskItemFailsWithInvalidDueDate() {
        assertFalse(TaskItem.Check_Date("2020-19-01"));
    }


    @Test
    public void creatingTaskItemFailsWithInvalidTitle() {
        assertThrows(IllegalArgumentException.class, () -> {
            TaskItem.Check_Title("");
        });
    }


    @Test
    public void creatingTaskItemSucceedsWithValidDueDate() {
        assertTrue(TaskItem.Check_Date("2020-01-01"));
    }

    @Test
    public void creatingTaskItemSucceedsWithValidTitle() {
        TaskItem.Check_Title("test");
    }

    @Test
    public void settingTaskItemDueDateFailsWithInvalidDate() {
        assertFalse(TaskItem.Check_Date("196-19-01"));
    }


    @Test
    public void settingTaskItemDueDateSucceedsWithValidDate() {
        assertTrue(TaskItem.Check_Date("2020-01-01"));
    }


    @Test
    public void settingTaskItemTitleSucceedsWithValidTitle() {
        TaskItem.Check_Title("test");
    }

}




