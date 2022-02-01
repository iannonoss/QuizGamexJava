package it.unimol.quiztime.entities;

public class Answer {
    private String description;
    private boolean isCorrect;

    public Answer(String description, boolean isCorrect) {
        this.description = description;
        this.isCorrect = isCorrect;
    }

    public String getDescription() {
        return description;
    }

    public boolean getIsCorrect() {
        return isCorrect;
    }
}
