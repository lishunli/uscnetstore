package com.usc.daos;



/**
 * Digital entity. @author MyEclipse Persistence Tools
 */

public class Digital  implements java.io.Serializable {


    // Fields    

     private Integer digitalId;
     private Producttype producttype;
     private String digitalName;
     private Float publishedPrice;
     private String manufacturer;
     private String brand;
     private String modelNumber;
     private String parameter;
     private String barcode;
     private String photo;
     private String description;
     private String specialExplanation;
     private Integer productsPflag;


    // Constructors

    /** default constructor */
    public Digital() {
    }

	/** minimal constructor */
    public Digital(String digitalName, Float publishedPrice, String brand, String barcode, Integer productsPflag) {
        this.digitalName = digitalName;
        this.publishedPrice = publishedPrice;
        this.brand = brand;
        this.barcode = barcode;
        this.productsPflag = productsPflag;
    }
    
    /** full constructor */
    public Digital(Producttype producttype, String digitalName, Float publishedPrice, String manufacturer, String brand, String modelNumber, String parameter, String barcode, String photo, String description, String specialExplanation, Integer productsPflag) {
        this.producttype = producttype;
        this.digitalName = digitalName;
        this.publishedPrice = publishedPrice;
        this.manufacturer = manufacturer;
        this.brand = brand;
        this.modelNumber = modelNumber;
        this.parameter = parameter;
        this.barcode = barcode;
        this.photo = photo;
        this.description = description;
        this.specialExplanation = specialExplanation;
        this.productsPflag = productsPflag;
    }

   
    // Property accessors

    public Integer getDigitalId() {
        return this.digitalId;
    }
    
    public void setDigitalId(Integer digitalId) {
        this.digitalId = digitalId;
    }

    public Producttype getProducttype() {
        return this.producttype;
    }
    
    public void setProducttype(Producttype producttype) {
        this.producttype = producttype;
    }

    public String getDigitalName() {
        return this.digitalName;
    }
    
    public void setDigitalName(String digitalName) {
        this.digitalName = digitalName;
    }

    public Float getPublishedPrice() {
        return this.publishedPrice;
    }
    
    public void setPublishedPrice(Float publishedPrice) {
        this.publishedPrice = publishedPrice;
    }

    public String getManufacturer() {
        return this.manufacturer;
    }
    
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getBrand() {
        return this.brand;
    }
    
    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModelNumber() {
        return this.modelNumber;
    }
    
    public void setModelNumber(String modelNumber) {
        this.modelNumber = modelNumber;
    }

    public String getParameter() {
        return this.parameter;
    }
    
    public void setParameter(String parameter) {
        this.parameter = parameter;
    }

    public String getBarcode() {
        return this.barcode;
    }
    
    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getPhoto() {
        return this.photo;
    }
    
    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }

    public String getSpecialExplanation() {
        return this.specialExplanation;
    }
    
    public void setSpecialExplanation(String specialExplanation) {
        this.specialExplanation = specialExplanation;
    }

    public Integer getProductsPflag() {
        return this.productsPflag;
    }
    
    public void setProductsPflag(Integer productsPflag) {
        this.productsPflag = productsPflag;
    }
   








}