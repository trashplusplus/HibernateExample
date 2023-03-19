package org.zeroxthree;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.BatchUpdateException;

public class Window extends JFrame {

    Window(String title){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle(title);
        setSize(500, 500);
        setResizable(false);
        setVisible(true);
        setLocationRelativeTo(null);

        JButton register = new JButton("Register");
        register.setSize(200, 50);
        register.setVisible(true);
        register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        JOptionPane panel = new JOptionPane();
        panel.setSize(500, 500);
        panel.setVisible(true);
        panel.add(register);

        this.add(panel);

    }


}
