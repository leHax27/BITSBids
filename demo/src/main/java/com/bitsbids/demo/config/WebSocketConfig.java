package com.bitsbids.demo.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.converter.MessageConverter;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

import java.util.List;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        // Configure an in-memory message broker with a destination prefix for user-specific destinations
        config.enableSimpleBroker("/topic", "/queue", "/user");
        config.setApplicationDestinationPrefixes("/app");
        config.setUserDestinationPrefix("/user");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // Register the /ws endpoint for WebSocket communication
        registry.addEndpoint("/ws")
                .setAllowedOrigins("*") // You may restrict origins based on your security requirements
                .withSockJS(); // Enable SockJS fallback options
    }

    @Override
    public boolean configureMessageConverters(List<MessageConverter> messageConverters) {
        // Configure a JSON message converter
        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
        converter.setObjectMapper(new ObjectMapper()); // You can customize the ObjectMapper if needed
        messageConverters.add(converter);

        return false;
    }
}
