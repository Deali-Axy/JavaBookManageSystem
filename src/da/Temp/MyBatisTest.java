package da.Temp;

import da.Config.Database;
import da.Model.Book;
import da.Model.IBookMapper;
import da.Model.IUserMapper;
import da.Model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;

import qfx.util.QDateTime;

public class MyBatisTest {
    public static void main(String args[]) throws IOException {

        // 加载mybatis的配置文件（它也加载关联的映射文件）
        String resource = "da/Config/MyBatis.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);

        Properties properties = new Properties();
        properties.setProperty("driver", Database.Driver);
        properties.setProperty("url", Database.Url);

        // 构建sqlSession的工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream, properties);

        // 创建能执行映射文件中sql的sqlSession，默认是手动提交事务的，使用自动提交的话加上参数 true
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        //使用xml mapper方式操作
        //查询对象
        User user = sqlSession.selectOne("da.Config.UserMappers.getUser", 1);
        System.out.println(user);
        //插入对象
//        user.setName("Michel");
//        int insert = sqlSession.insert("da.Config.UserMappers.insertUser", user);
//        sqlSession.commit();
//        System.out.println(insert);


        //使用注解方式操作
        IUserMapper userMapper = sqlSession.getMapper(IUserMapper.class);
        user = userMapper.getById(1);
        System.out.println(user);

        User user1 = new User("Mike", "Mike's Password");
        //插入对象
//        user1.setName("Mike");
//        user1.setPassword("Mikes passwd");
//        userMapper.add(user1);

        //通过名称查找
        User user2 = userMapper.getByName("hello");
        System.out.println(user2);

        IBookMapper bookMapper = sqlSession.getMapper(IBookMapper.class);

        //添加新书
//        Book book = new Book();
//        book.setName("CPlusPlusPrimer");
//        book.setAuthor("DealiAxy");
//        book.setPublisher("SuperDA");
//        book.setPublication_date(new Date());
//        book.setPages(100);
//        book.setISBN("I-dont-konw");
//        bookMapper.add(book);

        Book book1 = bookMapper.getById(1);
        System.out.println(book1);
    }
}
