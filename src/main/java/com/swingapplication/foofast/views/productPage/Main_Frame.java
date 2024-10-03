package com.swingapplication.foofast.views.productPage;

import javax.swing.*;
import java.awt.*;

public class Main_Frame extends JFrame {


    private TopPanel topPanel;
    private BottomPanel bottomPanel;




    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UIManager.setLookAndFeel(
                            UIManager.getSystemLookAndFeelClassName());
                    Main_Frame frame = new Main_Frame();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    // create the frame
    public Main_Frame() {
        setResizable(false);

        getContentPane().setBackground(new Color(255, 255, 255));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1010, 730);
        setLocationRelativeTo(null);

        setIconImage(new ImageIcon(getClass().getResource("/images/invoice.png")).getImage());


        topPanel = new TopPanel();
        bottomPanel = new BottomPanel();

        getContentPane().add(topPanel, BorderLayout.NORTH);
        getContentPane().add(bottomPanel, BorderLayout.CENTER);
    }


    

    









}
