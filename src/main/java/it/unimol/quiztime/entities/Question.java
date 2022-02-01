package it.unimol.quiztime.entities;

import java.util.List;

public class Question {
    private String description;
    private List<Answer> answers;
    public Question(String description, List<Answer> answers){
        this.description=description;
        this.answers=answers;
    }

    public String getDescription() {
        return description;
    }

    public List<Answer> getAnswers() {
        return answers;
    }
}
