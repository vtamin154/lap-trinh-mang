package main;

import controller.CalculatorController;
import model.CalculatorModel;
import view.CalculatorView;


/**
 *
 * @author vtamin154
 */
public class Calculator {
        public static void main(String[] args) {
    	
    	CalculatorView theView = new CalculatorView();
        
    	CalculatorModel theModel = new CalculatorModel();
        
        CalculatorController theController = new CalculatorController(theView,theModel);
        
        theView.setVisible(true);
        
    }
}

