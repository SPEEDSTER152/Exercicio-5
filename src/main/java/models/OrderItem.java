package models;

public class OrderItem {

    private Product product;
    private Integer quantity;
    private Double discount;

    public OrderItem(Product product, Integer quantity, Double discount) {
        this.product = product;
        this.quantity = quantity;
        this.discount = discount;
    }
    public Double totalPrice(){
       if(quantity <= product.getQuantityInStock) {
           return (product.getPriceWithoutDiscount(discount) * quantity);
       }else{
           return(product.getPriceWithoutDiscount(discount) * product.getQuantityInStock);
       }
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }
}
