package org.example.dao;

import lombok.RequiredArgsConstructor;
import org.example.dto.UserRequestDto;
import org.example.entity.UserEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@RequiredArgsConstructor
public class UserDao implements BaseDao<UserEntity, UserRequestDto>{
    private final SessionFactory sessionFactory;

    @Override
    public UserEntity findById(int id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        UserEntity userEntity = session.get(UserEntity.class, id);
        session.getTransaction().commit();
        session.close();
        return userEntity;
    }

    @Override
    public List<UserEntity> findAll() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<UserEntity> fromUserEntity = session.createQuery("from UserEntity ").list();
        session.getTransaction().commit();
        session.close();
        return fromUserEntity;
    }

    @Override
    public void save(UserRequestDto userRequestDto) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(userRequestDto);
        session.getTransaction().commit();
        session.close();
    }

}
