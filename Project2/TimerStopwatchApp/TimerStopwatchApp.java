package Project2.TimerStopwatchApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.text.DecimalFormat;

public class TimerStopwatchApp {
    private JFrame frame;
    private JLabel timerLabel;
    private JButton startButton;
    private JButton stopButton;
    private JButton resetButton;

    private Timer timer;
    private int elapsedTime = 0;
    private boolean isRunning = false;

    public TimerStopwatchApp() {
        frame = new JFrame("Timer and Stopwatch");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);
        frame.setLayout(new FlowLayout());

        timerLabel = new JLabel("00:00:00");
        timerLabel.setFont(new Font("Arial", Font.PLAIN, 24));
        frame.add(timerLabel);

        startButton = new JButton("Start");
        stopButton = new JButton("Stop");
        resetButton = new JButton("Reset");

        frame.add(startButton);
        frame.add(stopButton);
        frame.add(resetButton);

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                start();
            }
        });

        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stop();
            }
        });

        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reset();
            }
        });

        frame.setVisible(true);
    }

    private void start() {
        if (!isRunning) {
            isRunning = true;
            timer = new Timer(1000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    elapsedTime++;
                    updateTimerLabel();
                }
            });
            timer.start();
            startButton.setEnabled(false);
            stopButton.setEnabled(true);
            resetButton.setEnabled(true);
        }
    }

    private void stop() {
        if (isRunning) {
            isRunning = false;
            if (timer != null) {
                timer.stop();
            }
            startButton.setEnabled(true);
            stopButton.setEnabled(false);
            resetButton.setEnabled(true);
        }
    }

    private void reset() {
        stop();
        elapsedTime = 0;
        updateTimerLabel();
        startButton.setEnabled(true);
        stopButton.setEnabled(false);
        resetButton.setEnabled(false);
    }

    private void updateTimerLabel() {
        int hours = elapsedTime / 3600;
        int minutes = (elapsedTime % 3600) / 60;
        int seconds = elapsedTime % 60;
        timerLabel.setText(String.format("%02d:%02d:%02d", hours, minutes, seconds));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TimerStopwatchApp();
            }
        });
    }
}
