import javax.swing.JFrame;

public class SimpleCalculatorMain {
    public static void main(String[] args){
        SimpleCalculatorContent calc = new SimpleCalculatorContent();
        calc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        calc.setSize(350, 180);
        calc.setVisible(true);
    }
}
