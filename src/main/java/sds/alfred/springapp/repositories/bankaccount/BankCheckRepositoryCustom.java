package sds.alfred.springapp.repositories.bankaccount;

import java.util.List;

import sds.alfred.springapp.entities.bankaccount.BankCheck;

public interface BankCheckRepositoryCustom {
	
	public int deleteById( int id );
	
	public List<BankCheck> findAvailable();
}
