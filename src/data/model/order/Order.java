package data.model.order;

import data.model.product.Product;
import data.model.product.Status;
import data.model.user.User;

import java.util.Date;
import java.util.Objects;

public class Order {
    private Long id;
    private Date date;
    private User user;
    private Product product;
    private Status status;

    public Order(Long id, Date date, User user, Product product, Status status) {
        this.id = id;
        this.date = date;
        this.user = user;
        this.product = product;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order:" +
                "id: " + id + "\n" +
                "date: " + date + "\n" +
                "user: " + user + "\n" +
                "product: " + product + "\n" +
                "status: " + status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;
        Order order = (Order) o;
        return Objects.equals(getId(), order.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
