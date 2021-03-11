package org.codejudge.sb.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.EqualsAndHashCode;


@Entity
@Table(name = "QUIZ")
public class Quiz {
	
	public Quiz(Integer id, String name, String description, List<Question> questions) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.questions = questions;
	}

	public Quiz() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	@Override
	public String toString() {
		return "Quiz [id=" + id + ", name=" + name + ", description=" + description + "]";
	}
	@Id
	@Column(name = "QUIZID")
	@JsonProperty
	@GeneratedValue
	@EqualsAndHashCode.Include
	private Integer id;
	@JsonProperty
	@NotNull
	@Column(name = "NAME")
	private String name;
	@JsonProperty
	@Column(name = "DESCRIPTION")
	@NotNull
	private String description;
	
	@OneToMany(targetEntity=Question.class,mappedBy = "quizId", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, orphanRemoval = true)
	private List<Question> questions;
	
	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}
	

}
