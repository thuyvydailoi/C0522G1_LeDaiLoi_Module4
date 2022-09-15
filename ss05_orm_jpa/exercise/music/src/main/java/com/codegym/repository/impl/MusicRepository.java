package com.codegym.repository.impl;

import com.codegym.model.Music;
import com.codegym.repository.IMusicrepository;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MusicRepository implements IMusicrepository {
    @Override
    public List<Music> findAll() {
        Session session = null;
        List<Music> musicList;
        try {
            session = ConnectionUtil.sessionFactory.openSession();
            musicList = session.createQuery("FROM Music").getResultList();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return musicList;
    }

    @Override
    public void save(Music music) {
        Transaction transaction = null;
        Session session = null;

        try {
            session = ConnectionUtil.sessionFactory.openSession();
            transaction = session.beginTransaction();

            session.save(music);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void update(Music music) {
        Transaction transaction = null;
        Session session = null;

        try {
            session = ConnectionUtil.sessionFactory.openSession();
            transaction = session.beginTransaction();

            session.update(music);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public Music findById(int id) {
        Session session = null;
        Music music;
        try {
            session = ConnectionUtil.sessionFactory.openSession();
            music = (Music) session.createQuery("FROM Music WHERE id = :id").setParameter("id", id).getSingleResult();
            if (session != null) {
                session.close();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return music;
    }

    @Override
    public void remove(int id) {
        Transaction transaction = null;
        Session session = null;

        try {
            session = ConnectionUtil.sessionFactory.openSession();
            transaction = session.beginTransaction();

            session.remove(id);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }

    }
}
