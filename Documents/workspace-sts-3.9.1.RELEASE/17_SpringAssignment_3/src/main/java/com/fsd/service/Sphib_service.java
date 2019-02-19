package com.fsd.service;

import java.util.List;

import com.fsd.model.Book;
import com.fsd.model.Subject;

public interface Sphib_service {

	public Long addBook(Book book);

	public Long addSubject(Subject sub);

	public boolean deleteSubject(long subjectid);

	public boolean deleteBook(long bookid);

	public Book findBookById(long bookid);

	public Subject findSubjectById(long subjectid);

	public Iterable<Subject> findAllSubject();

	public Iterable<Book> findAllBook();

	List<Book> findBook(String field, long value);

	List<Subject> findSubject(String field, long value);

	public Subject findSubjectByDur(int durationInHours);

	// public Subject findSubjectByDur(String field,int value);

	public Book findBookByTitle(String title);
}
