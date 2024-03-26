package com.bookStore.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bookStore.Service.MyBookListService;

@Controller
public class MyBookListContoller {
	@Autowired
	private MyBookListService bookservice;
	
    @RequestMapping("/deleteMyList/{id}")
	public String deleteMyList(@PathVariable("id")int id) {
    	bookservice.deleteById(id);
		return "redirect:/my_books";
	}
}
