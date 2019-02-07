package org.oleg.taco.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 
 * @author Unit
 *  Controller that return home controller for get request by url "/"
 */
@Controller
public class HomeController {
	@GetMapping("/")
	public String home() {
		return "home";
	}

}
