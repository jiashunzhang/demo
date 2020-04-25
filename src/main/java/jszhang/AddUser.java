package jszhang;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

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
        t_name.setBounds(150, 20, 160, 40);

        l_pass.setBounds(60, 80, 80, 40);
        l_pass.setFont(kaiFont);
        t_pass.setBounds(150, 80, 160, 40);

        l_repass.setBounds(60, 140, 80, 40);
        l_repass.setFont(kaiFont);
        t_repass.setBounds(150, 140, 160, 40);

        ok.setBounds(100, 200, 80, 40);
        cancel.setBounds(240, 200, 80, 40);
        ok.setFont(kaiFont);
        cancel.setFont(kaiFont);

        cancel.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                AddUser.this.dispose();
            }

        });

        ok.addActionListener(new ActionListener(){

            Connection con = null;
            PreparedStatement statement = null;

            @Override
            public void actionPerformed(ActionEvent e) {
                String uname = t_name.getText();
                String upass = new String(t_pass.getPassword());
                String repass = new String(t_repass.getPassword());
                if(uname.length() < 2) {
                    JOptionPane.showMessageDialog(AddUser.this, "用户名太短！");
                    return;
                }
                if(upass.length() < 2) {
                    JOptionPane.showMessageDialog(AddUser.this, "too short");
                    return;
                }
                if( !upass.equals(repass) ) {
                    JOptionPane.showMessageDialog(AddUser.this, "password and confirm password should be the same");
                    return;
                }
                //后面连接数据库
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    // JOptionPane.showMessageDialog(Login.this, "驱动加载成功");
                    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?useSSL=false&serverTimezone=UTC","sa","nicai");
                    //JOptionPane.showMessageDialog(Login.this, "数据库连接成功");
                    statement = con.prepareStatement("insert into users values(null, ?,?)");
                    statement.setString(1, uname);
                    statement.setString(2, upass);
                    int result = statement.executeUpdate();
                    if(result > 0){
                        JOptionPane.showMessageDialog(AddUser.this, "添加成功！");
                        AddUser.this.dispose();
                    } else {
                            JOptionPane.showMessageDialog(AddUser.this, "添加失败");
                    }
                    if(statement != null) {
                        statement.close();
                    }
                    if(con != null) {
                        con.close();
                    }
                } catch (ClassNotFoundException e1) {
                    JOptionPane.showMessageDialog(AddUser.this, "驱动加载失败");
                } catch (SQLException e1) {
                    JOptionPane.showMessageDialog(AddUser.this, "添加失败");
                    e1.printStackTrace();
                }

            }

        });

    }

}