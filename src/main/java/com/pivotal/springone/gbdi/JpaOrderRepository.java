package com.pivotal.springone.gbdi;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import com.pivotal.springone.Order;

/**
 * Example Repository (DAO) class to demonstrate the use of @Auditable and 
 * the AuditingAdvice
 * 
 * @author msecrist
 *
 */
@Repository
public class JpaOrderRepository implements OrderRepository {
	private EntityManager em;
	
	@PersistenceContext
	public void setEntityManager(EntityManager em) {
		this.em = em;
	}
	
	public Order findByOrderId(long id) {
		return em.find(Order.class, id);
	}

	// TODO-01: Mark for for auditing using @Auditable 
	public Order save(Order entity) {
		if (entity.getId() == null) {
			em.persist(entity);
		} else {
			em.merge(entity);
		}
		em.flush();
		return entity;
	}

	// TODO-02: Mark for for auditing using @Auditable 
	public void delete(long id) {
		Order entity = findByOrderId(id);

		if (entity == null) {
			throw new EmptyResultDataAccessException(String.format("No Order entity with id %s exists!", id), 1);
		}

		delete(entity);	
	}

	/**
	 * Allows attached or detached entities. If not attached, it will first merge, then delete.
	 */
	// TODO-03: Mark for for auditing using @Auditable 
	public void delete(Order entity) {
		Assert.notNull(entity, "The entity must not be null!");
		em.remove(em.contains(entity) ? entity : em.merge(entity));
	}

}
