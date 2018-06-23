package da.Model;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface IBookMapper {
    //    @Insert("insert into User (name, password) values ('${name}', '${password}')")
    @Insert("insert into book (name, author, publisher, publication_date, pages, ISBN) " +
            "values (#{name}, #{author}, #{publisher}, #{publication_date}, #{pages}, #{ISBN})")
    int add(Book user);

    @Delete("delete from book where id=#{id}")
    int deleteById(int id);

    @Update("update book set name=#{name}, author=#{author}, publisher=#{publisher}," +
            "publication_date=#{publication_date}, pages=#{pages}, ISBN=#{ISBN}" +
            " where id=${id}")
    int update(Book user);

    @Select("select * from book where id=#{id}")
    Book getById(int id);

    @Select("select * from book where name=#{name}")
    List<Book> getByName(String name);

    @Select("select * from book where ISBN=#{ISBN}")
    Book getByISBN(String isbn);

    @Select("select * from book")
    List<Book> getAll();
}
