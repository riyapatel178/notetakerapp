package com.entities;
import java.util.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Note {
	
	
	@Id
	private int id;
	private String title;
	private String content;
	private Date addeddate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getAddeddate() {
		return addeddate;
	}
	public void setAddeddate(Date addeddate) {
		this.addeddate = addeddate;
	}
	public Note(String title, String content, Date addeddate) {
		super();
		this.id = new Random().nextInt(10000);
		this.title = title;
		this.content = content;
		this.addeddate = addeddate;
	}
	public Note() {
		super();
		
	}
	
	

}
