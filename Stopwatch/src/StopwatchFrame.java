import javax.swing.*;
import java.awt.*;

public class StopwatchFrame extends JFrame {

    private JLabel timeLabel;
    private JButton startBtn, stopBtn, resetBtn, lapBtn;
    private Timer timer;
    private int elapsedTime=0;
    private JTextArea lapArea;
    private JScrollPane scrollPane;
    
    public StopwatchFrame() {
        setTitle("Stopwatch");
        setSize(370, 380);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        timeLabel = new JLabel("00:00:00:00");
        timeLabel.setFont(new Font("Verdana", Font.PLAIN, 26));
        timeLabel.setBounds(90, 20, 250, 30);
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
        
        lapArea = new JTextArea();
        lapArea.setEditable(false);
        scrollPane = new JScrollPane(lapArea);
        scrollPane.setBounds(20, 120, 320, 170);
        add(scrollPane);
        
        JCheckBox darkModeCheck = new JCheckBox("Dark Mode");
        darkModeCheck.setBounds(20, 300, 120, 30);
        darkModeCheck.setFont(new Font("Arial", Font.PLAIN, 12));
        add(darkModeCheck);

        darkModeCheck.addActionListener(e -> {
            if (darkModeCheck.isSelected()) {
                // Dark Mode
                Color bg = Color.BLACK;
                Color fg = Color.GREEN;

                getContentPane().setBackground(bg);
                timeLabel.setForeground(fg);
                lapArea.setBackground(bg);
                lapArea.setForeground(fg);
                scrollPane.setBackground(bg);
                scrollPane.setForeground(fg);
                darkModeCheck.setBackground(bg);
                darkModeCheck.setForeground(fg);
                darkModeCheck.setOpaque(true);
                darkModeCheck.setFocusPainted(false);
                darkModeCheck.setBorderPainted(false);

            } else {
                // Light Mode
                Color bg = Color.WHITE;
                Color fg = Color.BLACK;

                getContentPane().setBackground(bg);
                timeLabel.setForeground(fg);
                lapArea.setBackground(Color.WHITE);
                lapArea.setForeground(fg);
                scrollPane.setBackground(bg);
                scrollPane.setForeground(fg);
                darkModeCheck.setBackground(bg);
                darkModeCheck.setForeground(fg);
            }
        });
        
        timer = new Timer(10, e -> {
            elapsedTime += 10;
            int totalSec = elapsedTime / 1000;
            int hrs = totalSec / 3600;
            int mins = (totalSec % 3600) / 60;
            int secs = totalSec % 60;
            int millis = (elapsedTime % 1000) / 10;
            timeLabel.setText(String.format("%02d:%02d:%02d:%02d", hrs, mins, secs, millis));
        });

        startBtn.addActionListener(e -> timer.start());
        stopBtn.addActionListener(e -> timer.stop());
        resetBtn.addActionListener(e -> {
            timer.stop();
            elapsedTime = 0;
            timeLabel.setText("00:00:00:00");
            lapArea.setText("");
        });
        lapBtn.addActionListener(e -> lapArea.append(timeLabel.getText() + "\n"));
        setVisible(true);
    }
}