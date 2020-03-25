
// Java program to move a mouse from the initial
// location to a specified location

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static util.Constants.INTERVAL;

class MoveMouseWithUI extends Frame implements ActionListener {
    // Frame
    static JFrame frame;
    static boolean need=true;
    // default constructor
    MoveMouseWithUI() {
    }

    public static void main(String args[]) {
        MoveMouseWithUI rm = new MoveMouseWithUI();
        frame = new JFrame("robomouse");
        // set the frame to close on exit
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Button b = new Button("START");
        Button stop = new Button("STOP");
        // add actionListener
        b.addActionListener(rm);
        stop.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("stop button pressed");
                need=false;
                System.exit(0);
            }
        });
        // create a panel
        Panel panel = new Panel();
        panel.add(b);
        panel.add(stop);
        frame.add(panel);
        // setsize of frame
        frame.setSize(300, 300);
        frame.show();
    }

    public Point getMousePointer() {
        return MouseInfo.getPointerInfo().getLocation();
    }

    // if button is pressed
    public void actionPerformed(ActionEvent e) {
        try {
            System.out.println("Robot Started");
            Robot robot = new Robot();
            int catalyst = 2;
            while (need) {
                robot.delay(INTERVAL);
                int x;
                if (catalyst % 2 == 0) {
                    x = getMousePointer().x - 1;
                    catalyst++;
                } else {
                    x = getMousePointer().x + 1;
                    catalyst = 2;
                }
                int y = getMousePointer().y;
                System.out.println("Mouse moving to :" + x + "," + y + "catalyst:" + catalyst);
                robot.mouseMove(x, y);
            }
        } catch (Exception evt) {
            System.err.println(evt.getMessage());
        }
    }
}
