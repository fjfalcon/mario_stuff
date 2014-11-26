package es.sanoguera.dao.hibernate;


/**
 * Created with IntelliJ IDEA.
 * User: fjfalcon
 * Date: 20.12.12
 * Time: 0:29
 * To change this template use File | Settings | File Templates.
 */

import java.io.Serializable;

public interface AbstractDAO<T, PK extends Serializable> {

    PK create(T newInstance) throws Exception;

    T read(PK id) throws Exception;

    void update(T transientObject) throws Exception;

    void delete(T persistentObject) throws Exception;

    T findByName(String fieldName, Object name) throws Exception;

    void clean();
}