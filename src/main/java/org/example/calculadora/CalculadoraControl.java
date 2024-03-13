package org.example.calculadora;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class CalculadoraControl {

    @FXML
    private TextField resultado;

    double[] numeros = new double[3];
    int[] nondec = new int[2];
    String[] dec = new String[2];
    String operando;
    boolean igual;
    int i = 0;
    boolean decimal=false;

    public void aniadir(String num){
        resultado.appendText(String.valueOf(num));
    }
    @FXML
    void onBoton0(ActionEvent event) {
        aniadir("0");
    }

    @FXML
    void onBoton1(ActionEvent event) {
        aniadir("1");
    }

    @FXML
    void onBoton2(ActionEvent event) {
        aniadir("2");
    }

    @FXML
    void onBoton3(ActionEvent event) {
        aniadir("3");
    }

    @FXML
    void onBoton4(ActionEvent event) {
        aniadir("4");
    }

    @FXML
    void onBoton5(ActionEvent event) {
        aniadir("5");
    }

    @FXML
    void onBoton6(ActionEvent event) {
        aniadir("6");
    }

    @FXML
    void onBoton7(ActionEvent event) {
        aniadir("7");
    }

    @FXML
    void onBoton8(ActionEvent event) {
        aniadir("8");
    }

    @FXML
    void onBoton9(ActionEvent event) {
        aniadir("9");
    }

    @FXML
    void onBotonBorrar(ActionEvent event) {
        String aux = resultado.getText();
        aux = aux.substring(0, aux.length()-1);
        resultado.setText(aux);
    }

    @FXML
    void onBotonDecimal(ActionEvent event) {
        aniadir(".");
    }

    @FXML
    void onDivision(ActionEvent event) {
        numeros[i]=Double.parseDouble(resultado.getText());
        operando = "/";
        aniadir("/");
        cambiar_numero();
    }

    @FXML
    void onIgual(ActionEvent event) {
        boolean resExiste = true;
        int long_num1 = (String.valueOf(numeros[0]).length());
        String aux = resultado.getText().substring(long_num1);
        numeros[1] = Double.parseDouble(aux);
        switch (operando){
            case "+":
                numeros[2] = numeros[0] + numeros[1];
                break;
            case "^":
                numeros[2] = Math.pow(numeros[0], numeros[1]);
                break;
            case "-":
                numeros[2] = numeros[0] - numeros[1];
                break;
            case "/":
                numeros[2] = numeros[0] / numeros[1];
                break;
            case "×":
                numeros[2] = numeros[0] * numeros[1];
                break;
            case "√":
                numeros[2] = (int) Math.pow(numeros[1], ((double) 1 /numeros[0]));
                break;
            case null:
                resExiste = false;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + operando);
        }
        if(resExiste){
            resultado.appendText("\n" + numeros[3]);
        } else {
            resultado.setText("Falta Operador");
        }
    }

    @FXML
    void onMultiplicacion(ActionEvent event) {
        operando=("×");
        numeros[i]=Double.parseDouble(resultado.getText());
        aniadir("×");
        cambiar_numero();
    }

    @FXML
    void onPotencia(ActionEvent event) {
        operando=("^");
        numeros[i]=Double.parseDouble(resultado.getText());
        aniadir("^");
        cambiar_numero();
    }

    @FXML
    void onRaiz(ActionEvent event) {
        operando=("√");
        numeros[i]=Double.parseDouble(resultado.getText());
        aniadir("√");
        cambiar_numero();
    }

    @FXML
    void onRestar(ActionEvent event) {
        operando=("-");
        numeros[i]=Double.parseDouble(resultado.getText());
        aniadir("-");
        cambiar_numero();
    }

    @FXML
    void onSumar(ActionEvent event) {
        operando=("+");
        numeros[i]=Double.parseDouble(resultado.getText());
        aniadir("+");
        cambiar_numero();
    }
    void cambiar_numero(){
        if(i==0){
            i=1;
        } else {
            i=0;
        }
    }
}