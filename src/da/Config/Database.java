package da.Config;

import da.Model.IBookMapper;
import da.Model.IBorrowMapper;
import da.Model.IUserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Database {
    public static final String FilePath = "data/hello-sqlite.db";
    public static final String Driver = "org.sqlite.JDBC";
    public static final String Url = "jdbc:sqlite:" + FilePath;
    public static final String myBatisConfigFile = "da/Config/MyBatis.xml";

    public static SqlSession getSqlSession() {
        // 加载mybatis的配置文件（它也加载关联的映射文件）
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(myBatisConfigFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Properties properties = new Properties();
        properties.setProperty("driver", Database.Driver);
        properties.setProperty("url", Database.Url);

        // 构建sqlSession的工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream, properties);

        // 创建能执行映射文件中sql的sqlSession，默认是手动提交事务的，使用自动提交的话加上参数 true
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        return sqlSession;
    }

    public static IUserMapper getUserMapper() {
        return getSqlSession().getMapper(IUserMapper.class);
    }

    public static IBookMapper getBookMapper() {
        return getSqlSession().getMapper(IBookMapper.class);
    }

    public static IBorrowMapper getBorrowMapper() {
        return getSqlSession().getMapper(IBorrowMapper.class);
    }
}
