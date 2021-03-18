package ru.job4j.inheritance.prof;

class Recipe extends Diagnosis {
    private String title;

    public String getRecipe() {
        return title;
    }

    public void setRecipe(String recipe) {
        this.title = recipe;
    }
}
