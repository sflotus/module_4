package org.arthur.ss6_jpa.repository;

import org.arthur.ss6_jpa.model.StudentClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStudentClassRepository extends JpaRepository<StudentClass,Long> {
}
