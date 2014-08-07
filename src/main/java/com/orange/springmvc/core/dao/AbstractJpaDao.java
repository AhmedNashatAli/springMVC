/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.orange.springmvc.core.dao;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Ahmed Nashaat OLC
 */
public abstract class AbstractJpaDao< T extends Serializable> {

    private Class< T> clazz;
    @PersistenceContext
    EntityManager entityManager;

    public void setClazz(Class< T> clazzToSet) {
        this.clazz = clazzToSet;
    }

    public T get(Long id) {
        return entityManager.find(clazz, id);
    }

    public List< T> findAll() {
        return entityManager.createQuery("from " + clazz.getName())
                .getResultList();
    }
    
    public void save(T entity) {
        entityManager.persist(entity);
    }

    public T update(T entity) {
        return entityManager.merge(entity);
    }

    public void delete(T entity) {
        entityManager.remove(entity);
    }

    public void delete(Long entityId) {
        T entity = get(entityId);
        delete(entity);
    }
}
