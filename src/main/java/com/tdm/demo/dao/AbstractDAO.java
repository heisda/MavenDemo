package com.tdm.demo.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public abstract class AbstractDAO<T> extends HibernateDaoSupport {

    private Class<T> entityClass;
    
    @SuppressWarnings("unchecked")
    public AbstractDAO(){
        this.entityClass = (Class<T>)((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }
    
    public void saveOrUpdate(T o){
        getSession().saveOrUpdate(o);
    }
    
    public void delete(Serializable id){
        getSession().delete(get(id));
    }
    
    public Object get(Serializable id){
        return getSession().get(entityClass, id);
    }
}
