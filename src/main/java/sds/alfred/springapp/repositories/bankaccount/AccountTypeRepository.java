package sds.alfred.springapp.repositories.bankaccount;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import sds.alfred.springapp.entities.bankaccount.AccountType;

public interface AccountTypeRepository extends JpaRepository<AccountType, Serializable>, AccountTypeRepositoryCustom{

	public List<AccountType> findAll();
	
	public AccountType saveAndFlush( AccountType accountType);
	
	public void delete( AccountType accountType );

}
