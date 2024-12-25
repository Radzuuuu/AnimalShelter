/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package animalshelter;

import javax.swing.*;
import java.awt.*;

public class LoadingScreen extends JFrame {
    private JProgressBar progressBar;

    public LoadingScreen(String imageName) {
        // Setup the loading screen
        setTitle("Loading...");
        setSize(500, 500);
        setLocationRelativeTo(null);
        setUndecorated(true);
        setLayout(null); // Use null layout for precise positioning

        // Add custom panel with an image background
        ImagePanel backgroundPanel = new ImagePanel(imageName);
        backgroundPanel.setBounds(0, 0, 500, 500);
        backgroundPanel.setLayout(null);
        add(backgroundPanel);

        // Add a label on top of the image
        JLabel label = new JLabel("Animal Shelter", JLabel.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 18));
        label.setForeground(Color.WHITE);
        label.setBounds(100, 275, 300, 30); // Adjust position and size
        backgroundPanel.add(label);

        // Add a smaller progress bar
        progressBar = new JProgressBar(0, 100);
        progressBar.setValue(0);
        progressBar.setStringPainted(true);
        progressBar.setBounds(100, 350, 300, 20); // Adjust position and size
        backgroundPanel.add(progressBar);

        setVisible(true);
    }

    public void updateProgress(int value) {
        progressBar.setValue(value);
    }

    // Custom JPanel to paint the background image
    private class ImagePanel extends JPanel {
        private Image backgroundImage;

        public ImagePanel(String imageName) {
            try {
                // Load image from the working directory
                backgroundImage = new ImageIcon(imageName).getImage();
            } catch (Exception e) {
                System.err.println("Error loading image: " + e.getMessage());
            }
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (backgroundImage != null) {
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            }
        }
    }
}

