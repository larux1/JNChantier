package services.order_de_travail;

import entities.OrderDeTravail;
import entities.Task;
import services.Service;

import java.sql.SQLException;
import java.util.List;

public interface order_de_travailService extends Service<OrderDeTravail> {
    public List<OrderDeTravail> retournerOrderDeTravails() throws SQLException;
    public OrderDeTravail retournerOrderDeTravailParId(OrderDeTravail o) throws SQLException;
    public List<OrderDeTravail> retournerOrdersDeTravailParTask(Task t) throws SQLException;
    public void ajouterOrderDeTravail(OrderDeTravail o) throws SQLException;

    public void supprimerOrderDeTravail(OrderDeTravail o) throws SQLException;

    public void modifierOrderDeTravail(OrderDeTravail o) throws SQLException;
    public void enregistrerOrderDeTravail(OrderDeTravail o) throws SQLException;
}
