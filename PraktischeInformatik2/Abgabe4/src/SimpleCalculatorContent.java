import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SimpleCalculatorContent extends JFrame {
    private JTextField input1;
    private JTextField input2;
    private JTextField resultTextfield;
    private JLabel status;

    public SimpleCalculatorContent(){
        super("SimpleCalculator");
        setLayout(new FlowLayout());

        JLabel operator = new JLabel("Erste Zahl:");
        operator.setPreferredSize(new Dimension(100, 24));
        add(operator);

        input1 = new JTextField("");
        input1.setPreferredSize(new Dimension(200, 24));
        input1.setToolTipText("Add something");
        add(input1);

        operator = new JLabel("Zweite Zahl:");
        operator.setPreferredSize(new Dimension(100, 24));
        add(operator);

        input2 = new JTextField("");
        input2.setPreferredSize(new Dimension(200, 24));
        input2.setToolTipText("Add something");
        add(input2);

        status = new JLabel("Ergebnis:");
        status.setPreferredSize(new Dimension(100, 24));
        add(status);

        resultTextfield = new JTextField("");
        resultTextfield.setPreferredSize(new Dimension(200, 24));
        resultTextfield.setToolTipText("Ergbenis");
        add(resultTextfield);

        JButton plus = new JButton("plus");
        plus.setToolTipText("Add");
        add(plus);

        JButton minus = new JButton("minus");
        plus.setToolTipText("Subtract");
        add(minus);

        plus.addActionListener(new Listener(input1, input2, 1));
        minus.addActionListener(new Listener(input1, input2, 2));


    }

    class Listener implements ActionListener{
         JTextField tf1;
         JTextField tf2;
         int action;

         Listener(JTextField tf1,JTextField tf2, int action){
             this.tf1 = tf1;
             this.tf2 = tf2;
             this.action = action;
         }

         public void actionPerformed(ActionEvent e){
             if(this.action==1){
                 status.setText(input1.getText()+"+"+input2.getText()+":");
                 int tf1int = Integer.parseInt(this.tf1.getText());
                 int tf2int = Integer.parseInt(this.tf2.getText());
                 int result = (tf1int+tf2int);
                 resultTextfield.setText(Integer.toString(result));
             }
             if(this.action==2){
                 status.setText(input1.getText()+"-"+input2.getText()+":");
                 int tf1int = Integer.parseInt(this.tf1.getText());
                 int tf2int = Integer.parseInt(this.tf2.getText());
                 int result = (tf1int-tf2int);
                 resultTextfield.setText(Integer.toString(result));
             }

             tf1.setText("");
             tf2.setText("");
             }

         }
     }

