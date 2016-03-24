package com.testproject.dao;

import com.testproject.model.Role;
import com.testproject.model.User;
import org.springframework.stereotype.Repository;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class UserDao extends HibernateDao {

    @Transactional
    public User getIdByUsernameAndPassword(String username, String password) {
        Criteria criteria = getSession().createCriteria(User.class);
        criteria.add(Restrictions.eq("username", username))
                .add(Restrictions.eq("password", password));
        List<User> users = criteria.list();
        return (users.size() != 0) && (users.size() < 2) ? users.get(0) : null;
    }

    @Transactional
    public void saveUser(User user) {
        getSession().save(user);
    }

    @Transactional
    public void saveRole(Role role) {
        getSession().save(role);
    }

}
