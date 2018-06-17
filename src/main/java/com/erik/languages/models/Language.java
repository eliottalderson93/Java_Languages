package com.erik.languages.models;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Size;

@Entity
@Table(name = "languages")
public class Language {
	//declarations and validations
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Size(min = 2, max = 20)
	private String name;
	@Size(min = 2, max = 20)
	private String creator;
	@DecimalMin("0.00")
	private double version;
	@Column(updatable=false)
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	//methods
	public Language() {}
	public Language(String Name, String Creator, double Version) {
		this.name = Name;
		this.creator = Creator;
		this.version = Version;
	}
	public void setId(Long id) {
		this.id = id; //use carefully
	}
	public void setName(String Name) {
		this.name = Name;
	}
	public void setCreator(String Creator) {
		this.creator = Creator;
	}
	public void setVersion(double Version) {
		this.version = Version;
	}
	public Long getId() {
		return this.id;
	}
	public String getName() {
		return this.name;
	}
	public String getCreator() {
		System.out.println("The God of Abraham and Isaac");
		return this.creator;
	}
	public double getVersion() {
		return this.version;
	}
	@PrePersist
    protected void onCreate(){
        this.createdAt = LocalDateTime.now();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = LocalDateTime.now();
    }
}
