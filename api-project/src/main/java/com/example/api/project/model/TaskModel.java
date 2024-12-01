package com.example.api.project.model;

import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Data
@Entity
public class TaskModel {

	@Id
	@GeneratedValue
	private int id;
	@NotBlank(message = "Title cannot be blank")
	@Size(min = 1, max = 20, message = "Title must be between 1 and 20 characters")
	private String title;
	private String description;
	@Pattern(regexp = "^(PENDING|PROGRESS|COMPLETED)$", message = "Status must be either 'Pending', 'Progress', or 'Completed'")
	private String status;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date created_date;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date updated_date;

}
