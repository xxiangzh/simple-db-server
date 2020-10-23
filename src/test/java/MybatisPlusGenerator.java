import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;


/**
 * mybatis-plus代码生成器
 * mybatis-plus官网：https://mp.baomidou.com/
 * Author 向振华 Date 2020/10/23
 */
public class MybatisPlusGenerator {

    static final String TABLE_NAME = "t_mem_member";
    static final String MODULE_NAME = TABLE_NAME;

    static final String PACKAGE_PATH = "com.xzh.db.club";
    static final String AUTHOR = "向振华";

    //修改TABLE_NAME、MODULE_NAME、AUTHOR后运行main方法
    //注意，会覆盖MODULE_NAME下的所有代码
    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator autoGenerator = new AutoGenerator();

        //全局配置
        GlobalConfig globalConfig = new GlobalConfig();
        //项目目录
        String projectPath = System.getProperty("user.dir");
        globalConfig.setOutputDir(projectPath + "/src/main/java");
        //生成后打开文件目录
        globalConfig.setOpen(false);
        //覆盖文件
        globalConfig.setFileOverride(true);
        //生成BaseResultMap
        globalConfig.setBaseResultMap(true);
        //生成BaseColumnList
        globalConfig.setBaseColumnList(true);
        //加上swagger注解
        globalConfig.setSwagger2(true);
        //自定义service接口名
        globalConfig.setServiceName("%sService");
        //使用java.util.Date
        globalConfig.setDateType(DateType.ONLY_DATE);
        globalConfig.setAuthor(AUTHOR);
        autoGenerator.setGlobalConfig(globalConfig);

        //数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://localhost:3306/db_club?useUnicode=true&useSSL=false&characterEncoding=utf8&serverTimezone=UTC");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("123456");
        autoGenerator.setDataSource(dsc);

        //包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent(PACKAGE_PATH);
        pc.setModuleName(MODULE_NAME);
        //在service包下生成Impl
        pc.setServiceImpl("service");
        //在mapper生成xml
        pc.setXml("mapper");
        autoGenerator.setPackageInfo(pc);

        //策略配置
        StrategyConfig strategy = new StrategyConfig();
        //数据库表映射到实体的命名策略
        strategy.setNaming(NamingStrategy.underline_to_camel);
        //数据库表字段映射到实体的命名策略, 未指定按照 naming 执行
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        //是否为lombok模型
        strategy.setEntityLombokModel(true);
        //生成 @RestController 控制器
        strategy.setRestControllerStyle(true);
        //表前缀
        strategy.setTablePrefix("t");
        //需要包含的表名，允许正则表达式（与exclude二选一配置）
        strategy.setInclude(TABLE_NAME);
        autoGenerator.setStrategy(strategy);
        autoGenerator.execute();

    }
}