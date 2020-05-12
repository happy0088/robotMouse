import java.awt.AWTException;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class RobotNotifier extends JFrame implements ActionListener {
    RobotNotifier rd = this;
    static int time_limit = 0;
    static JTextArea ta = new JTextArea(10, 10);
    JLabel welcome = new JLabel("Screen Lock Notifier......");
    JLabel limit = new JLabel("Time limit");
    JTextField time = new JTextField(10);
    JButton start = new JButton("start");
    JLabel note = new JLabel("NOTE: This App will pop-up a confirmation every 4 mins ");
    public static JPanel pane;

    public RobotNotifier() throws AWTException {
        this.setVisible(true);
        this.setDefaultCloseOperation(3);
        pane = new JPanel();
        pane.setBackground(Color.LIGHT_GRAY);
        start.addActionListener(this);
        pane.add(this.welcome);
        pane.add(this.start);
        this.add(pane);
        ta.setAutoscrolls(true);
        this.time.setText("0");
    }

    public static void main(String[] args) throws AWTException, IOException {
        RobotNotifier rd = new RobotNotifier();
        rd.setLocation(100, 100);
        rd.setTitle("Scren Lock Notifier");
        rd.setSize(200, 200);
        rd.setDefaultCloseOperation(3);
        rd.show();
        rd.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (this.start.getText().equals("start")) {
            pane.setBackground(Color.green);
            ta.setBackground(Color.green);
            ta.setText("Working");
            System.out.println(ta.getText());

            try {
                this.start_robot_mouse();
            } catch (AWTException var3) {
                var3.printStackTrace();
            }
        } else if (this.start.getText().equals("STOP")) {
            System.exit(1);
        }

    }

    void start_robot_mouse() throws AWTException {
        Font f = new Font("Times New Roman", 1, 20);
        ta.setFont(f);
        this.start.setText("STOP");
        (new RobotWorker("Robot_thread")).start();
        time_limit = Integer.parseInt(this.time.getText());
        System.out.println("time limit is" + time_limit);
    }

    public static void changeBgColor(Color colr) {
        pane.setBackground(colr);
    }

    public static void closeApp() {
        Date date = new Date();
        System.out.println(date.getMinutes());
        System.exit(1);
    }
}
