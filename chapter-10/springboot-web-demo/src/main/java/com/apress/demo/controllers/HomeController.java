/**
 * 
 */
package com.apress.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Siva
 *
 */
@Controller
public class HomeController
{
	
	@RequestMapping("/about")
//	@ResponseBody
	public String home(Model model)
	{
		return "aboutus.html";
	}
}
