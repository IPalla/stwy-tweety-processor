package com.stwy.org.tweetyprocessor.model.repository;

import com.stwy.org.tweetyprocessor.model.TweetUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TweetUserRepository extends JpaRepository<TweetUser, String> {
}
