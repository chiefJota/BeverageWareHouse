package com.jthissel.beveragewarehouse;

import java.util.UUID;

public class alcoholBeverage {

    protected enum alcType{
        NONE,
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
    private String alcPrice;
    private String alcContent;
    private String manufacturerOrigin;
    private alcType style;
    private String name;
    private String fileName;

    /**
     * constructor
     */
    public alcoholBeverage(){
        //generate unique identifier
        mId = UUID.randomUUID();

        description = " ";
        manufacturerOrigin = "";
        alcPrice = " ";
        alcContent = " ";

        style = alcType.NONE;
        name = " ";
        fileName = " ";
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

    public String getAlcContent() {
        return alcContent;
    }

    public String getAlcPrice() {
        return alcPrice;
    }

    public alcType getalcType(){
        return style;
    }

    public String getName() {
        return name;
    }

    public String getFileName() {
        return fileName;
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

    public void setAlcPrice(String alcPrice) {
        this.alcPrice = alcPrice;
    }

    public void setAlcContent(String alcContent) {
        this.alcContent = alcContent;
    }

    public void setAlcType(alcType alcType) {
        this.style = alcType;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
