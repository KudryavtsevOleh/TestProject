package com.testproject.dao;

import com.testproject.model.Todo;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class TodoDao extends HibernateDao {

    @Transactional
    @SuppressWarnings("unchecked")
    public List<Todo> getTodosByUserId(Integer userId) {
        Criteria criteria = getSession().createCriteria(Todo.class);
        criteria.createAlias("user", "user");
        criteria.add(Restrictions.eq("user.id", userId));
        return criteria.list();
    }

    @Transactional
    public void save(Todo todo) {
        getSession().save(todo);
    }

}
