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
 * @author Hassireen
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class TraineeCourse {
	@Id
    @GeneratedValue
    private long id;
	@NotNull
    private int courseCode ;
    @NotNull
    private String courseName;
    private  int duration;
    private LocalDate startDate;
    private LocalDate endDate;
}
