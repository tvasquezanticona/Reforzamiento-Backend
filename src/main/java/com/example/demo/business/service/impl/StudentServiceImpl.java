package com.example.demo.business.service.impl;

import com.example.demo.business.dao.StudentDao;
import com.example.demo.business.model.business.Student;
import com.example.demo.business.service.StudentService;
import io.reactivex.Completable;
import io.reactivex.Observable;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * <b>Class:</b> StudentServiceImpl.<br/>
 * @author RLR
 * @version 1.0.0
 */

@Service
@AllArgsConstructor
class StudentServiceImpl implements StudentService {

  private final StudentDao dao;

  @Override
  public Observable<Student> findAll() {
    return dao.findAll();
  }

  @Override
  public Completable save(Student student) {
    return dao.save(student);
  }

}
