package ru.netology.domain;
public class Product {
    protected int id;
    protected String name;
    protected int Price;

    public Product(int id, String name, int price) {
        this.id = id;
        this.name = name;
        Price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean matches(Product product, String search) {
        return product.getName().contains(search);
    }
}
