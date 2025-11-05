package se.lexicon.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;



public class PersonTest {

    @Test
    void testSummaryContainsName() {
        Person p = new Person(1, "Zackaria", "Azzoug", "azzoug.zackaria@gmail.com");
        assertTrue(p.getSummary().contains("Zackaria"));
    }
    @Test
    void testConstructorRejectsNullFirstName() {
        assertThrows(IllegalArgumentException.class,
                () -> new Person(1, null, "Azzoug", "azzoug.zackaria@gmail.com"));
    }
}
