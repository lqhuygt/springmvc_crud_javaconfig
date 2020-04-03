package com.springcrud.controller;

import com.springcrud.dao.StudentDao;
import com.springcrud.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CrudController {

    @Autowired
    private StudentDao studentDao;

    @RequestMapping(value = "/student", method = RequestMethod.GET)
    public ModelAndView readStudent(ModelAndView model){
        List<Student> studentList = studentDao.read();
        model.addObject("listStudent", studentList);
        model.setViewName("home");

        return model;
    }

    @RequestMapping(value = "/showForm", method = RequestMethod.GET)
    public ModelAndView showForm(ModelAndView model){
        Student student = new Student();
        model.addObject("showStudent", student);
        model.setViewName("studentForm");

        return model;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ModelAndView  createStudent (@ModelAttribute("student") Student student){
            studentDao.create(student);
            return new ModelAndView("redirect:/student");
    }

    @RequestMapping(value = "/update/{studentId}")
    public ModelAndView findStudentById( @PathVariable("studentId") int studentId){
        List<Student> studentList = studentDao.findStudentById(studentId);
        ModelAndView model = new ModelAndView("edit");
        model.addObject("listStudent",studentList.get(0));

        return model;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ModelAndView updateStudent(@ModelAttribute("student") Student student){
        studentDao.update(student);
        return new ModelAndView("redirect:/student");
    }

    @RequestMapping(value = "/delete/{studentId}", method = RequestMethod.GET)
    public ModelAndView deleteStudent(@PathVariable("studentId") int studentId){
        studentDao.delete(studentId);
        return new ModelAndView("redirect:/student");
    }
}
