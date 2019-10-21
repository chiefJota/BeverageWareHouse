package com.jthissel.beveragewarehouse;

import java.util.UUID;

public class alcoholBeverage {

    protected enum alcType{
        IPA,
        STOUT,
        SOUR,
        PORTER,
        WHISKEY,
        RUM,
        GIN;
    }

    /*instance variables*/
    private UUID mId;
    private String description;
    private double alcPrice;
    private double alcContent;
    private String manufacturerOrigin;
    private alcType style;
    private String name;

    /**
     * constructor
     */
    public alcoholBeverage(){
        //generate unique identifier
        mId = UUID.randomUUID();

        description = " ";
        manufacturerOrigin = "";
        alcPrice = 0.00;
        alcContent = 0.0;

        style = alcType.WHISKEY;
        name = "";
    }


    /**
     * Getters
     * @return
     */
    public UUID getId() {
        return mId;
    }

    public String getDescription() {
        return description;
    }

    public String getManufacturerOrigin() {
        return manufacturerOrigin;
    }

    public double getAlcContent() {
        return alcContent;
    }

    public double getAlcPrice() {
        return alcPrice;
    }

    public alcType getalcType(){
        return style;
    }

    public String getName() {
        return name;
    }

    /**
     * Setters
     */
    public void setDescription(String description) {
        this.description = description;
    }

    public void setManufacturerOrigin(String manufacturerOrigin) {
        this.manufacturerOrigin = manufacturerOrigin;
    }

    public void setAlcPrice(double alcPrice) {
        this.alcPrice = alcPrice;
    }

    public void setAlcContent(double alcContent) {
        this.alcContent = alcContent;
    }

    public void setAlcType(alcType alcType) {
        this.style = alcType;
    }

    public void setName(String name) {
        this.name = name;
    }
}
