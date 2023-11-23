package com.platao.epilogue.mapper;

import com.platao.epilogue.domain.Employee;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author platao
* @description 针对表【employee】的数据库操作Mapper
* @createDate 2023-11-16 16:31:37
* @Entity com.platao.epilogue.domain.Employee
*/
@Mapper
public interface EmployeeMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Employee record);

    int insertSelective(Employee record);

    Employee selectByPrimaryKey(Long id);

    List<Employee> selectAll();

    int updateByPrimaryKeySelective(Employee record);

    int updateByPrimaryKey(Employee record);

}
