package com.hualuo.model.combine;

import com.hualuo.model.entity.OrderEntity;
import com.hualuo.model.entity.OrderLineItemEntity;
import lombok.Data;

import java.util.List;

/**
 * 订单+订单行
 *
 * @author Joseph
 * @create 2019/4/2 22:53
 */
@Data
public class OrderPackage extends OrderEntity {

    private List<OrderLineItemEntity> orderLineItemList;
}
