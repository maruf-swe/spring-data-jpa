package com.practice.springdatajpa.repository;

import com.practice.springdatajpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {


    //method name= findByFirstName --> name should be entity Attribute name
    List<Student> findByFirstName(String firstName);

    List<Student> findByFirstNameContaining(String name);

    List<Student> findByLastNameNotNull();

    List<Student> findByGuardianName(String guardianName);

    // jpql works with class name
    @Query("select s from Student s where s.emailId=?1")
    Student getStudentByEmailAddress(String EmailId);

    @Query("select s.firstName from Student s where s.emailId=?1")
    String getStudentFirstNameByEmailAddress(String EmailId);

    // native query works with table name and column names
    @Query(
            value = "SELECT * FROM student_table s where s.email_address = ?1",
            nativeQuery = true
    )
    Student getStudentByEmailAddressNative(String EmailId);


    // Native Named Param
    @Query(
            value = "SELECT * FROM  student_table s where s.email_address = :emailId",
            nativeQuery = true
    )
    Student getStudentByEmailAddressNativeNamedParam(@Param("emailId") String emailId);
}
