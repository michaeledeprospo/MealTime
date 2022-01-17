package com.example.mealplan.model;


import androidx.annotation.NonNull;

public class Meal {
    private String name;
    private Integer calories;
    private Integer protein;
    private Integer fat;
    private Integer carbs;
    private String category;
    private String mealType;
    private String imageUrl;

    //make an api rquest to somethign -> myfitnesspal
    //{food: fries, type: bad}
    //
    public Meal(String name, Integer calories, Integer protein, Integer fat, Integer carbs, String category, String mealType){
        this.calories = calories;
        this.protein = protein;
        this.fat = fat;
        this.carbs = carbs;
        this.category = category;
        this.mealType = mealType;
    }

    public String getCalories() {
        return calories.toString();
    }

    public void setCalories(Integer calories) {
        this.calories = calories;
    }

    public String getProtein() {
        return protein.toString();
    }

    public void setProtein(Integer protein) {
        this.protein = protein;
    }

    public String getFat() {
        return fat.toString();
    }

    public void setFat(Integer fat) {
        this.fat = fat;
    }

    public String getCarbs() {
        return carbs.toString();
    }

    public void setCarbs(Integer carbs) {
        this.carbs = carbs;
    }


    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getMealType() {
        return mealType;
    }

    public void setMealType(String mealType) {
        this.mealType = mealType;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Meal(){
        this.calories = 12;
        this.protein = 13;
        this.fat = 10;
        this.carbs = 9;
        this.category = "cock";
        this.mealType = "poop";
        this.imageUrl = "";
    }
    public Meal(@NonNull String name){
        this.name = name;
        this.calories = 12;
        this.protein = 13;
        this.fat = 10;
        this.carbs = 9;
        this.category = "cock";
        this.mealType = "poop";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString(){
        return "cock " + calories.toString() + "weeeeeeeeeeeee" + fat.toString();
    }
}
