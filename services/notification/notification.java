package services.notification;

import dao.notification.NotificationDmpl;
import entities.Intervenant;
import entities.Notification;
import entities.Task;
import services.Service;
import services.materiel.materielService;

import java.sql.SQLException;
import java.util.List;

public class notification implements notificationService {
    NotificationDmpl ndmpl=new NotificationDmpl();

    @Override
    public List<Notification> retournerNotifications() throws SQLException {
        return ndmpl.findAll();
    }

    @Override
    public Notification retournerNotificationParId(Notification n) throws SQLException {
        return ndmpl.findOne(n.getID());
    }

    @Override
    public List<Notification> retournerNotificationsParTask(Task t) throws SQLException {
        return ndmpl.getNotificationByTask(t);
    }

    @Override
    public List<Notification> retournerNotificationsParIntervenant(Intervenant i) throws SQLException {
        return ndmpl.getNotificationByIntervenant(i);
    }

    @Override
    public void ajouterNotification(Notification n) throws SQLException {
        ndmpl.save(n);
    }

    @Override
    public void supprimerNotification(Notification n) throws SQLException {
        ndmpl.delete(n);
    }

    @Override
    public void modifierNotification(Notification n) throws SQLException {
        ndmpl.update(n);
    }

    @Override
    public void enregistrerNotification(Notification n) throws SQLException {
        ndmpl.save(n);
    }
}
