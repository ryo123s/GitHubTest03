package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.form.ChatForm;
import com.example.demo.form.GroupForm;
import com.example.demo.security.User;
import com.example.demo.service.ChatMemberService;
import com.example.demo.service.ChatService;
import com.example.demo.service.MessageService;

/**
 * チャットに関するコントローラー
 * @author jinjinliangjie
 *
 */
@Controller
public class ChatController {
	@Autowired
	private ChatService chatService;
	@Autowired
	private ChatMemberService chatMemberService;
	@Autowired
	private MessageService messageService;
	
	/**
	 * チャット画面に遷移する
	 * @param model
	 * @param groupMemberForm
	 * @return
	 */
	@PostMapping("/chat")
	public String chat(Model model, @ModelAttribute("GroupForm")GroupForm groupForm) {
		model.addAttribute("chatList", chatMemberService.getChatListByUserIdAndGroupId(groupForm));
		model.addAttribute("groupInfo", groupForm);
		return "/chat/chat";
	}
	
	/**
	 * グループ作成画面に遷移
	 * @param model
	 * @param groupForm
	 * @return
	 */
	@GetMapping("/chat/addChat")
	public String addChat(Model model, @ModelAttribute("groupForm")GroupForm groupForm) {
		model.addAttribute("groupForm", groupForm);
		System.out.println(groupForm.getGroup_id());
		return "/chat/addChat";
	}
	
	/**
	 * チャットを追加する処理
	 * @param model
	 * @param chatForm
	 * @return
	 */
	@PostMapping("/addChat")
	public String addChat(Model model, @ModelAttribute("chatForm")ChatForm chatForm) {
		System.out.println(chatForm.getGroup_id());
		chatService.addChat(chatForm);
		chatMemberService.addChatMember(chatForm);
		model.addAttribute("chatList", chatMemberService.getChatListByChatForm(chatForm));
		model.addAttribute("groupInfo", chatForm);
		return "/chat/chat";
	}
	
	/**
	 * チャットメンバー画面に遷移
	 * @param model
	 * @param chatForm
	 * @return
	 */
	@GetMapping("/chat/chatMember")
	public String chatMember(Model model, ChatForm chatForm) {
		model.addAttribute("chatMemberList", chatMemberService.getChatMemberByChatId(chatForm.getChat_id()));
		model.addAttribute("chatInfo", chatForm);
		return "/chat/chatMember";
	}
	
	/**
	 * チャットメンバー追加画面に遷移
	 * @param model
	 * @param chatForm
	 * @return
	 */
	@GetMapping("/chat/addChatMember")
	public String moveAddChatMember(Model model, @ModelAttribute("chatForm")ChatForm chatForm){
		model.addAttribute("userList", chatMemberService.getGroupUserListNoChat(chatForm));
		model.addAttribute("chatInfo", chatForm);
		return "/chat/addChatMember";
	}
	
	/**
	 * チャットメンバー追加処理
	 * @param model
	 * @param chatForm
	 * @param user
	 * @return
	 */
	@PostMapping("addChatMember")
	public String addChatMember(Model model, @ModelAttribute("chatForm")ChatForm chatForm, @AuthenticationPrincipal User user) {
		chatMemberService.addChatMember(chatForm);
		chatForm.setUser_id(user.getUser_id());
		model.addAttribute("chatMemberList", chatMemberService.getChatMemberByChatId(chatForm.getChat_id()));
		model.addAttribute("chatInfo", chatForm);
		return "/chat/chatMember";
	}
	
}
