package br.com.tddjava.tddjava.modules.courses.services;

import org.springframework.stereotype.Service;

import br.com.tddjava.tddjava.modules.courses.entities.Course;
import br.com.tddjava.tddjava.modules.courses.repositories.ICourseRepository;

@Service
public class CreateCourseService {

  private ICourseRepository repository;

  public CreateCourseService(ICourseRepository repository) {
    this.repository = repository;
  }
  
  public Course execute(Course course) {
    
    //validar se o curso existe pelo nome;
    Course existedCourse = this.repository.findByName(course.getName());

    ///se sim- retorna erro;
    if (existedCourse != null) {
      throw new Error("Curso já existe!");
    }

    //se não - salvar e retorna novo curso;
    return this.repository.save(course);
    
  }
}
