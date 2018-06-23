package da.View;

import javax.sound.midi.Soundbank;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;

import com.sun.org.apache.bcel.internal.generic.IUSHR;
import da.Model.IUserMapper;
import da.Model.User;
import da.Util.Desktop;
import da.Util.Desktop.*;
import org.apache.ibatis.session.SqlSession;

/**
 * todo 实现找回密码功能
 * todo User Guide
 * todo About
 */
public class Login {
    private JFrame frame;
    private JTextField usernameTxt;
    private JTextField passwordTxt;
    private JButton logInButton;
    private JButton signUpButton;
    private JButton forgotPasswordButton;
    private JButton userGuideButton;
    private JButton aboutButton;
    private JPanel PanelMain;

    public Login() {
        frame = new JFrame("Login");
        frame.setContentPane(PanelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        Login me = this;

        SqlSession sqlSession = da.Config.Database.getSqlSession();

        userGuideButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Desktop.OpenBrowser("http://blog.deali.cn");
            }
        });
        aboutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Desktop.OpenBrowser("http://blog.deali.cn");
            }
        });
        forgotPasswordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new SignUp();
//                SignUp.main(new String[]{});
            }
        });
        logInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                User user = new User(usernameTxt.getText(), passwordTxt.getText());
                IUserMapper userMapper = sqlSession.getMapper(IUserMapper.class);
                User userTarget = userMapper.getByName(user.getName());
                if (user.getPassword().equals(userTarget.getPassword())) {
                    new da.View.User(me, userTarget.getId());
                    frame.setVisible(false);
                } else
                    JOptionPane.showMessageDialog(null, " 用户名或密码错误！！ ", " 登录失败", JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    public JFrame getFrame() {
        return this.frame;
    }

    public static void main(String[] args) {
        try {
            org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        new Login();
    }
}
