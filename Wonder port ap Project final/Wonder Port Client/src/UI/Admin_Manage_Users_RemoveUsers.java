package UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.text.StyleContext.SmallAttributeSet;

public class Admin_Manage_Users_RemoveUsers extends SubClassesSmallFrame {
    static JLabel usersList;
    public Admin_Manage_Users_RemoveUsers() {

        ImageIcon footer0 = new ImageIcon("SmallRemoveAAAHeader.png");
        JLabel footerImage0 = new JLabel(footer0);
        footerImage0.setBounds(0, 0, 400, 30);
        add(footerImage0);


        usersList = new JLabel();
        usersList.setBounds(5, 30, 300, 200);
        add(usersList);

        final JTextField user = new JTextField("   UserID   ");
        user.setBounds(170, 300, 70, 30);
        add(user);


        JButton remove = new JButton(" R E M O V E ");
        remove.setBounds(200, 350, 130, 40);
        add(remove);
        remove.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                jsonData j;
                j = new jsonData(19, null, null, null, null, null, 0, 0, null, null, null, 0, 0, Integer.valueOf(user.getText()), false);
                try {
                    jsonData.writeSocketMyJson(j);
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                navigate(MainClassAfterUi.usersM);

            }
        });

        JButton close = new JButton(" C L O S E ");
        close.setBounds(50, 350, 130, 40);
        add(close);
        close.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                navigate(MainClassAfterUi.usersM);

            }
        });


        JLabel info = new JLabel("Enter  \" User ID\" And \"REMOVE\" That !  ");
        info.setBounds(80, 400, 400, 30);
        add(info);

    }

}
