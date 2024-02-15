import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;

public class SnakeGame extends JFrame {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 800;
    private static final int TILE_SIZE = 20;
    private static final int DELAY = 100;

    private ArrayList<Point> snake;
    private Point fruit;
    private int direction;
    private boolean running;

    public SnakeGame() {
        setTitle("Snake Game");
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP:
                        if (direction != 2) direction = 0;
                        break;
                    case KeyEvent.VK_RIGHT:
                        if (direction != 3) direction = 1;
                        break;
                    case KeyEvent.VK_DOWN:
                        if (direction != 0) direction = 2;
                        break;
                    case KeyEvent.VK_LEFT:
                        if (direction != 1) direction = 3;
                        break;
                }
            }
        });

        snake = new ArrayList<>();
        snake.add(new Point(WIDTH / 2, HEIGHT / 2));
        generateFruit();
        direction = 1;
        running = true;

        Timer timer = new Timer(DELAY, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (running) {
                    move();
                    checkCollision();
                    repaint();
                }
            }
        });
        timer.start();
    }

    private void generateFruit() {
        Random rand = new Random();
        int x = rand.nextInt(WIDTH / TILE_SIZE) * TILE_SIZE;
        int y = rand.nextInt(HEIGHT / TILE_SIZE) * TILE_SIZE;
        fruit = new Point(x, y);
    }

    private void move() {
        Point head = snake.get(0);
        Point newHead;
        switch (direction) {
            case 0: // UP
                newHead = new Point(head.x, (head.y - TILE_SIZE + HEIGHT) % HEIGHT);
                break;
            case 1: // RIGHT
                newHead = new Point((head.x + TILE_SIZE) % WIDTH, head.y);
                break;
            case 2: // DOWN
                newHead = new Point(head.x, (head.y + TILE_SIZE) % HEIGHT);
                break;
            case 3: // LEFT
                newHead = new Point((head.x - TILE_SIZE + WIDTH) % WIDTH, head.y);
                break;
            default:
                newHead = head;
                break;
        }
        snake.add(0, newHead);
        if (!newHead.equals(fruit)) {
            snake.remove(snake.size() - 1);
        } else {
            generateFruit();
        }
    }

    private void checkCollision() {
        Point head = snake.get(0);
        for (int i = 1; i < snake.size(); i++) {
            if (head.equals(snake.get(i))) {
                running = false;
                break;
            }
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        // Draw background
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        // Draw fruit
        g.setColor(Color.RED);
        g.fillRect(fruit.x, fruit.y, TILE_SIZE, TILE_SIZE);
        // Draw snake
        g.setColor(Color.GREEN);
        for (Point point : snake) {
            g.fillRect(point.x, point.y, TILE_SIZE, TILE_SIZE);
        }
        // Game Over
        if (!running) {
            g.setColor(Color.WHITE);
            g.setFont(new Font("Arial", Font.BOLD, 30));
            g.drawString("Game Over!", WIDTH / 2 - 100, HEIGHT / 2);
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SnakeGame().setVisible(true);
            }
        });
    }
}
