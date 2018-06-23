package da.Model;

import da.Config.Database;
import org.apache.ibatis.session.SqlSession;

import java.util.Date;

public class Borrow {
    private SqlSession sqlSession;
    private IUserMapper userMapper;
    private IBookMapper bookMapper;

    private int id = 0;
    private User user;
    private Book book;
    private Date date;
    private int user_id;
    private int book_id;

    public Borrow() {
        sqlSession = Database.getSqlSession();
        userMapper = sqlSession.getMapper(IUserMapper.class);
        bookMapper = sqlSession.getMapper(IBookMapper.class);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
        this.user_id = user.getId();
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
        this.book_id = book.getId();
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
        this.user = userMapper.getById(user_id);
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
        this.book = bookMapper.getById(book_id);
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    @Override
    public String toString() {
        return String.format("id: %d\n" +
                        "user: %s\n" +
                        "book: %s\n" +
                        "date: %s\n",
                this.id, this.user.getName(), this.book.getName(), this.date.toString());
    }
}
