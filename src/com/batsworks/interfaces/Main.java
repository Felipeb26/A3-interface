package com.batsworks.interfaces;

import com.batsworks.interfaces.view.Index;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        try {
            UIManager.LookAndFeelInfo[] looks = UIManager.getInstalledLookAndFeels();
            for (var look : looks) {
                var lookName = look.getName().toLowerCase();
                if (lookName.contains("gtk") || lookName.equals("nimbus"))
                    UIManager.setLookAndFeel(look.getClassName());
            }
            new Index();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
