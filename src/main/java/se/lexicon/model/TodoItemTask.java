package se.lexicon.model;

public class TodoItemTask {
   private int id;
   private boolean assigned;
   private TodoItem todoItem;
    private Person assignee;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isAssigned() {
        return assigned;
    }

    public TodoItem getTodoItem() {
        return todoItem;
    }

    public void setTodoItem(TodoItem todoItem) {
        this.todoItem = todoItem;

    }

    public Person getAssignee() {
        return assignee;
    }

    public void setAssignee(Person assignee) {
        this.assignee = assignee;
        this.assigned= (assignee != null);
    }

    public TodoItemTask(int id, TodoItem todoItem, Person assignee) {
        if (todoItem == null) {
            throw new IllegalArgumentException("todoItem cannot be null");
        }
        this.assignee = assignee;
        this.todoItem = todoItem;
        this.id = id;
        this.assigned = (assignee != null);
    }
public String getSummary() {
    String assigneeName = (assignee != null)
            ? assignee.getFirstName() + " " + assignee.getLastName()
            : "none";

    String title = (todoItem != null) ? todoItem.getTitle() : "null";

    return "{id " + id +
            ", assigned: " + assigned +
            ", todoItem " + title +
            ", assignee " + assigneeName +"}";
}
}
