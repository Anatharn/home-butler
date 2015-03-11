package sds.alfred.springapp.repositories.bankaccount;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import sds.alfred.springapp.entities.bankaccount.Accounting;

public interface AccountingRepository extends JpaRepository<Accounting, Serializable>, AccountingRepositoryCustom{
		
	public Accounting saveAndFlush( Accounting accounting);
}
