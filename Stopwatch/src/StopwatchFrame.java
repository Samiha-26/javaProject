import javax.swing.*;
import java.awt.*;

public class StopwatchFrame extends JFrame {

    private JLabel timeLabel;
    private JButton startBtn, stopBtn, resetBtn, lapBtn;

    public StopwatchFrame() {
        setTitle("Stopwatch - Update 1");
        setSize(370, 200);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        timeLabel = new JLabel("00:00:00:00");
        timeLabel.setFont(new Font("Verdana", Font.PLAIN, 26));
        timeLabel.setBounds(50, 20, 250, 30);
        add(timeLabel);

        startBtn = new JButton("Start");
        stopBtn = new JButton("Stop");
        resetBtn = new JButton("Reset");
        lapBtn = new JButton("Lap");

        startBtn.setBounds(20, 70, 70, 30);
        stopBtn.setBounds(100, 70, 70, 30);
        resetBtn.setBounds(180, 70, 70, 30);
        lapBtn.setBounds(260, 70, 70, 30);

        JButton[] buttons = { startBtn, stopBtn, resetBtn, lapBtn };
        for (JButton btn : buttons) {
            btn.setBackground(new Color(30, 144, 255));
            btn.setForeground(Color.WHITE);
            btn.setFont(new Font("Arial", Font.BOLD, 12));
            btn.setFocusPainted(false);
            add(btn);
        }

        setVisible(true);
    }
}