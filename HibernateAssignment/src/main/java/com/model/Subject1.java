package com.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "subject")
public class Subject1 {

	@Column(name="title")
	private String title;
	
	@Column(name="durationInHours")
	private int durationInHours;
	
	@OneToMany(mappedBy="subject")
	private Set<Book1> bookList;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="subjectId")
	private int subjectId;
	
	
	public int getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getDurationInHours() {
		return durationInHours;
	}

	public void setDurationInHours(int durationInHours) {
		this.durationInHours = durationInHours;
	}

	public Set<Book1> getBookList() {
		if(bookList == null) {
			bookList = new HashSet<Book1>();
		}
		return bookList;
	}

	public void setBookList(Set<Book1> bookList) {
		this.bookList = bookList;
	}

 
}
