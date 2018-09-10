package com.qa.accountmanagement.controller;

import com.qa.accountmanagement.domain.AccountDatabase;
import com.qa.accountmanagement.domain.repository.AccountDatabaseRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
@CrossOrigin(origins = "http://localhost:8081")
public class AccountDatabaseController {

    final
    AccountDatabaseRepository accountDatabaseRepository;

    @Autowired
    public AccountDatabaseController(AccountDatabaseRepository accountDatabaseRepository) {
        this.accountDatabaseRepository = accountDatabaseRepository;
    }

    @RequestMapping(value = "/create-account", method = RequestMethod.POST)
    public AccountDatabase createAccount(@RequestBody AccountDatabase accountDatabase) {
        return accountDatabaseRepository.save(accountDatabase);
    }

    @RequestMapping(value = "/find-all", method = RequestMethod.GET)
    public List<AccountDatabase> findAll() {
        return accountDatabaseRepository.findAll();
    }

    @RequestMapping (value = "/delete-all", method = RequestMethod.DELETE)
    public void deleteAll(){
        accountDatabaseRepository.deleteAll();
    }

    @RequestMapping(value = "/find-by-id/{id}", method = RequestMethod.GET)
    public AccountDatabase findById(@PathVariable Long id){
        return accountDatabaseRepository.findById(id).get();
    }

    @RequestMapping(value = "/find-by-name/{name}", method = RequestMethod.GET)
    public List<AccountDatabase> findByName(@PathVariable String name){
        return accountDatabaseRepository.findByName(name);
    }

    @RequestMapping(value = "/delete-account/{id}", method = RequestMethod.DELETE)
    public List<AccountDatabase> deleteAccount(@PathVariable Long id) {
        if(accountDatabaseRepository.findById(id).isPresent()){
            accountDatabaseRepository.deleteById(id);
            return accountDatabaseRepository.findAll();
        }else {
            return accountDatabaseRepository.findAll();
        }

    }

    @RequestMapping(value = "/update-account/{id}", method = RequestMethod.PUT)
    public List<AccountDatabase> updateAccount(@PathVariable Long id, @RequestBody AccountDatabase newAccount) {
        if(accountDatabaseRepository.findById(id).isPresent()){
            AccountDatabase existingAccount = accountDatabaseRepository.findById(id).get();
            BeanUtils.copyProperties(newAccount, existingAccount);
            accountDatabaseRepository.saveAndFlush(existingAccount);
            return accountDatabaseRepository.findAll();
        }else {
            return accountDatabaseRepository.findAll();
        }
    }
}
