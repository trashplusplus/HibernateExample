package org.zeroxthree.cruds;

import org.zeroxthree.HibernateUtil;
import org.zeroxthree.Players;

import org.hibernate.Session;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
//CRUD - create/read/update/delete

public class PlayersCRUD {

    public void save(Players players){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(players);
        session.flush();
        session.close();
    }

    public void delete(Players players){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(players);
        session.flush();
        session.close();
    }

    public List<Players> getAllPlayers(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Players> cq = cb.createQuery(Players.class);
        Root<Players> rootEntry = cq.from(Players.class);
        CriteriaQuery<Players> all = cq.select(rootEntry);

        TypedQuery<Players> allQuery = session.createQuery(all);
        return allQuery.getResultList();
    }

    public Players getById(int id){
        Session sesh = HibernateUtil.getSessionFactory().openSession();
        Players players = sesh.get(Players.class, id);
        return players;
    }

    public Players getByName(String nickname){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Players players = session.get(Players.class, nickname);
        return players;
    }
}
