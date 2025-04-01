package edu.miu.cs.cs489appsd.lab1a.productmgmtapp.model;

import edu.miu.cs.cs489appsd.lab1a.productmgmtapp.util.DataFormatUtil;

import java.math.BigInteger;
import java.time.LocalDate;

public class ProductMgmtApp {
    public static void printProducts(Product[] products){
        DataFormatUtil.convertToJson(products);
        System.out.println("--------------------------------");
        DataFormatUtil.convertToXML(products);
        System.out.println("--------------------------------");
        DataFormatUtil.convertToCSV(products);
    }
    public static void main(String[] args) {
        Product[] products= new Product[3];

        Product p1 = new Product(new BigInteger("3128874119"), "Banana", LocalDate.of(2023,1,24), 124, 0.55);
        Product p2 = new Product(new BigInteger("2927458265"), "Apple", LocalDate.of(2022,12,9), 18, 1.09);
        Product p3 = new Product(new BigInteger("9189927460"), "Carrot", LocalDate.of(2023,3,31), 89, 2.99);

        products[0] = p1;
        products[1] = p2;
        products[2] = p3;

        printProducts(products);
    }
}