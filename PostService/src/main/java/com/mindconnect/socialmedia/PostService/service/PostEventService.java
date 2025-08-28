package com.mindconnect.socialmedia.PostService.service;

import com.mindconnect.socialmedia.PostService.common.PostCreatedEvent;
import com.mindconnect.socialmedia.PostService.config.KafkaConfig;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class PostEventService {
    private final KafkaTemplate<String, PostCreatedEvent> kafkaTemplate;

    public PostEventService(KafkaTemplate<String, PostCreatedEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate; // Inject KafkaTemplate (Spring helper)
    }

    public void sendPostEvent(PostCreatedEvent event) {
        kafkaTemplate.send(KafkaConfig.POST_EVENTS_TOPIC, event.getPostId(), event);
        System.out.println("Sent event for postId=" + event.getPostId());
    }
}
