package se.lexicon;

import se.lexicon.model.Person;
import se.lexicon.model.TodoItem;
import se.lexicon.model.TodoItemTask;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
    Person p1 = new Person(1, "Zackaria", "Azzoug", "Azzoug.zackaria@gmail.com");
    TodoItem item = new TodoItem(101, "Change tires", "Winter is coming",
        java.time.LocalDate.of(2025, 12, 1), p1);
    TodoItemTask task = new TodoItemTask(501, item, p1);
System.out.println(p1.getSummary());
System.out.println(item.getSummary());
System.out.println(task.getSummary());

task.setAssignee(null);
        System.out.println("assigned after null? " + task.isAssigned());

    }
}
