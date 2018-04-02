package dz.aggoun.prayer.houres;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JFrame;

public class DigitalClock {

    public static void main(String[] arguments) {

        ClockLabel dateLable = new ClockLabel("date");
        ClockLabel timeLable = new ClockLabel("time");
        ClockLabel dayLable = new ClockLabel("day");

        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame f = new JFrame("Digital Clock");
        f.setSize(300, 150);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(new GridLayout(3, 1));

        f.add(dateLable);
        f.add(timeLable);
        f.add(dayLable);

        f.getContentPane().setBackground(Color.black);

        f.setVisible(true);
    }
}