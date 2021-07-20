package vn.molu.entity;


import javax.persistence.*;

@Entity
@Table(name = "detailed_order")
public class DetailedOrder extends BaseEntity {

    @Column(name = "detailed_order_code")
    private String detailedPOrderCode;

    @Column(name = "price_end")
    private Long priceEnd;

    @Column(name = "amount")
    private Long amount;
    @Column(name = "total_money")
    private Long totalMoney;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Products products;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order orderfk;

    public String getDetailedPOrderCode() {
        return detailedPOrderCode;
    }

    public void setDetailedPOrderCode(String detailedPOrderCode) {
        this.detailedPOrderCode = detailedPOrderCode;
    }

    public Long getPriceEnd() {
        return priceEnd;
    }

    public void setPriceEnd(Long priceEnd) {
        this.priceEnd = priceEnd;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Long getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Long totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Products getProducts() {
        return products;
    }

    public void setProducts(Products products) {
        this.products = products;
    }

    public Order getOrders() {
        return orderfk;
    }

    public void setOrders(Order orders) {
        this.orderfk = orders;
    }
}
