package topfactors.bus.define.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectedEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import topfactors.common.dto.ChatMessage;
import topfactors.constant.MessageSocketType;

@Component
public class WebSocketEventListener {
	private static final Logger logger = LoggerFactory.getLogger(WebSocketEventListener.class);
	
	@Autowired
	private SimpMessageSendingOperations messageTemplate;
	
	@EventListener
	public void handleWebSocketConnectListener(SessionConnectedEvent event) {
		logger.info("Received a new web socket connection: " + event.getUser().getName());
	}
	
	@EventListener
	public void handleWebSocketDisConnectListener(SessionDisconnectEvent event) {
		StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());
		
		String username = (String) headerAccessor.getSessionAttributes().get("username");
		
		if(username != null) {
			logger.info("User disconnect: " + username);
			
			ChatMessage chatMessage = new ChatMessage();
			chatMessage.setType(MessageSocketType.LEAVE);
			chatMessage.setSender(username);
			
			messageTemplate.convertAndSend("/topic/public", chatMessage);
		}
	}
}
