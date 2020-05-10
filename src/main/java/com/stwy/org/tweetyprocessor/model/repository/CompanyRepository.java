package com.stwy.org.tweetyprocessor.model.repository;

import com.stwy.org.tweetyprocessor.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, String> {
}
