import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class EmailApp {
    private static JTextField firstNameField;
    private static JTextField lastNameField;
    private static JTextArea outputArea;
    private static JComboBox<String> departmentComboBox;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Email Generator");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JLabel firstNameLabel = new JLabel("First Name:");
        firstNameLabel.setBounds(10, 10, 100, 25);
        frame.add(firstNameLabel);

        firstNameField = new JTextField();
        firstNameField.setBounds(120, 10, 160, 25);
        frame.add(firstNameField);

        JLabel lastNameLabel = new JLabel("Last Name:");
        lastNameLabel.setBounds(10, 40, 100, 25);
        frame.add(lastNameLabel);

        lastNameField = new JTextField();
        lastNameField.setBounds(120, 40, 160, 25);
        frame.add(lastNameField);

        JLabel departmentLabel = new JLabel("Department:");
        departmentLabel.setBounds(10, 70, 100, 25);
        frame.add(departmentLabel);

        String[] departments = {"empty" ,"Marketing", "Informatics", "Sport", "Development"};
        departmentComboBox = new JComboBox<>(departments);
        departmentComboBox.setBounds(120, 70, 160, 25);
        frame.add(departmentComboBox);

        JButton generateButton = new JButton("Generate Email");
        generateButton.setBounds(10, 100, 150, 25);
        frame.add(generateButton);

        outputArea = new JTextArea();
        outputArea.setBounds(10, 130, 360, 120);
        frame.add(outputArea);

        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String firstName = firstNameField.getText();
                String lastName = lastNameField.getText();
                String department = (String) departmentComboBox.getSelectedItem();
                if (!firstName.isEmpty() && !lastName.isEmpty() && !Objects.equals(department, "empty")) {
                    User user = new User(firstName, lastName);
                    Email email = new Email(user);
                    email.chooseDepartment(department);
                    String emailAddress = email.generateEmail();
                    String altEmail = email.setAlternativeEmail();
                    String password = email.randomPassword(10);
                    String altPassword = email.changePassword(10);

                    outputArea.setText("Generated Email: " + emailAddress + "\n");
                    outputArea.append("Alternative Email: " + altEmail + "\n");
                    outputArea.append("Password: " + password + "\n");
                    outputArea.append("Alternative Password: " + altPassword + "\n");
                } else {
                    outputArea.setText("Please enter first name, last name, and select a department.");
                }
            }
        });

        frame.setVisible(true);
    }
}
