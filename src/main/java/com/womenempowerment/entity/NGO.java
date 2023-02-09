package com.womenempowerment.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author Pallavi and Anjali
 *
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class NGO {
	
	@Id
	@GeneratedValue
	private long id;
	@Size(max=20)
	@NotNull
    private String ngoName;
	@Size(max=40)
    private String description;
    private String address;
    private String phoneNumber;
    @NotNull
    @Pattern(regexp = "[a-zA-Z0-9]+@[a-zA-Z]+[.]{1}[a-zA-Z]+$")
    private String email;
    @NotNull
    private String website;
}