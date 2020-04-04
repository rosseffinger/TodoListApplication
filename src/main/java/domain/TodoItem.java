package domain;

import java.time.LocalDateTime;

public class TodoItem {

    private int id;
    private String owner;
    private String description;
    private LocalDateTime createdDate;
    private LocalDateTime dueDate;
    private boolean isCompleted = false;

    public TodoItem(String description, LocalDateTime dueDate) {
        this.description = description;
        this.createdDate = LocalDateTime.now();
        this.dueDate = dueDate;
    }

    public int getId() {

        return id;
    }

    public String getOwner() {

        return owner;
    }

    public String getDescription() {

        return description;
    }

    public LocalDateTime getCreatedDate() {

        return createdDate;
    }

    public LocalDateTime getDueDate() {

        return dueDate;
    }

    public boolean getCompletionStatus() {
        return isCompleted;
    }

    public void snooze(LocalDateTime due) {
        dueDate = due.plusMinutes(5);
    }

    public void completeItem() {
        isCompleted = true;
    }

}
