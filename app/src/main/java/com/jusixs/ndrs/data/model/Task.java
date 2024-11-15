package com.jusixs.ndrs.data.model;

public class Task {
    private String name;
    private String description;
    private String assignedTo;
    private String status;

    // Constructor
    public Task(String name, String description, String assignedTo, String status) {
        this.name = name;
        this.description = description;
        this.assignedTo = assignedTo;
        this.status = status;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
