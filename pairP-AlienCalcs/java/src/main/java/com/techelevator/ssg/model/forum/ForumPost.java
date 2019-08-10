package com.techelevator.ssg.model.forum;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class ForumPost {
	private Long id;
	
    @Size(max=20, message="Username can not be over 20 characters")
	@NotBlank(message="**Required**")
	private String username;
	
    @Size(min=2, message="Subject must be over 2 characters")
	@NotBlank(message="**Required**")
	private String subject;
	
	@NotBlank(message="**Required**")
	private String message;
	private LocalDateTime datePosted;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public LocalDateTime getDatePosted() {
		return datePosted;
	}
	public Date getJavaDatePosted() {
		return java.sql.Timestamp.valueOf(datePosted);
	}
	
	
	
	public void setDatePosted(LocalDateTime datePosted) {
		this.datePosted = datePosted;
	}
}
