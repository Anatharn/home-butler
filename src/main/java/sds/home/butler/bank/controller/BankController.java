package sds.home.butler.bank.controller;

import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import sds.home.butler.bank.entity.Bank;
import sds.home.butler.bank.service.BankService;

import java.util.List;

@RestController
@RequestMapping("api/home-butler/mybank/bank")
public class BankController {

    private final BankService bankService;

    public BankController(BankService bankService) {
        this.bankService = bankService;
    }

    @GetMapping
    public List<Bank> getBanks(){
        return bankService.getAllBanks();
    }

    @GetMapping(path = "/{id}")
    public Bank getBank(@PathVariable("id") Long id){
        return bankService.getBankById(id).orElseThrow(() -> new ResponseStatusException(HttpStatusCode.valueOf(404)));
    }

    @PostMapping ( consumes = {"application/json"})
    public Bank postBank(@RequestBody Bank bank){
        return bankService.create(bank);
    }

    @PutMapping(consumes = {"application/json"})
    public Bank putBank(@RequestBody Bank bank){
        return bankService.update(bank);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteBank(@PathVariable("id") Long id){
        bankService.delete(id);
    }
}
