package com.womenempowerment.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author Manasa and Bhavani
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class FeedBack {
	
	@Id
	@GeneratedValue
	private long feedBackId;
	@NotNull
	private int overallRating;
	@NotNull
	private String comments;
	private String trainingCourse;
	private LocalDate feedBackDate;

	public FeedBack(int i, int j, int k, String string, String string2, LocalDate now) {

	}
}
