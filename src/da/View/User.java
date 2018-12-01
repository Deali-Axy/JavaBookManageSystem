package da.View;

import da.Model.Borrow;
import da.Model.IBorrowMapper;
import da.Model.IUserMapper;
import org.apache.ibatis.session.SqlSession;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Date;
import java.util.List;


public class User {
    private User me = this;
    private Login login;

    private int user_id;
    private SqlSession sqlSession;
    private da.Model.User user;
    private IBorrowMapper borrowMapper;
    private List<Borrow> borrowList;

    private int selectedId = -1;
    private Borrow selectedBorrow;

    private JTextField usernameTxt;
    private JTextField passwordTxt;
    private JButton updateUserInfoButton;
    private JList<String> bookList;
    private JPanel PanelMain;
    private JButton returnButton;
    private JButton logOutButton;
    private JButton renewButton;
    private JButton enterLibraryButton;
    private JButton refreshButton;


    public User(Login login, int id) {
        JFrame frame = new JFrame("User");
        frame.setContentPane(PanelMain);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(650, 700);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        bookList.setBorder(BorderFactory.createTitledBorder("Borrowed History"));

        this.login = login;
        user_id = id;

        sqlSession = da.Config.Database.getSqlSession();
        IUserMapper userMapper = sqlSession.getMapper(IUserMapper.class);
        user = userMapper.getById(user_id);

        usernameTxt.setText(user.getName());
        passwordTxt.setText(user.getPassword());

        refreshBookList();

        //修改用户信息
        updateUserInfoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //todo 修改用户信息
            }
        });

        //注销，返回登录页面
        logOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                login.getFrame().setVisible(true);
                frame.dispose();
            }
        });

        //进入图书馆
        enterLibraryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new Library(user_id);
            }
        });

        bookList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent listSelectionEvent) {
                selectedId = bookList.getSelectedIndex();
                selectedBorrow = borrowList.get(selectedId);
                System.out.println(selectedBorrow.getBook().getName());
            }
        });

        //还书
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (selectedBorrow != null) {
                    borrowMapper.deleteById(selectedBorrow.getId());
                    JOptionPane.showMessageDialog(null, " 还书成功！ ", " ok", JOptionPane.OK_OPTION);
                    refreshBookList();
                }
            }
        });

        //图书续借
        renewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (selectedBorrow != null) {
                    selectedBorrow.setDate(new Date());
                    borrowMapper.update(selectedBorrow);
                    JOptionPane.showMessageDialog(null, " 续借成功！ ", " ok", JOptionPane.OK_OPTION);
                    refreshBookList();
                }
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
        borrowMapper = sqlSession.getMapper(IBorrowMapper.class);
        borrowList = borrowMapper.getByUserID(user_id);
        DefaultListModel<String> defaultListModel = new DefaultListModel<String>();
        for (Borrow borrow : borrowList) {
            String lbl = "";
            try {
                lbl = borrow.getBook().getName() +
                        " (Borrow Date: " + borrow.getDate().toString() + ")";
            } catch (Exception e) {
                lbl = "<Read book info error! " + e.getMessage() + ">";
            } finally {
                defaultListModel.addElement(lbl);
            }
        }
        bookList.setModel(defaultListModel);
    }

    public static void main(String args[]) {
        try {
            org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
        } catch (Exception e) {
            //TODO exception
        }
    }
}
