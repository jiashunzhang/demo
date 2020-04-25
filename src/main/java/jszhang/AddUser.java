package jszhang;

import javax.swing.*;
import java.awt.*;

public class AddUser extends JDialog {

    private static final long serialVersionUID = -5116968700267175491L;

    private Font kaiFont = new Font("AR PL UKai CN", Font.PLAIN, 20);

    private JLabel l_name = new JLabel("用户名:");
    private JTextField t_name = new JTextField(12);

    private JLabel l_pass = new JLabel("密  码:");
    private JPasswordField t_pass = new JPasswordField(12);

    private JLabel l_repass = new JLabel("确认密码");
    private JPasswordField t_repass = new JPasswordField(12);

    private JButton ok = new JButton("确定");
    private JButton cancel = new JButton("取消");

    public AddUser() {
        this.setModal(true);
        this.setSize(400,300);
        this.setLocation(300,300);
        this.setTitle("添加新用户");
        this.setLayout(null);

        this.add(l_name);
        this.add(t_name);
        this.add(l_pass);
        this.add(t_pass);
        this.add(l_repass);
        this.add(t_repass);
        this.add(ok);
        this.add(cancel);

        l_name.setBounds(60, 20, 80, 40);
        l_name.setFont(kaiFont);
        t_name.setBounds(150, 20, 80, 40);


    }

}