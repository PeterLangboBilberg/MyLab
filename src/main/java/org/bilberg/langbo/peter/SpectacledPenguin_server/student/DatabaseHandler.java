package org.bilberg.langbo.peter.SpectacledPenguin_server.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Service
public class DatabaseHandler {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    private final String getStudentsSql = "Select * from tbl_Student";
    private final String getStudentSql = "Select * from tbl_Student where id = ";
    private final String getCountSql = "Select count(*) from tbl_Student";

public DatabaseHandler(){

}

    public List<Student> getstudents(){
        return jdbcTemplate.query(getStudentsSql, BeanPropertyRowMapper.newInstance(Student.class));
    }

    public Student getstudent(long id){
        List<Student> list =  jdbcTemplate.query(getStudentSql+id, BeanPropertyRowMapper.newInstance(Student.class));
        if(list.size() > 0){
            return list.getFirst();
        }else{
            return null;
        }
    }

    public int getCount(){
        return jdbcTemplate.queryForObject(getCountSql, Integer.class);
    }

    public boolean add(Student student) {
    System.out.println("adding "+student);

            String query="insert into tbl_Student values(?,?,?,?)";
            return jdbcTemplate.execute(query,new PreparedStatementCallback<Boolean>(){
                @Override
                public Boolean doInPreparedStatement(PreparedStatement ps)
                        throws SQLException, DataAccessException {

                    ps.setLong(1,student.getId());
                    ps.setString(2,student.getName());
                    ps.setString(3,student.getEmail());
                    ps.setInt(4,student.getAge());

                    return ps.execute();

                }
            });
        }
}
