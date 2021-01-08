package com.alwo.service.impl;

import com.alwo.model.OrderStatus;
import com.alwo.repository.OrderStatusRepository;
import com.alwo.service.OrderStatusService;
import org.springframework.stereotype.Service;

@Service
public class OrderStatusServiceImpl implements OrderStatusService {

    private OrderStatusRepository orderStatusRepository;

    public OrderStatusServiceImpl(OrderStatusRepository orderStatusRepository) {
        this.orderStatusRepository = orderStatusRepository;
    }

    @Override
    public OrderStatus getOrderStatus(long id) {
        return orderStatusRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Order " + id + " does not exist"));
    }
}
