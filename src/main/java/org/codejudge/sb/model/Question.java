package org.codejudge.sb.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "QUESTION")
public class Question {
	@Id
	@Column(name = "QUESTIONID")
	@JsonProperty
	private int id;
	@Column(name = "NAME")
	@JsonProperty
	private String name;
	@Column(name = "OPTIONS")
	@JsonProperty
	private String options;
	@Column(name = "CORRECTOPTION")
	@JsonProperty(value="correct_option")
	
	
	private String correctOption;
	
	@ManyToOne(targetEntity=Quiz.class)
	@JoinColumn(name="QUIZID")
	@JsonProperty(value="quiz")
	private int quizId;
	@Column(name = "POINTS")
	@JsonProperty
	private int points;

	@Override
	public String toString() {
		return "Question [id=" + id + ", name=" + name + ", options=" + options + ", correctOption=" + correctOption
				+ ", quiz=" + quizId + ", point=" + points + "]";
	}

}
