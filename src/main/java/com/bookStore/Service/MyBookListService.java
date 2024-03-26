package com.bookStore.Service;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookStore.Repository.MyBookListRepository;
import com.bookStore.entity.MyBookList;

@Service
public class MyBookListService {


@Autowired
private MyBookListRepository bookRepo;
	public void saveMyBooks(MyBookList book) {
		bookRepo.save(book);
	}
	public List<MyBookList> getAllMyBooks(){
		return bookRepo.findAll();
	}
	
	public void deleteById(int id) {
		 bookRepo.deleteById(id);
	}
}
