package es.sanoguera.dao;

/**
 * Created by fjfalcon on 26.11.14.
 */
/**
 * Created with IntelliJ IDEA.
 * User: fjfalcon
 * Date: 20.12.12
 * Time: 0:29
 * To change this template use File | Settings | File Templates.
 */

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import es.sanoguera.dao.hibernate.AbstractDAO;
import es.sanoguera.dao.hibernate.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;



public class HibernateDAO<T, PK extends Serializable> extends HibernateUtil implements AbstractDAO<T, PK>
{
    private Class<T> type;

    public HibernateDAO(Class<T> type) {
        this.type = type;
    }

    @SuppressWarnings("unchecked")
    public PK create(T o) throws Exception {
        try {
            begin();
            PK id = (PK) getSession().save(o);
            commit();
            return id;
        } catch (HibernateException e) {
            rollback();
            throw new Exception(e.getCause().getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public T read(PK id) throws Exception {
        return (T) getSession().get(type, id);
    }

    public void update(T o) throws Exception {
        try {
            begin();
            getSession().update(o);
            commit();
        } catch (HibernateException e) {
            rollback();
            e.printStackTrace();
        }

    }
    public void saveOrUpdate(T o) throws Exception {
        try {
            begin();
            getSession().saveOrUpdate(o);
            commit();
        } catch (HibernateException e) {
            rollback();
            e.printStackTrace();
        }

    }

    public List<T> findAll() {
        List objects = null;
        try {
            begin();
            Query query = getSession().createQuery("from " + type.getName());
            objects = query.list();
            commit();
        } catch (HibernateException e) {
            rollback();
            e.printStackTrace();

        }
        return objects;
    }

    public void delete(T o) throws Exception {

        try {
            begin();
            getSession().delete(o);
            commit();
        } catch (HibernateException e) {
            rollback();
            throw new Exception(e.getCause().getMessage());
        }

    }


    @SuppressWarnings("unchecked")
    public T findByName(String fieldName, Object name) throws NoSuchElementException {
        T result = null;
        List<T> find = getSession().createCriteria(type).add(Restrictions.eq(fieldName, name)).list();
        if (find.size() > 0)
            result = find.get(0);
        return result;
    }

    public List<T> findByNameWithNull(String fieldName) {
        return getSession().createCriteria(type).add(Restrictions.isNull(fieldName)).list();
    }

    public void clean() {
        getSession().clear();
    }


}