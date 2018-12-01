package da.Temp;

import da.Config.Database;
import da.Model.Book;
import da.Model.IBookMapper;
import org.apache.ibatis.session.SqlSession;

import java.util.Date;

import qfx.util.QMath;

public class BookTest {
    public static void main(String args[]) {
        //添加新书
        String[] bookNameList = new String[]{
                "Android and Linux Kernel",
                "Programming in Python3",
                "How network to be connect",
                "How computer work",
                "How to write a lite compiler",
                "Learning Linux"
        };

        for (String s : bookNameList) {
            Book book = new Book();
            book.setName(s);
            book.setAuthor("DealiAxy");
            book.setPublisher("SuperDA");
            book.setPublication_date(new Date());
            book.setPages(100);
            book.setISBN(da.Util.ISBN.generate());
            Database.getBookMapper().add(book);
            System.out.println(book);
        }
    }
}
