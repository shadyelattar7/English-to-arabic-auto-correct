package com.sahil;


import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class TrayClass {

    static TrayIcon trayIcon;

    public TrayClass() {
        show();
    }

    public static void show() {
        if (!SystemTray.isSupported()) {
            System.exit(0);
        }
        trayIcon = new TrayIcon(creatIcon("/com/sahil/keyboard.png", "Icon"));
        final SystemTray tray = SystemTray.getSystemTray();
        trayIcon.setToolTip("keyloop");

        final PopupMenu menu = new PopupMenu();

        MenuItem About = new MenuItem("About");
        MenuItem Exit = new MenuItem("Exit");
        MenuItem Settings = new MenuItem("Settings");
       
        
        menu.add(Settings);
        menu.addSeparator();
        menu.add(About);
        menu.addSeparator();
        menu.add(Exit);
        
        
        
        About.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                JOptionPane.showMessageDialog(null, "el hamd el lah ");

            }
        });

        Exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                System.exit(0);
            }
        });
        
          Settings.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                new Settingsframe().setVisible(true);
            }
        });
        

        trayIcon.setPopupMenu(menu);

        try {
            tray.add(trayIcon);
        } catch (Exception e) {
        }
    }

    protected static Image creatIcon(String path, String desc) {
        URL imageURL = TrayClass.class.getResource(path);
        return (new ImageIcon(imageURL, desc)).getImage();
    }
}
