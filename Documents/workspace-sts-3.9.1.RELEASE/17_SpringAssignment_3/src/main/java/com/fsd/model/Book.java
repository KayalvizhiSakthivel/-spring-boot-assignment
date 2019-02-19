package com.fsd.model;

import java.io.Serializable;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Book_data")
public class Book implements Serializable {
	public static final long serialVersionUID = 1L;
	@Id
	@Column(name = "bookId")
	private long bookId;
	@Column(name = "title")
	private String title;
	@Column(name = "price")
	private double price;
	@Column(name = "volume")
	private int volume;

	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "publishDate", nullable = false)

	private LocalDate publishDate;

	@JoinColumn(name = "subjectId")
	private Subject subjectId;

	public Subject getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(Subject subjectId) {
		this.subjectId = subjectId;
	}

	public long getBookId() {
		return bookId;
	}

	public void setBookId(long bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	public LocalDate getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(@NotNull LocalDate publishDate) {
		this.publishDate = publishDate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", title=" + title + ", price=" + price + ", volume=" + volume
				+ ", publishDate=" + publishDate + "]";
	}

}
