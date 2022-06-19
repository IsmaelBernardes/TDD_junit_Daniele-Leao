package br.com.tddjava.tddjava.modules.courses.entities;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="courses")
public class Course {
  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID id;
  
  private String description;
  private String name;
  private int workload;

  public Course(UUID id, String description, String name, int workload) {
    this.id = id;
    this.description = description;
    this.name = name;
    this.workload = workload;
  }

  public Course() {
  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getWorkload() {
    return workload;
  }

  public void setWorkload(int workload) {
    this.workload = workload;
  }  
}
