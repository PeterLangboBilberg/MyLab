package org.bilberg.langbo.peter.SpectacledPenguin_server.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service
public class StudentService {


    private DatabaseHandler databaseHandler;

    @Autowired
    public StudentService(DatabaseHandler databaseHandler) {
        this.databaseHandler = databaseHandler;
    }


    public List<Student> getstudents(){
        return databaseHandler.getstudents();
    }

    public Student getstudent(long id){
        return databaseHandler.getstudent(id);
    }

    public int getCount(){
        return databaseHandler.getCount();
    }

    public void add(Student student)  {
      if(student.getName().equals("Ole")){
          throw new IllegalArgumentException("Du må ikke hedde Ole");
      }
        databaseHandler.add(student);
    }
}
