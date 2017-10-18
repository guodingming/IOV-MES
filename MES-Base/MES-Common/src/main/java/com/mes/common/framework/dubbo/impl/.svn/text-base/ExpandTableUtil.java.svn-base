package com.mes.common.framework.dubbo.impl;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.mes.common.framework.spring.ServiceBeanContext;

import javax.sql.DataSource;
import java.sql.*;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 动态生成扩展表增删改查sql语句工具类
 *
 * Created by xiuyou.xu on 2017/7/5.
 */
public class ExpandTableUtil {
    /**
     * 查询表的主键字段名称集合
     *
     * @param tableName
     * @return
     */
    public static Set<String> getPrimaryKeyColumnNames(String tableName) {
        DataSource dataSource = (DataSource) ServiceBeanContext.getInstance().getBean("dataSource");
        try (Connection con = dataSource.getConnection()) {
            DatabaseMetaData metaData = con.getMetaData();
            ResultSet keys = metaData.getPrimaryKeys(null, "%", tableName);
            Set<String> pk = Sets.newHashSet();
            while (keys.next()) {
                pk.add(keys.getString("COLUMN_NAME"));
            }
            return pk;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 查询表的所有字段信息
     *
     * @param tableName
     * @return
     */
    public static List<Map<String, Object>> getColumns(String tableName) {
        DataSource dataSource = (DataSource) ServiceBeanContext.getInstance().getBean("dataSource");
        try (Connection con = dataSource.getConnection()) {
            DatabaseMetaData metaData = con.getMetaData();
            ResultSet rs = metaData.getColumns(null, "%", tableName, "%");
            Set<String> pk = getPrimaryKeyColumnNames(tableName);
            List<Map<String, Object>> columns = Lists.newArrayList();
            while (rs.next()) {
                Map<String, Object> column = Maps.newHashMap();
                String columnName = rs.getString("COLUMN_NAME");
                column.put("COLUMN_NAME", columnName);
                String type = rs.getString("TYPE_NAME");
                if (type.contains("(")) {
                    type = type.substring(0, type.indexOf("("));
                }
                column.put("COLUMN_TYPE", type);
                column.put("COLUMN_PRECISION", rs.getInt("COLUMN_SIZE"));
                column.put("NULLABLE", rs.getInt("NULLABLE") == ResultSetMetaData.columnNoNulls ? false : true);
                column.put("DEFAULT_VALUE", rs.getString("COLUMN_DEF"));
                column.put("IS_PK", pk.contains(columnName));

                columns.add(column);
            }
            return columns;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 动态生成表的insert语句
     *
     * @param tableName
     * @param params
     * @return
     */
    public static String getInsertSql(String tableName, Map<String, Object> params) {
        StringBuilder sb = new StringBuilder();
        if (params != null && !params.isEmpty()) {
            sb.append("insert into ").append(tableName).append(" (");
            params.keySet().stream().forEach(key -> {
                // 参数中包含的字段才加入insert语句中
                sb.append(key).append(",");
            });
            sb.deleteCharAt(sb.length() - 1).append(") values (");
            params.keySet().stream().forEach(key -> {
                // 需要对不同字段类型进行区分，有的类型不需要用单引号包含
                sb.append("'").append(params.get(key)).append("'").append(",");
            });
            sb.deleteCharAt(sb.length() - 1).append(")");
        }
        return sb.toString();
    }

    /**
     * 动态生成表的update语句
     *
     * @param tableName
     * @param params
     * @return
     */
    public static String getUpdateSql(String tableName, Map<String, Object> params) {
        StringBuilder sb = new StringBuilder();
        if (params != null && !params.isEmpty()) {
            Set<String> pk = getPrimaryKeyColumnNames(tableName);
            sb.append("update ").append(tableName).append(" set ");
            params.keySet().stream().forEach(key -> {
                // 主键字段不更新，而是作为行过滤条件
                if (!pk.contains(key)) {
                    sb.append(key).append("=").append("'").append(params.get(key)).append("',");
                }
            });
            sb.deleteCharAt(sb.length() - 1);
            if (pk != null && !pk.isEmpty()) {
                sb.append(" where ");
                pk.stream().forEach(key -> {
                    if (params.containsKey(key)) {
                        sb.append(key).append("='").append(params.get(key)).append("' and ");
                    }
                });
                sb.delete(sb.length() - 5, sb.length());
            }
        }
        return sb.toString();
    }

    /**
     * 动态生成表的delete语句
     *
     * @param tableName
     * @param params
     * @return
     */
    public static String getDeleteSql(String tableName, Map<String, Object> params) {
        StringBuilder sb = new StringBuilder();
        if (params != null && !params.isEmpty()) {
            sb.append("delete from ").append(tableName);
            sb.append(" where ");
            params.keySet().stream().forEach(key -> {
                sb.append(key).append("='").append(params.get(key)).append("' and ");
            });
            sb.delete(sb.length() - 5, sb.length());
        }
        return sb.toString();
    }

    /**
     * 动态生成表的select语句
     *
     * @param tableName
     * @param params
     * @return
     */
    public static String getSelectSql(String tableName, Map<String, Object> params) {
        StringBuilder sb = new StringBuilder();
        sb.append("select * from ").append(tableName);
        if (params != null && !params.isEmpty()) {
            sb.append(" where ");
            params.keySet().stream().forEach(key -> {
                sb.append(key).append("='").append(params.get(key)).append("' and ");
            });
            sb.delete(sb.length() - 5, sb.length());
        }

        return sb.toString();
    }



}
