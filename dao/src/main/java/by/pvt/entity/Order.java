package by.pvt.entity;

import java.util.List;

/**
 * Created by Dmitry on 10/23/2016.
 */
public class Order {
    private int id;
    private List<Product> productList;
    private String isRegistryOrder = "not"; //yes - registry ; not - not registry
    private String isPaidOrder = "not"; //yes - paid; not - not paid

    public Order() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public String getIsRegistryOrder() {
        return isRegistryOrder;
    }

    public void setIsRegistryOrder(String isRegistryOrder) {
        this.isRegistryOrder = isRegistryOrder;
    }

    public String getIsPaidOrder() {
        return isPaidOrder;
    }

    public void setIsPaidOrder(String isPaidOrder) {
        this.isPaidOrder = isPaidOrder;
    }


}
