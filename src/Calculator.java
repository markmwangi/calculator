/*	
	Simple calculator. Add, subtract, multiply and divide.
	04/08/2018
	@author Mark Mwangi 
*/
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import javax.swing.*;
import javax.swing.border.*;

public class Calculator implements ActionListener {
	private  boolean check = false;
	private JButton [] buttonArray;
	private JTextField text;
	private String[] numbersArray;
	private String textString, buttonChecker;
	private double n1, n2;
	private DecimalFormat formatOne;
	private Color plusColor, minusColor, multiplyColor, divideColor,  equalColor;
	private Border buttonBorder1, buttonBorder2, buttonBorder3, buttonBorder4, buttonBorder5, buttonBorder6;
	private JPanel panel1, panel2, panel3, panel4, panel5, panel6;
	
	//Main method
	public static void main(String[] args){
		Calculator cal = new Calculator();
		cal.layout();
	}

	//UI Manager
	private void layout(){
		JFrame calcFrame = new JFrame("Calculator");
		calcFrame.getContentPane().setBackground(Color.DARK_GRAY);
		calcFrame.setSize(265,400);
		calcFrame.setLayout(new FlowLayout());
		calcFrame.setResizable(false);
		calcFrame.setLocationRelativeTo(null);
		calcFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		calcFrame.setLayout(new GridLayout(6,1));

		//Creating and setting layouts for panels that will store buttons and textfield
		panel1 = new JPanel();
		panel1.setLayout(new GridLayout(1,1));
		panel1.setBackground(Color.DARK_GRAY);
		panel2 = new JPanel();
		panel2.setLayout(new GridLayout(1,4));
		panel2.setBackground(Color.DARK_GRAY);
		panel3 = new JPanel();
		panel3.setLayout(new GridLayout(1,4));
		panel3.setBackground(Color.DARK_GRAY);
		panel4 = new JPanel();
		panel4.setLayout(new GridLayout(1,4));
		panel4.setBackground(Color.DARK_GRAY);
		panel5 = new JPanel();
		panel5.setLayout(new GridLayout(1,4));
		panel5.setBackground(Color.DARK_GRAY);
		panel6 = new JPanel();
		panel6.setLayout(new GridLayout(1,4));
		panel6.setBackground(Color.DARK_GRAY);

		plusColor = new Color(255,102,102);
		minusColor = new Color(255,90,90);
		multiplyColor =  new Color(255,80,80);
		divideColor = new Color(255,70,70);
		equalColor = new Color(255,60,60);
		
		buttonBorder1 = new LineBorder(plusColor, 1, true);
		buttonBorder2 = new LineBorder(minusColor, 1, true);
		buttonBorder3 = new LineBorder(multiplyColor, 1, true);
		buttonBorder4 = new LineBorder(divideColor, 1, true);
		buttonBorder5 = new LineBorder(equalColor, 1, true);
		buttonBorder6 = new LineBorder(Color.DARK_GRAY, 1, true);
		
		text = new JTextField("0");
		text.setBackground(Color.DARK_GRAY);
		text.setForeground(Color.WHITE);
		text.setBorder(buttonBorder6);
		text.setEditable(false);
		text.setFont(new Font("Sansserrif", Font.PLAIN, 18));
		panel1.add(text);
		
		String[] buttonList = {"","\u00b1","\u232b","CE","+","7","8","9","\u2212","4","5","6","\u00d7","1","2","3","\u00F7","","0",".","="};
		buttonArray = new JButton[buttonList.length];
		
		Font buttonFont = new Font("Monospaced", Font.PLAIN, 23);
		//adding buttons to panels
		for(int i = 0; i < buttonList.length; i++){
			buttonChecker = (String)buttonList[i];
			if(i <= 4 && i > 0) {
				if(buttonChecker.equals("+")) {
					buttonArray[i] = new JButton(buttonList[i]);
					buttonArray[i].setBackground(plusColor);
					buttonArray[i].setForeground(Color.WHITE);
					buttonArray[i].setFont(buttonFont);
					buttonArray[i].setBorder(buttonBorder1);
					buttonArray[i].addActionListener(this);
					panel2.add(buttonArray[i]);
				}
				else {
					buttonArray[i] = new JButton(buttonList[i]);
					buttonArray[i].setBackground(Color.DARK_GRAY);
					buttonArray[i].setForeground(Color.WHITE);
					buttonArray[i].setFont(buttonFont);
					buttonArray[i].setBorder(buttonBorder6);
					buttonArray[i].addActionListener(this);
					panel2.add(buttonArray[i]);
				}
			}
			if(i > 4 && i <= 8) {
				if(buttonChecker.equals("\u2212")) {
					buttonArray[i] = new JButton(buttonList[i]);
					buttonArray[i].setBackground(minusColor);
					buttonArray[i].setForeground(Color.WHITE);
					buttonArray[i].setFont(buttonFont);
					buttonArray[i].setBorder(buttonBorder2);
					buttonArray[i].addActionListener(this);
					panel3.add(buttonArray[i]);
				}
				else {
					buttonArray[i] = new JButton(buttonList[i]);
					buttonArray[i].setBackground(Color.DARK_GRAY);
					buttonArray[i].setForeground(Color.WHITE);
					buttonArray[i].setFont(buttonFont);
					buttonArray[i].setBorder(buttonBorder6);
					buttonArray[i].addActionListener(this);
					panel3.add(buttonArray[i]);
				}
			}
			if(i > 8 && i <= 12) {
				if( buttonChecker.equals("\u00d7")) {
					buttonArray[i] = new JButton(buttonList[i]);
					buttonArray[i].setBackground(multiplyColor);
					buttonArray[i].setForeground(Color.WHITE);
					buttonArray[i].setFont(buttonFont);
					buttonArray[i].setBorder(buttonBorder3);
					buttonArray[i].addActionListener(this);
					panel4.add(buttonArray[i]);
				}
				else {
					buttonArray[i] = new JButton(buttonList[i]);
					buttonArray[i].setBackground(Color.DARK_GRAY);
					buttonArray[i].setForeground(Color.WHITE);
					buttonArray[i].setFont(buttonFont);
					buttonArray[i].setBorder(buttonBorder6);
					buttonArray[i].addActionListener(this);
					panel4.add(buttonArray[i]);
				}
			}
			if(i > 12 && i <= 16) {
				if( buttonChecker.equals("\u00F7")) {
					buttonArray[i] = new JButton(buttonList[i]);
					buttonArray[i].setBackground(divideColor);
					buttonArray[i].setForeground(Color.WHITE);
					buttonArray[i].setFont(buttonFont);
					buttonArray[i].setBorder(buttonBorder4);
					buttonArray[i].addActionListener(this);
					panel5.add(buttonArray[i]);
				}
				else {
					buttonArray[i] = new JButton(buttonList[i]);
					buttonArray[i].setBackground(Color.DARK_GRAY);
					buttonArray[i].setForeground(Color.WHITE);
					buttonArray[i].setFont(buttonFont);
					buttonArray[i].setBorder(buttonBorder6);
					buttonArray[i].addActionListener(this);
					panel5.add(buttonArray[i]);
				}
			}
			
			if(i > 16 && i <= buttonList.length){
				if( buttonChecker.equals("=")) {
					buttonArray[i] = new JButton(buttonList[i]);
					buttonArray[i].setBackground(equalColor);
					buttonArray[i].setForeground(Color.WHITE);
					buttonArray[i].setFont(buttonFont);
					buttonArray[i].setBorder(buttonBorder5);
					buttonArray[i].addActionListener(this);
					panel6.add(buttonArray[i]);
				}
				else {
					buttonArray[i] = new JButton(buttonList[i]);
					buttonArray[i].setBackground(Color.DARK_GRAY);
					buttonArray[i].setForeground(Color.WHITE);
					buttonArray[i].setFont(buttonFont);
					buttonArray[i].setBorder(buttonBorder6);
					buttonArray[i].addActionListener(this);
					panel6.add(buttonArray[i]);
				}
			}
			
		}
		//button 17 is set to not clickable  
		buttonArray[17].setEnabled(false);
		
		//adding panels to frame
		calcFrame.add(panel1);
		calcFrame.add(panel2);
		calcFrame.add(panel3);
		calcFrame.add(panel4);
		calcFrame.add(panel5);
		calcFrame.add(panel6);
		calcFrame.setVisible(true);
	}
	
	//actionListener manager
	public void actionPerformed(ActionEvent e){
		char[] textArray; 
		String temp = "";
		if(text.getText().equals("0") || text.getText().equals("ERROR")) {
			text.setText("");
		}
		//positive/negative button
		try {
			if(e.getSource() == buttonArray[1]) {
				formatOne = new DecimalFormat("0.#######");
				if(check == true){
					textString  = text.getText();
					numbersArray = textString.split("[\\+, \u2212, \u00d7 \u00f7]");
					n1 = Double.parseDouble(numbersArray[0]);
					n2 = Double.parseDouble(numbersArray[1]);
					if(textString.contains("+")){
						n2 *= -1;
						text.setText(formatOne.format(n1) + "+" + formatOne.format(n2));
					}
					if(textString.contains("\u2212")){
						n2 *= -1;
						text.setText(formatOne.format(n1) + "\u2212" + formatOne.format(n2));
					}
					if(textString.contains("\u00d7")){
						n2 *= -1;
						text.setText(formatOne.format(n1) + "\u00d7" + formatOne.format(n2));
					}
					if(textString.contains("\u00f7")){
						n2 *= -1;
						text.setText(formatOne.format(n1) + "\u00f7" + formatOne.format(n2));
					}
				}
				else {
					n1 = (Double.parseDouble(text.getText())*-1);
					text.setText(formatOne.format(n1));
				}
			}
		}
		catch(Exception exc) {
			System.out.println(exc);
		}
		//delete button
		if(e.getSource() == buttonArray[2]){
				textArray = text.getText().toCharArray();
				for(int j = 0; j < textArray.length - 1; j++){
					temp += textArray[j]; 	
				}
				text.setText(temp);
				if((text.getText().contains("+") || text.getText().contains("\u2212") || text.getText().contains("\u00d7") || text.getText().contains("\u00F7")) == false)
					check = false;
			}
			
		//clear button
		if(e.getSource() == buttonArray[3]){
			text.setText("0");
			check = false;
		}
		//9 button
		if(e.getSource() == buttonArray[7]){
			temp = (text.getText() + "9");
			text.setText(temp);
		}
		//8 button
		if(e.getSource() == buttonArray[6]){
			temp = (text.getText() + "8");
			text.setText(temp);
		}
		//plus button
		if(e.getSource() == buttonArray[4]){
			if(check == false && text.getText().equals("")){
				check = true;
				text.setText("0" + "+");
			}
			else if(check == false){
				check = true;
				temp = (text.getText() + "+");
				text.setText(temp);
			}
		}
		//7 button
		if(e.getSource() == buttonArray[5]){
			temp = (text.getText() + "7");
			text.setText(temp);
		}
		//6 button
		if(e.getSource() == buttonArray[11]){
			temp = (text.getText() + "6");
			text.setText(temp);
		}
		//minus button
		if(e.getSource() == buttonArray[8]){
			if(check == false && text.getText().equals("")){
				check = true;
				temp = ("0" + "\u2212");
				text.setText(temp);
			}
			else if(check == false){
				check = true;
				temp = (text.getText() + "\u2212");
				text.setText(temp);
			}
		}
		//5 button
		if(e.getSource() == buttonArray[10]){
			temp = (text.getText() + "5");
			text.setText(temp);
		}
		//4 button
		if(e.getSource() == buttonArray[9]){
			temp = (text.getText() + "4");
			text.setText(temp);
		}
		//multiply button
		if(e.getSource() == buttonArray[12] && text.getText().equals("")){
			if(check == false){
				check = true;
				temp = ("0" + "\u00d7");
				text.setText(temp);
			}
		}
		else if(e.getSource() == buttonArray[12]){
			if(check == false){
				check = true;
				temp = (text.getText() + "\u00d7");
				text.setText(temp);
			}
		}
		//3 button
		if(e.getSource() == buttonArray[15]){
			temp = (text.getText() + "3");
			text.setText(temp);
		}
		//2 button
		if(e.getSource() == buttonArray[14]){
			temp = (text.getText() + "2");
			text.setText(temp);
		}
		//divide button
		if(e.getSource() == buttonArray[16]){
			if(check == false && text.getText().equals("")){
				check = true;
				temp = ("0" + "\u00F7");
				text.setText(temp);
			}
			else if(check == false){
				check = true;
				temp = (text.getText() + "\u00F7");
				text.setText(temp);
			}
		}
			
		//1 button
		if(e.getSource() == buttonArray[13]){
			temp = (text.getText() + "1");
			text.setText(temp);
		}
		//0 button
		if(e.getSource() == buttonArray[18]){
			temp = (text.getText() + "0");
			text.setText(temp);
		}
		//decimal button
		if(e.getSource() == buttonArray[19])
		{
			if(check == false && !text.getText().contains(".")) {
			temp = (text.getText() + ".");
			text.setText(temp);
			}
			else if(check == true) {
				textString = text.getText();
				numbersArray = textString.split("[\\+, \u2212, \u00d7 \u00f7]");
				try {
					if(!numbersArray[1].contains(".")) {
						temp = (text.getText() + ".");
						text.setText(temp);	
					}
				}
				catch(Exception exc) {
					text.setText(text.getText() + ".");
				}
			}
		}
		//equals
		if(e.getSource() == buttonArray[20]){
			if(check == true){
				formatOne = new DecimalFormat("0.#######");
				textString  = text.getText();
				numbersArray = textString.split("[\\+, \u2212, \u00d7 \u00f7]");
				n1 = Double.parseDouble(numbersArray[0]);
				n2 = Double.parseDouble(numbersArray[1]);
				if(textString.contains("+")){
					check = false;
					text.setText(formatOne.format(n1+n2));
				}
				if(textString.contains("\u2212")){
					check = false;
					text.setText(formatOne.format(n1-n2));
				}
				if(textString.contains("\u00d7")){
					check = false;
					text.setText(formatOne.format((n1*n2) + 0 ));
					 
				}
				if(textString.contains("\u00f7")){
					if(n2 == 0){
						check = false;
						text.setText("ERROR");
					}
					else{
					check = false;
					text.setText(formatOne.format((n1/n2) + 0));
					}
				}
			}
		}	
	}
}
