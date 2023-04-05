package org.example.dto;

public class Feedback {
    private Integer id;
    private String feedback;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public String writableString() {
        return id + "#" + feedback;
    }

    @Override
    public String toString() {
        return "Feedback{" +
                "id=" + id +
                ", feedback='" + feedback + '\'' +
                '}';
    }
}
