package da.View;

import da.Config.Database;
import da.Model.Book;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import static javax.swing.JOptionPane.ERROR_MESSAGE;

public class BookAdd {
    private JButton saveBookInformationButton;
    private JTextField textName;
    private JTextField textAuthor;
    private JTextField textPublisher;
    private JTextField textPages;
    private JTextField textISBN;
    private JPanel PanelMain;

    public BookAdd() {
        JFrame frame = new JFrame("BookAdd");
        frame.setContentPane(PanelMain);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        textISBN.setText(da.Util.ISBN.generate());


        saveBookInformationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (textName.getText().length() == 0) {
                    JOptionPane.showMessageDialog(null, " 书籍名称呢？！ ", " 操作失败！", ERROR_MESSAGE);
                    return;
                }

                if (textAuthor.getText().length() == 0) {
                    JOptionPane.showMessageDialog(null, " 作者不能为空！ ", " 操作失败！", ERROR_MESSAGE);
                    return;
                }

                if (textPublisher.getText().length() == 0) {
                    JOptionPane.showMessageDialog(null, " 出版社也不能为空啊！ ", " 操作失败！", ERROR_MESSAGE);
                    return;
                }

                if (textPages.getText().length() == 0) {
                    JOptionPane.showMessageDialog(null, " 这本书页数多少？你倒是说啊！ ", " 操作失败！", ERROR_MESSAGE);
                    return;
                }

                Book book = new Book();
                book.setName(textName.getText());
                book.setAuthor(textAuthor.getText());
                book.setPublisher(textPublisher.getText());
                book.setPublication_date(new Date());
                book.setPages(Integer.parseInt(textPages.getText()));
                book.setISBN(textISBN.getText());

                Database.getBookMapper().add(book);

                JOptionPane.showMessageDialog(null, " 添加书籍成功！ ", " 操作成功！", JOptionPane.PLAIN_MESSAGE);
            }
        });
    }

    public static void main(String[] args) {
        try {
            org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        new BookAdd();
    }
}
