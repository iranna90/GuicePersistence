package guice;

import javax.persistence.EntityManager;

import com.google.inject.Inject;
import com.google.inject.persist.Transactional;

public class MyAppDAO implements IsomeDao{
    @Inject
    private EntityManager em;
 
    @Transactional
    public MyEntity find(long id) {
        return em.find(MyEntity.class, id);
    }
 
    @Transactional
    public void save(MyEntity entity) {
        em.persist(entity);
    }
}