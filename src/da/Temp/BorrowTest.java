package da.Temp;

import da.Model.*;
import org.apache.ibatis.session.SqlSession;

import java.util.Date;

public class BorrowTest {
    public static void main(String args[]) {
        SqlSession sqlSession = da.Config.Database.getSqlSession();
        IBorrowMapper borrowMapper = sqlSession.getMapper(IBorrowMapper.class);
        IUserMapper userMapper = sqlSession.getMapper(IUserMapper.class);
        IBookMapper bookMapper = sqlSession.getMapper(IBookMapper.class);
        User user = userMapper.getById(1);
        Book book = bookMapper.getById(4);

        Borrow borrow = new Borrow();
        borrow.setUser(user);
        borrow.setBook(book);
        borrow.setDate(new Date());
        borrowMapper.add(borrow);

        borrow = borrowMapper.getById(1);
        System.out.println(borrow);
    }
}
