package da.Model;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface IBorrowMapper {
    //    @Insert("insert into User (name, password) values ('${name}', '${password}')")
    @Insert("insert into Borrow (user_id, book_id, date) values (#{user_id}, #{book_id}, #{date})")
    int add(Borrow borrow);

    @Update("update Borrow set user_id=#{user_id}, book_id=#{book_id}, date=#{date} where id=${id}")
    int update(Borrow borrow);

    @Delete("delete from Borrow where id=#{id}")
    int deleteById(int id);

    @Select("select * from Borrow where id=#{id}")
    Borrow getById(int id);

    @Select("select * from Borrow where user_id=#{id}")
    List<Borrow> getByUser(User user);

    @Select("select * from Borrow where user_id=#{id}")
    List<Borrow> getByUserID(int id);

    @Select("select * from Borrow")
    List<Borrow> getAll();
}
