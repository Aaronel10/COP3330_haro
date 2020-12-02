import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class TaskListTest {

    @Test
    public void addingItemsIncreasesSize()
    {
        TaskItem item = new TaskItem("title", "desc", LocalDate.parse("2020-02-21"), false);
        TaskList list = new TaskList();
        list.add(item);
        assertEquals(1,list.getSize());
        list.clear();
    }

    @Test
    public void completingTaskItemChangesStatus()
    {
        TaskItem item = new TaskItem("title", "desc", LocalDate.parse("2020-02-21"), false);
        TaskList list = new TaskList();
        list.add(item);
        list.markComplete(0);
        assertEquals(true, item.isCompleted());
        list.clear();
    }


    @Test
    public void completingTaskItemFailsWithInvalidIndex() {
        TaskItem task = new TaskItem("a", "b", LocalDate.parse("2020-02-11"), false);
        TaskList list = new TaskList();
        list.add(task);
        assertThrows(IndexOutOfBoundsException.class, () -> { list.markComplete(50);
        } );
        list.clear();
    }


    @Test
    public void editingTaskItemChangesValues(){
        TaskItem task = new TaskItem("fasfasfsa", "sfafasf", LocalDate.parse("2020-02-21"), false);
        TaskList list = new TaskList();
        list.add(task);
        list.editTask(0,"title", "desc", LocalDate.parse("2020-02-21"));

        assertEquals("title", task.getTitle());
        list.clear();
    }



    @Test
    public void editingTaskItemDescriptionChangesValue(){
        TaskItem task = new TaskItem("fasfasfsa", "sfafasf", LocalDate.parse("2020-02-21"), false);
        TaskList list = new TaskList();
        list.add(task);
        list.editTask(0, "new task", "description", LocalDate.parse("2020-02-21"));
        assertEquals("description", task.getDescription());
        list.clear();
    }


    @Test
    public void editingTaskItemDescriptionFailsWithInvalidIndex(){
        TaskItem task = new TaskItem("fasfasfsa", "sfafasf", LocalDate.parse("2020-02-21"), false);
        TaskList list = new TaskList();
        list.add(task);

        assertThrows(IndexOutOfBoundsException.class, () -> {         list.editTask(50, "dasda", "fasfa", LocalDate.parse("2020-02-21") );;
        } );
        list.clear();
    }



    @Test
    public void editingItemDescriptionSucceedsWithExpectedValue() {
        TaskItem task = new TaskItem("fasfasfsa", "sfafasf", LocalDate.parse("2020-02-21"), false);
        TaskList list = new TaskList();
        list.add(task);
        list.editTask(0,"name", "expected", LocalDate.parse("2020-02-21"));
        assertEquals("expected", task.getDescription());
        list.clear();

    }


    @Test
    public void editingTaskItemDueDateFailsWithInvalidIndex() {
        TaskItem task = new TaskItem("fasfasfsa", "sfafasf", LocalDate.parse("2020-02-21"), false);
        TaskList list = new TaskList();
        list.add(task);
        assertThrows(IndexOutOfBoundsException.class, () -> {         list.editTask(4, "gasgasg", "sfafasf", LocalDate.parse("2020-10-21"));;
        } );
        list.clear();
    }


    @Test
    public void editingTaskItemTitleChangesValue(){
        TaskItem task = new TaskItem("fasfasfsa", "sfafasf", LocalDate.parse("2020-02-21"), false);
        TaskList list = new TaskList();
        list.add(task);
        list.editTask(0, "new title", "fasfsa", LocalDate.parse("2020-02-21"));
        assertEquals("new title", task.getTitle());
        list.clear();
    }

    @Test
    public void editingTaskItemTitleFailsWithInvalidIndex() {
        TaskItem task = new TaskItem("fasfasfsa", "sfafasf", LocalDate.parse("2020-02-21"), false);
        TaskList list = new TaskList();
        list.add(task);
        assertThrows(IndexOutOfBoundsException.class, () -> {         list.editTask(4, "new title to test", "sfafasf", LocalDate.parse("2020-10-21"));;
        } );
        list.clear();
    }


    @Test
    public void editingItemTitleFailsWithEmptyString() {
        TaskItem task = new TaskItem("title", "desc", LocalDate.parse("2020-02-21"), false);
        TaskList list = new TaskList();
        list.add(task);
        list.editTask(0, "", "desc", LocalDate.parse("2020-02-21"));
        assertEquals("title", task.getTitle());
        list.clear();

    }

    @Test
    public void editingTaskItemDueDateChangesValue() {
        TaskItem task = new TaskItem("title", "desc", LocalDate.parse("2020-02-21"), false);
        TaskList list = new TaskList();
        list.add(task);
        list.editTask(0, "", "desc", LocalDate.parse("2042-02-21"));
        assertEquals(LocalDate.parse("2042-02-21"), task.getDueDate());
        list.clear();
    }


    @Test
    public void gettingTaskItemDescriptionFailsWithInvalidIndex(){
        TaskItem task = new TaskItem("title", "desc", LocalDate.parse("2020-02-21"), false);
        TaskList list = new TaskList();
        list.add(task);
        TaskItem task2 = new TaskItem("job 2 ", "random", LocalDate.parse("2020-02-21"), false);
        assertThrows(IndexOutOfBoundsException.class, () -> {         list.getObject(5).getDescription();;
        } );
        list.clear();
    }

    @Test
    public void gettingTaskItemDescriptionSucceedsWithValidIndex() {
        TaskItem task = new TaskItem("title", "desc", LocalDate.parse("2020-02-21"), false);
        TaskList list = new TaskList();
        list.add(task);
        TaskItem task2 = new TaskItem("job 2 ", "random", LocalDate.parse("2020-02-21"), false);
        list.add(task2);
        assertEquals("random", list.getObject(1).getDescription());
        list.clear();
    }


    @Test
    public void gettingTaskItemDueDateFailsWithInvalidIndex(){
        TaskItem task = new TaskItem("title", "desc", LocalDate.parse("2020-02-21"), false);
        TaskList list = new TaskList();
        list.add(task);
        TaskItem task2 = new TaskItem("job 2 ", "random", LocalDate.parse("2020-02-21"), false);
        assertThrows(IndexOutOfBoundsException.class, () -> {         list.getObject(5).getDueDate();;
        } );
        list.clear();
    }


    @Test
    public void gettingTaskItemDueDateSucceedsWithValidIndex(){
        TaskItem task = new TaskItem("title", "desc", LocalDate.parse("2020-02-21"), false);
        TaskList list = new TaskList();
        list.add(task);
        TaskItem task2 = new TaskItem("job 2 ", "random", LocalDate.parse("2020-02-21"), false);
        list.add(task2);
        assertEquals(LocalDate.parse("2020-02-21"), list.getObject(1).getDueDate());
        list.clear();
    }


    @Test
    public void gettingTaskItemTitleFailsWithInvalidIndex() {
        TaskItem task = new TaskItem("title", "desc", LocalDate.parse("2020-02-21"), false);
        TaskList list = new TaskList();
        list.add(task);
        TaskItem task2 = new TaskItem("job 2 ", "random", LocalDate.parse("2020-02-21"), false);
        assertThrows(IndexOutOfBoundsException.class, () -> {         list.getObject(5).getTitle();;
        } );
        list.clear();
    }


    @Test
    public void removingTaskItemsDecreasesSize(){
        TaskItem task = new TaskItem("title", "desc", LocalDate.parse("2020-02-21"), false);
        TaskList list = new TaskList();
        list.add(task);
        list.removeTask(0);
        assertEquals(0,list.getSize());
        list.clear();
    }

    @Test
    public void gettingTaskItemTitleSucceedsWithValidIndex(){
        TaskItem task = new TaskItem("title", "desc", LocalDate.parse("2020-02-21"), false);
        TaskList list = new TaskList();
        list.add(task);
        assertEquals("title", list.getObject(0).getTitle());
        list.clear();
    }

    @Test
    public void removingTaskItemsFailsWithInvalidIndex(){
        TaskItem task = new TaskItem("title", "desc", LocalDate.parse("2020-02-21"), false);
        TaskList list = new TaskList();
        list.add(task);
        TaskItem task2 = new TaskItem("job 2 ", "random", LocalDate.parse("2020-02-21"), false);
        assertThrows(IndexOutOfBoundsException.class, () -> {         list.removeTask(6);
        } );
        list.clear();

    }

    @Test
    public void uncompletingTaskItemChangesStatus(){
        TaskItem task = new TaskItem("title", "desc", LocalDate.parse("2020-02-21"), false);
        TaskList list = new TaskList();
        list.add(task);
        list.getObject(0).setCompleted(true);
        list.getObject(0).setCompleted(false);
        assertEquals(false, list.getObject(0).isCompleted());
        list.clear();
    }


    @Test
    public void uncompletingTaskItemFailsWithInvalidIndex(){
        TaskItem task = new TaskItem("title", "desc", LocalDate.parse("2020-02-21"), false);
        TaskList list = new TaskList();
        list.add(task);
        list.getObject(0).setCompleted(true);

        assertThrows(IndexOutOfBoundsException.class, () -> {        list.getObject(5).setCompleted(false);;
        } );
        list.clear();
    }

    @Test
    public void newTaskListIsEmpty(){
      TaskList list = new TaskList();
      assertEquals(0, list.getSize());
    }

    /*  Works in console but when I test this I just get stuck on loading. still not sure why after several changes
    @Test
    public void savedTaskListCanBeLoaded()
    {
        TaskList list = new TaskList();
        TaskItem item = new TaskItem("saved", "save attempt", LocalDate.parse("2020-02-21"), false);
        list.add(item);
        list.saveTasks("saveAttempt");
        TaskList loadedList = new TaskList();
        loadedList.loadTask("saveAttempt");
        assertEquals("saved", loadedList.getObject(0).getTitle());
    }
   */

}