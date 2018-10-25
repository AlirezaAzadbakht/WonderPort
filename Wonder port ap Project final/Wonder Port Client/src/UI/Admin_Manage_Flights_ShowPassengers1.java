package UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Admin_Manage_Flights_ShowPassengers1 extends SubClassesSmallFrame {
    static JLabel flightsList;
    public Admin_Manage_Flights_ShowPassengers1() {
        ImageIcon footer0 = new ImageIcon("SmallEditAHeader.png");
        JLabel footerImage0 = new JLabel(footer0);
        footerImage0.setBounds(0, 0, 400, 30);
        add(footerImage0);


        flightsList = new JLabel();
        flightsList.setBounds(5, 30, 300, 200);
        add(flightsList);

        final JTextField num = new JTextField("  Flight'sNumber   ");
        num.setBounds(135, 300, 130, 30);
        add(num);


        JButton open = new JButton(" O P E N ");
        open.setBounds(200, 350, 130, 40);
        add(open);
        open.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                jsonData j =new jsonData(21, null, null, null, null, null, 0, 0, null, null, null, 0, 0, Integer.valueOf(num.getText()), false);
                try {
                    jsonData.writeSocketMyJson(j);
                    String msg = jsonData.readSocket();
                    MainClassAfterUi.showPass2=new Admin_Manage_Flights_ShowPassengers2();
                    MainClassAfterUi.showPass2.SubClassesLabelMaker(msg);
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                navigate(MainClassAfterUi.showPass2);

            }
        });

        JButton close = new JButton(" C L O S E ");
        close.setBounds(50, 350, 130, 40);
        add(close);
        close.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                navigate(MainClassAfterUi.admin);

            }
        });

        JLabel info = new JLabel("Enter  \" AirPort NAME\" And \"OPEN\" It to change !  ");
        info.setBounds(60, 400, 400, 30);
        add(info);
    }
}
