package sds.alfred.springapp.repositories.bankaccount;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import sds.alfred.springapp.entities.bankaccount.BankCheck;

@Repository
@Transactional
public class BankCheckRepositoryImpl implements BankCheckRepositoryCustom{
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public int deleteById(int id) {
		Query query = em.createQuery("DELETE FROM BankCheck bc WHERE bc.id = :id");
		return query.setParameter( "id", id ).executeUpdate();
	}

	@Override
	public List<BankCheck> findAvailable() {
		Query query = em.createQuery( "FROM BankCheck bc WHERE (bc.cancelled IS NULL OR bc.cancelled = false) AND (bc.used IS NULL OR bc.used = false)" );
		return query.getResultList();
	}
	
	
}
