package gui;

import util.Parser;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Created by jhcpokemon on 06/05/15.
 */
public class LL1GrammarParser {
    private JTextField textField1;
    private JButton Button;
    private JTextArea textArea1;
    private JPanel LL1GrammarParser;
    private JTextArea textArea2;
    private JTextArea textArea3;

    public LL1GrammarParser() {
        Button.addActionListener(e -> {
            ArrayList<StringBuilder> result = Parser.startParse(textField1.getText());
            textArea1.setText("分析栈\n");
            textArea2.setText("余留输入串\n");
            textArea3.setText("所用产生式\n");
            textArea1.append(result.get(0).toString());
            textArea2.append(result.get(1).toString());
            textArea3.append(result.get(2).toString());
        });
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        JFrame frame = new JFrame("LL1GrammarParser");
        frame.setContentPane(new LL1GrammarParser().LL1GrammarParser);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(1280, 720);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
