package se.lexicon.model;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

public class TodoItemTest {

    @Test
    void testConstructorAndGetters() {
        Person creator = new Person(1, "Zackaria", "Azzoug", "azzoug.zackaria@gmail.com");
        LocalDate deadline = LocalDate.of(2025, 12, 1);

        TodoItem item = new TodoItem(101, "Change tires", "Winter is coming", deadline, creator);

        assertEquals(101, item.getId());
        assertEquals("Change tires", item.getTitle());
        assertEquals("Winter is coming", item.getDescription());
        assertEquals(deadline, item.getDeadLine());
        assertEquals(creator, item.getCreator());
        assertFalse(item.isDone());
    }

    @Test
    void testSettersAndDoneFlag() {
        Person creator = new Person(2, "Ali", "Khan", "ali.khan@gmail.com");
        TodoItem item = new TodoItem(102, "Test task", "desc", LocalDate.now().plusDays(2), creator);

        item.setTitle("Updated task");
        item.setDescription("Updated description");
        item.setDone(true);

        assertEquals("Updated task", item.getTitle());
        assertEquals("Updated description", item.getDescription());
        assertTrue(item.isDone());
    }

    @Test
    void testIsOverdue() {
        Person creator = new Person(3, "Sara", "Larsen", "sara@gmail.com");

        TodoItem pastItem = new TodoItem(103, "Past", "Old task",
                LocalDate.now().minusDays(1), creator);
        TodoItem futureItem = new TodoItem(104, "Future", "Upcoming task",
                LocalDate.now().plusDays(1), creator);

        assertTrue(pastItem.isOverdue(), "Yesterday’s deadline should be overdue");
        assertFalse(futureItem.isOverdue(), "Tomorrow’s deadline should not be overdue");
    }

    @Test
    void testValidationThrowsException() {
        Person creator = new Person(5, "Zack", "Azz", "zack@gmail.com");

        assertThrows(IllegalArgumentException.class,
                () -> new TodoItem(201, null, "desc", LocalDate.now(), creator));

        assertThrows(IllegalArgumentException.class,
                () -> new TodoItem(202, "", "desc", LocalDate.now(), creator));

        assertThrows(IllegalArgumentException.class,
                () -> new TodoItem(203, "Task", "desc", null, creator));
    }

    @Test
    void testGetSummaryFormat() {
        Person creator = new Person(6, "Zackaria", "Azzoug", "zackaria@gmail.com");
        TodoItem item = new TodoItem(105, "Task", "desc", LocalDate.of(2025, 12, 1), creator);

        String summary = item.getSummary();

        assertTrue(summary.contains("id 105"));
        assertTrue(summary.contains("done: false"));
        assertTrue(summary.contains("deadline 2025-12-01"));
        assertTrue(summary.contains("creator: Zackaria Azzoug"));
    }
}
