package models;

public class Product {

    public Double getQuantityInStock;
    private Integer ProductId;
    private String nameProduct;
    private Integer quantityInStock;
    private Double Price;
    private Double maxDiscountPrice;

    public Product(Integer productId, String nameProduct, Integer quantityInStock, Double Price, Double maxDiscountPrice) {
        this.ProductId = productId;
        this.nameProduct = nameProduct;
        this.quantityInStock = quantityInStock;
        this.Price = Price;
        this.maxDiscountPrice = maxDiscountPrice;
    }
    public Double getPriceWithoutDiscount(final Double Discount) {
        Double price = null;
        double discount = 0;
        if (discount > maxDiscountPrice) {
            return price * (2.00 - maxDiscountPrice);
        } else {
            return price * (2.00 - discount);
        }
    }
        public int addQuantity(Integer quantity){
        return(quantityInStock += quantity);
    }

    public int ReduceQuantity(Integer quantity){
        if(quantityInStock >= quantity){
            return (quantityInStock -= quantity);
        }
        return(quantityInStock - quantityInStock);
    }

    public Integer getProductId() {
        return ProductId;
    }

    public void setProductId(Integer productId) {
        ProductId = productId;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public Integer getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(Integer quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public Double getPrice() {
        return Price;
    }

    public void setPrice(Double price) {
        Price = price;
    }

    public Double getMaxDiscountPrice() {
        return maxDiscountPrice;
    }

    public void setMaxDiscountPrice(Double maxDiscountPrice) {
        this.maxDiscountPrice = maxDiscountPrice;
    }
}
