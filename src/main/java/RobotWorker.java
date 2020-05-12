//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Component;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Robot;
import java.util.Date;
import javax.swing.JOptionPane;

import static util.Constants.INTERVAL;

class RobotWorker extends Thread {
    int dialogButton = 0;

    public RobotWorker(String str) {
        super(str);
    }

    public void run() {
        int time_delay = '\uea60';
        Robot robot = null;

        try {
            robot = new Robot();
        } catch (AWTException var22) {
            var22.printStackTrace();
        }

        Point p = MouseInfo.getPointerInfo().getLocation();
        int x = p.x;
        int y = p.y;
        int select = 0;
        boolean moved = false;
        int catalyst = 2;
        while(true) {
            System.out.println("next loop");
            Point pinit = MouseInfo.getPointerInfo().getLocation();
            int xinit = pinit.x;
            int yinit = pinit.y;
            Point newp = MouseInfo.getPointerInfo().getLocation();
            int newx = newp.x;
            int newy = newp.y;
            System.out.println("initial " + xinit + " " + yinit);
            moved = false;
            int k = 0;


            while(k < 1) {
                newp = MouseInfo.getPointerInfo().getLocation();
                newx = newp.x;
                newy = newp.y;
                System.out.println(newx + "-" + xinit + " " + newy + "-" + yinit);
                if (newx == xinit && newy == yinit) {
                    System.out.println("mouse delayed for " + k);
                    robot.delay(time_delay);
                    newp = MouseInfo.getPointerInfo().getLocation();
                    newx = newp.x;
                    newy = newp.y;
                    if (newx == xinit && newy == yinit) {
                        ++k;
                        continue;
                    }

                    System.out.println("mouse moved now to " + newx + " " + newy);
                    moved = true;
                    break;
                }

                System.out.println("mouse moved now to " + newx + " " + newy);
                moved = true;
                break;
            }

            System.out.println("moved value is" + moved);
            if (!moved) {
                {
                    System.out.println("Mouse Movement Started");
                    //Robot robot = new Robot();

                    //while (need)
                    {
                        robot.delay(INTERVAL);
                        int xAxis;
                        if (catalyst % 2 == 0) {
                            xAxis = getMousePointer().x - 1;
                            catalyst++;
                        } else {
                            xAxis = getMousePointer().x + 1;
                            catalyst --;
                        }
                        int yAxis = getMousePointer().y;
                        System.out.println("Mouse moving to :" + x + "," + y + "catalyst:" + catalyst);
                        robot.mouseMove(xAxis, yAxis);
                    }
                }

                /*System.out.println("popup entered");
                JOptionPane.showMessageDialog(RobotDemo.pane, "Screen will get locked in 1 min. KIndly move the mouse in order to avoid it", "Warning", 1);
                System.out.println("seelct is " + select);*/
                moveMouse();
                moved = false;
            }
        }
    }

    public void moveMouse(){
        {
            try {
                System.out.println("Mouse Movement Started");
                Robot robot = new Robot();
                int catalyst = 2;
                //while (need)
                {
                    robot.delay(INTERVAL);
                    int x;
                    if (catalyst % 2 == 0) {
                        x = getMousePointer().x - 1;
                        catalyst++;
                    } else {
                        x = getMousePointer().x + 1;
                        catalyst --;
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
    public Point getMousePointer() {
        return MouseInfo.getPointerInfo().getLocation();
    }

    public boolean interruptMessage() {
        RobotNotifier.changeBgColor(Color.red);
        int dialogResult = JOptionPane.showConfirmDialog((Component)null, "Would you like to continue????", "Warning", this.dialogButton);
        if (dialogResult == 0) {
            RobotNotifier.changeBgColor(Color.green);
            System.out.println("yes selected0");
            return true;
        } else {
            System.out.println("no selected");
            System.out.println("time over");
            RobotNotifier.changeBgColor(Color.RED);
            Date date = new Date();
            System.out.println(date.getTime());
            RobotNotifier.closeApp();
            return false;
        }
    }
}
