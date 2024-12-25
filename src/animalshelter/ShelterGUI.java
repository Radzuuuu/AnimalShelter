/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package animalshelter;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ShelterGUI extends JFrame {
    private ArrayList<Animal> animals;
    private JTextArea displayArea;
    private JTextField nameField, actionField;
    private final JComboBox<String> typeDropdown;

    public ShelterGUI() {
        animals = new ArrayList<>();

        // Set up the JFrame
        setTitle("Animal Shelter Management");
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Display Area
        displayArea = new JTextArea();
        displayArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(displayArea);
        add(scrollPane, BorderLayout.CENTER);
        setLocationRelativeTo(null);
        setIconImage(new ImageIcon("Icon.png").getImage());
        // Input Panel for Adding Animals
        JPanel inputPanel = new JPanel(new GridLayout(3, 2));
        inputPanel.setBorder(BorderFactory.createTitledBorder("Add an Animal"));

        inputPanel.add(new JLabel("Name:"));
        nameField = new JTextField();
        inputPanel.add(nameField);

        inputPanel.add(new JLabel("Type:"));
        typeDropdown = new JComboBox<>(new String[]{"Dog", "Cat", "Rabbit", "Bird", "Reptile", "Other"});
        inputPanel.add(typeDropdown);

        JButton addButton = new JButton("Register Animal");
        inputPanel.add(addButton);
        add(inputPanel, BorderLayout.NORTH);

        // Action Panel for Adoption/Return
        JPanel actionPanel = new JPanel(new GridLayout(3, 1));
        actionPanel.setBorder(BorderFactory.createTitledBorder("Actions"));

        actionPanel.add(new JLabel("Enter Animal Name:"));
        actionField = new JTextField();
        actionPanel.add(actionField);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton adoptButton = new JButton("Adopt");
        JButton returnButton = new JButton("Return to Shelter");
        buttonPanel.add(adoptButton);
        buttonPanel.add(returnButton);
        actionPanel.add(buttonPanel);
        add(actionPanel, BorderLayout.SOUTH);

        // Button Action Listeners
        addButton.addActionListener(e -> addAnimal());
        adoptButton.addActionListener(e -> adoptAnimal());
        returnButton.addActionListener(e -> returnAnimal());

        // Initial Display
        refreshDisplay();
    }

    private void addAnimal() {
        String name = nameField.getText().trim();
        String type = (String) typeDropdown.getSelectedItem();
        if (!name.isEmpty() && type != null) {
            animals.add(new Animal(name, type));
            nameField.setText("");
            typeDropdown.setSelectedIndex(0);
            refreshDisplay();
        } else {
            JOptionPane.showMessageDialog(this, "Please enter the animal's name.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void adoptAnimal() {
        String name = actionField.getText().trim();
        if (!name.isEmpty()) {
            for (Animal animal : animals) {
                if (animal.getName().equalsIgnoreCase(name)) {
                    JOptionPane.showMessageDialog(this, animal.adopt(), "Adopt Animal", JOptionPane.INFORMATION_MESSAGE);
                    refreshDisplay();
                    return;
                }
            }
            JOptionPane.showMessageDialog(this, "Animal not found!", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Please enter the animal's name.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void returnAnimal() {
        String name = actionField.getText().trim();
        if (!name.isEmpty()) {
            for (Animal animal : animals) {
                if (animal.getName().equalsIgnoreCase(name)) {
                    JOptionPane.showMessageDialog(this, animal.returnToShelter(), "Return Animal", JOptionPane.INFORMATION_MESSAGE);
                    refreshDisplay();
                    return;
                }
            }
            JOptionPane.showMessageDialog(this, "Animal not found!", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Please enter the animal's name.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void refreshDisplay() {
        displayArea.setText("");
        if (animals.isEmpty()) {
            displayArea.setText("No animals in the shelter.");
        } else {
            for (Animal animal : animals) {
                displayArea.append(animal.toString() + "\n");
            }
        }
    }
}
