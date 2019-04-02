package com.hualuo.model.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @author Joseph
 * @create 2019/4/2 22:32
 */
@Entity
@Table(name = "t_order_line_item", schema = "testdb", catalog = "")
public class OrderLineItemEntity {
    private String orderLineId;
    private String orderId;
    private Integer status;
    private Integer itemType;
    private Timestamp createTime;
    private String customerId;

    @Id
    @Column(name = "orderLineId")
    public String getOrderLineId() {
        return orderLineId;
    }

    public void setOrderLineId(String orderLineId) {
        this.orderLineId = orderLineId;
    }

    @Basic
    @Column(name = "orderId")
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    @Basic
    @Column(name = "status")
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Basic
    @Column(name = "itemType")
    public Integer getItemType() {
        return itemType;
    }

    public void setItemType(Integer itemType) {
        this.itemType = itemType;
    }

    @Basic
    @Column(name = "createTime")
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "customerId")
    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderLineItemEntity that = (OrderLineItemEntity) o;
        return Objects.equals(orderLineId, that.orderLineId) &&
                Objects.equals(orderId, that.orderId) &&
                Objects.equals(status, that.status) &&
                Objects.equals(itemType, that.itemType) &&
                Objects.equals(createTime, that.createTime) &&
                Objects.equals(customerId, that.customerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderLineId, orderId, status, itemType, createTime, customerId);
    }
}
