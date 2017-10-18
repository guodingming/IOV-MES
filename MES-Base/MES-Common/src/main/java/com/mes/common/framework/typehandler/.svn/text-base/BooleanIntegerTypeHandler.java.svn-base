package com.mes.common.framework.typehandler;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * java中的boolean和jdbc中的int之间的转换   true : 1    false : 0
 */
public class BooleanIntegerTypeHandler implements TypeHandler<Boolean> {

    @Override
    public void setParameter(PreparedStatement preparedStatement, int i, Boolean aBoolean, JdbcType jdbcType) throws SQLException {
        if (aBoolean==true){
            preparedStatement.setInt(i,new Integer(1));
        }else{
            preparedStatement.setInt(i,new Integer(0));
        }
    }

    @Override
    public Boolean getResult(ResultSet resultSet, String s) throws SQLException {
        return null;
    }

    @Override
    public Boolean getResult(ResultSet resultSet, int i) throws SQLException {
        return resultSet.getBoolean(i);
    }

    @Override
    public Boolean getResult(CallableStatement callableStatement, int i) throws SQLException {
        return null;
    }
}
