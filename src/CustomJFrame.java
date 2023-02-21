/*
 *  Author: Daven Hill
 *  Course: COP3503
 *  Project #: 4
 *  Title  : GUI
 *  Due Date:  12/11/2022
 *
 *  Creates a dietary survey
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;

//class declaration
public class CustomJFrame extends JFrame{
    private  JLabel headingLabel;
    private JLabel firstNameLabel;
    private JLabel lastNameLabel;
    private JLabel phoneNumberLabel;
    private JLabel emailLabel;
    private JLabel dietaryLabel;
    private JLabel genderLabel;
    private JLabel waterLabel;
    private JLabel mealsLabel;

    private JLabel checkBoxLabel;
    private JLabel walkLabel;
    private JLabel weightLabel;
    private JTextField firstNameTextField;
    private JTextField lastNameTextField;
    private JTextField phoneNumberTextField;
    private JTextField emailTextField;
    private JRadioButton maleRadioButton;
    private JRadioButton femaleRadioButton;

    private JRadioButton preferRadioButton;
    private ButtonGroup radioButtonGroup;

    private JSpinner waterIntakeSpinner;
    private JSlider mealSlider;
    private JCheckBox wheatCheckBox;
    private JCheckBox sugarCheckBox;
    private JCheckBox dairyCheckBox;
    private JComboBox walkComboBox;
    private String[] walkOptions;
    private JFormattedTextField weightFormattedTextField;
    private JButton clearButton;
    private JButton submitButton;
    private FileHandler fileHandler;

    //CustomJFrame constructor
    public CustomJFrame(){
        GridBagConstraints layoutManager = new GridBagConstraints();
        fileHandler = new FileHandler();

        JFrame frame = new JFrame("Dietary Survey");
        frame.setLayout(new GridBagLayout());
        frame.setSize(500,700);
        headingLabel = new JLabel("Personal Information");
        Font f = new Font("The Bold Font", Font.BOLD, 16);

        JPanel panel = new JPanel();
        firstNameLabel = new JLabel("First Name:");
        lastNameLabel = new JLabel("Last Name:");
        phoneNumberLabel = new JLabel("Phone Number:");
        emailLabel = new JLabel("Email:");
        genderLabel = new JLabel("Sex:");
        panel.add(firstNameLabel);
        firstNameTextField = new JTextField(10);
        lastNameTextField = new JTextField(10);
        phoneNumberTextField = new JTextField(10);
        emailTextField = new JTextField(10);
        maleRadioButton = new JRadioButton("Male");
        femaleRadioButton = new JRadioButton("Female");
        preferRadioButton = new JRadioButton("Prefer not to say");
        radioButtonGroup = new ButtonGroup();
        dietaryLabel = new JLabel("Dietary Questions");
        dietaryLabel.setFont(f);
        waterLabel = new JLabel("How many cups of water do you drink a day on average?");
        SpinnerNumberModel s = new SpinnerNumberModel(15,0,50,1);
        waterIntakeSpinner = new JSpinner(s);
        mealsLabel = new JLabel("How many meals on average do you eat a day?");
        mealSlider = new JSlider(SwingConstants.HORIZONTAL,0,10,3);
        mealSlider.setMinorTickSpacing(1);
        mealSlider.setMajorTickSpacing(1);
        mealSlider.setPaintLabels(true);
        mealSlider.setPaintTicks(true);
        mealSlider.setPaintTrack(true);
        mealSlider.setSize(100,100);
        checkBoxLabel = new JLabel("Do any of these meals regularly contain:");
        dairyCheckBox = new JCheckBox("Dairy");
        wheatCheckBox = new JCheckBox("Wheat");
        sugarCheckBox = new JCheckBox("Sugar");

        walkLabel = new JLabel("On average how many miles do you walk in a day?");
        walkOptions = new String[]{"Less Than 1 Mile", "More than 1 mile but less than 2 miles", "More than 2 miles but less than 3 miles"
                ,"More than 3 miles"};
        walkComboBox = new JComboBox<String>(walkOptions);

        weightLabel = new JLabel("How much do you weigh?");

        NumberFormat n = NumberFormat.getNumberInstance();
        weightFormattedTextField = new JFormattedTextField(n);
        weightFormattedTextField.setColumns(10);
        weightFormattedTextField.setEditable(true);
        weightFormattedTextField.setText("");

        clearButton = new JButton("Clear");
        clearButton.setBackground(Color.BLUE);
        submitButton = new JButton("Submit");
        submitButton.setBackground(Color.ORANGE);



        layoutManager.insets = new Insets(2,2,2,2);
        headingLabel.setFont(f);
        layoutManager.gridx=0;
        layoutManager.gridy=0;
        frame.add(headingLabel,layoutManager);

        layoutManager.gridx = 0;
        layoutManager.gridy = 1;
        layoutManager.gridy = 1;
        frame.add(firstNameLabel,layoutManager);
        layoutManager.gridx = 1;
        frame.add(firstNameTextField,layoutManager);

        layoutManager.gridx =0;
        layoutManager.gridy=2;
        frame.add(lastNameLabel,layoutManager);
        layoutManager.gridx = 1;
        layoutManager.gridy = 2;
        frame.add(lastNameTextField,layoutManager);

        layoutManager.gridx = 0;
        layoutManager.gridy = 3;
        frame.add(phoneNumberLabel,layoutManager);
        layoutManager.gridx=1;
        layoutManager.gridy=3;
        frame.add(phoneNumberTextField,layoutManager);

        layoutManager.gridx = 0;
        layoutManager.gridy = 4;
        frame.add(emailLabel,layoutManager);
        layoutManager.gridx = 1;
        layoutManager.gridy=4;
        frame.add(emailTextField,layoutManager);

        layoutManager.gridx=0;
        layoutManager.gridy=5;
        frame.add(genderLabel, layoutManager);

        layoutManager.gridx = 1;
        layoutManager.gridy = 5;
        frame.add(maleRadioButton,layoutManager);

        layoutManager.gridx = 1;
        layoutManager.gridy = 6;
        frame.add(femaleRadioButton,layoutManager);

        layoutManager.gridx = 1;
        layoutManager.gridy = 7;
        frame.add(preferRadioButton,layoutManager);

        radioButtonGroup.add(maleRadioButton);
        radioButtonGroup.add(femaleRadioButton);
        radioButtonGroup.add(preferRadioButton);
         layoutManager.gridx = 0;
         layoutManager.gridy = 8;
        frame.add(dietaryLabel,layoutManager);

        layoutManager.gridx=0;
        layoutManager.gridy=9;
        layoutManager.gridwidth=2;
        frame.add(waterLabel,layoutManager);

        layoutManager.gridx=0;
        layoutManager.gridy=10;
        frame.add(waterIntakeSpinner,layoutManager);

        layoutManager.gridx=0;
        layoutManager.gridy=11;
        frame.add(mealsLabel,layoutManager);

        layoutManager.gridx=0;
        layoutManager.gridy=12;
        frame.add(mealSlider,layoutManager);

        layoutManager.gridx=0;
        layoutManager.gridy=13;
        frame.add(checkBoxLabel,layoutManager);

        layoutManager.gridx=0;
        layoutManager.gridy=14;
        frame.add(dairyCheckBox,layoutManager);

        layoutManager.gridx=0;
        layoutManager.gridy=15;
        frame.add(wheatCheckBox,layoutManager);

        layoutManager.gridx=0;
        layoutManager.gridy=16;
        frame.add(sugarCheckBox,layoutManager);

        layoutManager.gridx=0;
        layoutManager.gridy=17;
        frame.add(walkLabel, layoutManager);

        layoutManager.gridx=0;
        layoutManager.gridy=18;
        frame.add(walkComboBox,layoutManager);

        layoutManager.gridx=0;
        layoutManager.gridy=19;
        frame.add(weightLabel,layoutManager);

        layoutManager.gridx=0;
        layoutManager.gridy=20;
        frame.add(weightFormattedTextField,layoutManager);

        layoutManager.gridx=0;
        layoutManager.gridy=21;
        frame.add(submitButton,layoutManager);

        layoutManager.gridx=0;
        layoutManager.gridy=22;
        frame.add(clearButton,layoutManager);
        InnerActionListener listener = new InnerActionListener();

        submitButton.addActionListener(listener);
        clearButton.addActionListener(listener);

        frame.setVisible(true);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    // Inner action listener class
     class InnerActionListener implements ActionListener {
        /**
         * Performs an action based on button clicks.
         * @param e The ActionEvent.
         */
        @Override
        public void actionPerformed(ActionEvent e) {
             JButton button = (JButton) e.getSource();
             String name = button.getText();
             if(name.equals("Submit")){
                 SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
                 Date d = Calendar.getInstance().getTime();
                 String date = simpleDateFormat.format(d);
                 String x = date + "," + firstNameTextField.getText() + "," + lastNameTextField.getText() + "," + phoneNumberTextField.getText() +
                         "," + emailTextField.getText() + "," + getSelectedButtonText(radioButtonGroup) + "," + waterIntakeSpinner.getValue()
                         + "," + mealSlider.getValue() + "," + dairyCheckBox.isSelected() + "," + wheatCheckBox.isSelected() + "," +
                         sugarCheckBox.isSelected()+","+walkComboBox.getSelectedItem() + "," + weightFormattedTextField.getText();
                 fileHandler.writeResults(x);
                 System.out.println("submit");
                 System.out.println(x);
             }else if (name.equals("Clear")){
                 clearForm();
                 System.out.println("cleared");
             }
        }
        /**
         * Clears the data of the survey.
         */
        private void clearForm(){
         firstNameTextField.setText("");
         lastNameTextField.setText("");
         phoneNumberTextField.setText("");
         emailTextField.setText("");
         radioButtonGroup.clearSelection();
         waterIntakeSpinner.setValue(15);
         mealSlider.setValue(3);
         wheatCheckBox.setSelected(false);
         sugarCheckBox.setSelected(false);
         dairyCheckBox.setSelected(false);
         walkComboBox.setSelectedIndex(0);
         weightFormattedTextField.setText("");
        }


    }
    /**
     * Returns the selected button in a button group.
     * @param buttonGroup The buttonGroup.
     * @return The string of the choice.
     */
    public String getSelectedButtonText(ButtonGroup buttonGroup) {
        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();

            if (button.isSelected()) {
                return button.getText();
            }
        }

        return null;
    }
}//end of class

