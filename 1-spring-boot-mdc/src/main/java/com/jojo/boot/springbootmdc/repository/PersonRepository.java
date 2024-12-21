package com.jojo.boot.springbootmdc.repository;

import com.jojo.boot.springbootmdc.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository   extends JpaRepository<Person, Integer> {}
