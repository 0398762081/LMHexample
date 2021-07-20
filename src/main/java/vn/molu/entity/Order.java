package vn.molu.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "ordertable")
public class Order extends BaseEntity {

    @Column(name = "order_code")
    private String orderCode;

    @Column(name = "order_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date oderDate;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "address")
    private String address;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_number")
    private Long phoneNumber;

    @Column(name = "so_loai_san_pham")
    private Long soLoaiSanPham;

    @Column(name = "total_money")
    private Long totalMoney;

    @OneToMany(mappedBy = "orderfk")
    private List<DetailedOrder> detailedOrders = new ArrayList<>();

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public Date getOderDate() {
        return oderDate;
    }

    public void setOderDate(Date oderDate) {
        this.oderDate = oderDate;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Long getSoLoaiSanPham() {
        return soLoaiSanPham;
    }

    public void setSoLoaiSanPham(Long soLoaiSanPham) {
        this.soLoaiSanPham = soLoaiSanPham;
    }

    public Long getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Long totalMoney) {
        this.totalMoney = totalMoney;
    }

    public List<DetailedOrder> getDetailedOrders() {
        return detailedOrders;
    }

    public void setDetailedOrders(List<DetailedOrder> detailedOrders) {
        this.detailedOrders = detailedOrders;
    }
}
