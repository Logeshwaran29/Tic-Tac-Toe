import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class game implements ActionListener {
    JFrame f = new JFrame();
    JPanel p = new JPanel();
    JPanel p1 = new JPanel();
    JPanel p2 = new JPanel();
    JLabel l = new JLabel();
    JLabel l1 = new JLabel();
    JButton[] b = new JButton[9];
    JButton b1 = new JButton();
    boolean play = true, next = true;
    int c = 0;

    game() {
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().setBackground(Color.BLACK);
        f.setVisible(true);
        f.setTitle("Tic-Tac-Toe");
        f.setBounds(50, 50, 600, 600);
        f.setLayout(new BorderLayout());
        // ==========================================================//
        l.setBackground(Color.black);
        l.setText("Tic-Tac-Toe");
        l.setFont(new Font("Comic Sans MS", Font.BOLD, 50));
        l.setLocation(0, 450);
        l.setForeground(Color.BLUE);
        l.setOpaque(true);
        l.setHorizontalAlignment(JLabel.CENTER);
        // ==========================================================//
        p1.setLayout(new GridLayout(3, 3));
        p1.setBackground(new Color(100, 100, 100));
        for (int i = 0; i < 9; i++) {
            b[i] = new JButton();
            p1.add(b[i]);
            b[i].setFocusable(false);
            b[i].addActionListener(this);
            b[i].setBackground(Color.white);
        }
        p.setLayout(new BorderLayout());
        p.setBounds(0, 0, 600, 100);
        p.add(l);
        b1.setFocusable(false);
        b1.addActionListener(this);
        b1.setText("RESET");
        b1.setHorizontalAlignment(JButton.CENTER);
        p2.add(b1);
        p2.setForeground(Color.black);
        f.add(p, BorderLayout.NORTH);
        f.add(p1);
        f.add(p2, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            c = 0;
            next = true;
            for (int i = 0; i < 9; i++) {
                b[i].setText("");
                b[i].setEnabled(true);
                b[i].setBackground(Color.WHITE);
                l.setText("Tic-Tac-Toe");
            }
        } else {
            for (int i = 0; i < 9; i++) {
                c++;
                if (e.getSource() == b[i]) {
                    if (play) {
                        if (b[i].getText() == "") {
                            b[i].setText("X");
                            b[i].setFont(new Font("Comic Sans MS", Font.BOLD, 50));
                            b[i].setForeground(Color.red);
                            play = false;
                            check();
                        }
                    } else {
                        if (b[i].getText() == "") {
                            b[i].setText("O");
                            b[i].setFont(new Font("Comic Sans MS", Font.BOLD, 50));
                            b[i].setForeground(Color.blue);
                            play = true;
                            check();
                        }
                    }
                }
            }
            if (c == 81 && next) {
                l.setText("Draw");
                for (int a = 0; a < 9; a++) {
                    b[a].setEnabled(false);
                }
            }
        }
    }

    public void check() {
        // X wins=========================================================//
        if (b[0].getText() == "X" && b[1].getText() == "X" && b[2].getText() == "X") {
            x(0, 1, 2);
        }
        if (b[3].getText() == "X" && b[4].getText() == "X" && b[5].getText() == "X") {
            x(3, 4, 5);
        }
        if (b[6].getText() == "X" && b[7].getText() == "X" && b[8].getText() == "X") {
            x(6, 7, 8);
        }
        if (b[0].getText() == "X" && b[3].getText() == "X" && b[6].getText() == "X") {
            x(0, 3, 6);
        }
        if (b[1].getText() == "X" && b[4].getText() == "X" && b[7].getText() == "X") {
            x(1, 4, 7);
        }
        if (b[2].getText() == "X" && b[5].getText() == "X" && b[8].getText() == "X") {
            x(2, 5, 8);
        }
        if (b[0].getText() == "X" && b[4].getText() == "X" && b[8].getText() == "X") {
            x(0, 4, 8);
        }
        if (b[2].getText() == "X" && b[4].getText() == "X" && b[6].getText() == "X") {
            x(2, 4, 6);
        }
        // O wins==========================================================//
        if (b[0].getText() == "O" && b[1].getText() == "O" && b[2].getText() == "O") {
            o(0, 1, 2);
        }
        if (b[3].getText() == "O" && b[4].getText() == "O" && b[5].getText() == "O") {
            o(3, 4, 5);
        }
        if (b[6].getText() == "O" && b[7].getText() == "O" && b[8].getText() == "O") {
            o(6, 7, 8);
        }
        if (b[0].getText() == "O" && b[3].getText() == "O" && b[6].getText() == "O") {
            o(0, 3, 6);
        }
        if (b[1].getText() == "O" && b[4].getText() == "O" && b[7].getText() == "O") {
            o(1, 4, 7);
        }
        if (b[2].getText() == "O" && b[5].getText() == "O" && b[8].getText() == "O") {
            o(2, 5, 8);
        }
        if (b[0].getText() == "O" && b[4].getText() == "O" && b[8].getText() == "O") {
            o(0, 4, 8);
        }
        if (b[2].getText() == "O" && b[4].getText() == "O" && b[6].getText() == "O") {
            o(2, 4, 6);
        }
    }

    public void x(int i, int j, int k) {
        b[i].setBackground(Color.GREEN);
        b[j].setBackground(Color.GREEN);
        b[k].setBackground(Color.GREEN);
        for (int a = 0; a < 9; a++) {
            b[a].setEnabled(false);
        }
        l.setText("Player 1 wins");
        next = false;
    }

    public void o(int i, int j, int k) {
        b[i].setBackground(Color.GREEN);
        b[j].setBackground(Color.GREEN);
        b[k].setBackground(Color.GREEN);
        for (int a = 0; a < 9; a++) {
            b[a].setEnabled(false);
        }
        l.setText("Player 2 Wins");
        next = false;
    }
}