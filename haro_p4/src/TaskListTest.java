import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.jupiter.api.Assertions.*;
import java.io.IOException;

import java.util.*;

public class TaskListTest{

    private void setup() {
        int size = TaskList.get_size();
        for(int i = 0; i<size; i++)
        {
            TaskList.Remove_Task(i);
        }
    }

    @Test
    public void addTaskIncreaseSize(){
        setup();
        TaskList.Create_New_Task("Title", "Description", "2020-01-01");
        assertEquals(TaskList.get_size(), 1);
        TaskList.Create_New_Task("Title", "Description", "2020-01-01");
        assertEquals(TaskList.get_size(), 2);
    }

    @Test
    public void completingTaskItemChangesStatus() {
        setup();
        TaskList.Create_New_Task("Title", "Description", "2020-01-01");
        TaskList.Mark_Task(0, true);
        assertTrue(TaskList.List.get(0).completed);
    }

    @Test
    public void completingTaskItemFailsWithInvalidIndex() {
        setup();
        assertThrows(IndexOutOfBoundsException.class, () -> {
            TaskList.Create_New_Task("Title", "Description", "2020-01-01");
            TaskList.Mark_Task(2, true);
        });
    }

    @Test
    public void editingTaskItemChangesValues() {
        setup();
        TaskList.Create_New_Task("Title", "Description", "2020-01-01");
        TaskList.Edit_Task(0, "New Title", "New Description", "2022-01-01");
        assertEquals(TaskList.List.get(0).title, "New Title");
        assertEquals(TaskList.List.get(0).description, "New Description");
        assertEquals(TaskList.List.get(0).due_date, "2022-01-01");
    }

    @Test
    public void editingTaskItemDescriptionFailsWithInvalidIndex() {
        setup();
        assertThrows(IndexOutOfBoundsException.class, () -> {
            TaskList.Create_New_Task("Title", "Description", "2020-01-01");
            TaskList.Edit_Task(2, "New Title", "New Description", "2022-01-01");
        });
    }

    @Test
    public void editingTaskItemDueDateChangesValue() {
        setup();
        TaskList tasks = new TaskList();
        TaskList.Create_New_Task("Title", "Description", "2020-01-01");
        TaskList.Edit_Task(0, "New Title", "New Description", "2022-01-01");
        assertEquals(TaskList.List.get(0).due_date, "2022-01-01");
    }

    @Test
    public void editingTaskItemDueDateFailsWithInvalidIndex() {
        setup();
        assertThrows(IndexOutOfBoundsException.class, () -> {
            TaskList.Create_New_Task("Title", "Description", "2020-01-01");
            TaskList.Edit_Task(2, "New Title", "New Description", "2022-01-01");
        });
    }

    @Test
    public void editingTaskItemTitleFailsWithInvalidIndex() {
        setup();
        assertThrows(IndexOutOfBoundsException.class, () -> {
            TaskList.Create_New_Task("Title", "Description", "2020-01-01");
            TaskList.Edit_Task(2, "New Title", "New Description", "2022-01-01");
        });}

    @Test
    public void gettingTaskItemDescriptionFailsWithInvalidIndex() {
        setup();
        assertThrows(IndexOutOfBoundsException.class, () -> {
            TaskList.Create_New_Task("Title", "Description", "2020-01-01");
            String description = TaskList.List.get(2).description;
        });
    }

    @Test
    public void gettingTaskItemDescriptionSucceedsWithValidIndex() {
        setup();
        TaskList.Create_New_Task("Title", "Description", "2020-01-01");
        assertEquals(TaskList.List.get(0).description, "Description");
    }

    @Test
    public void gettingTaskItemDueDateFailsWithInvalidIndex() {
        setup();
        assertThrows(IndexOutOfBoundsException.class, () -> {
            TaskList.Create_New_Task("Title", "Description", "2020-01-01");
            assertEquals(TaskList.List.get(2).due_date, "2020-01-01");
        });
    }


    @Test
    public void gettingTaskItemDueDateSucceedsWithValidIndex() {
        setup();
        TaskList.Create_New_Task("Title", "Description", "2020-01-01");
        assertEquals(TaskList.List.get(0).due_date, "2020-01-01");
    }

    @Test
    public void gettingTaskItemTitleFailsWithInvalidIndex() {
        setup();
        assertThrows(IndexOutOfBoundsException.class, () -> {
            TaskList.Create_New_Task("Title", "Description", "2020-01-01");
            assertEquals(TaskList.List.get(2).title, "Title");
        });
    }

    @Test
    public void gettingTaskItemTitleSucceedsWithValidIndex() {
        setup();
        TaskList.Create_New_Task("Title", "Description", "2020-01-01");
        assertEquals(TaskList.List.get(0).title, "Title");
    }

    @Test
    public void newTaskListIsEmpty() {
        setup();
        assertEquals(TaskList.List.size(), 0);
    }

    @Test
    public void removingTaskItemsDecreasesSize() {
        setup();
        TaskList.Create_New_Task("Title", "Description", "2020-01-01");
        assertEquals(TaskList.get_size(), 1);
        TaskList.Remove_Task(0);
        assertEquals(TaskList.get_size(), 0);
    }

    @Test
    public void removingTaskItemsFailsWithInvalidIndex() {
        setup();
        assertThrows(IndexOutOfBoundsException.class, () -> {
            TaskList.Create_New_Task("Title", "Description", "2020-01-01");
            assertEquals(TaskList.get_size(), 1);
            TaskList.Remove_Task(1);
        });
    }

    @Test
    public void savedTaskListCanBeLoaded() throws IOException {
        setup();
        TaskList.Create_New_Task("TESTTitle", "Description", "2020-01-01");
        TaskList.Savefile("testing");
        TaskList.Loadfile("testing");
        assertEquals(TaskList.List.get(0).title, "TESTTitle");
    }

    @Test
    public void uncompletingTaskItemChangesStatus() {
        setup();
        TaskList.Create_New_Task("Title", "Description", "2020-01-01");
        TaskList.Mark_Task(0, false);
        assertFalse(TaskList.List.get(0).completed);
    }

    @Test
    public void uncompletingTaskItemFailsWithInvalidIndex() {
        setup();
        assertThrows(IndexOutOfBoundsException.class, () -> {
            TaskList.Create_New_Task("Title", "Description", "2020-01-01");
            TaskList.Mark_Task(2, false);
        });
    }



}




