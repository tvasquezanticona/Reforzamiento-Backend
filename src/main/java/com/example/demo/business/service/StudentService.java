package com.example.demo.business.service;

import com.example.demo.business.model.business.Student;
import io.reactivex.Completable;
import io.reactivex.Observable;

/**
 * <b>Interface:</b> StudentService.<br/>
 * @author RLR
 * @version 1.0.0
 */

public interface StudentService {

  Observable<Student> findAll();

  Completable save(Student student);
}
