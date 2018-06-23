package da.View;

import da.Config.Database;
import da.Model.Book;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.JOptionPane.*;

public class BookEditor {
    private Book book;

    private JTextField textName;
    private JTextField textPublisher;
    private JTextField textDate;
    private JTextField textPages;
    private JTextField textISBN;
    private JButton saveBookInformationButton;
    private JPanel PanelMain;
    private JTextField textAuthor;

    public BookEditor(int id) {
        JFrame frame = new JFrame("BookEditor");
        frame.setContentPane(PanelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        textDate.setEnabled(false);

        book = Database.getBookMapper().getById(id);
        textName.setText(book.getName());
        textAuthor.setText(book.getAuthor());
        textPublisher.setText(book.getPublisher());
        textDate.setText(book.getPublication_date().toString());
        textPages.setText(String.valueOf(book.getPages()));
        textISBN.setText(book.getISBN());


        saveBookInformationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Book modifyBook = new Book();
                modifyBook.setId(book.getId());
                modifyBook.setName(textName.getText());
                modifyBook.setAuthor(textAuthor.getText());
                modifyBook.setPublisher(textPublisher.getText());
                modifyBook.setPublication_date(book.getPublication_date());
                modifyBook.setPages(Integer.parseInt(textPages.getText()));
                modifyBook.setISBN(textISBN.getText());

                int k = Database.getBookMapper().update(modifyBook);
                System.out.println(k);
                if (k == 1) {
                    showMessageDialog(null, " 修改图书信息成功！ ", " ok", OK_OPTION);
                }
            }
        });
    }

    public static void main(String[] args) {
        try {
            org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
        } catch (Exception e) {
            //TODO exception
        }
        new BookEditor(1);
    }
}
