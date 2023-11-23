package com.platao.epilogue.domain;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @TableName employee
 */
@Data
public class Employee implements Serializable {
    private Integer empId;

    private String empName;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    private String gender;

    private Double salary;

    private Integer deptId;

    private static final long serialVersionUID = 1L;
}