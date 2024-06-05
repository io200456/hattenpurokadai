import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Analog Clock");
        AnalogClock clock = new AnalogClock();

        // 背景色を変更するボタンを追加
        JButton redButton = new JButton("Green Background");
        redButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clock.setBackgroundColor(Color.GREEN);
            }
        });

        JButton blueButton = new JButton("WHITE Background");
        blueButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clock.setBackgroundColor(Color.WHITE);
            }
        });

        // フレームにコンポーネントを追加
        frame.setLayout(new BorderLayout());
        frame.add(redButton, BorderLayout.NORTH);
        frame.add(blueButton, BorderLayout.SOUTH);
        frame.add(clock, BorderLayout.CENTER);

        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
