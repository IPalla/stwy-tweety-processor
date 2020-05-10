package com.stwy.org.tweetyprocessor.messaging;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface TweetProcessedOutput {
    @Output("tweety-processor-output")
    MessageChannel tweetProcessedOutput();
}
