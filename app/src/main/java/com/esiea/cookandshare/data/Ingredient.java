package com.esiea.cookandshare.data;

public class Ingredient
{
    private String name;
    private String type;
    private String bestOrigin;
    private String taste;
    private String image;

    public Ingredient(String name, String type, String bestOrigin, String taste, String image)
    {
        this.name = name;
        this.type = type;
        this.bestOrigin = bestOrigin;
        this.taste = taste;
        this.image = image;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public String getBestOrigin()
    {
        return bestOrigin;
    }

    public void setBestOrigin(String bestOrigin)
    {
        this.bestOrigin = bestOrigin;
    }

    public String getTaste()
    {
        return taste;
    }

    public void setTaste(String taste)
    {
        this.taste = taste;
    }

    public String getImage()
    {
        return image;
    }

    public void setImage(String image)
    {
        this.image = image;
    }
}
