package da.View;

import da.Model.IBookMapper;
import org.apache.ibatis.session.SqlSession;

import javax.swing.*;

public class Book {
    private int book_id;
    private da.Model.Book book;

    private JLabel bookNameLabel;
    private JLabel authorLabel;
    private JLabel publisherLabel;
    private JLabel dateLabel;
    private JLabel pagesLabel;
    private JLabel isbnLabel;
    private JPanel PanelMain;

    public Book(int id) {
        JFrame frame = new JFrame("Book");
        frame.setContentPane(PanelMain);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        book_id = id;

        SqlSession sqlSession = da.Config.Database.getSqlSession();
        IBookMapper bookMapper = sqlSession.getMapper(IBookMapper.class);
        book = bookMapper.getById(book_id);

        bookNameLabel.setText(book.getName());
        authorLabel.setText(book.getAuthor());
        publisherLabel.setText(book.getPublisher());
        dateLabel.setText(book.getPublication_date().toString());
        pagesLabel.setText(String.valueOf(book.getPages()));
        isbnLabel.setText(book.getISBN());
    }

    public static void main(String[] args) {
        try {
            org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
        } catch (Exception e) {
            //TODO exception
        }
        new Book(1);
    }
}
