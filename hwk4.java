import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * This program implements an animation that moves a car shape.
 */
public class hwk4 {
	public static void main(String[] args) throws InterruptedException {
		JFrame frame = new JFrame();
		frame.setSize(400, 800);
		final MoveableShape shape = new CarShape(0, 0, CAR_WIDTH);
		final MoveableShape shape2 = new CarShape(0, 0, CAR_WIDTH);
		final MoveableShape shape3 = new CarShape(0, 0, CAR_WIDTH);

		ShapeIcon icon = new ShapeIcon(shape, ICON_WIDTH, ICON_HEIGHT);
		ShapeIcon icon2 = new ShapeIcon(shape2, ICON_WIDTH, ICON_HEIGHT);
		ShapeIcon icon3 = new ShapeIcon(shape3, ICON_WIDTH, ICON_HEIGHT);
		final JLabel label = new JLabel(icon);
		final JLabel label2 = new JLabel(icon2);
		final JLabel label3 = new JLabel(icon3);
		frame.setLayout(new FlowLayout());
		
		frame.add(label);
		frame.add(label2);
		frame.add(label3);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		// goes in different speed cause of what delay you have

		final int DELAY = 10;
		final int DELAY2 = 15;
		final int DELAY3 = 20;

		// Milliseconds between timer ticks
		Timer t = new Timer(DELAY, event -> {
			shape.move();

			label.repaint();

		});
		Timer t2 = new Timer(DELAY2, event -> {
			shape2.move();
			label2.repaint();
		});
		Timer t4 = new Timer(DELAY3, event -> {
			shape3.move();
			label3.repaint();
		});

//      t.start();
//      t2.start();
//      t4.start();
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				t.start();
			}
		});
		Thread t3 = new Thread(new Runnable() {
			public void run() {
				t2.start();
			}
		});
		Thread t5 = new Thread(new Runnable() {
			public void run() {
				t4.start();
			}
		});

		t1.start();
		t1.sleep(200);// speed of the car
		t3.start();
		t3.sleep(600);
		t5.start();
		t5.sleep(500);
	}

	private static final int ICON_WIDTH = 400;
	private static final int ICON_HEIGHT = 200;
	private static final int CAR_WIDTH = 100;

}
