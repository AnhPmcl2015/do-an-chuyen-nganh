package topfactors.controller.pub;

import java.security.Principal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import topfactors.common.dto.ChatMessage;

@Controller
public class ChatController {

	private static final Logger logger = LoggerFactory.getLogger(ChatController.class);
	
	@Autowired
	private SimpMessagingTemplate simpMessagingTemplate;
	
	@MessageMapping("/secured/room")
	public void sendSpecific(@Payload ChatMessage chatMessage, Principal user,
			@Header("simpSessionId") String sessionId) {

		simpMessagingTemplate.convertAndSendToUser("user123", "/secured/user/queue/specific-user", chatMessage);;
	}
	
	@MessageMapping("/qr/chat.message")
	@SendTo("/topic/public")
	public ChatMessage sendMessage(@Payload ChatMessage chatMessage) {
		logger.info("Tin nhắn gửi đến: " + chatMessage);
		return chatMessage;
	}
	
	@MessageMapping("/qr/chat.addUser")
	@SendTo("/topic/public")
	public ChatMessage addUser(@Payload ChatMessage chatMessage, SimpMessageHeaderAccessor headerAccessor) {
		logger.info("Header accessor: " + headerAccessor);
		headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
		return chatMessage;
	}
}
