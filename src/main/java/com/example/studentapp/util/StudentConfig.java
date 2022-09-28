package com.example.studentapp.util;

import com.example.studentapp.models.Student;
import com.example.studentapp.repositories.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

//    @Bean
//    CommandLineRunner commandLineRunner(StudentRepository repository) {
//        return args -> {
//              Student arseniy = new Student(
//                      "Arseniy",
//                      "senya@gmail.com",
//                      LocalDate.of(1999, Month.MARCH, 22)
//              );
//
//            Student matvey = new Student(
//                    "Matvey",
//                    "matvey@yandex.ru",
//                    LocalDate.of(1999, Month.MARCH, 30)
//            );
//
//            repository.saveAll(List.of(arseniy,matvey));
//        };
//    }
}
