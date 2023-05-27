package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demo.model.Course;

@Service
public class CourseServiceImpl implements CourseService{
	
	List <Course> list;
	public CourseServiceImpl() {
		list=new ArrayList<>();
		list.add(new Course(123,"Java","JAVA is programming langauage"));
		list.add(new Course(143,"Spring","Spring is a framework"));
		
		
	}

	@Override
	public List<Course> getCourses() {
		// TODO Auto-generated method stub
		return list;
	}

	
	public Course getCourse(int courseId) {
		// TODO Auto-generated method stub
		Course c=null;
		for(Course course:list)
		{
			if(course.getId()==courseId) {
				c=course;
				break;
				
			}
		}
		return c;
	}

	@Override
	public Course addCourse(Course course) {
		list.add(course);
		return course;
	}

	@Override
	public Course updateCourse(Course course) {
		list.forEach(e -> {
			if(e.getId()==course.getId()) {
				e.setName(course.getName());
				e.setDescription(course.getDescription());
			}
		}
		);
		return course;
	}

	@Override
	public void deleteCourse(int parseInt) {
		list=this.list.stream().filter(e -> e.getId()!=parseInt).collect(Collectors.toList());
		
	}
	
	

}
