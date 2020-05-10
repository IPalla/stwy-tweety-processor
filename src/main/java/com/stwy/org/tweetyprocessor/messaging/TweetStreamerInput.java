package com.stwy.org.tweetyprocessor.messaging;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface TweetStreamerInput {
    @Input("tweety-streamer-input")
    SubscribableChannel tweetStreamerInput();
}
