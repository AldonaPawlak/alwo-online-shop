package com.alwo.service;

import com.alwo.dto.OrderDataDto;
import com.alwo.model.Order;
import com.alwo.model.OrderedProduct;
import com.alwo.model.User;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface OrderService {

    List<Order> getOrders(int page, Sort.Direction sort);

    Order getOrder(long id);

    List<OrderedProduct> getUserOrderedProducts(User user);

    Order addOrder(Order order);

    void deleteOrder(long id);

    Order editOrder(Order order);

    void finishOrder(long orderId);

    void  cancelOrder(long orderId);

    List<Order> getUserOrders();

    void  cancel(long orderId);

    Order createNewOrder(OrderDataDto orderDataDto);
}
