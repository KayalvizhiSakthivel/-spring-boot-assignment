package com.fsd.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fsd.model.Book;
import com.fsd.model.Subject;
import com.fsd.service.Sphib_service_impl;

@Controller
public class SpringController {

	@Autowired
	private Sphib_service_impl sp_service;

	@GetMapping({ "/", "/home" })
	public String WelcomeAction() {
		return "welcome";
	}

	@GetMapping("/addBook")
	public ModelAndView addBookAction(@RequestParam(value = "bookId", required = false) Long bookId) {
		Book b = bookId == null ? new Book() : sp_service.findBookById(bookId);
		return new ModelAndView("addBookForm", "book", b);
	}

	@PostMapping("/addBook")
	public ModelAndView addBookSaveAction(@Valid @ModelAttribute("book") Book b, BindingResult bindingResult) {
		ModelAndView mv = null;

		if (bindingResult.hasErrors())
			mv = new ModelAndView("addBookForm", "book", b);

		else {
			sp_service.addBook(b);
			mv = new ModelAndView("addBookForm", "book", b);
		}

		return mv;

	}

	@GetMapping("/deleteBook")
	public ModelAndView deleteBookAction(@RequestParam(value = "bookId", required = false) Long bookId) {
		List<Book> b = bookId == null ? new ArrayList<Book>() : sp_service.findAllBook();
		return new ModelAndView("deleteBookForm", "book", b);
	}

	@PostMapping("/deleteBook")
	public ModelAndView deleteBookActionfromdb(@RequestParam(name = "bookId", required = true) Long bookId) {
		sp_service.deleteBook(bookId);
		List<Book> b = bookId == null ? new ArrayList<Book>() : sp_service.findAllBook();
		return new ModelAndView("deleteBookForm", "book", b);
	}

	@GetMapping("/searchBook")
	public ModelAndView searchBookAction() {
		return new ModelAndView("searchBookForm", "book", new String[] { "bookId" });
	}

	@PostMapping("/searchBook")
	public ModelAndView searchBookfromdb(@RequestParam String field, @RequestParam long value) {
		ModelAndView mv = new ModelAndView("searchBookForm", "book", new String[] { "bookId" });
		mv.addObject("recs", sp_service.findBook(field, value));
		return mv;
	}

	@GetMapping("/addSubject")
	public ModelAndView addSubjectAction(@RequestParam(value = "subjectId", required = false) Long subjectId) {
		Subject s = subjectId == null ? new Subject() : sp_service.findSubjectById(subjectId);
		List<Book> booklist = new ArrayList<Book>();
		booklist.add(new Book());
		s.setReferences(booklist);
		return new ModelAndView("addSubjectForm", "subject", s);
	}

	@PostMapping("/addSubject")
	public ModelAndView addSubjectSaveAction(@Valid @ModelAttribute("subject") Subject s, BindingResult bindingResult) {
		ModelAndView mv = null;

		if (bindingResult.hasErrors())
			mv = new ModelAndView("addSubjectForm", "subject", s);

		else {
			sp_service.addSubject(s);
			mv = new ModelAndView("addSubjectForm", "subject", s);
		}

		return mv;

	}

	@GetMapping("/deleteSubject")
	public ModelAndView deleteSubjectAction(@RequestParam(value = "subjectId", required = false) Long subjectId) {
		List<Subject> s = subjectId == null ? new ArrayList<Subject>() : sp_service.findAllSubject();
		return new ModelAndView("deleteSubjectForm", "subject", s);
	}

	@PostMapping("/deleteSubject")
	public ModelAndView deleteSUbjectActionfromdb(@RequestParam(name = "subjectId", required = true) Long subjectId) {
		sp_service.deleteSubject(subjectId);
		List<Subject> s = subjectId == null ? new ArrayList<Subject>() : sp_service.findAllSubject();
		return new ModelAndView("deleteSubjectForm", "subject", s);
	}

	@GetMapping("/searchSubject")
	public ModelAndView searchSubjectAction() {
		return new ModelAndView("searchSubjectForm", "subject", new String[] { "subjectId" });
	}

	@PostMapping("/searchSubject")
	public ModelAndView searchSubjectfromdb(@RequestParam String field, @RequestParam long value) {
		ModelAndView mv = new ModelAndView("searchSubjectForm", "subject", new String[] { "subjectId" });
		mv.addObject("recs", sp_service.findSubject(field, value));
		return mv;
	}

	@GetMapping("/searchSubjectByDur")
	public ModelAndView searchSubjectByDurAction() {

		return new ModelAndView("searchSubjectByDurForm", "subject", null);
	}

	@PostMapping("/searchSubjectByDur")
	public ModelAndView searchSubjectByDurfromdb(
			@RequestParam(name = "durationInHours", required = true) int durationInHours) {

		Subject s = sp_service.findSubjectByDur(durationInHours);

		return new ModelAndView("searchSubjectByDurForm", "subject", s);

	}
	/*
	 * @GetMapping("/searchSubjectByDur") public ModelAndView
	 * searchSubjectByDurAction() { return new
	 * ModelAndView("searchSubjectByDurForm", "subject", new String[] {
	 * "durationInHours" }); }
	 * 
	 * @PostMapping("/searchSubjectByDur") public ModelAndView
	 * searchSubjectByDurfromdb(@RequestParam String field, @RequestParam int value)
	 * { ModelAndView mv = new ModelAndView("searchSubjectByDurForm", "subject", new
	 * String[] { "durationInHours" }); mv.addObject("recs",
	 * sp_service.findSubjectByDur(field, value)); System.out.println(mv); return
	 * mv; }
	 */

	@GetMapping("/searchBookByTitle")
	public ModelAndView searchBookByTitleAction(@RequestParam(value = "title", required = false) String title) {

		return new ModelAndView("searchBookByTitleForm", "book", null);
	}

	@PostMapping("/searchBookByTitle")
	public ModelAndView searchBookByTitlefromdb(@RequestParam(name = "title", required = true) String title) {
		Book b = sp_service.findBookByTitle(title);

		ModelAndView mv = new ModelAndView("searchBookByTitleForm", "book", b);

		return mv;

	}

}