package com.zaxyliu.mapper;

import com.zaxyliu.pojo.EmpExpr;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmpExprMapper {
    void insertBach(List<EmpExpr> exprList);

    void deleteByEmpIds(List<Integer> empIds);
}
