package com.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "book")
public class Book1 {

	public Book1(String title, double price, int volume, Subject1 subject1) {
		this.title = title;
		this.volume = volume;
		this.price = price;
		this.subject = subject1;
	}

	public Book1() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "bookid")
	private int bookid;

	@Column(name = "title")
	private String title;

	@Column(name = "price")
	private double price;

	@Column(name = "volume")
	private int volume;

	@Column(name="publishDate")
	private LocalDate publishDate;

	@ManyToOne
	@JoinColumn(name = "subjectId", nullable = false)
	private Subject1 subject;

	public int getBookid() {
		return bookid;
	}

	public void setBookid(int bookid) {
		this.bookid = bookid;
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

	public void setPublishDate(LocalDate publishDate) {
		this.publishDate = publishDate;
	}

	public Subject1 getSubject() {
		return subject;
	}

	public void setSubject(Subject1 subject) {
		this.subject = subject;
	}

}
