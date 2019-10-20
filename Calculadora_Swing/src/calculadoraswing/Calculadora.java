/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadoraswing;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 *
 * @author Usuario DAM 2
 */
public class Calculadora extends JFrame implements ActionListener {

    Container container;
    JPanel panelSuperior, panelInferior, panelCentral;
    JPanel panelDerecha;
    TextField texto;
    JButton estandar, cientifica;
    JButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9;
    JButton bSen, bCos, bTan, bLog, bLn;
    JButton ac, masMenos, bPorcentaje, bDivision, bMultiplicacion, bResta, bSuma, bIgual, bVacio, bPunto;
    boolean operando = false;
    Double op1 = 0.0,
            op2 = 0.0;
    int tipoOperacion;
    Double resultado = 0.0;

    public void initGUI() {
        this.setTitle("Calculadora");
        this.setBounds(50, 50, 500, 500);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        instancias();
        configurarContainer();
        acciones();
        pack();
    }

    private void instancias() {
        //Container
        container = this.getContentPane();
        //JPanels
        panelCentral = new JPanel();
        panelInferior = new JPanel();
        panelSuperior = new JPanel();
        panelDerecha = new JPanel();
        //TextField
        texto = new TextField();
        //Botones
        b0 = new JButton("0");
        b0.setActionCommand(Constantes.BTN_b0);
        b1 = new JButton("1");
        b1.setActionCommand(Constantes.BTN_b1);
        b2 = new JButton("2");
        b2.setActionCommand(Constantes.BTN_b2);
        b3 = new JButton("3");
        b3.setActionCommand(Constantes.BTN_b3);
        b4 = new JButton("4");
        b4.setActionCommand(Constantes.BTN_b4);
        b5 = new JButton("5");
        b5.setActionCommand(Constantes.BTN_b5);
        b6 = new JButton("6");
        b6.setActionCommand(Constantes.BTN_b6);
        b7 = new JButton("7");
        b7.setActionCommand(Constantes.BTN_b7);
        b8 = new JButton("8");
        b8.setActionCommand(Constantes.BTN_b8);
        b9 = new JButton("9");
        b9.setActionCommand(Constantes.BTN_b9);

        bSuma = new JButton("+");
        bSuma.setActionCommand(Constantes.BTN_sum);
        bResta = new JButton("-");
        bResta.setActionCommand(Constantes.BTN_res);
        bMultiplicacion = new JButton("*");
        bMultiplicacion.setActionCommand(Constantes.BTN_mul);
        bDivision = new JButton("/");
        bDivision.setActionCommand(Constantes.BTN_div);

        estandar = new JButton("Estandar");
        estandar.setActionCommand(Constantes.BTN_est);
        cientifica = new JButton("Cientifica");
        cientifica.setActionCommand(Constantes.BTN_cie);
        ac = new JButton("AC");
        ac.setActionCommand(Constantes.BTN_AC);
        masMenos = new JButton("+/-");
        masMenos.setActionCommand(Constantes.BTN_MM);
        bPorcentaje = new JButton("%");
        bPorcentaje.setActionCommand(Constantes.BTN_por);

        bVacio = new JButton("");
        bVacio.setActionCommand(Constantes.BTN_vac);
        bPunto = new JButton(".");
        bPunto.setActionCommand(Constantes.BTN_dot);
        bIgual = new JButton("=");
        bIgual.setActionCommand(Constantes.BTN_igu);
        bSen = new JButton("sin");
        bSen.setActionCommand(Constantes.BTN_sen);
        bCos = new JButton("cos");
        bCos.setActionCommand(Constantes.BTN_cos);
        bTan = new JButton("tan");
        bTan.setActionCommand(Constantes.BTN_tan);
        bLog = new JButton("log");
        bLog.setActionCommand(Constantes.BTN_log);

    }

    private void configurarContainer() {
        container.setLayout(new BorderLayout());
        container.add(configSuperior(), BorderLayout.NORTH);
        container.add(configInferior(), BorderLayout.SOUTH);
        container.add(configCentral(), BorderLayout.CENTER);
    }

    private JPanel configSuperior() {
        panelSuperior.setLayout(new BorderLayout());
        panelSuperior.add(texto, BorderLayout.CENTER);

        return panelSuperior;
    }

    private JPanel configInferior() {
        panelInferior.add(estandar);
        panelInferior.add(cientifica);

        return panelInferior;
    }

    public JPanel configurarDerecha() {
        panelDerecha.setLayout(new GridLayout(4, 1));
        panelDerecha.add(bSen);
        panelDerecha.add(bCos);
        panelDerecha.add(bTan);
        panelDerecha.add(bLog);
        return panelDerecha;
    }

    private JPanel configCentral() {
        panelCentral.setLayout(new GridLayout(5, 4, 1, 1));
        panelCentral.add(ac);
        panelCentral.add(masMenos);
        panelCentral.add(bPorcentaje);
        panelCentral.add(bDivision);
        panelCentral.add(b7);
        panelCentral.add(b8);
        panelCentral.add(b9);
        panelCentral.add(bMultiplicacion);
        panelCentral.add(b4);
        panelCentral.add(b5);
        panelCentral.add(b6);
        panelCentral.add(bResta);
        panelCentral.add(b1);
        panelCentral.add(b2);
        panelCentral.add(b3);
        panelCentral.add(bSuma);
        panelCentral.add(b0);
        panelCentral.add(bVacio);
        panelCentral.add(bPunto);
        panelCentral.add(bIgual);

        return panelCentral;
    }

    private void acciones() {
        Component[] componentes = panelCentral.getComponents();
        for (Component item : componentes) {
            ((JButton) item).addActionListener(this);
        }

        Component[] componentes1 = panelInferior.getComponents();
        for (Component item : componentes1) {
            ((JButton) item).addActionListener(this);
        }

        Component[] componentes2 = panelDerecha.getComponents();
        for (Component item : componentes2) {
            ((JButton) item).addActionListener(this);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        switch (e.getActionCommand()) {
            case Constantes.BTN_b0:
                if (!operando) {
                    texto.setText(texto.getText() + "0");
                } else {
                    texto.setText("0");
                    operando = false;
                }
                break;
            case Constantes.BTN_b1:
                if (!operando) {
                    texto.setText(texto.getText() + "1");
                } else {
                    texto.setText("1");
                    operando = false;
                }
                break;
            case Constantes.BTN_b2:
                if (!operando) {
                    texto.setText(texto.getText() + "2");
                } else {
                    texto.setText("2");
                    operando = false;
                }
                break;
            case Constantes.BTN_b3:
                if (!operando) {
                    texto.setText(texto.getText() + "3");
                } else {
                    texto.setText("3");
                    operando = false;
                }
                break;
            case Constantes.BTN_b4:
                if (!operando) {
                    texto.setText(texto.getText() + "4");
                } else {
                    texto.setText("4");
                    operando = false;
                }
                break;
            case Constantes.BTN_b5:
                if (!operando) {
                    texto.setText(texto.getText() + "5");
                } else {
                    texto.setText("5");
                    operando = false;
                }
                break;
            case Constantes.BTN_b6:
                if (!operando) {
                    texto.setText(texto.getText() + "6");
                } else {
                    texto.setText("6");
                    operando = false;
                }
                break;
            case Constantes.BTN_b7:
                if (!operando) {
                    texto.setText(texto.getText() + "7");
                } else {
                    texto.setText("7");
                    operando = false;
                }
                break;
            case Constantes.BTN_b8:
                if (!operando) {
                    texto.setText(texto.getText() + "8");
                } else {
                    texto.setText("8");
                    operando = false;
                }
                break;
            case Constantes.BTN_b9:
                if (!operando) {
                    texto.setText(texto.getText() + "9");
                } else {
                    texto.setText("9");
                    operando = false;
                }
                break;
            case Constantes.BTN_AC:
                texto.setText("");
                op1 = 0.0;
                op2 = 0.0;
                tipoOperacion = 0;
                bPunto.setEnabled(true);
                break;
            case Constantes.BTN_cie:
                if (!panelDerecha.isShowing()) {
                    container.add(configurarDerecha(), BorderLayout.EAST);
                }
                pack();
                break;
            case Constantes.BTN_est:
                if (panelDerecha.isShowing()) {
                    container.remove(panelDerecha);
                }
                pack();
                break;
            case Constantes.BTN_div:
                if (texto.getText().isEmpty()) {
                    break;
                } else {
                    operando = true;
                    op1 = Double.valueOf(texto.getText());
                    bPunto.setEnabled(true);
                    tipoOperacion = 4;
                    break;
                }
            case Constantes.BTN_igu:
                if (texto.getText().isEmpty()) {
                    break;
                } else {
                    op2 = Double.valueOf(texto.getText());

                    switch (tipoOperacion) {
                        case 1:
                            resultado = op1 + op2;
                            break;
                        case 2:
                            resultado = op1 - op2;
                            break;
                        case 3:
                            resultado = op1 * op2;
                            break;
                        case 4:
                            resultado = op1 / op2;
                            break;
                        case 5:
                            resultado = (op1 / 100) * op2;
                            break;
                    }
                    texto.setText(Double.toString(resultado));
                    bPunto.setEnabled(false);
                    break;
                }
            case Constantes.BTN_MM:
                if (texto.getText().isEmpty()) {
                    break;
                } else {
                    Double num;
                    String cadena;
                    cadena = texto.getText();
                    num = (-1) * Double.valueOf(cadena);
                    texto.setText(num.toString());
                    break;
                }
            case Constantes.BTN_mul:
                if (texto.getText().isEmpty()) {
                    break;
                } else {
                    operando = true;
                    op1 = Double.valueOf(texto.getText());
                    bPunto.setEnabled(true);
                    tipoOperacion = 3;
                    break;
                }

            case Constantes.BTN_dot:
                if (texto.getText().isEmpty()) {
                    texto.setText("0.");
                    bPunto.setEnabled(false);
                    break;
                } else {
                    texto.setText(texto.getText() + ".");
                    bPunto.setEnabled(false);
                    break;
                }
            case Constantes.BTN_res:
                if (texto.getText().isEmpty()) {
                    break;
                } else {
                    operando = true;
                    op1 = Double.valueOf(texto.getText());
                    bPunto.setEnabled(true);
                    tipoOperacion = 2;
                    break;
                }
            case Constantes.BTN_sum:
                if (texto.getText().isEmpty()) {
                    break;
                } else {
                    operando = true;
                    op1 = Double.valueOf(texto.getText());
                    bPunto.setEnabled(true);
                    tipoOperacion = 1;
                    break;
                }
            case Constantes.BTN_por:
                if (texto.getText().isEmpty()) {
                    break;
                } else {
                    operando = true;
                    op1 = Double.valueOf(texto.getText());
                    bPunto.setEnabled(true);
                    tipoOperacion = 5;
                    break;
                }
            case Constantes.BTN_sen:
                if (texto.getText().isEmpty()) {
                    break;
                } else {
                    op1 = Double.valueOf(texto.getText());
                    op1 = Math.toRadians(op1);
                    op2 = op1;
                    resultado = Math.sin(op1);
                    texto.setText(Double.toString(resultado));
                    bPunto.setEnabled(false);
                    break;
                }
            case Constantes.BTN_cos:
                if (texto.getText().isEmpty()) {
                    break;
                } else {
                    op1 = Double.valueOf(texto.getText());
                    op1 = Math.toRadians(op1);
                    op2 = op1;
                    resultado = Math.cos(op1);
                    texto.setText(Double.toString(resultado));
                    bPunto.setEnabled(false);
                    break;
                }
            case Constantes.BTN_tan:
                if (texto.getText().isEmpty()) {
                    break;
                } else {
                    op1 = Double.valueOf(texto.getText());
                    op1 = Math.toRadians(op1);
                    op2 = op1;
                    resultado = Math.tan(op1);
                    texto.setText(Double.toString(resultado));
                    bPunto.setEnabled(false);
                    break;
                }
            case Constantes.BTN_log:
                if (texto.getText().isEmpty()) {
                    break;
                } else {
                    op1 = Double.valueOf(texto.getText());
                    op2 = op1;
                    resultado = Math.log10(op1);
                    texto.setText(Double.toString(resultado));
                    bPunto.setEnabled(false);
                    break;
                }

        }
    }

}
