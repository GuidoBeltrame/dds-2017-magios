package ar.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MenuController {

	@RequestMapping(value = "/menu")
	public ModelAndView menu() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("menu");

		return mv;
	}
}
