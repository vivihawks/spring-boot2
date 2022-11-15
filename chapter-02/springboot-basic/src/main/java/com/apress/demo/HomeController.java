/**
 * 
 */
package com.apress.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Siva
 *
 */
@Controller
public class HomeController {

	@Value("logging.level.org.springframework")
	private String test;

	@RequestMapping("/home")
//	@ResponseBody
	public String home(Model model) {
//		return "This is response body";
		return "index.html";
	}
}
