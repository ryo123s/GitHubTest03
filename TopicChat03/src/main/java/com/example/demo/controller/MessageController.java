package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.form.ChatForm;
import com.example.demo.form.MessageForm;
import com.example.demo.service.MessageService;

/**
 * メッセージのコントローラー
 * @author jinjinliangjie
 *
 */
@Controller
public class MessageController {
	@Autowired
	private MessageService messageService;
	
	/**
	 * メッセージ画面に遷移する
	 * @param model
	 * @param chatForm
	 * @param messageForm
	 * @return
	 */
	@GetMapping("/message/message")
	public String message(Model model, @ModelAttribute("chatForm")ChatForm chatForm, MessageForm messageForm) {
		model.addAttribute("messageList", messageService.getMessageByChatId(chatForm.getChat_id()));
		model.addAttribute("chatInfo", chatForm);
		return "/message/message";
	}
	
	/**
	 * メッセージ送信処理
	 * @param model
	 * @param messageForm
	 * @return
	 */
	@PostMapping("/addMessage")
	public String addMessage(Model model, @ModelAttribute("messageForm")MessageForm messageForm) {
		messageService.addMessage(messageForm);
		model.addAttribute("messageList", messageService.getMessageByChatId(messageForm.getChat_id()));
		model.addAttribute("chatInfo", messageForm);
		return "/message/message";
	}
}
