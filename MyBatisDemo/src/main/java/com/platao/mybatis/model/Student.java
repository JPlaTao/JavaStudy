package com.platao.mybatis.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private Integer id;
    private String name;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birth;
    private String gender;

    /**
     * 新增数据使用的构造 不包括自增主键
     *
     * @param name   姓名
     * @param birth  生日
     * @param gender 性别
     */
    public Student(String name, Date birth, String gender) {
        this.name = name;
        this.birth = birth;
        this.gender = gender;
    }
}
