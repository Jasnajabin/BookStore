package com.bookStore.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookStore.Repository.BookRepository;
import com.bookStore.entity.Book;

@Service
public class BookService {
@Autowired
private BookRepository repo;
	public void saveBook(Book b) {
		repo.save(b);
	}
	public List<Book> getAllBook(){
		return repo.findAll();
	}
	
	public Book getBookById(int id) {
		return repo.findById(id).get();
	}
	public void deleteById(int id) {
		repo.deleteById(id);
	}
}
