package da.View;

import da.Model.IUserMapper;
import da.Model.User;
import org.apache.ibatis.session.SqlSession;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUp {
    private JFrame frame;

    private JTextField usernameTxt;
    private JTextField passwordTxt;
    private JButton signUpButton;
    private JPanel PanelMain;

    public SignUp() {
        frame = new JFrame("SignUp");
        frame.setContentPane(PanelMain);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(500, 300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        SqlSession sqlSession = da.Config.Database.getSqlSession();

        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                User user = new User(usernameTxt.getText(), passwordTxt.getText());
                IUserMapper userMapper = sqlSession.getMapper(IUserMapper.class);
                for (User u : userMapper.getAll()) {
                    if (user.getName().equals(u.getName())) {
                        JOptionPane.showMessageDialog(null, " 用户名已经被注册了啊！！ ", " 换一个用户名", JOptionPane.ERROR_MESSAGE);
                    }
                }
                userMapper.add(user);
                JOptionPane.showMessageDialog(null, " 注册用户成功！ ", " 成功！", JOptionPane.INFORMATION_MESSAGE);
                frame.setVisible(false);
            }
        });
    }

    public static void main(String[] args) {
        try {
            org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
        } catch (Exception e) {
            //TODO exception
        }
        new SignUp();
    }
}
