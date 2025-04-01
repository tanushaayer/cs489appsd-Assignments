package edu.miu.cs.cs489appsd.lab1a.productmgmtapp.model;

import edu.miu.cs.cs489appsd.lab1a.productmgmtapp.util.DataFormatUtil;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.Date;

public class Product {
    private BigInteger productId;
    private String productName;
    private LocalDate dateSupplied;
    private Integer inStock;
    private Double price;

    Product(BigInteger productId, String productName, LocalDate dateSupplied, Integer inStock, Double price) {
        this.productId = productId;
        this.productName = productName;
        this.dateSupplied = dateSupplied;
        this.inStock = inStock;
        this.price = price;
    }

    Product(){
        this(null,null,null,null,null);
    }

    Product(BigInteger productId, String productName, double price){
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.dateSupplied = null;
        this.inStock = null;
    }

    public BigInteger getProductId() {
        return productId;
    }
    public void setProductId(BigInteger productId) {
        this.productId = productId;
    }
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public LocalDate getDateSupplied() {
        return dateSupplied;
    }
    public void setDateSupplied(LocalDate dateSupplied) {
        this.dateSupplied = dateSupplied;
    }
    public int getInStock() {
        return inStock;
    }
    public void setInStock(int inStock) {
        this.inStock = inStock;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

}
