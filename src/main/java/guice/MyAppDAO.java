package guice;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import com.google.inject.Inject;
import com.google.inject.persist.Transactional;

public class MyAppDAO implements IsomeDao {
	@Inject
	private EntityManager em;

	@Transactional
	public <T> T find(String accountName,Class<T> clazz,String field) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<T> q = cb.createQuery(clazz);
		Root<T> c = q.from(clazz);
		ParameterExpression<String> p = cb.parameter(String.class);
		q.select(c).where(cb.equal(c.get(field), p));
		TypedQuery<T> query = em.createQuery(q);
		query.setParameter(p, accountName);
		List<T> queryResult = query.getResultList();
		return queryResult.stream().findFirst().get();
	}

	@Transactional
	public <T> void save(T entity) {
		em.merge(entity);
	}
}