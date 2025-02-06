package org.dnyanyog.service;

import org.dnyanyog.common.DBUtils;
import org.dnyanyog.dto.Product;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductService {
    public String addProduct(Product product) {
        String query = "INSERT INTO product (ProductID, ProductName, ProductPrice, ProductQuantity) VALUES (" +
                product.productId + ", '" + product.productName + "', " + product.productPrice + ", " + product.productQuantity + ")";
        try {
            DBUtils.executeUpdateQuery(query);
            return "Product added successfully!";
        } catch (SQLException e) {
            return "Error adding product!";
        }
    }

    public List<Product> searchProduct(String productName) {
        List<Product> products = new ArrayList<>();
        try {
            ResultSet rs = DBUtils.executeSelectQuery("SELECT * FROM product WHERE ProductName LIKE '%" + productName + "%'");
            while (rs.next()) {
                Product product = new Product();
                product.productId = rs.getInt("ProductID");
                product.productName = rs.getString("ProductName");
                product.productPrice = rs.getDouble("ProductPrice");
                product.productQuantity = rs.getInt("ProductQuantity");
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }
}
