package lamhd.spring.security.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/users")
public class UserController {
	@RequestMapping(method = RequestMethod.GET)
	public String getUsers(Model model, Principal principal) {
		// Get Username login
		String username = principal.getName();
		return "user";
	}

}
