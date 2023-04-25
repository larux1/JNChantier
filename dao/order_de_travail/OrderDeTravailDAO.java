package dao.order_de_travail;


import dao.Dao;
import entities.OrderDeTravail;
import entities.Task;

import java.util.List;

public interface OrderDeTravailDAO extends Dao<OrderDeTravail> {
    List<OrderDeTravail> getOrderDeTravailByTask(Task t);
}
