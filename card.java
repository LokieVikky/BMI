package com.example.lokie.bmi;

import android.media.Image;

public class card {
    public String formula;
    public String weight;
    public Image author;

    public card(String formula, String weight, Image author) {
        this.formula = formula;
        this.weight = weight;
        this.author = author;
    }

    public String getFormula() {
        return formula;
    }

    public void setFormula(String formula) {
        this.formula = formula;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public Image getAuthor() {
        return author;
    }

    public void setAuthor(Image author) {
        this.author = author;
    }

    public card(){

    }
}
