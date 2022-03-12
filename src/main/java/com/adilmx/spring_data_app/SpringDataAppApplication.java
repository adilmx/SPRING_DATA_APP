package com.adilmx.spring_data_app;

import com.adilmx.spring_data_app.constants.AccountType;
import com.adilmx.spring_data_app.dao.AccountRepository;
import com.adilmx.spring_data_app.dao.UserRepository;
import com.adilmx.spring_data_app.model.Account;
import com.adilmx.spring_data_app.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class SpringDataAppApplication implements CommandLineRunner {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private UserRepository userRepository;
    
    public static void main(String[] args) {
        SpringApplication.run(SpringDataAppApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        User user1 = new User("ADIL","0601020304");
        User user2 = new User("ADIL","0601020304");
        User user3 = new User("ADIL","0601020304");
        userRepository.save(user1);
        accountRepository.save(new Account(null, AccountType.ACTIVATED,new Date(),user1));
        userRepository.save(user2);
        accountRepository.save(new Account(null, AccountType.CLOSED,new Date(),user2));
        userRepository.save(user3);
        accountRepository.save(new Account(null, AccountType.CLOSED,new Date(),user3));
        System.out.println("getting closed accounts");
        List<Account> accounts = accountRepository.findByType(AccountType.CLOSED);
        System.out.println("CLOSED ACCOUNTS :");
        accounts.stream().forEach((account)-> {
            System.out.println(account);
        });
        Page<Account> accountPage = accountRepository.findAll(PageRequest.of(0,2));
        System.out.println("ACCOUNTS OF PAGE 1 :");
        accountPage.stream().forEach((account)-> {
            System.out.println(account);
        });
        Page<Account> accountPageSorted = accountRepository.findAll(PageRequest.of(0,3, Sort.by("type").ascending()));
        System.out.println("ACCOUNTS OF PAGE 1 SORTED BY TYPE :");
        accountPageSorted.stream().forEach((account)-> {
            System.out.println(account);
        });
    }
}
