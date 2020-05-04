package com.mkyong.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mkyong.dao.UserDao;
import com.mkyong.model.User;

@Controller
public class WelcomeController {

//	private static final Logger logger = LoggerFactory.getLogger(WelcomeController.class);

	@Autowired
	private UserDao userDao;

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String welcome(Model model) {
		return "welcome";
	}

	@RequestMapping(value = "/request1", method = RequestMethod.GET)
	public String request1(Model model) {
		List<User> users = userDao.findAll();
		System.out.println(users);
		model.addAttribute("user", users);
		return "request1";
	}

	@RequestMapping(value = "/request2", method = RequestMethod.GET)
	public String request2(Model model) {
		List<User> users = userDao.findByLastName("corner");
		System.out.println(users);
		model.addAttribute("user", users);
		return "request2";
	}

	@RequestMapping(value = "/request3", method = RequestMethod.GET)
	public String request3(Model model) {
		List<User> users = userDao.findLetterAll("a");
		System.out.println(users);
		model.addAttribute("user", users);
		return "request3";
	}

}