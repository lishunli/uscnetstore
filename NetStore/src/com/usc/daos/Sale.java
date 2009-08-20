package com.usc.daos;



/**
 * Sale entity. @author MyEclipse Persistence Tools
 */

public class Sale  implements java.io.Serializable {


    // Fields    

     private Integer saleCommodityId;
     private Commodity commodity;
     private Operator operator;
     private Float salePrice;
     private Integer priority;


    // Constructors

    /** default constructor */
    public Sale() {
    }

	/** minimal constructor */
    public Sale(Float salePrice, Integer priority) {
        this.salePrice = salePrice;
        this.priority = priority;
    }
    
    /** full constructor */
    public Sale(Commodity commodity, Operator operator, Float salePrice, Integer priority) {
        this.commodity = commodity;
        this.operator = operator;
        this.salePrice = salePrice;
        this.priority = priority;
    }

   
    // Property accessors

    public Integer getSaleCommodityId() {
        return this.saleCommodityId;
    }
    
    public void setSaleCommodityId(Integer saleCommodityId) {
        this.saleCommodityId = saleCommodityId;
    }

    public Commodity getCommodity() {
        return this.commodity;
    }
    
    public void setCommodity(Commodity commodity) {
        this.commodity = commodity;
    }

    public Operator getOperator() {
        return this.operator;
    }
    
    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public Float getSalePrice() {
        return this.salePrice;
    }
    
    public void setSalePrice(Float salePrice) {
        this.salePrice = salePrice;
    }

    public Integer getPriority() {
        return this.priority;
    }
    
    public void setPriority(Integer priority) {
        this.priority = priority;
    }
   








}