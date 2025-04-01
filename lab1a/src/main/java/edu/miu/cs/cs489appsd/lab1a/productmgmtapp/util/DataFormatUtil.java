package edu.miu.cs.cs489appsd.lab1a.productmgmtapp.util;

import edu.miu.cs.cs489appsd.lab1a.productmgmtapp.model.Product;

public class DataFormatUtil {

    public static void convertToJson(Product[] products) {
        System.out.println("Printed in JSON Format");
        StringBuilder json = new StringBuilder("[\n");
        for (int i = 0; i < products.length; i++) {
            Product p = products[i];

            json.append("{")
                    .append("\"productId\":").append(p.getProductId()).append(", ")
                    .append("\"name\":").append(p.getProductName()).append(", ")
                    .append("\"dateSupplied\":").append(p.getDateSupplied()).append(", ")
                    .append("\"quantityInStock\":").append(p.getInStock()).append(", ")
                    .append("\"unitPrice\":").append(p.getPrice()).append(", ")
                    .append("}");

            if (i < products.length - 1) {
                json.append(",");
            }
            json.append("\n");
        }
        json.append("]");
        System.out.println(json.toString());
    }

    public static void convertToXML(Product[] products) {
        System.out.println("Printed in XML Format");
        StringBuilder xml = new StringBuilder("<?xml version=\"1.0\"?>\n<products>\n");
        for (Product product : products) {
            xml.append("  <product ")
                    .append("productId=\"").append(product.getProductId()).append("\" ")
                    .append("name=\"").append(product.getProductName()).append("\" ")
                    .append("dateSupplied=\"").append(product.getDateSupplied()).append("\" ")
                    .append("quantityInStock=\"").append(product.getInStock()).append("\" ")
                    .append("unitPrice=\"").append(product.getPrice()).append("\" />\n");
        }
        xml.append("</products>");
        System.out.println(xml.toString());
    }

    public static void convertToCSV(Product[] products) {
        System.out.println("Printed in Comma-Separated Values (CSV) Format");
        StringBuilder csv = new StringBuilder();
        for (Product product : products) {
            csv.append("\"").append(product.getProductId()).append("\",")
                    .append("\"").append(product.getProductName()).append("\",")
                    .append("\"").append(product.getDateSupplied()).append("\",")
                    .append("\"").append(product.getInStock()).append("\",")
                    .append("\"").append(product.getPrice()).append("\",")
                    .append("\n");
        }
        System.out.println(csv.toString());
    }
}
