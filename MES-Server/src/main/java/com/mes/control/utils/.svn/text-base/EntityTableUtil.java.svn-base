package com.mes.control.utils;

import com.mes.common.framework.dubbo.impl.ExpandTableUtil;
import com.mes.common.framework.spring.ServiceBeanContext;
import com.mes.common.utils.IDGenerator;
import com.mes.control.mapper.MetadataMapper;
import com.mes.control.mapper.TableMapper;
import com.mes.entity.control.Metadata;
import com.mes.entity.control.Table;

import javax.sql.DataSource;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.*;
import java.io.File;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 实体表信息导入数据库工具类
 * <p>
 * Created by xiuyou.xu on 2017/7/6.
 */
public class EntityTableUtil {
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlRootElement(name = "entity-table")
    public static class EntityTable {
        @XmlElement(name = "name")
        private String name;
        @XmlElement(name = "cn-name")
        private String cnName;
        @XmlElement(name = "entity-class")
        private String entityClass;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCnName() {
            return cnName;
        }

        public void setCnName(String cnName) {
            this.cnName = cnName;
        }

        public String getEntityClass() {
            return entityClass;
        }

        public void setEntityClass(String entityClass) {
            this.entityClass = entityClass;
        }
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlRootElement(name = "entity-tables")
    public static class EntityTables {
        @XmlElement(name = "persisted")
        private boolean persisted;
        @XmlElement(name = "type")
        private List<TableType> types;

        public boolean isPersisted() {
            return persisted;
        }

        public void setPersisted(boolean persisted) {
            this.persisted = persisted;
        }

        public List<TableType> getTypes() {
            return types;
        }

        public void setTypes(List<TableType> types) {
            this.types = types;
        }
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlRootElement(name = "type")
    public static class TableType {
        @XmlAttribute(name = "name")
        private String name;
        @XmlElement(name = "entity-table")
        private List<EntityTable> tables;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<EntityTable> getTables() {
            return tables;
        }

        public void setTables(List<EntityTable> tables) {
            this.tables = tables;
        }
    }

    /**
     * 从xml文件中读取实体表相关信息
     *
     * @return
     */
    public static EntityTables getAllEntityTables() {
        try {
            JAXBContext context = JAXBContext.newInstance(EntityTables.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();

            EntityTables tables = (EntityTables) unmarshaller.unmarshal(EntityTableUtil.class.getClassLoader().getResourceAsStream("configs/entity-tables.xml"));
            return tables;
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 将基础表信息持久化到扩展表相关信息表中
     */
    public static void persist() {
        EntityTables tables = getAllEntityTables();
        if (!tables.isPersisted()) {
            List<TableType> types = tables.getTypes();
            if (types != null && !types.isEmpty()) {
                TableMapper tableMapper = (TableMapper) ServiceBeanContext.getInstance().getBean("tableMapper");
                MetadataMapper metadataMapper = (MetadataMapper) ServiceBeanContext.getInstance().getBean("metadataMapper");
                // 首先删除表中旧数据
                tableMapper.deleteAll();
                metadataMapper.deleteAll();
                types.stream().forEach(type -> {
                    List<EntityTable> tbls = type.getTables();
                    if (tbls != null && !tbls.isEmpty()) {
                        tbls.stream().forEach(table -> {
                            String id = IDGenerator.getID();
                            Table tab = new Table();
                            tab.setId(id);
                            tab.setName(table.getName());
                            tab.setCnName(table.getCnName());
                            tab.setEntityClass(table.getEntityClass());
                            tab.setType(type.getName());
                            tab.setTableTypeId("1");
                            tableMapper.save(tab);

                            List<Map<String, Object>> columns = ExpandTableUtil.getColumns(table.getName());
                            if (columns != null && !columns.isEmpty()) {
                                columns.stream().forEach(column -> {
                                    Metadata metadata = new Metadata();
                                    metadata.setId(IDGenerator.getID());
                                    metadata.setName(column.get("COLUMN_NAME").toString());
                                    metadata.setColumn(column.get("COLUMN_NAME").toString());
                                    metadata.setType(column.get("COLUMN_TYPE").toString());
                                    metadata.setLength(column.get("COLUMN_PRECISION").toString());
                                    metadata.setIsNull(column.get("NULLABLE").toString());
                                    metadata.setIsPk(column.get("IS_PK").toString());
                                    if (column.get("DEFAULT_VALUE") != null) {
                                        metadata.setDefaultValue(column.get("DEFAULT_VALUE").toString());
                                    }
                                    metadata.setTableId(id);

                                    metadataMapper.save(metadata);
                                });
                            }
                        });
                        System.out.println("persist entity tables data result: true");
                    }
                });
            }

            // 写入xml文件，更新是否已persisted
            tables.setPersisted(true);
            try {
                JAXBContext context = JAXBContext.newInstance(EntityTables.class);
                Marshaller marshaller = context.createMarshaller();
                File oldFile = new File(EntityTableUtil.class.getClassLoader().getResource("configs/entity-tables.xml").getPath());
                File newFile = new File(oldFile.getParent(), "entity-tables-new.xml");
                marshaller.marshal(tables, newFile);
                if (oldFile.delete()) {
                    newFile.renameTo(oldFile);
                }
            } catch (JAXBException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 获取创建表的sql
     * @param list
     * @param tableName
     * @return
     * @throws Exception
     */
    public static String getCreateSql(List<Metadata> list,String tableName) throws Exception {
        StringBuffer buffer = new StringBuffer();
        StringBuffer sql = new StringBuffer();
        sql.append(" create table ").append(tableName).append("( ");
        for ( Metadata matadata : list ) {
            if ("true".equalsIgnoreCase(matadata.getIsPk())) {
                buffer.append(matadata.getColumn()).append(",");
            }
            sql.append(" ").append(matadata.getColumn()).append(" ").append(matadata.getType());
            if ( !"".equals(matadata.getLength() ) ) {
                sql.append("(").append(matadata.getLength()).append(")");
            }
            if (matadata.getDefaultValue() != null && matadata.getDefaultValue().length() > 0) {
                if (matadata.getType().contains("CHAR")) {
                    sql.append(" default '" + matadata.getDefaultValue() + "' ");
                } else if(matadata.getType().contains("VARCHAR")) {
                    sql.append(" default \"" + matadata.getDefaultValue() + "\" ");
                }else{
                    sql.append(" default " + matadata.getDefaultValue() + " ");
                }
            }
            if ("false".equalsIgnoreCase(matadata.getIsNull())) {
                sql.append(" not null ");
            }
            //追加逗号分隔符
            sql.append(",");
        }
        if (buffer.length() > 0) {
            sql.append(" primary key  (" + buffer.substring(0, buffer.length() - 1) + " ) ");
        }
        //没有主键项，则去掉最后一个逗号
        sql = new StringBuffer(sql.substring(0, sql.length() - 1));
        sql.append(" ) ");
        return sql.toString();
    }

    /**
     * 获取追加字段的SQL语句
     * @param list
     * @param tableName
     * @return
     * ledengyun
     * @throws Exception
     */
    public static String getAddColumSql(List<Metadata> list,String tableName) throws Exception{
        StringBuffer sql = new StringBuffer();
        StringBuffer buffer = new StringBuffer();
        sql.append(" ALTER TABLE ").append(tableName).append(" ");
        for ( Metadata matadata : list ) {
            if ("true".equalsIgnoreCase(matadata.getIsPk())) {
                buffer.append(matadata.getColumn()).append(",");
            }
           sql.append("ADD COLUMN");
            sql.append(" ").append(matadata.getColumn()).append(" ").append(matadata.getType());
            if ( !"".equals(matadata.getLength() ) ) {
                sql.append("(").append(matadata.getLength()).append(")");
            }
            if (matadata.getDefaultValue() != null && matadata.getDefaultValue().length() > 0) {
                if (matadata.getType().contains("CHAR")) {
                    sql.append(" default '" + matadata.getDefaultValue() + "' ");
                } else if(matadata.getType().contains("VARCHAR")) {
                    sql.append(" default \"" + matadata.getDefaultValue() + "\" ");
                }else{
                    sql.append(" default " + matadata.getDefaultValue() + " ");
                }
            }
            if ("false".equalsIgnoreCase(matadata.getIsNull())) {
                sql.append(" not null ");
            }
            //追加分号分隔符
            sql.append(",");
        }
        if (buffer.length() > 0) {
            sql.append("ADD PRIMARY KEY   (" + buffer.substring(0, buffer.length() - 1) + " ) ");
        }
        //没有主键项，则去掉最后一个逗号
        sql = new StringBuffer(sql.substring(0, sql.length() - 1));
        return sql.toString();
    }

    /**
     * 执行SQL
     * @param sql
     * @return
     * @throws Exception
     */
    public static boolean actionSql(String sql) throws Exception {
        DataSource dataSource = (DataSource) ServiceBeanContext.getInstance().getBean("dataSource");
        Connection con = dataSource.getConnection();
        boolean returnFlag = false;
        PreparedStatement statement = null;
        try {
            if (con != null) {
                statement = con.prepareStatement(sql);
                statement.execute();
                returnFlag = true;

            }
        } catch (Exception e) {
            throw e;
        } finally {
            if (statement != null) {
                statement.close();
            }
        }
        return returnFlag;
    }

    public static List queryData(String sql){
        DataSource dataSource = (DataSource) ServiceBeanContext.getInstance().getBean("dataSource");
        List list = new ArrayList();
        try {
            Connection con = dataSource.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs =stmt.executeQuery(sql);
            ResultSetMetaData md = rs.getMetaData();
            int columnCount = md.getColumnCount();
            while (rs.next()) {
                Map rowData = new HashMap();
                for (int i = 1; i <= columnCount; i++) {
                    rowData.put(md.getColumnName(i), rs.getObject(i));
                }
                list.add(rowData);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

       return list;
    }

    public static void main(String[] args) {
        System.out.println(getAllEntityTables());
    }
}
