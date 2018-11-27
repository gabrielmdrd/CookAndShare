package com.esiea.cookandshare.domain;

import com.esiea.cookandshare.data.Ingredient;

import java.util.List;

public class Recipe
{
    private String name;
    private String author;
    private String[] imagesURL;
    private String shortDescription;
    private List<Ingredient> ingredients;
    private String directions;
    private String preparationTime;
    private String cookingTime;
    private String tips;
    private String nutritionFacts;

    public Recipe(String name, String author, String[] imagesURL, String shortDescription, List<Ingredient> ingredients, String directions, String preparationTime, String cookingTime, String tips, String nutritionFacts)
    {
        this.name = name;
        this.author = author;
        this.imagesURL = imagesURL;
        this.shortDescription = shortDescription;
        this.ingredients = ingredients;
        this.directions = directions;
        this.preparationTime = preparationTime;
        this.cookingTime = cookingTime;
        this.tips = tips;
        this.nutritionFacts = nutritionFacts;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String[] getImagesURL() {
        return imagesURL;
    }

    public void setImagesURL(String[] imagesURL) {
        this.imagesURL = imagesURL;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public String getDirections() {
        return directions;
    }

    public void setDirections(String directions) {
        this.directions = directions;
    }

    public String getPreparationTime() {
        return preparationTime;
    }

    public void setPreparationTime(String preparationTime) {
        this.preparationTime = preparationTime;
    }

    public String getCookingTime() {
        return cookingTime;
    }

    public void setCookingTime(String cookingTime) {
        this.cookingTime = cookingTime;
    }

    public String getTips() {
        return tips;
    }

    public void setTips(String tips) {
        this.tips = tips;
    }

    public String getNutritionFacts() {
        return nutritionFacts;
    }

    public void setNutritionFacts(String nutritionFacts) {
        this.nutritionFacts = nutritionFacts;
    }
}
