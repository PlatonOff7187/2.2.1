package hiber.dao;


import hiber.model.Car;
import hiber.model.User;

import org.hibernate.SessionFactory;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().save(user);
   }

   @Override
   public List<User> listUsers() {
      Query query = sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }


   @Override
   public User getPerson(Car car) {
      Query query1 = sessionFactory.getCurrentSession().createQuery("from User user where user.car=:carid");
      query1.setParameter("carid", car);
      User user = (User) query1.getSingleResult();

      return user;
   }
}