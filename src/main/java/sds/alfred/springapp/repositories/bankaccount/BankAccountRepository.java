package sds.alfred.springapp.repositories.bankaccount;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import sds.alfred.springapp.entities.bankaccount.BankAccount;

public interface BankAccountRepository extends JpaRepository<BankAccount, Serializable>, BankAccountRepositoryCustom{

	public List<BankAccount> findAll();
}
