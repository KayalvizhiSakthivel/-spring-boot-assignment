package com.fsd.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fsd.model.Book;

@Repository
public interface Book_Repo extends CrudRepository<Book, Long> {

	List<Book> findAllByBookId(long bookId);

	@Query(value = "select bookId,title,price,volume,publishdate,subjectId from Book_Data where title=?1", nativeQuery = true)
	public Book findBookByTitle(String title);

}
