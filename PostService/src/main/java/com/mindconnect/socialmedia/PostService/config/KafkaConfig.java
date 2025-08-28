package com.mindconnect.socialmedia.PostService.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaConfig {
    public static final String POST_EVENTS_TOPIC = "post-events"; // topic-name
    @Bean
    public NewTopic postEventsTopic() {
        return TopicBuilder.name(KafkaConfig.POST_EVENTS_TOPIC)
                .partitions(3)
                .replicas(1)
                .build();
    }
}
