package com.djw.edu;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

/**
 * @Author djw
 * @Description mybatis-plus代码生成器
 * @Date 2020/4/7 14:15
 */
public class CodeGenerator {

    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir("F:\\guli\\service_edu" + "/src/main/java");
        gc.setAuthor("djw"); //作者
        gc.setOpen(true); //是否打开文件
        gc.setServiceName("%sService"); //去掉service接口的首字母I
        gc.setSwagger2(true); //实体属性 Swagger2 注解
        gc.setFileOverride(true); //是否覆盖相同文件
        gc.setDateType(DateType.ONLY_DATE); //设置时间类型为Date
        gc.setIdType(IdType.ASSIGN_UUID); //主键生成策略
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        dsc.setUrl("jdbc:mysql://localhost:3306/mybatisplus?serverTimezone=UTC&characterEncoding=utf8");
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("123456");
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent("com.djw.edu");
//        pc.setEntity("entity");
//        pc.setMapper("mapper");
//        pc.setService("service");
        mpg.setPackageInfo(pc);

        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();

        // 配置自定义输出模板
        templateConfig.setController(null);
        templateConfig.setXml(null);
        mpg.setTemplate(templateConfig);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel); //表名生成策略-驼峰命名法
        strategy.setColumnNaming(NamingStrategy.underline_to_camel); //字段名生成策略-驼峰命名法
        strategy.setEntityLombokModel(true); //lombok模型，@Accessors(chain = true) setter链式操作
        strategy.setRestControllerStyle(true); //restful api风格控制器
        strategy.setEntityTableFieldAnnotationEnable(true); //生成的字段映射原表字段
        strategy.setInclude("sys_file"); //将要生成的表名
        strategy.setControllerMappingHyphenStyle(true); //url中驼峰转连字符
        strategy.setTablePrefix(pc.getModuleName() + "_"); //生成实体时去掉表前缀
        mpg.setStrategy(strategy);

        mpg.execute();
    }
}
