package services.task;

import dao.task.TaskDmpl;
import entities.*;
import services.Service;

import java.sql.SQLException;
import java.util.List;

public class task implements taskService {
    TaskDmpl tmpl=new TaskDmpl();


    @Override
    public List<Task> retournerTasks() throws SQLException {
        return tmpl.findAll();
        
/*
 * Le principe L de SOLID, également connu sous le nom de Principe de substitution de Liskov, stipule que les objets d'une classe dérivée doivent pouvoir être utilisés comme des objets de leur classe de base sans que cela ne perturbe le fonctionnement correct du programme.

Les classes abstraites contribuent à ce principe en fournissant une structure de base pour les classes dérivées. En d'autres termes, elles établissent un contrat de base pour les classes dérivées en définissant des méthodes et des propriétés communes que toutes les classes dérivées doivent implémenter.

De cette manière, les classes abstraites garantissent que toutes les classes dérivées respectent les mêmes règles 
et la même structure de base. Cela permet aux objets de ces classes dérivées d'être utilisés en toute transparence comme des objets de la classe de base, sans affecter le fonctionnement correct du programme.

En résumé, les classes abstraites contribuent au principe L de SOLID en fournissant une structure de base commune pour les classes dérivées, garantissant ainsi que toutes les classes dérivées respectent les mêmes règles et la même structure de base, ce qui permet l'utilisation transparente d'objets dérivés comme des objets de leur classe de base.
 */
    }

    @Override
    public Task retournerTaskParId(Task t) throws SQLException {
        return tmpl.findOne(t.getID());
    }

    @Override
    public Task retournerTaskParOrderDeTravail(OrderDeTravail o){
        return tmpl.getTaskByOrderDeTravail(o);
    }

    @Override
    public List<Task> retournerTasksParNotification(Notification n){
        return tmpl.getTasksByNotification(n);
		/* 
		 * 
		 * Le choix de créer une classe dans un modèle orienté objet dépend du concept que cette classe représente. 
		 * En général, il est important de créer une classe pour représenter une entité distincte qui possède un comportement, des propriétés et des relations avec d'autres entités.



Voici quelques critères importants à prendre en compte lors de la création d'une classe :


Cohérence conceptuelle : la classe doit être cohérente du point de vue conceptuel. Cela signifie que la classe doit représenter une entité distincte et avoir un comportement et des propriétés qui sont liés à cet entité.



Responsabilité unique : la classe doit avoir une responsabilité unique et clairement définie. Cela signifie qu'elle doit avoir un but précis et ne doit pas avoir de fonctionnalités ou de comportements qui n'ont rien à voir avec cette responsabilité.



Encapsulation : la classe doit encapsuler ses propriétés et ses méthodes, c'est-à-dire qu'elle doit cacher sa complexité interne et ne fournir que des interfaces claires et cohérentes aux autres classes. Cela permet d'isoler les changements internes de la classe et facilite la maintenance et l'évolutivité du code.



Réutilisabilité : la classe doit être conçue de manière à pouvoir être réutilisée dans d'autres parties du code. Cela signifie qu'elle doit être suffisamment générique et flexible pour être utilisée dans différents contextes.



Cohésion : les propriétés et les méthodes de la classe doivent être cohérentes et liées entre elles. Cela signifie qu'elles doivent toutes contribuer à la responsabilité unique de la classe et ne pas avoir d'effet secondaire.



En résumé, la création d'une classe doit être basée sur un concept cohérent, avoir une responsabilité unique, être encapsulée, être réutilisable et avoir une cohésion interne. 
Ces critères aident à assurer que les classes sont claires, maintenables, évolutives et réutilisables dans différents contextes.
		*/
    }

    @Override
    public List<Task> retournerTasksParIntervenant(Intervenant i){
        return tmpl.getTasksByIntervenant(i);
    }

    @Override
    public List<Task> retournerTasksParProjet(Projet p){
        return tmpl.getTasksByProjet(p);
    }

    @Override
    public List<Task> retournerTasksParMateriel(Materiel m){
        return tmpl.getTasksByMateriel(m);
    }

    @Override
    public Materiel affecter_materiel(long t,long m){
        return tmpl.affecter_materiel(t,m);
    }

    @Override
    public Intervenant affecter_intervenant(long t,long i){
        return tmpl.affecter_intervenant(t,i);
    }

    @Override
    public boolean supprimer_affectation_intervenant(Task t,Intervenant i){
        return tmpl.delete_affectation_intervenant(t,i);
    }

    @Override
    public boolean supprimer_affectation_materiel(Task t,Materiel m){
        return tmpl.delete_affectation_materiel(t,m);
    }

    @Override
    public void ajouterTask(Task t) throws SQLException {
        tmpl.save(t);
    }

    @Override
    public void supprimerTask(Task t) throws SQLException {
        tmpl.delete(t);
    }

    @Override
    public void modifierTask(Task t) throws SQLException {
        tmpl.update(t);
    }

    @Override
    public void enregistrerTask(Task t) throws SQLException {
        tmpl.save(t);
    }
}
