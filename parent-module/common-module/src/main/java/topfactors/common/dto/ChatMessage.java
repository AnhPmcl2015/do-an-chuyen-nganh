package topfactors.common.dto;

import topfactors.constant.MessageSocketType;

public class ChatMessage {
	private MessageSocketType type;
	private String content;
	private String sender;

	public ChatMessage(MessageSocketType type, String content, String sender) {
		super();
		this.type = type;
		this.content = content;
		this.sender = sender;
	}

	public ChatMessage() {
		super();
	}

	public MessageSocketType getType() {
		return type;
	}

	public String getContent() {
		return content;
	}

	public String getSender() {
		return sender;
	}

	public void setType(MessageSocketType type) {
		this.type = type;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

}
