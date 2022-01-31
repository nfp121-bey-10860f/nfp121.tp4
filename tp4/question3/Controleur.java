package question3;

import question3.tp3.PileI;
import question3.tp3.PilePleineException;
import question3.tp3.PileVideException;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Controleur extends JPanel {

    private JButton push, add, sub, mul, div, clear;
    private PileModele<Integer> pile;
    private JTextField donnee;
    JPanel boutons;

    public Controleur(PileModele<Integer> pile) {
        super();
        this.pile = pile;
        this.donnee = new JTextField(8);

        this.push = new JButton("push");
        this.add = new JButton("+");
        this.sub = new JButton("-");
        this.mul = new JButton("*");
        this.div = new JButton("/");
        this.clear = new JButton("[]");

        add(donnee);
        donnee.addActionListener(null); //a completé
        boutons = new JPanel();
        actualiserInterface();

        push.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try{
                    pile.empiler(Integer.parseInt(donnee.getText()));
                    donnee.setText("");
                }catch(NumberFormatException nfe){
                    donnee.setText("Only numbers are acceptable");
                }catch(PilePleineException ppe){
                    donnee.setText("Stack is full");
                }
            }
        });
        boutons.add(add);
        add.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try{
                    if(!pile.estVide() && pile.taille() >= 2){
                        pile.empiler(pile.depiler() + pile.depiler());
                        donnee.setText(pile.sommet() + "");
                    }else{
                        donnee.setText("Enter at least 2 numbers");
                    }
                }catch(PilePleineException ppe){
                    donnee.setText("Stack is full");
                }catch(PileVideException pve){
                    donnee.setText("Stack is empty");
                }
                
            }
        });
        boutons.add(sub);
        sub.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try{
                    if(!pile.estVide() && pile.taille() >= 2){
                        pile.empiler(pile.depiler() - pile.depiler());
                        donnee.setText(pile.sommet() + "");
                    }else{
                        donnee.setText("Enter at least 2 numbers");
                    }
                }catch(PilePleineException ppe){
                    donnee.setText("Stack is full");
                }catch(PileVideException pve){
                    donnee.setText("Stack is empty");
                }
                
            }
        });
        boutons.add(mul);
        mul.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try{
                    if(!pile.estVide() && pile.taille() >= 2){
                        pile.empiler(pile.depiler() * pile.depiler());
                        donnee.setText(pile.sommet() + "");
                    }else{
                        donnee.setText("Enter at least 2 numbers");
                    }
                }catch(PilePleineException ppe){
                    donnee.setText("Stack is full");
                }catch(PileVideException pve){
                    donnee.setText("Stack is empty");
                }
                
            }
        });
        boutons.add(div);
        div.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try{
                    if(!pile.estVide() && pile.taille() >= 2){
                        int n1 = pile.depiler();
                        int n2 = pile.depiler();
                        try{
                            if(n2 != 0){
                                pile.empiler(n1 / n2);
                                donnee.setText(pile.sommet() + "");
                            }
                            else
                                throw new NumberFormatException();
                        }catch(NumberFormatException nfe){
                            donnee.setText("Can't devide by 0");
                        }
                    }else{
                        donnee.setText("Enter at least 2 numbers");
                    }
                }catch(PilePleineException ppe){
                    donnee.setText("Stack is full");
                }catch(PileVideException pve){
                    donnee.setText("Stack is empty");
                }
                
            }
        });
        boutons.add(clear);
        clear.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try{
                    donnee.setText("");
                    while(!pile.estVide()){
                        pile.depiler();
                    }
                }catch(PileVideException pve){
                    donnee.setText("Stack is empty");
                }
                
            }
        });
        add(boutons);
    }

    public void actualiserInterface() {
        setLayout(new GridLayout(2, 1));
        boutons.setLayout(new FlowLayout());
        boutons.add(push);
        boutons.setBackground(Color.red);
    }

    private Integer operande() throws NumberFormatException {
        return Integer.parseInt(donnee.getText());
    }

}