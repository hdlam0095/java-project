package lamhd.spring.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

	@RequestMapping(value = { "/index", "/" }, method = RequestMethod.GET)
	public String index(Model model) {
		return "index";
	}

	@RequestMapping(value = { "/user_admin" }, method = RequestMethod.GET)
	public String pageAll(Model model) {
		return "user_admin";
	}

	@RequestMapping(value = { "/login" }, method = RequestMethod.GET)
	public String login(Model model) {
		return "login";
	}
	@RequestMapping(value = { "/403" }, method = RequestMethod.GET)
	public String error(Model model) {
		return "error_403";
	}

}
