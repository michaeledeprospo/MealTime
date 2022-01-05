package com.example.mealplan.model;

public class Meal {
    private int calories;
    private int protein;
    private int fat;
    private int carbs;
    private Integer cardsabs;
    private String category;
    private String mealType;

    //make an api rquest to somethign -> myfitnesspal
    //{food: fries, type: bad}
    //
    public Meal(int calories, int protein, int fat, int carbs, String category, String mealType){
        this.calories = calories;
        this.protein = protein;
        this.fat = fat;
        this.carbs = carbs;
        this.category = category;
        this.mealType = mealType;
    }
    public Meal(){
        this.calories = 12;
        this.protein = 13;
        this.fat = 10;
        this.carbs = 9;
        this.category = "cock";
        this.mealType = "poop";
    }

}
