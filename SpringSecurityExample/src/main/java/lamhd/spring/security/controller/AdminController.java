package lamhd.spring.security.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {
	@RequestMapping(method = RequestMethod.GET)
	public String getAdmin(Model model, Principal principal) {
		// get User name login
		String username = principal.getName();
		// String username = principal.getName();
		// User loginedUser = (User) ((Authentication)
		// principal).getPrincipal();
		// String userInfo = WebUtils.toString(loginedUser);
		// model.addAttribute("userInfo", userInfo);
		return "admin";
	}

}
