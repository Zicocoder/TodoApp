package se.lexicon.model;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

public class TodoItemTaskTest {

    private Person p() {
        return new Person(1, "Zackaria", "Azzoug", "z@x.com");
    }

    private TodoItem item(Person creator) {
        return new TodoItem(101, "Change tires", "Winter is coming",
                LocalDate.now().plusDays(7), creator);
    }

    @Test
    void constructor_setsAssignedBasedOnAssignee() {
        Person creator = p();
        TodoItem ti = item(creator);

        TodoItemTask unassigned = new TodoItemTask(501, ti, null);
        assertFalse(unassigned.isAssigned());

        TodoItemTask assigned = new TodoItemTask(502, ti, creator);
        assertTrue(assigned.isAssigned());
    }

    @Test
    void constructor_throwsIfTodoItemNull() {
        Person someone = p();
        assertThrows(IllegalArgumentException.class,
                () -> new TodoItemTask(600, null, someone));
    }

    @Test
    void setAssignee_updatesAssignedFlag() {
        Person creator = p();
        TodoItem ti = item(creator);
        TodoItemTask task = new TodoItemTask(700, ti, null);

        assertFalse(task.isAssigned());
        task.setAssignee(creator);
        assertTrue(task.isAssigned());
        task.setAssignee(null);
        assertFalse(task.isAssigned());
    }

    @Test
    void summary_containsTitleAndAssigneeNameOrNone() {
        Person creator = p();
        TodoItem ti = item(creator);
        TodoItemTask task = new TodoItemTask(800, ti, creator);

        String s1 = task.getSummary();
        assertTrue(s1.contains("Change tires"));
        assertTrue(s1.contains("Zackaria Azzoug"));

        task.setAssignee(null);
        String s2 = task.getSummary();
        assertTrue(s2.contains("assignee none"));
    }
}
