package sds.alfred.springapp.repositories.bankaccount;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class BankAccountRepositoryImpl implements BankAccountRepositoryCustom{
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public int deleteById(int id) {
		Query query = em.createQuery("DELETE FROM BankAccount ba WHERE ba.id = :id");
		return query.setParameter( "id", id ).executeUpdate();
	}
	
}
