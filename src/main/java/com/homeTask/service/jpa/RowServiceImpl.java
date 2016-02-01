package com.homeTask.service.jpa;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.homeTask.entity.Row;
import com.homeTask.service.RowService;


@Repository("rowService") 
public class RowServiceImpl implements RowService{
	
	@PersistenceContext 
	private EntityManager em; 

	private Log log = LogFactory.getLog(RowServiceImpl.class); 

	
	public Collection<Row> findAll() {
		Query query = em.createNamedQuery("Row.findAll");
		return query.getResultList();
	}
	@Transactional
	public Row save(Row row) {
		if (row.getId() == null) { 
			log.info("Inserting new row"); 
			em.persist(row); 
			} else { 
			em.merge(row); 
			log.info("Updating existing row"); 
			log.info("Row saved with id: " + row.getId()); 
			}
		return row;
	}
	@Transactional
	public void delete(Row row) {
		Row mergedRow = em.merge(row); 
		em.remove(mergedRow); 
		log.info("Row with id: " + row.getId() 
		+ " deleted successfully"); 

		
	}
	

}
