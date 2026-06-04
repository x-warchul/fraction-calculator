/** Program Name: FractionCalculator.java
 *  Purpose: A program designed to work with the Fraction class to display user created fractions and allow multiple operations
 *  		 Additionally illustrates knowledge of GUI, OOP and exceptions
 *  @author Xander Warchulski
 *  @version 1.0
 *  @since April 13, 2025
 */

//import Swing utilities and ArrayList

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class FractionCalculator extends JFrame 
{
	//instantiate GUI components
    private JTextField txtNumField, txtDenField;
    private JTextArea txtFractionArea, txtOperationArea;
    private JComboBox<String> cmbOperations;
    private ArrayList<Fraction> fractions;

    public FractionCalculator() 
    {
    	//build the JFrame
        setTitle("Fraction Calculator");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        //create an ArrayList to hold user-created fractions
        fractions = new ArrayList<>();

        //building the panel for user input
        JPanel inputPanel = new JPanel(new GridLayout(3, 2));
        inputPanel.add(new JLabel("Numerator:"));
        txtNumField = new JTextField();
        inputPanel.add(txtNumField);
        inputPanel.add(new JLabel("Denominator:"));
        txtDenField = new JTextField();
        inputPanel.add(txtDenField);
        
        //building input panel buttons and uses anonymous listeners to add capabilities to the buttons
        JButton btnBuild = new JButton("Build Fraction");
        btnBuild.addActionListener(e -> buildFraction());
        inputPanel.add(btnBuild);

        JButton btnStartOver = new JButton("Start Over!");
        btnStartOver.addActionListener(e -> startOver());
        inputPanel.add(btnStartOver);
        
        //add the input panel to the Frame
        add(inputPanel, BorderLayout.NORTH);

        //building the output panel
        JPanel outputPanel = new JPanel(new GridLayout(1, 2));
        txtFractionArea = new JTextArea("Here is your fraction:\n");
        txtFractionArea.setEditable(false);
        outputPanel.add(new JScrollPane(txtFractionArea));

        txtOperationArea = new JTextArea("Here is your operation:\n");
        txtOperationArea.setEditable(false);
        outputPanel.add(new JScrollPane(txtOperationArea));
        
        //add the output panel to the frame
        add(outputPanel, BorderLayout.CENTER);

        //build the lower panel to allow user to access fraction operations
        JPanel operationPanel = new JPanel();
        operationPanel.add(new JLabel("Select an operation:"));
        
        //string array to hold the operations
        String[] operations = {
            "Decimal", "Reciprocal", "Lowest Terms",
            "Add", "Multiply", "Equals", "Greater Than", "Sort"
        };
        
        //populating a combo box with possible operations
        cmbOperations = new JComboBox<>(operations);
        cmbOperations.addActionListener(e -> performOperation());
        operationPanel.add(cmbOperations);
        
        //add the panel to the frame
        add(operationPanel, BorderLayout.SOUTH);

        //instantiate a menu bar
        JMenuBar menuBar = new JMenuBar();
        
        //menu #1 - basic program usage (starting over, exiting the program)
        JMenu fileMenu = new JMenu("File");
        fileMenu.setMnemonic(KeyEvent.VK_F);
        
        JMenuItem startOverItem = new JMenuItem("Start Over", KeyEvent.VK_S);
        startOverItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));
        startOverItem.addActionListener(e -> startOver());
        fileMenu.add(startOverItem);
        
        JMenuItem exitItem = new JMenuItem("Exit", KeyEvent.VK_X);
        exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_DOWN_MASK));
        exitItem.addActionListener(e -> System.exit(0));
        fileMenu.add(exitItem);
        
        //menu #2 - access to all available operations
        //adds separators between unary, binary and sorting operators
        JMenu operationsMenu = new JMenu("Operations");
        operationsMenu.setMnemonic(KeyEvent.VK_O);
        
        // Unary Operations
        JMenuItem decimalItem = new JMenuItem("Decimal", KeyEvent.VK_D);
        decimalItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.CTRL_DOWN_MASK));
        decimalItem.addActionListener(e -> cmbOperations.setSelectedIndex(0));
        operationsMenu.add(decimalItem);
        
        JMenuItem reciprocalItem = new JMenuItem("Reciprocal", KeyEvent.VK_R);
        reciprocalItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.CTRL_DOWN_MASK));
        reciprocalItem.addActionListener(e -> cmbOperations.setSelectedIndex(1));
        operationsMenu.add(reciprocalItem);
        
        JMenuItem lowestTermsItem = new JMenuItem("Lowest Terms", KeyEvent.VK_L);
        lowestTermsItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, InputEvent.CTRL_DOWN_MASK));
        lowestTermsItem.addActionListener(e -> cmbOperations.setSelectedIndex(2));
        operationsMenu.add(lowestTermsItem);
        
        operationsMenu.addSeparator();

        JMenuItem addItem = new JMenuItem("Add", KeyEvent.VK_A);
        addItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_DOWN_MASK));
        addItem.addActionListener(e -> cmbOperations.setSelectedIndex(3));
        operationsMenu.add(addItem);
        
        JMenuItem multiplyItem = new JMenuItem("Multiply", KeyEvent.VK_M);
        multiplyItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, InputEvent.CTRL_DOWN_MASK));
        multiplyItem.addActionListener(e -> cmbOperations.setSelectedIndex(4));
        operationsMenu.add(multiplyItem);
        
        JMenuItem equalsItem = new JMenuItem("Equals", KeyEvent.VK_E);
        equalsItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_DOWN_MASK));
        equalsItem.addActionListener(e -> cmbOperations.setSelectedIndex(5));
        operationsMenu.add(equalsItem);
        
        JMenuItem greaterThanItem = new JMenuItem("Greater Than", KeyEvent.VK_G);
        greaterThanItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, InputEvent.CTRL_DOWN_MASK));
        greaterThanItem.addActionListener(e -> cmbOperations.setSelectedIndex(6));
        operationsMenu.add(greaterThanItem);
        
        operationsMenu.addSeparator();

        JMenuItem sortItem = new JMenuItem("Sort", KeyEvent.VK_S);
        sortItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
        sortItem.addActionListener(e -> cmbOperations.setSelectedIndex(7));
        operationsMenu.add(sortItem);
        
        //menu #3 - help menu to display information about the program and author
        JMenu helpMenu = new JMenu("Help");
        helpMenu.setMnemonic(KeyEvent.VK_H);
        
        JMenuItem aboutItem = new JMenuItem("About", KeyEvent.VK_A);
        aboutItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
        aboutItem.addActionListener(e -> JOptionPane.showMessageDialog(this, 
            "Fraction Calculator\nCreated by Xander Warchulski", "About", JOptionPane.INFORMATION_MESSAGE));
        helpMenu.add(aboutItem);
        
        //adding the menus to the menu bar and the menu bar to the frame
        menuBar.add(fileMenu);
        menuBar.add(operationsMenu);
        menuBar.add(helpMenu);
        
        setJMenuBar(menuBar);
    }
    
    //function referred to by the Build Fraction button
    private void buildFraction() 
    {
        try 
        {
        	//removes trailing and leading spaces from the num and den variables
            String numText = txtNumField.getText().trim();
            String denText = txtDenField.getText().trim();
            
            //if either variable is empty or too large, throw their respective exceptions
            if (numText.isEmpty() || denText.isEmpty()) 
            {
                throw new EmptyOperandException("Numerator or denominator is empty.");
            }
            
            if (numText.length() > 10 || denText.length() > 10) 
            {
                throw new LongOperandException("Operand exceeds 10 characters.");
            }

            int num = Integer.parseInt(numText);
            int den = Integer.parseInt(denText);

            Fraction fraction = new Fraction(num, den);
            fractions.add(fraction);
            txtFractionArea.append(fraction + "\n");

            txtNumField.setText("");
            txtDenField.setText("");
        }
        
        //catch to display an option pane depending on the exception caught
        catch (EmptyOperandException | LongOperandException | DivisionByZeroException e) 
        {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        //additional catch for input validation
        catch (NumberFormatException e) 
        {
            JOptionPane.showMessageDialog(this, "Only integer values are allowed.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    //function referred to by the combo box operations
    private void performOperation() 
    {
    	//if the user hasn't built a fraction yet, display an error message forbidding operation access
        if (fractions.isEmpty()) 
        {
            
            if (!txtNumField.getText().isEmpty() || !txtDenField.getText().isEmpty()) 
            {
                JOptionPane.showMessageDialog(this, 
                    "Please build a fraction first.", 
                    "Error", 
                    JOptionPane.ERROR_MESSAGE);
            }
            return;
        }
        
        //cast combo-box selection to string for switch cases and get last fraction in the arrayList
        String operation = (String) cmbOperations.getSelectedItem();
        Fraction last = fractions.get(fractions.size() - 1);

        try 
        {
        	//switch case to call Fraction class methods on the last available fraction
            switch (operation) 
            {
                case "Decimal":
                    txtOperationArea.append(last + " as decimal: " + last.toDecimal() + "\n");
                    break;
                case "Reciprocal":
                    txtOperationArea.append("Reciprocal of " + last + ": " + last.toReciprocal() + "\n");
                    break;
                case "Lowest Terms":
                    Fraction reduced = last.lowestTerms();
                    txtOperationArea.append(last + " in lowest terms: " + reduced + "\n");
                    break;
                    
                //additional cases for binary operations that retrieves the last TWO fractions in the arrayList    
                //and displays an error if there aren't two available
                case "Add":
                case "Multiply":
                case "Equals":
                case "Greater Than":
                    if (fractions.size() < 2) 
                    {
                        JOptionPane.showMessageDialog(this, "Need two fractions for this operation.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    Fraction secondLast = fractions.get(fractions.size() - 2);
                    switch (operation) 
                    {
                        case "Add":
                            txtOperationArea.append(secondLast + " + " + last + " = " + secondLast.add(last) + "\n");
                            break;
                        case "Multiply":
                            txtOperationArea.append(secondLast + " * " + last + " = " + secondLast.multiply(last) + "\n");
                            break;
                        case "Equals":
                            txtOperationArea.append(secondLast + " == " + last + ": " + secondLast.equals(last) + "\n");
                            break;
                        case "Greater Than":
                            txtOperationArea.append(secondLast + " > " + last + ": " + secondLast.greaterThan(last) + "\n");
                            break;
                    }
                    break;
                    
                //final case for sorting the fractions in the arrayList    
                case "Sort":
                    fractions.sort(Fraction::compareTo);
                    txtFractionArea.setText("Sorted fractions:\n");
                    for (Fraction f : fractions) 
                    {
                        txtFractionArea.append(f + "\n");
                    }
                    txtOperationArea.append("Fractions sorted.\n");
                    break;
            }
        } 
        
        catch (DivisionByZeroException e) 
        {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    //function referred to by the 'Start Over' button
    private void startOver() 
    {
    	//reset the GUI components and variables
        fractions.clear();
        txtFractionArea.setText("Here is your fraction:\n");
        txtOperationArea.setText("Here is your operation:\n");
        txtNumField.setText("");
        txtDenField.setText("");
        cmbOperations.setSelectedIndex(0);
    }
    
    //instantiate and display the Frame when the program starts
    public static void main(String[] args) 
    {
            FractionCalculator frame = new FractionCalculator();
            frame.setVisible(true);
    }
}