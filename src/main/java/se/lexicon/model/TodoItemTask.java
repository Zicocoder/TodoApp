package se.lexicon.model;

public class TodoItemTask {
    int id;
    boolean assigned;
    TodoItem todoItem;
    Person assignee;

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

    public TodoItemTask(Person assignee, TodoItem todoItem, int id) {
        if (todoItem == null) {
            throw new IllegalArgumentException("todoItem cannot be null");
        }
        this.assignee = assignee;
        this.todoItem = todoItem;
        this.id = id;
        this.assigned = (assignee != null);
    }

    String assigneeName = (assignee != null)
            ? assignee.getFirstName() + " " + assignee.getLastName()
            : "none";

    String title = (todoItem != null) ? todoItem.getTitle() : "null";

}
