package com.springapp.springapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.springapp.springapp.model.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Integer> {
    Todo findByTitle(String title);

    @Query(value = "select t from Todo t where t.id != :id and t.title = :title")
    Todo findByIdAndTitle(int id, String title);
}
