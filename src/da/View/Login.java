package da.View;

import javax.sound.midi.Soundbank;
import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.util.Enumeration;

import com.sun.org.apache.bcel.internal.generic.IUSHR;
import da.Model.IUserMapper;
import da.Model.User;
import da.Util.Desktop;
import da.Util.Desktop.*;
import da.Util.OSinfo;
import org.apache.ibatis.session.SqlSession;
import sun.awt.OSInfo;

/**
 * todo 实现找回密码功能
 * todo User Guide
 * todo About
 */
public class Login {
    private JFrame frame;
    private JTextField usernameTxt;
    private JPasswordField passwordTxt;
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

    /**
     * 加载全局字体
     *
     * @param font
     */
    private static void InitGlobalFont(Font font) {
        FontUIResource fontRes = new FontUIResource(font);
        for (Enumeration<Object> keys = UIManager.getDefaults().keys();
             keys.hasMoreElements(); ) {
            Object key = keys.nextElement();
            Object value = UIManager.get(key);
            if (value instanceof FontUIResource) {
                UIManager.put(key, fontRes);
            }
        }
    }


    public static void main(String[] args) {
        try {
            org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        new Login();
        if (OSinfo.isWindows()) {
            InitGlobalFont(new Font("Microsoft YaHei", Font.PLAIN, 16));
        }
        if (OSinfo.isLinux()) {
            InitGlobalFont(new Font("TSCu_Comic", Font.PLAIN, 16));
        }
    }
}
