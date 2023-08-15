package com.bookshelves.model;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="author")
public class Author {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long authorid;
	
	private String authorname;
	
	@CreationTimestamp
	private LocalDateTime createdOn;
	
	@UpdateTimestamp
	private LocalDateTime updatedOn;
	
	private String authoraddress;
	
	@OneToMany(mappedBy="author")
	private List<Book> book;


	


	public Long getAuthorid() {
		return authorid;
	}


	public void setAuthorid(Long authorid) {
		this.authorid = authorid;
	}


	public String getAuthorname() {
		return authorname;
	}


	public void setAuthorname(String authorname) {
		this.authorname = authorname;
	}



	public LocalDateTime getCreatedOn() {
		return createdOn;
	}


	public void setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
	}


	public LocalDateTime getUpdatedOn() {
		return updatedOn;
	}


	public void setUpdatedOn(LocalDateTime updatedOn) {
		this.updatedOn = updatedOn;
	}


	public String getAuthoraddress() {
		return authoraddress;
	}


	public void setAuthoraddress(String authoraddress) {
		this.authoraddress = authoraddress;
	}


	public Author( Long authorid,String authorname,String authoraddress) {
//		this.authorid = authorid;
		this.authorname = authorname;
		this.authoraddress = authoraddress;
		
	}


	public Author() {
	}


	@Override
	public String toString() {
		return "Author [authorid=" + authorid + ", authorname=" + authorname + ", createdOn=" + createdOn
				+ ", updatedOn=" + updatedOn + ", authoraddress=" + authoraddress + "]";
	}
	
}
