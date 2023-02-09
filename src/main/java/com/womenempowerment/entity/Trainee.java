package com.womenempowerment.entity;

import java.util.List;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author Nischay and Hassireen
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Trainee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long traineeId;
	@NotNull
	@Size(max=15,message="limit reached")
	private String firstName;
	@NotNull
	private String lastName;
	@Pattern(regexp = "[a-zA-Z0-9]+@[a-zA-Z]+[.]{1}[a-zA-Z]+$")
	private String emailId;
	private int age;
	private String occupation;
	@NotNull
	@Size(min=4,max=8,message="Password does not meet the requirements")
	private String password;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="fk_Id")
	private NGO ngo;
	
	@OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name ="fk_cid")
    private List<TraineeCourse> course;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="fk_sid")
	private List<Scheme> scheme;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_fid")
    private FeedBack feedBack;
	
}
