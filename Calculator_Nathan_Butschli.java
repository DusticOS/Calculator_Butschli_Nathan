/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator_nathan_butschli;

//import necessary libraries
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

//declare class
public class Calculator_Nathan_Butschli extends JFrame
{
    //create fields neccesary for building the GUI
    // panel, calcButtons, and executeBtn are panels where the textfield, numpad, and execute/clear buttons, respectively are stored
    //numBtns is an array where the numkeys are stored
    //the remaining buttons are for the operators
    //tfDisplay holds the textfield that displays both the user's calculation and the result
    //the remaining fields hold the window size
    private JPanel panel;
    private JPanel calcButtons;
    private JPanel executeBtn;
    private JButton[] numBtns;
    private JButton plusBtn, minusBtn, mltBtn, divBtn, expBtn, openBtn, closBtn, eqlBtn, clrBtn;
    private JTextField tfDisplay;
    private final int WINDOW_WIDTH = 300;
    private final int WINDOW_HEIGHT = 300;
    
    private enum OPERATOR
    {
        ADD(0), SUBTRACT(0), MULTIPLY(1), DIVIDE(1), EXPONENT(2);
        final int priority;
        OPERATOR(int p)
        {
            priority = p;
        }
    }

    
    //constructor, calls the method that builds the panel
    //sets the window's title and size, allows the close key to function, and makes the window visible
    public Calculator_Nathan_Butschli()
    {
        buildPanel();
        add(calcButtons);
        setTitle("Calculator");
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    //buildPanel builds the Panel
    private void buildPanel()
    {
        //creates the text field panel, sets the layout to flow as well as its size
        panel = new JPanel();
        panel.setLayout(new FlowLayout());
        tfDisplay = new JTextField(24);
        //tfResult = new JTextField(24);
        panel.add(tfDisplay);
        //panel.add(tfResult);
        
        
        //adds the numpad, I did not use a loop because I added the operator
        //buttons at regular increments between the numbers, so that they make
        //up a column on the right hand size
        calcButtons = new JPanel();
        calcButtons.setLayout(new GridLayout(5, 4));
        numBtns = new JButton[10];
        plusBtn = new JButton("+");
        plusBtn.addActionListener(new ButtonListener());
        calcButtons.add(plusBtn);
        numBtns[0] = new JButton("0");
        numBtns[0].addActionListener(new ButtonListener());
        numBtns[1] = new JButton("1");
        numBtns[1].addActionListener(new ButtonListener());
        calcButtons.add(numBtns[1]);
        numBtns[2] = new JButton("2");
        numBtns[2].addActionListener(new ButtonListener());
        calcButtons.add(numBtns[2]);
        numBtns[3] = new JButton("3");
        numBtns[3].addActionListener(new ButtonListener());
        calcButtons.add(numBtns[3]);
        minusBtn = new JButton("-");
        minusBtn.addActionListener(new ButtonListener());
        calcButtons.add(minusBtn);
        numBtns[4] = new JButton("4");
        numBtns[4].addActionListener(new ButtonListener());
        calcButtons.add(numBtns[4]);
        numBtns[5] = new JButton("5");
        numBtns[5].addActionListener(new ButtonListener());
        calcButtons.add(numBtns[5]);
        numBtns[6] = new JButton("6");
        numBtns[6].addActionListener(new ButtonListener());
        calcButtons.add(numBtns[6]);
        mltBtn = new JButton("*");
        mltBtn.addActionListener(new ButtonListener());
        calcButtons.add(mltBtn);
        numBtns[7] = new JButton("7");
        numBtns[7].addActionListener(new ButtonListener());
        calcButtons.add(numBtns[7]);
        numBtns[8] = new JButton("8");
        numBtns[8].addActionListener(new ButtonListener());
        calcButtons.add(numBtns[8]);
        numBtns[9] = new JButton("9");
        numBtns[9].addActionListener(new ButtonListener());
        calcButtons.add(numBtns[9]);        
        divBtn = new JButton("/");
        divBtn.addActionListener(new ButtonListener());
        calcButtons.add(divBtn); 
        openBtn = new JButton("(");
        openBtn.addActionListener(new ButtonListener());
        calcButtons.add(openBtn);
        closBtn = new JButton(")");
        closBtn.addActionListener(new ButtonListener());
        calcButtons.add(closBtn);
        calcButtons.add(numBtns[0]);
        expBtn = new JButton("^");
        expBtn.addActionListener(new ButtonListener());
        calcButtons.add(expBtn);
        eqlBtn = new JButton("=");
        eqlBtn.addActionListener(new ButtonListener());
        calcButtons.add(eqlBtn);      
        clrBtn = new JButton("AC");
        clrBtn.addActionListener(new ButtonListener());
        calcButtons.add(clrBtn);
        
        //executeBtn = new JPanel();
        //executeBtn.setLayout(new GridLayout(1,2));
          
          
        
        
        //adds the panel for the execute and clear keys
        setLayout(new BorderLayout());
        add(panel, BorderLayout.NORTH);
        add(calcButtons, BorderLayout.CENTER);
        //add(executeBtn, BorderLayout.SOUTH);
    }
    
    
    //action listener
    private class ButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            //if statement that determines which keys were pressed
            //if execute was pressed, call the reverse polish notation method
            //and display the result in the text field
            String btnLabel = e.getActionCommand();
            if(btnLabel == "=")
            {   
                //tfDisplay.setText(Double.toString(rpnCalc(shuntYard(tfDisplay.getText()))));
                String[] exprData = new String[tfDisplay.getText().length()];
            }
            //if clear was pressed, set the text field to empty
            else if(btnLabel == "AC")
            {
                tfDisplay.setText("");
            }
            //if any other button was pressed, append it to the end of whatever
            //is currently in the text field
            else
            {
                tfDisplay.setText(tfDisplay.getText() + btnLabel);
            }
        }
    }
    
    public double rpnCalc(String expr)
    {
        
        double res = 0;
        return res;
    }
    public String shuntYard(String expr)
    {
        Queue<Character> opq = new LinkedList<Character>();
        Deque<Character> stack = new ArrayDeque<Character>();
        for(int i = 0; i < expr.length(); i++)
        {
            if(Character.isDigit(expr.charAt(i)))
            {
                opq.add(expr.charAt(i));
            }
            else if(isOperator(expr.charAt(i)))
            {
                while(isOperator(stack.peek()))
                {
                    
                }
            }
        }
        String rPN = "";
        return rPN;
    }
    public boolean isOperator(Character val)
    {
        return (val.equals("+") || val.equals("-") || val.equals("*") || val.equals("/"));
    }
    //hey look it's the main method
    public static void main(String[] args)
    {
        //call the calculator
        Calculator_Nathan_Butschli test = new Calculator_Nathan_Butschli();
    }
}
