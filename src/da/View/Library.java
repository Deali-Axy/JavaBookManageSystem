package da.View;

import da.Config.Database;
import da.Model.*;
import da.Model.User;
import da.Model.Book;
import org.apache.ibatis.session.SqlSession;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import java.util.List;

import static javax.swing.JOptionPane.ERROR_MESSAGE;

public class Library {
    private SqlSession sqlSession;

    private List<Book> bookList;

    private int selectedId = -1;
    private Book selectedBook;

    private JFrame frame;
    private JLabel usernameLabel;
    private JPanel PanelMain;
    private JList<String> listBooks;
    private JButton addBookButton;
    private JButton removeButton;
    private JButton editBookButton;
    private JButton borrowButton;
    private JButton refreshButton;

    public Library(int id) {
        frame = new JFrame("Library");
        frame.setContentPane(PanelMain);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(500, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        listBooks.setBorder(BorderFactory.createTitledBorder("图书馆藏书列表"));

        sqlSession = Database.getSqlSession();
        User user = Database.getUserMapper().getById(id);

        refreshBookList();

        usernameLabel.setText(user.getName());
        listBooks.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent listSelectionEvent) {
                selectedId = listBooks.getSelectedIndex();
                selectedBook = bookList.get(selectedId);
                System.out.println(selectedId);
                System.out.println(selectedBook.getName());
            }
        });
        listBooks.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                if (mouseEvent.getClickCount() == 2) { //鼠标双击
                    if (selectedId > -1) {
                        new da.View.Book(selectedBook.getId());
                    }
                }
            }
        });
        addBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
        editBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });

        //借书
        borrowButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (selectedId > -1) {
                    IBorrowMapper borrowMapper = sqlSession.getMapper(IBorrowMapper.class);
                    Borrow borrow = new Borrow();
                    borrow.setUser(user);
                    borrow.setBook(selectedBook);
                    borrow.setDate(new Date());
                    borrowMapper.add(borrow);
                    JOptionPane.showMessageDialog(null, " 借书成功！ ", " ok", JOptionPane.PLAIN_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, " 还没选择要借什么书呢！ ", " 借书失败", ERROR_MESSAGE);
                }
            }
        });

        //编辑图书信息
        editBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (!user.isAdmin()) {
                    JOptionPane.showMessageDialog(null, " 你不是系统管理员！ ", " 操作失败！", ERROR_MESSAGE);
                    return;
                }
                if (selectedBook != null) {
                    new BookEditor(selectedBook.getId());
                    refreshBookList();
                }
            }
        });

        //删除图书
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (!user.isAdmin()) {
                    JOptionPane.showMessageDialog(null, " 你不是系统管理员！ ", " 操作失败！", ERROR_MESSAGE);
                    return;
                }

                if (selectedBook != null) {
                    int k = Database.getBookMapper().deleteById(selectedBook.getId());
                    if (k == 1) {
                        JOptionPane.showMessageDialog(null, " 删除成功！ ", " ok", JOptionPane.PLAIN_MESSAGE);
                        refreshBookList();
                    }
                }
            }
        });

        //添加图书
        addBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (!user.isAdmin()) {
                    JOptionPane.showMessageDialog(null, " 你不是系统管理员！ ", " 操作失败！", ERROR_MESSAGE);
                    return;
                }
                new BookAdd();
            }
        });
        refreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                refreshBookList();
            }
        });
    }

    private void refreshBookList() {
        bookList = Database.getBookMapper().getAll();
        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (Book b : Database.getBookMapper().getAll()) {
            listModel.addElement(b.getName());
        }
        listBooks.setModel(listModel);
    }

    public static void main(String[] args) {
        try {
            org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        new Library(1);
    }
}
