/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.CalculatorModel;
import view.CalculatorView;

/**
 *
 * @author vtamin154
 */
public class CalculatorController {

    private CalculatorView theView;
    private CalculatorModel theModel;

    public CalculatorController(CalculatorView theView, CalculatorModel theModel) {
        this.theView = theView;
        this.theModel = theModel;
        for(int i =0;i<9;i++) {
			theView.getFunctionButtons(i).addActionListener(new CalculateListener());
			theView.getFunctionButtons(i).setFont(theView.getMyFont());
			theView.getFunctionButtons(i).setFocusable(false);
		}
		
		for(int i =0;i<10;i++) {
			theView.getNumberButtons(i).addActionListener(new CalculateListener());
			theView.getNumberButtons(i).setFont(theView.getMyFont());
			theView.getNumberButtons(i).setFocusable(false);
		}
        
    }

    class CalculateListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            for (int i = 0; i < 10; i++) {
                if (e.getSource() == theView.getNumberButtons(i)) {
                    theView.setTextfield(theView.getTextfield().concat(String.valueOf(i)));
                }
            }
            if (e.getSource() == theView.getDecButton()) {
                theView.setTextfield(theView.getTextfield().concat("."));
            }
            if (e.getSource() == theView.getAddButton()) {
                theModel.setNum1(Double.parseDouble(theView.getTextfield()));
//                System.out.println("+");
                theModel.setOperator('+');
                theView.setTextfield("");
            }
            if (e.getSource() == theView.getSubButton()) {
                theModel.setNum1(Double.parseDouble(theView.getTextfield()));
                theModel.setOperator('-');
                theView.setTextfield("");
            }
            if (e.getSource() == theView.getMulButton()) {
                theModel.setNum1(Double.parseDouble(theView.getTextfield()));
                theModel.setOperator('*');
                theView.setTextfield("");
            }
            if (e.getSource() == theView.getDivButton()) {
                theModel.setNum1(Double.parseDouble(theView.getTextfield()));
                theModel.setOperator('/');
                theView.setTextfield("");
            }
            if (e.getSource() == theView.getEquButton()) {
                theModel.setNum2(Double.parseDouble(theView.getTextfield()));

                switch (theModel.getOperator()) {
                    case '+':
//                      theModel.setResult(theModel.getNum1() + theModel.getNum2());
                        theModel.calculate('+');
                        break;
                    case '-':
//                        theModel.setResult(theModel.getNum1() - theModel.getNum2());
                        theModel.calculate('-');
                        break;
                    case '*':
//                        theModel.setResult(theModel.getNum1() * theModel.getNum2());
                        theModel.calculate('*');
                        break;
                    case '/':
//                        theModel.setResult(theModel.getNum1() / theModel.getNum2());
                        theModel.calculate('/');
                        break;
                }
                theView.setTextfield(String.valueOf(theModel.getResult()));
                theModel.setNum1(theModel.getResult());
            }
            if (e.getSource() == theView.getClrButton()) {
                theView.setTextfield("");
            }
            if (e.getSource() == theView.getDelButton()) {
                String string = theView.getTextfield();
                theView.setTextfield("");
                for (int i = 0; i < string.length() - 1; i++) {
                    theView.setTextfield(theView.getTextfield() + string.charAt(i));
                }
            }
            if (e.getSource() == theView.getNegButton()) {
                double temp = Double.parseDouble(theView.getTextfield());
                temp *= -1;
                theView.setTextfield(String.valueOf(temp));
            }
        }

    }
}
