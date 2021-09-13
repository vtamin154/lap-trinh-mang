/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author vtamin154
 */
public class CalculatorModel {
    	private double num1=0,num2=0,result=0;
	private char operator;

    public CalculatorModel() {
    }

    public double getNum1() {
        return num1;
    }

    public void setNum1(double num1) {
        this.num1 = num1;
    }

    public double getNum2() {
        return num2;
    }

    public void setNum2(double num2) {
        this.num2 = num2;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public char getOperator() {
        return operator;
    }

    public void setOperator(char operator) {
        this.operator = operator;
    }
    public void calculate(char operator){
        switch(operator){
            case '+':
                this.result = this.num1+this.num2;
                setResult(result);
                break;
            case '-':
                this.result = this.num1-this.num2;
                setResult(result);
                break;
            case '*':
                this.result = this.num1*this.num2;
                setResult(result);
                break;
            case '/':
                this.result = this.num1/this.num2;
                setResult(result);
                break;
        }
    }
    
}
