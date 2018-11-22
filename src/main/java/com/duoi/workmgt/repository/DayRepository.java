package com.duoi.workmgt.repository;

import com.duoi.workmgt.domain.Day;
import com.duoi.workmgt.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface DayRepository extends JpaRepository<Day,LocalDate> {

    Optional<User>  findOneByDate(LocalDate date);

    List<User> findAllByDates(List<LocalDate> dates);

    void deleteByDate(LocalDate date);

    void deleteAll();
}
