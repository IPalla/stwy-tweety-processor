package com.stwy.org.tweetyprocessor.messaging;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class MessagingService {

    private final TweetProcessedOutput tweetProcessedOutput;

    @StreamListener(target="tweety-streamer-input")
    public void handleInputTweet(@Payload Object streamTweet){
        log.info("Received tweet {}", streamTweet);
        // TODO process tweet
        log.info("Sending tweet to stwey data collector");
        tweetProcessedOutput.tweetProcessedOutput().send(MessageBuilder.withPayload(streamTweet)
                .build());
    }

}
