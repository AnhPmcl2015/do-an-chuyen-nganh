package topfactors.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer{

//	@Override
//	public void registerStompEndpoints(StompEndpointRegistry registry) {
//		registry.addEndpoint("/secured/room").withSockJS();
//	}
//	
//	@Override
//	public void configureMessageBroker(MessageBrokerRegistry registry) {
//		registry.setApplicationDestinationPrefixes("/spring-security-mvc-socket");
//		registry.setUserDestinationPrefix("/secured/user");
//		registry.enableSimpleBroker("/secured/user/queue/specific-user");
//	}
	
	@Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/ws").withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.setApplicationDestinationPrefixes("/topfactors");
        registry.enableSimpleBroker("/topic", "/queue");
    }
}
