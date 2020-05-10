package com.stwy.org.tweetyprocessor.service;

import com.stwy.org.tweetyprocessor.model.Company;
import com.stwy.org.tweetyprocessor.model.TweetUser;
import com.stwy.org.tweetyprocessor.model.repository.CompanyRepository;
import com.stwy.org.tweetyprocessor.model.repository.TweetUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@AllArgsConstructor
public class CompanyService {

    private CompanyRepository companyRepository;
    private TweetUserRepository tweetUserRepository;

    public Company addCompany(String companySymbol){
        if (companyRepository.findById(companySymbol).isPresent()) {
            throw new RuntimeException("Company already exists"); // 409 Conflict
        }
        Company newCompany = Company.builder().symbol(companySymbol).build();
        return companyRepository.save(newCompany);
    }

    public Company addUser(String userName, String companySymbol){
        Company company = companyRepository.findById(companySymbol).orElseGet(()->this.addCompany(companySymbol));
        TweetUser newUser = TweetUser.builder().screenName(userName).company(company).build();
        newUser = tweetUserRepository.save(newUser);
        if (company.getUsers() == null){
            company.setUsers(Arrays.asList(newUser));
        }
        return company;
    }

    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    public Company getCompany(String companySymbol) {
        return companyRepository.findById(companySymbol)
                .orElseThrow(()->new RuntimeException("Company does not exists")); // 404 Not found
    }

    public void deleteCompany(String companySymbol) {
        companyRepository.deleteById(companySymbol);
    }
}
