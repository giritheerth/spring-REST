package com.learn.course_service.service;

import org.springframework.stereotype.Service;
import com.learn.course_service.dto.Course;
import java.util.List;
import java.util.Random;
import java.util.ArrayList;

@Service
public class CourseService {

    private List<Course> courseDatabase = new ArrayList<>();

    // create course object
    public Course createCourse(Course course) {
        course.setCourseId(new Random().nextInt(1000));
        courseDatabase.add(course);
        return course;
    }

    // get all courses
    public List<Course> getAllCourses() {
        return courseDatabase;
    }

    // get course by id
    public Course getCourseById(int courseId) {
      return courseDatabase.stream()
                .filter(course -> course.getCourseId() == courseId)
                .findFirst()
                .orElse(null);
    }

    // update course by id 
    public Course updateCourseById(int courseId, Course course) {
        for (Course c : courseDatabase) {
            if (c.getCourseId() == courseId) {
                c.setCourseName(course.getCourseName());
                c.setTrainerName(course.getTrainerName());
                c.setDuration(course.getDuration());
                c.setStartDate(course.getStartDate());
                c.setCourseType(course.getCourseType());
                c.setFees(course.getFees());
                c.setCertAvailable(course.isCertAvailable());
                c.setCourseDescription(course.getCourseDescription());
                return c;
            }
        }
        return null;
    }

     // delete course by id
    public boolean deleteCourseById(int courseId) {
       try{
            courseDatabase.removeIf(course -> course.getCourseId() == courseId);
            return true;
        } catch (Exception e) {
            return false;
       }
}

}