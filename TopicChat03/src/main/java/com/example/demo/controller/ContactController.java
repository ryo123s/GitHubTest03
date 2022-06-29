package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.form.ContactForm;
import com.example.demo.security.User;
import com.example.demo.service.ContactService;

/**
 * コンタクトに関するコントローラー
 * @author jinjinliangjie
 *
 */
@Controller
public class ContactController {
	@Autowired
	private ContactService contactService;
	
	/**
	 * コンタクト画面に遷移する
	 * @param model
	 * @param user
	 * @param contactForm
	 * @return
	 */
	@GetMapping("/contact/contact")
	public String contact(Model model, @AuthenticationPrincipal User user, ContactForm contactForm) {
		model.addAttribute("contactList", contactService.getContactUserList(user.getUser_id()));
		model.addAttribute("user_id", user.getUser_id());
		return"/contact/contact";
	}
	
	/**
	 * コンタクト追加画面への遷移
	 * @param model
	 * @param contactForm
	 * @return
	 */
	@GetMapping("/contact/addContact")
	public String moveAddContact(Model model, @ModelAttribute("contactForm")ContactForm contactForm) {
		model.addAttribute("contactForm", contactForm);
		return "/contact/addContact";
	}
	
	/**
	 * ユーザーを検索する
	 * @param model
	 * @param contactForm
	 * @return
	 */
	@PostMapping("/searchUser")
	public String searchUser(Model model, @ModelAttribute("contactForm")ContactForm contactForm) {
		model.addAttribute("addUserInfo", contactService.searchUserByUserId(contactForm.getContact_user_id()));
		model.addAttribute("contactForm", contactForm);
		return "/contact/addContact";
	}
	
	/**
	 * コンタクトを追加する
	 * @param model
	 * @param user
	 * @param contactForm
	 * @return
	 */
	@PostMapping("/addContact")
	public String addContact(Model model, @AuthenticationPrincipal User user, @Valid ContactForm contactForm, BindingResult result) {
		contactService.addContact(contactForm);
		model.addAttribute("contactList", contactService.getContactUserList(user.getUser_id()));
		model.addAttribute("user_id", contactForm.getUser_id());
		return "/contact/contact";
	}
	
	/**
	 * コンタクトユーザー情報画面に遷移
	 * @param model
	 * @param contactForm
	 * @return
	 */
	@GetMapping("/contact/contactUser")
	public String contactUser(Model model, @ModelAttribute("contactForm")ContactForm contactForm) {
		model.addAttribute("contactForm", contactForm);
		return "contact/contactUser";
	}
	
	/**
	 * コンタクト登録解除の処理
	 * @param model
	 * @param contactForm
	 * @return
	 */
	@PostMapping("/deleteContact")
	public String deleteContact(Model model, @ModelAttribute("contactForm")ContactForm contactForm) {
		contactService.deleteContact(contactForm);
		model.addAttribute("contactList", contactService.getContactUserList(contactForm.getUser_id()));
		model.addAttribute("user_id", contactForm.getUser_id());
		return "/contact/contact";
	}
}
