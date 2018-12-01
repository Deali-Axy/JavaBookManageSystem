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
import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;
import org.jb2011.lnf.beautyeye.ch3_button.BEButtonUI;
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

        userGuideButton.setUI(new BEButtonUI().setNormalColor(BEButtonUI.NormalColor.green));
        userGuideButton.setForeground(Color.white);
        userGuideButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Desktop.OpenBrowser("http://blog.deali.cn");
            }
        });

        aboutButton.setUI(new BEButtonUI().setNormalColor(BEButtonUI.NormalColor.lightBlue));
        aboutButton.setForeground(Color.white);
        aboutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Desktop.OpenBrowser("http://blog.deali.cn");
            }
        });

        forgotPasswordButton.setUI(new BEButtonUI().setNormalColor(BEButtonUI.NormalColor.red));
        forgotPasswordButton.setForeground(Color.white);
        forgotPasswordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });

        signUpButton.setUI(new BEButtonUI().setNormalColor(BEButtonUI.NormalColor.blue));
        signUpButton.setForeground(Color.white);
        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new SignUp();
            }
        });

        logInButton.setUI(new BEButtonUI().setNormalColor(BEButtonUI.NormalColor.normal));
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
            // 如何开启/关闭窗口在不活动时的半透明效果? 设置此开关量为false即表示关闭之，BeautyEye LNF中默认是true
            BeautyEyeLNFHelper.translucencyAtFrameInactive = false;
            // 弱立体感半透明的边框效果
            BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.translucencySmallShadow;
            BeautyEyeLNFHelper.launchBeautyEyeLNF();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        // 隐藏设置按钮
        UIManager.put("RootPane.setupButtonVisible", false);


        // 多系统字体适配
        if (OSinfo.isWindows())
            InitGlobalFont(new Font("Microsoft YaHei", Font.PLAIN, 16));
        if (OSinfo.isLinux())
            InitGlobalFont(new Font("Noto Sans Mono CJK SC Regular", Font.PLAIN, 16));    //
        if (OSinfo.isMacOS())
            InitGlobalFont(new Font("STXihei", Font.PLAIN, 16));    // 华文细黑

        new Login();
    }
}
