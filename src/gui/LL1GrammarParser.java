package gui;

import javax.swing.*;

/**
 * Created by jhcpokemon on 06/05/15.
 */
public class LL1GrammarParser{
    private JTextField textField1;
    private JButton 开始解析Button;
    private JTextArea textArea1;
    private JPanel LL1GrammarParser;

    public static void main(String[] args) {
        JFrame frame = new JFrame("LL1GrammarParser");
        frame.setContentPane(new LL1GrammarParser().LL1GrammarParser);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
