package com.eshop.generator.config;

import com.eshop.generator.dao.GeneratorDao;
import com.eshop.generator.dao.MySQLGeneratorDao;
import com.eshop.generator.dao.OracleGeneratorDao;
import com.eshop.generator.dao.PostgreSQLGeneratorDao;
import com.eshop.generator.dao.SQLServerGeneratorDao;
import com.eshop.generator.utils.BIZException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * 数据库配置
 *
 */
@Configuration
public class DbConfig {

    @Value("${eshop.database: mysql}")
    private String database;

    @Autowired
    private MySQLGeneratorDao mySQLGeneratorDao;
    @Autowired
    private OracleGeneratorDao oracleGeneratorDao;
    @Autowired
    private SQLServerGeneratorDao sqlServerGeneratorDao;
    @Autowired
    private PostgreSQLGeneratorDao postgreSQLGeneratorDao;

    @Bean
    @Primary
    public GeneratorDao getGeneratorDao(){
        if("mysql".equalsIgnoreCase(database)){
            return mySQLGeneratorDao;
        }else if("oracle".equalsIgnoreCase(database)){
            return oracleGeneratorDao;
        }else if("sqlserver".equalsIgnoreCase(database)){
            return sqlServerGeneratorDao;
        }else if("postgresql".equalsIgnoreCase(database)){
            return postgreSQLGeneratorDao;
        }else {
            throw new BIZException("不支持当前数据库：" + database);
        }
    }
}
