package com.fsd.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fsd.dao.Book_Repo;
import com.fsd.dao.Subject_Repo;
import com.fsd.model.Book;
import com.fsd.model.Subject;

@Service
public class Sphib_service_impl implements Sphib_service {

	@Autowired
	private Subject_Repo sub_repo;
	@Autowired
	private Book_Repo book_repo;

	@Override

	public Long addBook(Book book) {
		// TODO Auto-generated method stub
		Book b = book_repo.save(book);
		return b == null ? -1 : b.getBookId();

	}

	@Override

	public Long addSubject(Subject sub) {
		// TODO Auto-generated method stub
		Subject s = sub_repo.save(sub);
		return s == null ? -1 : s.getSubjectId();

	}

	@Override

	public boolean deleteSubject(long subjectid) {
		// TODO Auto-generated method stub
		boolean isDeleted = false;
		if (sub_repo.existsById(subjectid)) {
			sub_repo.deleteById(subjectid);
			isDeleted = true;

		}
		return isDeleted;
	}

	@Override

	public boolean deleteBook(long bookid) {
		// TODO Auto-generated method stub
		boolean isDeleted = false;
		if (book_repo.existsById(bookid)) {
			book_repo.deleteById(bookid);
			isDeleted = true;

		}
		return isDeleted;
	}

	@Override

	public Book findBookById(long bookid) {
		// TODO Auto-generated method stub
		Optional<Book> book = book_repo.findById(bookid);
		return book.isPresent() ? book.get() : null;
	}

	@Override

	public Subject findSubjectById(long subjectid) {
		// TODO Auto-generated method stub
		Optional<Subject> subject = sub_repo.findById(subjectid);
		return subject.isPresent() ? subject.get() : null;
	}

	@Override

	public List<Subject> findAllSubject() {
		// TODO Auto-generated method stub
		return (List<Subject>) sub_repo.findAll();

	}

	@Override
	public List<Book> findAllBook() {
		// TODO Auto-generated method stub
		return (List<Book>) book_repo.findAll();

	}

	@Override
	public List<Book> findBook(String field1, long value1) {
		List<Book> records = null;

		// if("bookId".equals(field1))
		records = book_repo.findAllByBookId(value1);

		return records;
	}

	@Override
	public List<Subject> findSubject(String field, long value) {
		List<Subject> records = null;
		if ("subjectId".equals(field))
			records = sub_repo.findAllBySubjectId(value);

		return records;
	}

	/*
	 * public Subject findSubjectByDur(String field,int value) { Subject records =
	 * null; //if ("subjectId".equals(field)) records =
	 * sub_repo.findSubjectByDur(value); System.out.println(records); return
	 * records; }
	 */

	@Override
	public Subject findSubjectByDur(int durationInHours) {
		// TODO Auto-generated method stub

		Subject s = sub_repo.findSubjectByDur(durationInHours);

		return s;
	}

	@Override
	public Book findBookByTitle(String title) {
		// TODO Auto-generated method stub
		return book_repo.findBookByTitle(title);

	}

}
