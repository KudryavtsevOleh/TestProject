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
    public List<Todo> getTodosByUserId(Integer userId) {
        Criteria criteria = getSession().createCriteria(Todo.class);
        criteria.createAlias("us", "user");
        criteria.add(Restrictions.eq("us.id", userId));
        return criteria.list();
    }

}
