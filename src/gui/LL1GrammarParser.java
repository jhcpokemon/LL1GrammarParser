package gui;

import javax.swing.*;

/**
 * Created by jhcpokemon on 06/05/15.
 */
public class LL1GrammarParser{
    private JTextField textField1;
    private JButton Button;
    private JTextArea textArea1;
    private JPanel LL1GrammarParser;

    public LL1GrammarParser() {
        Button.addActionListener(e -> {
            System.out.print("clicked");
        });
    }

    public static void main(String[] args) {
        try{
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }catch (Exception e){
            e.printStackTrace();
        }
        JFrame frame = new JFrame("LL1GrammarParser");
        frame.setContentPane(new LL1GrammarParser().LL1GrammarParser);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(1280,720);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
