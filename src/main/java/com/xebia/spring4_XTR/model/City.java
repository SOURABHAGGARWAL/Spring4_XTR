package com.xebia.spring4_XTR.model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class City implements Serializable {

	private static final long serialVersionUID = 786780698189638649L;

	@Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String state;
    
    @Column(nullable = false)
    private String country;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
}
