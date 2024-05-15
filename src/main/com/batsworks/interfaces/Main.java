package main.com.batsworks.interfaces;

import javax.swing.*;
import main.com.batsworks.interfaces.view.Index;

public class Main {

    public static void main(String[] args) {
        try {
            UIManager.LookAndFeelInfo[] looks = UIManager.getInstalledLookAndFeels();
            for (var look : looks) {
                var lookName = look.getName().toLowerCase();
                if (lookName.contains("gtk") || lookName.equals("nimbus"))
                    UIManager.setLookAndFeel(look.getClassName());
                System.out.println(lookName);
            }
            new Index();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

}
