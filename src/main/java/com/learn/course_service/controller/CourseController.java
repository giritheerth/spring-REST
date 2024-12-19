package com.learn.course_service.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.learn.course_service.dto.Course;
import com.learn.course_service.service.CourseService;

@RestController // Controller and ResponseBody
@RequestMapping("/course") // base url
public class CourseController {

    private CourseService courseService;

    // constructor injection
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    // add course to database
    /*
     * postman - object as input need to write @RequestBody to convert json into
     * object
     */
    @PostMapping("/addCourse")
    public ResponseEntity<?> addCourse(@RequestBody Course course) {
        Course newCourse = courseService.createCourse(course);
        return new ResponseEntity<>(newCourse, HttpStatus.CREATED); // return 201 status code
    }

    // find all courses
    @GetMapping("/getAllCourses")
    public ResponseEntity<?> getAllCourses() {
        return new ResponseEntity<>(courseService.getAllCourses(), HttpStatus.OK); // return 200 status code
    }

    // find course by id by passing courseId (mandatory)
    @GetMapping("/getCourseById/{courseId}")
    public ResponseEntity<?> getCourseById(@PathVariable int courseId) {
        Course course = courseService.getCourseById(courseId);
        if (course == null) {
            return new ResponseEntity<>("Course not found", HttpStatus.NOT_FOUND); // return 404 status code
        }
        return new ResponseEntity<>(course, HttpStatus.OK); // return 200 status code
    }

    // find course by id by search using requestparam (optional)
    @GetMapping("/getCourseById/request")
    public ResponseEntity<?> getCourseByIdRequestParam(@RequestParam(required = false) int courseId) {
        Course course = courseService.getCourseById(courseId);
        if (course == null) {
            return new ResponseEntity<>("Course not found", HttpStatus.NOT_FOUND); // return 404 status code
        }
        return new ResponseEntity<>(course, HttpStatus.OK); // return 200 status code
    }

    // delete
    @DeleteMapping("/deleteCourseById/{courseId}")
    public ResponseEntity<?> deleteCourseById(@PathVariable int courseId) {
        boolean isDeleted = courseService.deleteCourseById(courseId);
        if (!isDeleted) {
            return new ResponseEntity<>("Course not found", HttpStatus.NOT_FOUND); // return 404 status code
        }
        return new ResponseEntity<>("Course deleted successfully", HttpStatus.OK); // return 200 status code
    }

    // update
    @PutMapping("/updateCourse/{courseId}")
    public ResponseEntity<?> updateCourse(@PathVariable int courseId, @RequestBody Course course) {
        Course existingCourse = courseService.getCourseById(courseId);
        if (existingCourse != null) {
            courseService.updateCourseById(courseId, course);
        }
        return new ResponseEntity<>(course, HttpStatus.OK); // return 200 status code
    }

}
