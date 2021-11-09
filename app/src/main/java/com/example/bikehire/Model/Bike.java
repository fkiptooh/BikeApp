package com.example.bikehire.Model;

public class Bike {
    private String  Name,Image, Description, Price, Discount, ModelsId;

    public Bike() {
    }

    public Bike(String name, String image, String description, String price, String discount, String modelsId) {
        Name = name;
        Image = image;
        Description = description;
        Price = price;
        Discount = discount;
        ModelsId = modelsId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getDiscount() {
        return Discount;
    }

    public void setDiscount(String discount) {
        Discount = discount;
    }

    public String getModelsId() {
        return ModelsId;
    }

    public void setModelsId(String modelsId) {
        ModelsId = modelsId;
    }
}
