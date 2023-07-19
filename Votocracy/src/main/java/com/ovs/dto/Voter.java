package com.ovs.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Voter {
	
	   
	@Id
    @Column(name = "employee_id", length = 12)
    private String voterId;

    
	
	public Voter() {
		
	}

    public String getVoterId() {
        return voterId;
    }

    public void setVoterId(String voterId) {
        // Perform numeric validation and enforce fixed length
        if (voterId == null || !voterId.matches("\\d{12}")) {
            throw new IllegalArgumentException("Employee ID must be a 12-digit number.");
        }
        this.voterId = voterId;
    }

}
