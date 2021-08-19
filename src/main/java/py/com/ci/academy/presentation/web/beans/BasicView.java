/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.ci.academy.presentation.web.beans;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;
import py.com.ci.academy.course.boundary.CourseManager;
import py.com.ci.academy.course.boundary.CourseManager.Course;
import py.com.ci.academy.teacher.boundary.TeacherManager;
import py.com.ci.academy.teacher.entities.Teacher;

/**
 *
 * @author cbustamante
 */
@Named("dtBasicView")
@ViewScoped
public class BasicView implements Serializable {

    private List<Teacher> teachers;

    private TeacherManager teacherManager;

    private List<Course> courses;

    private CourseManager courseManager;

    @PostConstruct
    public void init() {
        teacherManager = new TeacherManager();
        teachers = teacherManager.getAll();

        courseManager = new CourseManager();
        courses = courseManager.getAll();
    }

    public List<Teacher> getTeachers() {
        Teacher teacher = new Teacher();
        return teachers;
    }

    public List<Course> getCourses() {
        Course course = new Course();
        return courses;
    }

}
