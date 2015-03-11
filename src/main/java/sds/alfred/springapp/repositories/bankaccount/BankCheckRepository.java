package sds.alfred.springapp.repositories.bankaccount;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sds.alfred.springapp.entities.bankaccount.BankCheck;

public interface BankCheckRepository extends JpaRepository<BankCheck, Serializable>, BankCheckRepositoryCustom {

	public List<BankCheck> findAll();
	
	@Query( "FROM BankCheck bc WHERE id = :id AND ( used IS NULL OR  used = false ) AND ( cancelled IS NULL OR cancelled = false )" )
	public BankCheck findAvailableById(@Param( "id" ) Integer id );
}
