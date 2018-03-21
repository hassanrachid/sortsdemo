package com.hassan.sorting;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Frame {

	static int bubble[] = ArrayUtil.randomIntArray(75);
	static int insert[] = bubble.clone();
	static int quick[] = bubble.clone();
	static DisplayArrayPanel bubblesort = new DisplayArrayPanel();
	static DisplayArrayPanel insertion = new DisplayArrayPanel();
	static DisplayArrayPanel quicksort = new DisplayArrayPanel();
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 500);
		JPanel panel = new JPanel(new GridLayout(1, 3));
		JPanel labels = new JPanel(new FlowLayout(1, 92, 10));

		bubblesort.setNumbers(bubble);
		insertion.setNumbers(insert);
		quicksort.setNumbers(quick);
		
		labels.add(new JLabel("Bubble Sort"));
		panel.add(bubblesort);
		labels.add(new JLabel("Insertion Sort"));
		panel.add(insertion);
		labels.add(new JLabel("Quick Sort"));
		panel.add(quicksort);
		
		frame.add(labels, BorderLayout.NORTH);
		frame.add(panel);

		new Thread(new Runnable() {

			@Override
			public void run() {
				int n = bubble.length;
				int temp = 0;
				for (int i = 0; i < n; i++) {
					for (int j = 1; j < (n - i); j++) {
						if (bubble[j - 1] > bubble[j]) {
							temp = bubble[j - 1];
							bubble[j - 1] = bubble[j];
							bubble[j] = temp;
						}
						bubblesort.repaint();
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}).start();

		new Thread(new Runnable() {

			@Override
			public void run() {
				int n = insert.length;
				for (int i = 1; i < n; ++i) {
					int key = insert[i];
					int j = i - 1;
					while (j >= 0 && insert[j] > key) {
						insert[j + 1] = insert[j];
						j = j - 1;
					}
					insert[j + 1] = key;
					insertion.repaint();
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}

		}).start();

		new Thread(new Runnable() {

			@Override
			public void run() {
				quickSort(0, quick.length - 1);
			}

		}).start();
	}
	
	public static void quickSort(int lowerIndex, int higherIndex) {
        
        int i = lowerIndex;
        int j = higherIndex;
        int pivot = quick[lowerIndex+(higherIndex - lowerIndex)/2];
        while (i <= j) {
            while (quick[i] < pivot) {
                i++;
            }
            while (quick[j] > pivot) {
                j--;
            }
            if (i <= j) {
                exchangeNumbers(i, j);
                i++;
                j--;
            }
            quicksort.repaint();
            try {
    			Thread.sleep(50);
    		} catch (InterruptedException e) {
    			e.printStackTrace();
    		}
        }
        if (lowerIndex < j)
            quickSort(lowerIndex, j);
        if (i < higherIndex)
            quickSort(i, higherIndex);        
    }
 
    public static void exchangeNumbers(int i, int j) {
        int temp = quick[i];
        quick[i] = quick[j];
        quick[j] = temp;
    }
}
