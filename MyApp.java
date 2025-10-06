import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MyApp extends JFrame {
    private JTextField screen;   // pole tekstowe pełniące rolę wyświetlacza
    private JButton button_1 = new JButton("1");
    private JButton button_2 = new JButton("2");
    private JButton button_3 = new JButton("3");
    private JButton button_4 = new JButton("4");
    private JButton button_5 = new JButton("5");
    private JButton button_6 = new JButton("6");
    private JButton button_7 = new JButton("7");
    private JButton button_8 = new JButton("8");
    private JButton button_9 = new JButton("9");
    private JButton button_0 = new JButton("0");
    private JButton button_add = new JButton("+");
    private JButton button_substract = new JButton("-");
    private JButton button_divide = new JButton("/");
    private JButton button_multiply = new JButton("*");
    private JButton button_equal = new JButton("=");
    private JButton button_C = new JButton("C");
    private JButton button_backspace = new JButton("<-");

    private double firstNumber = 0;
    private String operator = "";

    public MyApp() {
      JPanel panel = new JPanel(new BorderLayout());
      screen = new JTextField(10);
      panel.add("North", screen);
      JPanel panelButtons = new JPanel(new GridLayout(5, 4)); 
        // menadżer rozkładu z 5 wierszami i czterema kolumnami


      button_9.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
              screen.setText(screen.getText() + "9");
          }
      });
      panelButtons.add(button_9);

      button_8.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
              screen.setText(screen.getText() + "8");
          }
      });
      panelButtons.add(button_8);

      button_7.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
              screen.setText(screen.getText() + "7");
          }
      });
      panelButtons.add(button_7);

      //dzielenie
      button_divide.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
              if (!screen.getText().equals("")) {
                  firstNumber = Double.parseDouble(screen.getText());
                  operator = "/";
                  screen.setText("");
              }
          }
      });
      panelButtons.add(button_divide);

      button_6.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
              screen.setText(screen.getText() + "6");
          }
      });
      panelButtons.add(button_6);

      button_5.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
              screen.setText(screen.getText() + "5");
          }
      });
      panelButtons.add(button_5);

      button_4.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
              screen.setText(screen.getText() + "4");
          }
      });
      panelButtons.add(button_4);

      //mnożenie
      button_multiply.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
              if (!screen.getText().equals("")) {
                  firstNumber = Double.parseDouble(screen.getText());
                  operator = "*";
                  screen.setText("");
              }
          }
      });
      panelButtons.add(button_multiply);

      button_3.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
              screen.setText(screen.getText() + "3");
          }
      });
      panelButtons.add(button_3);

      button_2.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
              screen.setText(screen.getText() + "2");
          }
      });
      panelButtons.add(button_2);

      button_1.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
              screen.setText(screen.getText() + "1");
          }
      });
      panelButtons.add(button_1);

      //odejmowanie
      button_substract.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
              if (!screen.getText().equals("")) {
                  firstNumber = Double.parseDouble(screen.getText());
                  operator = "-";
                  screen.setText("");
              }
          }
      });
      panelButtons.add(button_substract);

      // wyczyść
      button_C.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
              screen.setText("");
              firstNumber = 0;
              operator = "";
          }
      });
      panelButtons.add(button_C);

      button_0.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
              screen.setText(screen.getText() + "0");
          }
      });
      panelButtons.add(button_0);

      //backspace
      button_backspace.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
              String text = screen.getText();
              if (!text.isEmpty()) {
                  screen.setText(text.substring(0, text.length() - 1));
              }
          }
      });
      panelButtons.add(button_backspace);

      //dodawanie
      button_add.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
              if (!screen.getText().equals("")) {
                  firstNumber = Double.parseDouble(screen.getText());
                  operator = "+";
                  screen.setText("");
              }
          }
      });
      panelButtons.add(button_add);

      panelButtons.add(new JLabel());
      panelButtons.add(new JLabel());
      panelButtons.add(new JLabel());

      //rowna sie
      button_equal.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
              if (!screen.getText().equals("")) {
                  double secondNumber = Double.parseDouble(screen.getText());
                  double result = 0;
                  switch (operator) {
                      case "+": result = firstNumber + secondNumber; break;
                      case "-": result = firstNumber - secondNumber; break;
                      case "*": result = firstNumber * secondNumber; break;
                      case "/":
                          if (secondNumber != 0) {
                              result = firstNumber / secondNumber;
                          } else {
                              screen.setText("Błąd: /0");
                              return;
                          }
                          break;
                  }
                  screen.setText("" + result);
                  operator = "";
              }
          }
      });
      panelButtons.add(button_equal);

      panel.add("Center", panelButtons); 
      setContentPane(panel); 
      pack();   
      setVisible(true);
    }
    

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MyApp();
            }
        });
    }
}


