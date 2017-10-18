package com.mes.common.utils;

/**
 */
public class PageUtil {
    /**
     * 根据数据库类型，生成特定的分页sql
     *
     * @param sql
     * @param dialect
     * @param pageNum
     * @param perPage
     * @return
     */
    public static String buildPageSql(String sql, String dialect, int pageNum, int perPage) {
        StringBuilder pageSql = new StringBuilder();
        if ("mysql".equalsIgnoreCase(dialect)) {
            pageSql = buildPageSqlForMysql(sql, pageNum, perPage);
        } else if ("oracle".equalsIgnoreCase(dialect)) {
            pageSql = buildPageSqlForOracle(sql, pageNum, perPage);
        } else {
            return sql;
        }
        return pageSql.toString();
    }

    /**
     * mysql的分页语句
     *
     * @param sql
     * @param pageNum
     * @param perPage
     * @return
     */
    public static StringBuilder buildPageSqlForMysql(String sql, int pageNum, int perPage) {
        StringBuilder pageSql = new StringBuilder(100);
        String beginrow = String.valueOf((pageNum-1) * perPage);
        pageSql.append(sql);
        pageSql.append(" limit " + beginrow + "," + perPage);
        return pageSql;
    }

    /**
     * oracle的分页语句
     *
     * @param sql
     * @param pageNum
     * @param perPage
     * @return
     */
    public static StringBuilder buildPageSqlForOracle(String sql, int pageNum, int perPage) {
        StringBuilder pageSql = new StringBuilder(100);
        String beginrow = String.valueOf((pageNum - 1) * perPage);
        String endrow = String.valueOf(pageNum * perPage);
        pageSql.append("select * from ( select temp.*, rownum row_id from ( ");
        pageSql.append(sql);
        pageSql.append(" ) temp where rownum <= ").append(endrow);
        pageSql.append(") where row_id > ").append(beginrow);
        return pageSql;
    }
}
