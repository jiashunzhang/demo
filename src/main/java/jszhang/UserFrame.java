package jszhang;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * MainFrame
 */
public class UserFrame extends JFrame {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    JMenuBar bar = new JMenuBar();

    JMenu menu_file = new JMenu("文件");
    JMenuItem menu_file_new = new JMenuItem("新建");
    JMenuItem menu_file_exit = new JMenuItem("注销");

    private Font kaiFont = new Font("AR PL UKai CN", Font.PLAIN, 20);

    public UserFrame() {
        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation(50, 50);
        this.setJMenuBar(bar);

        menu_file.setFont(kaiFont);
        bar.add(menu_file);

        menu_file_new.setFont(kaiFont);
        menu_file_exit.setFont(kaiFont);
        menu_file.add(menu_file_new);
        menu_file.add(menu_file_exit);

        menu_file_exit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Login login = new Login();
                login.setVisible(true);
                UserFrame.this.dispose();
            }
            
        });
    
    }
    
}