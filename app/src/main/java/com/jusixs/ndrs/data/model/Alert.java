package com.jusixs.ndrs.data.model;

public class Alert {
    private String type; // "general" or "emergency"
    private String message;
    private String audience; // "citizens", "firstResponders", or "both"
    private String priority; // "normal" or "high"
    private String location;
    private String status; // "sent" or "failed"

    // Getters and setters
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public String getAudience() { return audience; }
    public void setAudience(String audience) { this.audience = audience; }

    public String getPriority() { return priority; }
    public void setPriority(String priority) { this.priority = priority; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
