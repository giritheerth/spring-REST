package com.learn.course_service.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {

    private int courseId;
    private String courseName;
    private String trainerName;
    private String duration;
    private Date startDate;
    private String courseType;
    private Double fees;
    private boolean isCertAvailable;

}
