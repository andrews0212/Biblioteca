package modelo.DAO;

import jakarta.persistence.EntityManager;
import modelo.conexion.Conexion;

import java.util.List;

public class DAOGN<T,ID>{

    private EntityManager em;
    private Class<T> entityClass;

    public DAOGN(Class<T> entityClass) {
       this.em = Conexion.getEntityManager();
       this.entityClass = entityClass;
    }
    public void add(T t) {
        em.getTransaction().begin();
        em.persist(t);
        em.getTransaction().commit();
    }
    public void update(T t) {
        em.getTransaction().begin();
        em.merge(t);
        em.getTransaction().commit();
    }
    public void delete(T t) {
        em.getTransaction().begin();
        em.remove(t);
        em.getTransaction().commit();

    }
    public T find(ID id) {
        return em.find(entityClass, id);
    }
    public List<T> findAll() {
        return em.createQuery("select t from "+entityClass.getSimpleName()+" t").getResultList();
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }
}
