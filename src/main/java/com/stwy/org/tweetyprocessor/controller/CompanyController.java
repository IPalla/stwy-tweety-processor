package com.stwy.org.tweetyprocessor.controller;

import com.stwy.org.tweetyprocessor.model.Company;
import com.stwy.org.tweetyprocessor.service.CompanyService;
import com.stwy.org.tweetyprocessor.service.dto.CreateCompanyRequestDto;
import com.stwy.org.tweetyprocessor.service.dto.CreateUserRequestDto;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@RestController
@RequestMapping("/companies")
@AllArgsConstructor
@Valid
public class CompanyController {

    private CompanyService companyService;

    @GetMapping()
    ResponseEntity<List<Company>> getAllCompanies(){
        return ResponseEntity.ok(companyService.getAllCompanies());
    }

    @PostMapping()
    ResponseEntity<Company> addCompany(@Valid @RequestBody CreateCompanyRequestDto createCompanyRequestDto) {
        return ResponseEntity.ok(companyService.addCompany(createCompanyRequestDto.getCompanySymbol()));
    }

    @PostMapping("/{companySymbol}/users")
    ResponseEntity<Company> addUser(@NotEmpty @PathVariable String companySymbol, @Valid @RequestBody CreateUserRequestDto createUserRequestDto){
        return ResponseEntity.ok(companyService.addUser(createUserRequestDto.getScreenName(), companySymbol));
    }

    @GetMapping("/{companySymbol}")
    ResponseEntity<Company> getCompany(@NotEmpty @PathVariable String companySymbol){
        return ResponseEntity.ok(companyService.getCompany(companySymbol));
    }

    @DeleteMapping("/{companySymbol}")
    ResponseEntity deleteCompany(@NotEmpty @PathVariable String companySymbol){
        companyService.deleteCompany(companySymbol);
        return ResponseEntity.noContent().build();
    }
}
