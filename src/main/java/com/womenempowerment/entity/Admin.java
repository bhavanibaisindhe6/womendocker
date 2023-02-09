package com.womenempowerment.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author Anjali
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Admin {
	@Id
	@GeneratedValue
	private long id;
	@NotNull
    private String adminUsername;
	@NotNull
	@Size(min=4,max=8,message="Password does not meet the requirements")
    private String adminPassword;
}
