package com.example.demo.business.dao.impl;

import com.example.demo.business.dao.StudentDao;
import com.example.demo.business.dao.repository.StudentRepository;
import com.example.demo.business.model.business.Student;
import com.example.demo.business.model.entity.StudentEntity;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * <b>Class:</b> StudentDaoImpl.<br/>
 * <b>Inject:</b> {@link StudentDao}
 * @author RLR
 * @version 1.0.0
 */
@Slf4j
@Component
@AllArgsConstructor
class StudentDaoImpl implements StudentDao {

  private final StudentRepository repository;

  private final StudentMapper mapper;

  @Override
  public Observable<Student> findAll() {
    return Observable.fromCallable(repository::findAll)
            .subscribeOn(Schedulers.io())
            .flatMapIterable(studentEntities -> studentEntities)
            .map(mapper::mapStudent)
            .doOnSubscribe(disposable -> log.debug("Listing the students with their data."))
            .doOnNext(student -> log.trace(student.toString()))
            .doOnComplete(() -> log.info("The list of students has been completed."));
  }

//  private Student mapStudent(StudentEntity entity) {
//    return Student.builder()
//            .dateOfBirth(entity.getDateOfBirth())
//            .firstName(entity.getFirstName())
//            .gender(entity.getGender())
//            .lastName(entity.getLastName())
//            .middleName(entity.getMiddleName())
//            .otherStudentDetail(entity.getOtherStudentDetail())
//            .build();
//  }

  @Override
  public Completable save(Student student) {
    return Single.fromCallable(() -> mapper.mapStudentEntity(student))
            .map(repository::save)
            .subscribeOn(Schedulers.io())
            .doOnSubscribe(disposable -> log.debug("Registering the student."))
            .ignoreElement()
            .doOnComplete(() -> log.info("The student was saved correctly."));
  }

//  private StudentEntity mapStudentEntity(Student student) {
//    return StudentEntity.builder()
//            .dateOfBirth(student.getDateOfBirth())
//            .firstName(student.getFirstName())
//            .gender(student.getGender())
//            .lastName(student.getLastName())
//            .middleName(student.getMiddleName())
//            .otherStudentDetail(student.getOtherStudentDetail())
//            .build();
//  }
}
