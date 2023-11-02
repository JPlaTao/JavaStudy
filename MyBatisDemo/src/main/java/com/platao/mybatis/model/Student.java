package com.platao.mybatis.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private Integer id;
    private String name;
    private Date birth;
    private String gender;

    public Student(String name,Date birth,String gender){
        this.name = name;
        this.birth = birth;
        this.gender = gender;
    }
}
