package com.hdfc.repository;

import com.hdfc.entity.Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class CourseRepository {

    private Map<Integer, Course> courseStorage = new HashMap<>();

    public void save(Course course){
        courseStorage.put(course.getCourseId(),course);
    }

    public Course getById(int courseId){
        return courseStorage.get(courseId);
    }

    public List<Course> getAll(){
        return new ArrayList<Course>(courseStorage.values());
    }

    public void update(int courseId , Course newCourse){
        if(newCourse == null) return;
        Course course = courseStorage.get(courseId);
        course.setCourseName(newCourse.getCourseName());
        course.setTrainerName(newCourse.getTrainerName());
        course.setDurationInDays(newCourse.getDurationInDays());
        course.setMaxCapacity(newCourse.getMaxCapacity());
        course.setFees(newCourse.getFees());
    }

    public Course remove(int courseId){
        Course removedCourse = courseStorage.get(courseId);
        courseStorage.remove(courseId);
        return removedCourse;
    }
}
