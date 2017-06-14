package com.axmedbek.dao;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by axmedbek on 6/11/17.
 */
public class PersonDaoImpl implements PersonDao
{

    private JdbcTemplate jdbcTemplate;

    public PersonDaoImpl(DataSource dataSource) {

        jdbcTemplate = new JdbcTemplate(dataSource);
    }


    public void insert(Person person) {

        String sql = "insert into person(id,name) values(?,?)";

        jdbcTemplate.update(sql, person.getId(), person.getName());

    }

    public List<Person> getPersonList() {
        String sql = "select * from person";
       List<Person> personList = jdbcTemplate.query(sql, new ResultSetExtractor<List<Person>>() {
           public List<Person> extractData(ResultSet rs) throws SQLException, DataAccessException {

               List<Person> list = new ArrayList<Person>();
               while (rs.next())
               {
                   Person person = new Person();
                   person.setId(rs.getInt(1));
                   person.setName(rs.getString(2));
                   list.add(person);

               }
               return list;
           }
       });
       return personList;
    }

    public void delete(int id) {
        String sql = "delete from person where id=?";

        jdbcTemplate.update(sql,new Object[]{id});
    }


}
