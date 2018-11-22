package com.duoi.workmgt.repository;

import com.duoi.workmgt.domain.Day;
import com.duoi.workmgt.domain.Task;
import com.duoi.workmgt.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long> {

    Optional<Task> findByTaskId(Long id);

    Optional<Task> findByMenager(User menager);

    Optional<Task> findByUserInGroup(List<User> users);

    Optional<Task> findByEndOfTask(LocalTime endOfTask);

    Optional<Task> findByBeginningOfTask(LocalTime beginOfTask);

    Optional<Task> findByGroup(List<User> users);

    Optional<Task> findByTaskDay(Day day);

    Optional<Task> findByName(String name);

    List<Task>  findAllByTaskDay(Day day);

    List<Task> findAllByDate(LocalDate date);

    List<Task> findAllByMenager(User menager);

    List<Task> findAllByUserInGroup(List<User> users);

    @Override
    void deleteById(Long aLong);

    void deleteAllByTaskDay(Day day);

    void deleteAllByDate(LocalDate localDate);
}
