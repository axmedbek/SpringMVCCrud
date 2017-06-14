package com.axmedbek.dao;

import java.util.List;

/**
 * Created by axmedbek on 6/11/17.
 */
public interface PersonDao {

    void insert(Person person);
    List<Person> getPersonList();
    void delete(int id);
}
