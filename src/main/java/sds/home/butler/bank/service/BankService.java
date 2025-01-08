package sds.home.butler.bank.service;

import org.springframework.stereotype.Service;
import sds.home.butler.bank.entity.Bank;
import sds.home.butler.bank.repository.BankRepository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class BankService {

    private final BankRepository bankRepository;

    public BankService(BankRepository bankRepository) {
        this.bankRepository = bankRepository;
    }

    public List<Bank> getAllBanks() {
        return bankRepository.findAll();
    }

    public Optional<Bank> getBankById(Long id) {
        return bankRepository.findById(id);
    }

    public Bank create(Bank bank) {
        if(Objects.isNull(bank.getName())){
            throw new IllegalArgumentException("Bank name cannot be null");
        }
        return bankRepository.save(bank);
    }

    public Bank update(Bank bank) {
        return bankRepository.save(bank);
    }

    public void delete(Long id) {
        bankRepository.deleteById(id);
    }
}
