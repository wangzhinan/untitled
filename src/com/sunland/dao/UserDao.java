package com.sunland.dao;

import com.sunland.bean.PageBean;
import com.sunland.po.Book;
import com.sunland.po.User;
import org.hibernate.criterion.DetachedCriteria;

import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import java.util.List;

public class UserDao extends BaseDao {
    public void save(User user){
        this.getHibernateTemplate().save(user);
    }

    public boolean findUser(String name,String password){
        String hql = "from User where name = ? and password = ?";
        Query query = this.getSessionFactory().openSession().createQuery(hql);
        query.setParameter(0,name);
        query.setParameter(1,password);
        return query.list().size() > 0;
    }

    public void test(){
        System.out.println("test");
    }

    public PageBean<User> findByPage(int curPage){
        PageBean<User> pageBean = new PageBean<>();
        pageBean.setCurPage(curPage);
        int pageSize = (int) Math.ceil( findCount()/pageBean.getPageSize());
        return pageBean;
    }

    public long findCount(){
        String hql = "select count(password) from User";
        Query query = this.getSessionFactory().getCurrentSession().createQuery(hql);
        return (long) query.uniqueResult();
    }

    public List<User> findByPage(int begin,int pageSize){
        DetachedCriteria criteria = DetachedCriteria.forClass(User.class);
//        criteria.add(Restrictions.like("name","%系统管理员%"));
        return (List<User>) this.getHibernateTemplate().findByCriteria(criteria,begin,pageSize);
    }



}
