import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

public class AnalogClock extends JPanel {
    private Color backgroundColor = Color.WHITE; // 初期背景色は白色

    public AnalogClock() {
        Timer timer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                repaint();
            }
        });
        timer.start();
    }
    @Override
protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    // 現在のサイズを取得
    int width = getWidth();
    int height = getHeight();

    // 背景を描画
    g.setColor(backgroundColor);
    g.fillRect(0, 0, width, height);

    // 現在時刻を取得
    Calendar now = Calendar.getInstance();
    int hours = now.get(Calendar.HOUR_OF_DAY);
    int minutes = now.get(Calendar.MINUTE);
    int seconds = now.get(Calendar.SECOND);

    // アナログ時計の目盛りと数字を描画
    int centerX = width / 2;
    int centerY = height / 2;
    int radius = (int) (Math.min(width, height) * 0.4);

    // 目盛りの角度間隔
    double angleStep = Math.PI / 6.0;

    for (int i = 1; i <= 12; i++) {
        double angle = -Math.PI / 2 + i * angleStep; // 開始角度を調整する
        int x = (int) (centerX + radius * Math.cos(angle));
        int y = (int) (centerY + radius * Math.sin(angle));

        // 目盛りを描画
        g.setColor(Color.BLACK);

        // 数字を描画
        int number = i;
        FontMetrics fm = g.getFontMetrics();
        int numberWidth = fm.stringWidth(String.valueOf(number));
        int numberHeight = fm.getHeight();
        g.drawString(String.valueOf(number), x - numberWidth / 2, y + numberHeight / 4);
    }

    // アナログ時計の針を描画
    // 時針
    g.setColor(Color.BLACK);
    drawHand(g, centerX, centerY, radius * 0.5, (hours % 12 + minutes / 60.0) * (2 * Math.PI / 12));

    // 分針
    g.setColor(Color.BLACK);
    drawHand(g, centerX, centerY, radius * 0.7, (minutes + seconds / 60.0) * (2 * Math.PI / 60));

    // 秒針
    g.setColor(Color.RED);
    drawHand(g, centerX, centerY, radius * 0.9, seconds * (2 * Math.PI / 60));
}


    
    private void drawHand(Graphics g, int centerX, int centerY, double length, double angle) {
        int x = (int) (centerX + length * Math.sin(angle));
        int y = (int) (centerY - length * Math.cos(angle));
        g.drawLine(centerX, centerY, x, y);
    }

    public void setBackgroundColor(Color color) {
        this.backgroundColor = color;
        repaint();
    }
}
