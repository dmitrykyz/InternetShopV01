package by.pvt.entity;

/**
 * Created by Dmitry on 10/23/2016.
 */
public class Product extends Entity{
    private String nameProduct;
    private double price;
    private String status = "yes"; //yes - shop has this product; not - shop do not has this product

    public Product() {
        super();
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public double getPrice() {
        return price;
    }

    public String getStatus() {
        return status;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
