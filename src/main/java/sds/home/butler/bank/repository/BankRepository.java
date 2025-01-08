package sds.home.butler.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sds.home.butler.bank.entity.Bank;

@Repository
public interface BankRepository extends JpaRepository<Bank, Long> {
}
