package com.detroitlabs.chucknorris.Model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Locale;

@JsonIgnoreProperties(ignoreUnknown = true)
public class JeopardyFacts {

    private String question;

    private String answer;

    private Category category;

    private int dollarAmount;


    @JsonProperty("category")
    public Category getCategory() {
        return category;
    }

    @JsonProperty("category")
    public void setCategory(Category category) {
        this.category = category;
    }

    @JsonProperty("value")
    public int getDollarAmount() {
        return dollarAmount;
    }

    @JsonProperty("value")
    public void setDollarAmount(int dollarAmount) {
        this.dollarAmount = dollarAmount;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
