package dao.notification;

import dao.Dao;
import entities.*;

import java.util.List;

public interface NotificationDAO extends Dao<Notification> {
   public List<Notification> getNotificationByTask(Task t);
   public List<Notification> getNotificationByIntervenant(Intervenant i);
}
