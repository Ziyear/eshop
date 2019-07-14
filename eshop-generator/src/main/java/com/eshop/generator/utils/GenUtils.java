package com.eshop.generator.utils;

import com.eshop.generator.entity.ColumnEntity;
import com.eshop.generator.entity.TableEntity;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.WordUtils;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.*;

/**
 * 代码生成器   工具类
 *
 */
@Slf4j
public class GenUtils {

    // 获取controller模板
    public static List<String> getTemplates() {
        List<String> templates = new ArrayList<>();
        templates.add("template/Controller.java.vm");
        return templates;
    }

    // 获取service模板
    public static List<String> getServiceTemplates() {
        List<String> templates = new ArrayList<String>();
        templates.add("template/Service.java.vm");
        templates.add("template/ServiceImpl.java.vm");
        return templates;
    }

    //获取entity模板
    public static List<String> getEntityTemplates() {
        List<String> templates = new ArrayList<String>();
        templates.add("template/Entity.java.vm");
        templates.add("template/Bean.java.vm");
        return templates;
    }

    // 获取dao模板
    public static List<String> getDaoTemplates() {
        List<String> templates = new ArrayList<String>();
        templates.add("template/Dao.java.vm");
        templates.add("template/Dao.xml.vm");
        return templates;
    }

    /**
     * 校验即将删除的文件
     *
     * @param file
     **/
    private static void checkAndDeleteFile(File file) {
        String currentFile = file.getPath() + "\\" + file.getName();
        if (file.exists() && file.isFile()) {
            log.info("正在删除文件：" + currentFile);
            if (file.delete()) {
                log.info("成功删除文件");
            } else {
                log.info("删除失败");
            }
        } else {
            log.info("文件不存在，无需删除操作");
        }
    }


    /**
     * 生成代码
     */
    public static boolean generatorCode(Map<String, String> table,
                                        List<Map<String, String>> columns) {
        //配置信息
        Configuration config = getConfig();
        boolean hasBigDecimal = false;
        //表信息
        TableEntity tableEntity = new TableEntity();
        tableEntity.setTableName(table.get("tableName"));
        tableEntity.setComments(table.get("tableComment"));
        //表名转换成Java类名
        String className = tableToJava(tableEntity.getTableName(), config.getString("tablePrefix"));
        tableEntity.setClassName(className);
        tableEntity.setClassname(StringUtils.uncapitalize(className));

        //列信息
        List<ColumnEntity> columsList = new ArrayList<>();
        for (Map<String, String> column : columns) {
            ColumnEntity columnEntity = new ColumnEntity();
            columnEntity.setColumnName(column.get("columnName"));
            columnEntity.setDataType(column.get("dataType"));
            columnEntity.setComments(column.get("columnComment"));
            columnEntity.setExtra(column.get("extra"));

            //列名转换成Java属性名
            String attrName = columnToJava(columnEntity.getColumnName());
            columnEntity.setAttrName(attrName);
            columnEntity.setAttrname(StringUtils.uncapitalize(attrName));

            //列的数据类型，转换成Java类型
            String attrType = config.getString(columnEntity.getDataType(), "unknowType");
            columnEntity.setAttrType(attrType);
            if (!hasBigDecimal && attrType.equals("BigDecimal")) {
                hasBigDecimal = true;
            }
            //是否主键
            if ("PRI".equalsIgnoreCase(column.get("columnKey")) && tableEntity.getPk() == null) {
                tableEntity.setPk(columnEntity);
            }

            columsList.add(columnEntity);
        }
        tableEntity.setColumns(columsList);

        //没主键，则第一个字段为主键
        if (tableEntity.getPk() == null) {
            tableEntity.setPk(tableEntity.getColumns().get(0));
        }

        //设置velocity资源加载器
        Properties prop = new Properties();
        prop.put("file.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
        Velocity.init(prop);

        String mainPath = config.getString("mainPath");
        mainPath = StringUtils.isBlank(mainPath) ? "com.eshop" : mainPath;
        // 放service
        String serviceMainPath = config.getString("servicemainPath");
        serviceMainPath = StringUtils.isBlank(serviceMainPath) ? "com.eshop" : serviceMainPath;
        // 放entity
        String entityMainPath = config.getString("entityMainPath");
        entityMainPath = StringUtils.isBlank(entityMainPath) ? "com.eshop" : entityMainPath;
        // 放dao
        String daoMainPath = config.getString("daoMainPath");
        daoMainPath = StringUtils.isBlank(daoMainPath) ? "com.eshop" : daoMainPath;

        //封装模板数据
        Map<String, Object> map = new HashMap<>();
        map.put("tableName", tableEntity.getTableName());
        map.put("comments", tableEntity.getComments());
        map.put("pk", tableEntity.getPk());
        map.put("className", tableEntity.getClassName());
        map.put("classname", tableEntity.getClassname());
        map.put("pathName", tableEntity.getClassname().toLowerCase());
        map.put("columns", tableEntity.getColumns());
        map.put("hasBigDecimal", hasBigDecimal);
        map.put("mainPath", mainPath);
        map.put("package", config.getString("package"));
        map.put("moduleName", config.getString("moduleName"));
        map.put("author", config.getString("author"));
        map.put("email", config.getString("email"));
        map.put("datetime", DateUtils.format(new Date(), DateUtils.DATE_TIME_PATTERN));
        //新增加参数
        map.put("servicemainPath", config.getString("servicemainPath"));
        map.put("servicepackage", config.getString("servicepackage"));
        map.put("entityMainPath", config.getString("entityMainPath"));
        map.put("entityPackage", config.getString("entityPackage"));
        map.put("daoMainPath", config.getString("daoMainPath"));
        map.put("daoPackage", config.getString("daoPackage"));

        VelocityContext context = new VelocityContext(map);

        // 获取controller模板列表
        List<String> templates = getTemplates();
        for (String template : templates) {
            //渲染模板
            StringWriter sw = new StringWriter();
            Template tpl = Velocity.getTemplate(template, "UTF-8");
            tpl.merge(context, sw);
            try {
                String filePathName = config.getString("projectPath") + "/src/" + getFileName(template, tableEntity.getClassName(), config.getString("package"), config.getString("moduleName"));
                //如果文件存在则删除原文件
                File file = new File(filePathName);
                checkAndDeleteFile(file);
                //创建新文件
                FileUtils.write(new File(filePathName)
                        , sw.toString()
                        , "utf-8"
                        , true);
            } catch (IOException e) {
                throw new BIZException("渲染模板失败，表名：" + tableEntity.getTableName(), e);
            }
        }

        // 获取service模板列表
        List<String> serviceTemplates = getServiceTemplates();
        for (String template : serviceTemplates) {
            //渲染模板
            StringWriter sw = new StringWriter();
            Template tpl = Velocity.getTemplate(template, "UTF-8");
            tpl.merge(context, sw);
            try {
                String servicefilePathName = config.getString("serviceprojectPath") + "/src/" + getFileName(template, tableEntity.getClassName(), config.getString("servicepackage"), config.getString("moduleName"));
                //如果文件存在则删除原文件
                File file = new File(servicefilePathName);
                checkAndDeleteFile(file);
                //创建新文件
                FileUtils.write(new File(servicefilePathName)
                        , sw.toString()
                        , "utf-8"
                        , true);
            } catch (IOException e) {
                throw new BIZException("渲染模板失败，表名：" + tableEntity.getTableName(), e);
            }
        }

        // 获取entity模板列表
        List<String> entityTemplates = getEntityTemplates();
        for (String template : entityTemplates) {
            //渲染模板
            StringWriter sw = new StringWriter();
            Template tpl = Velocity.getTemplate(template, "UTF-8");
            tpl.merge(context, sw);
            try {
                String entityfilePathName = config.getString("entityprojectPath") + "/src/" + getFileName(template, tableEntity.getClassName(), config.getString("entityPackage"), config.getString("moduleName"));
                //如果文件存在则删除原文件
                File file = new File(entityfilePathName);
                checkAndDeleteFile(file);
                //创建新文件
                FileUtils.write(new File(entityfilePathName)
                        , sw.toString()
                        , "utf-8"
                        , true);
            } catch (IOException e) {
                throw new BIZException("渲染模板失败，表名：" + tableEntity.getTableName(), e);
            }
        }

        // 获取dao模板列表
        List<String> daoTemplates = getDaoTemplates();
        for (String template : daoTemplates) {
            //渲染模板
            StringWriter sw = new StringWriter();
            Template tpl = Velocity.getTemplate(template, "UTF-8");
            tpl.merge(context, sw);
            try {
                String daofilePathName = config.getString("daoprojectPath") + "/src/" + getFileName(template, tableEntity.getClassName(), config.getString("daoPackage"), config.getString("moduleName"));
                //如果文件存在则删除原文件
                File file = new File(daofilePathName);
                checkAndDeleteFile(file);
                //创建新文件
                FileUtils.write(new File(daofilePathName)
                        , sw.toString()
                        , "utf-8"
                        , true);
            } catch (IOException e) {
                throw new BIZException("渲染模板失败，表名：" + tableEntity.getTableName(), e);
            }
        }
        return true;
    }


    /**
     * 列名转换成Java属性名
     */
    public static String columnToJava(String columnName) {
        return WordUtils.capitalizeFully(columnName, new char[]{'_'}).replace("_", "");
    }

    /**
     * 表名转换成Java类名
     */
    public static String tableToJava(String tableName, String tablePrefix) {
        if (StringUtils.isNotBlank(tablePrefix)) {
            tableName = tableName.replace(tablePrefix, "");
        }
        return columnToJava(tableName);
    }

    /**
     * 获取配置信息
     */
    public static Configuration getConfig() {
        try {
            return new PropertiesConfiguration("generator.properties");
        } catch (ConfigurationException e) {
            throw new BIZException("获取配置文件失败，", e);
        }
    }

    /**
     * 获取文件名
     */
    public static String getFileName(String template, String className, String packageName, String moduleName) {
        String packagePath = "main" + File.separator + "java" + File.separator;
        if (StringUtils.isNotBlank(packageName)) {
            packagePath += packageName.replace(".", File.separator) + File.separator + moduleName + File.separator;
        }

        if (template.contains("Entity.java.vm")) {
            return packagePath + "entity" + File.separator + className + "Entity.java";
        }

        if (template.contains("Bean.java.vm")) {
            return packagePath + "excel" + File.separator + className + "Bean.java";
        }

        if (template.contains("Dao.java.vm")) {
            return packagePath + "dao" + File.separator + className + "Dao.java";
        }

        if (template.contains("Service.java.vm")) {
            return packagePath + "service" + File.separator + className + "Service.java";
        }

        if (template.contains("ServiceImpl.java.vm")) {
            return packagePath + "service" + File.separator + "impl" + File.separator + className + "ServiceImpl.java";
        }

        if (template.contains("Controller.java.vm")) {
            return packagePath + "controller" + File.separator + className + "Controller.java";
        }

        if (template.contains("Dao.xml.vm")) {
            return "main" + File.separator + "resources" + File.separator + "mapper" + File.separator + moduleName + File.separator + className + "Dao.xml";
        }

        return null;
    }
}