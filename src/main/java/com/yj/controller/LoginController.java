package com.yj.controller;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yj.model.Member;
import com.yj.pojo.GoogleUser;
import com.yj.service.MemberService;
import com.yj.utils.GoogleAuthHelper;

@Controller
public class LoginController {
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	@Autowired
	private Environment env;
	@Autowired
	private MemberService memberService;
	@Autowired
	private GoogleAuthHelper googleAuthHelper;

	@RequestMapping("/")
	public String home() {
		return "/dashboard";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public Model login(Model model) {
		String apiUrl = googleAuthHelper.buildLoginUrl(env.getProperty("google.callback"));
		model.addAttribute("version", env.getProperty("project.version"));
		model.addAttribute("apiUrl", apiUrl);

		return model;
	}

	@RequestMapping(value = "/accessDenied", method = RequestMethod.GET)
	public String accessDenied(@RequestParam(value = "state", required = false) String state, Model model) {
		this.login(model);
		model.addAttribute("state", state);

		return "login";
	}

	@RequestMapping(value = "/authentication", method = RequestMethod.GET)
	public String authentication(@RequestParam(value = "code", required = false) String authCode) throws IOException {
		if (authCode == null) {
			return "redirect:/accessDenied?state=codeIsNull";
		}
		GoogleUser googleUser = googleAuthHelper.getUserInfoJson(authCode);
		/*
		 * https://github.com/mdanter/OAuth2v1 전달되어야 하는 url -
		 * https://www.googleapis.com/oauth2/v1/userinfo?access_token=
		 */
		if (googleUser == null) {
			throw new RuntimeException("googleUser is null~!");
		}

		boolean isEmail = memberService.isEmail(googleUser.getEmail());
		if(!isEmail) {
			try {
				memberService.insertGoogleMember(googleUser);
			} catch (Exception e) {
				logger.error("구글 유저 등록 실패 : " + e.getMessage());
				return "redirect:/accessDenied?state=googleError";
			}
		}

		return "redirect:/login";
	}

	@RequestMapping(value = "/joinView", method = RequestMethod.GET)
	public String joinView(Member member) {
		return "join";
	}
	
	@RequestMapping(value = "/singup", method = RequestMethod.GET)
	public String singup() { //소셜 로그인 이용자 추가 정보 받기
		
		return null;
	}
	
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(Member member) {
		try {
			memberService.join(member);
		} catch (Exception e) {
			logger.error("회원 가입 실패 : " + e.getMessage());
			return "redirect:/accessDenied?state=joinError";
		}
		return "dashboard";
	}
}
