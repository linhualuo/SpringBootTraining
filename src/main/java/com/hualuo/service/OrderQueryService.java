package com.hualuo.service;

import com.hualuo.model.combine.OrderPackage;
import com.hualuo.model.entity.OrderEntity;
import com.hualuo.model.entity.OrderLineItemEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Tuple;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 订单查询
 *
 * @author Joseph
 * @create 2019/4/2 22:34
 */
@Service
public class OrderQueryService {

    private static final Logger LOG = LoggerFactory.getLogger(OrderQueryService.class);

    @PersistenceContext
    private EntityManager entityManager;

    public OrderEntity queryByOrderId(String orderId) {

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<OrderEntity> query = cb.createQuery(OrderEntity.class);
        Root<OrderEntity> orderRoot = query.from(OrderEntity.class);

        List<Predicate> predicateList = new ArrayList<>();
        predicateList.add(cb.equal(orderRoot.get("orderId"), orderId));

        query.where(predicateList.toArray(new Predicate[predicateList.size()]));
        TypedQuery<OrderEntity> typedQuery = entityManager.createQuery(query);
        return typedQuery.getSingleResult();
    }

    public void queryPackageByOrderId(String orderId) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Tuple> query = cb.createQuery(Tuple.class);
        Root<OrderEntity> orderRoot = query.from(OrderEntity.class);
        Root<OrderLineItemEntity> lineItemRoot = query.from(OrderLineItemEntity.class);

        Expression<String> orderIdPath = orderRoot.get("orderId").as(String.class);
        Expression<String> itemOrderIdPath = lineItemRoot.get("orderId").as(String.class);
        Expression<String> lineItemIdPath = lineItemRoot.get("orderLineId").as(String.class);

        Join<OrderEntity, OrderLineItemEntity> join = orderRoot.join("OrderEntity", JoinType.INNER);
        join.on(cb.equal(orderIdPath, itemOrderIdPath));
        List<Predicate> predicateList = new ArrayList<>();
        predicateList.add(cb.equal(orderIdPath, orderId));

        query.where(predicateList.toArray(new Predicate[predicateList.size()]))
                .multiselect(orderIdPath, lineItemIdPath);
        List<Tuple> tupleList = entityManager.createQuery(query).getResultList();

        for (Tuple tuple : tupleList) {
            String tempOrderId = tuple.get(orderIdPath);
            String tempLineId = tuple.get(lineItemIdPath);
            LOG.info("orderId = {}, lineId = {}", tempOrderId, tempLineId);
        }
    }
}
