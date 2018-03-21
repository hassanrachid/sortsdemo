package com.hassan.sorting;

import java.awt.Graphics;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class DisplayArrayPanel extends JPanel {

	int numbers[];

	public void setNumbers(int numbers[]) {

		this.numbers = numbers;
		repaint();
	}

	protected synchronized void paintComponent(Graphics g) {

		super.paintComponent(g);

		int max = numbers[0];

		for (int x = 1; x < numbers.length; x++) {

			if (max < numbers[x]) {
				max = numbers[x];
			}

		}

		int height = (int) (getSize().height * 0.98);
		int width = getSize().width;

		int unitWidth = (int) (width * 1.0 / numbers.length);

		for (int i = 0; i < numbers.length; i++) {

			g.drawRect((int) (i * unitWidth), getSize().height - (int) ((numbers[i] * 1.0 / max) * height),
					(int) (unitWidth), getSize().height);
		}

	}
}