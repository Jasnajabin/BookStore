package com.bookStore.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bookStore.Service.BookService;
import com.bookStore.Service.MyBookListService;
import com.bookStore.entity.Book;
import com.bookStore.entity.MyBookList;

@Controller
public class BookController {
	@Autowired
	private BookService service;
	
	@Autowired
	private MyBookListService myBookservice;
	@GetMapping("/")
	public String home() {
		return "home";
	}
	@GetMapping("/book_Register")
	public String bookRegister() {
		return "bookRegister";
	}
	@GetMapping("/available_books")
	public  ModelAndView   getAllBook() {
		List<Book> list= service.getAllBook();
//		ModelAndView m=new ModelAndView();
//		m.setViewName("bookList");
//		m.addObject("book", list);
		return new ModelAndView("bookList","book",list);
	}
	@PostMapping("/save")
	public String saveBook(@ModelAttribute Book b) {
		service.saveBook(b);
		return "redirect:/available_books";
	}
	@GetMapping("/my_books")
	public String getMyBooks(Model model) {
		List<MyBookList>list=myBookservice.getAllMyBooks();
		model.addAttribute("book", list);
		return "myBooks";
	}
	@RequestMapping("/mylist/{id}")
	public String getMyList(@PathVariable("id") int id) {
		Book b=service.getBookById(id);
		MyBookList mb=new MyBookList(b.getId(),b.getName(),b.getAuthor(),b.getPrice());
		myBookservice.saveMyBooks(mb);
		return "redirect:/my_books";
		
	}
	@RequestMapping("/editBook/{id}")
	public String editBook(@PathVariable("id")int id, Model model) {
		Book b=service.getBookById(id);
		model.addAttribute("book", b);
		return "bookEdit";
	}
	@RequestMapping("/deleteBook/{id}")
	public String deleteBook(@PathVariable("id") int id) {
		service.deleteById(id);
		return "redirect:/available_books";
	}
	

}
