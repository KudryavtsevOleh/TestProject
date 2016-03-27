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
    @SuppressWarnings("unchecked")
    public User getIdByUsernameAndPassword(String username, String password) {
        Criteria criteria = getSession().createCriteria(User.class);
        criteria.add(Restrictions.eq("username", username))
                .add(Restrictions.eq("password", password));
        List<User> users = criteria.list();
        return (users.size() != 0) && (users.size() < 2) ? users.get(0) : null;
    }

    @Transactional
    @SuppressWarnings("unchecked")
    public List<Role> getAllRoles() {
        return getSession().createCriteria(Role.class).list();
    }

    @Transactional
    @SuppressWarnings("unchecked")
    public List<User> getAllUsers() {
        return getSession().createCriteria(User.class).list();
    }

    public Role getRoleByName(String name) {
        return (Role) getSession()
                .createCriteria(Role.class)
                .add(Restrictions.eq("name", name))
                .uniqueResult();
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
