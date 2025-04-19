package com.springai.spring_ai_llama2;

import org.springframework.ai.chat.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class SpringAiLlama2Application {
	public static void main(String[] args) {
		SpringApplication.run(SpringAiLlama2Application.class, args);
	}
}

@RestController
@RequestMapping("/chat")
class ChatController {

	@Autowired
	private ChatService myChatService;

	@PostMapping
	public String chat(@RequestBody String userInput) {
		return myChatService.ask(userInput); // ✔️ Works
	}
}

@Service
class ChatService {

	private ChatClient chatClient;

	public ChatService(ChatClient chatClient) {
		this.chatClient = chatClient;
	}

	public String ask(String userInput) {
		return chatClient.call(userInput);
	}
}