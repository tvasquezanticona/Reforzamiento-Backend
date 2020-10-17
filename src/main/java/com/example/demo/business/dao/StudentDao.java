package com.example.demo.business.dao;

import com.example.demo.business.model.business.Student;
import io.reactivex.Completable;
import io.reactivex.Observable;

/**
 * <b>Interface:</b> StudentDao.<br/>
 * @author RLR
 * @version 1.0.0
 */

public interface StudentDao {

  Observable<Student> findAll();

  Completable save(Student student);
}
