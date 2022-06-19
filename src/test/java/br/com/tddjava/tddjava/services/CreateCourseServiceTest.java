package br.com.tddjava.tddjava.services;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.Test;

import br.com.tddjava.tddjava.modules.courses.entities.Course;
import br.com.tddjava.tddjava.modules.courses.repositories.CourseInMemoryRepository;
import br.com.tddjava.tddjava.modules.courses.services.CreateCourseService;

public class CreateCourseServiceTest {
  
  @Test
  public void should_be_able_to_create_a_new_course() {
    
    //create a new course;
    //create course table (Entity);
    //ID, description, name, workload;
    Course course = new Course();
    course.setDescription("Course_Description_Test");
    course.setName("Course_Name_Test");
    course.setWorkload(100);
    
    //create course repository;
    CourseInMemoryRepository repository = new CourseInMemoryRepository();

    //create a new sevice;
    CreateCourseService createCourseService = new CreateCourseService(repository);
    Course createdCourse = createCourseService.execute(course);
   
    assertNotNull(createdCourse.getId());
  }

  @Test(expected=Error.class)
  public void should_not_be_able_to_create_a_new_course_if_exists() {
    
    Course course = new Course();
    course.setDescription("Not_Create_Course");
    course.setName("Not_Create_Course");
    course.setWorkload(100);
    
    CourseInMemoryRepository repository = new CourseInMemoryRepository();

    CreateCourseService createCourseService = new CreateCourseService(repository);
    createCourseService.execute(course);
    createCourseService.execute(course);
  }
}
