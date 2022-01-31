package question2;

import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import java.awt.TextArea;
import javax.swing.JButton;

public class JButtonObserver implements ActionListener{

    private String nom;
    private TextArea contenu;
    
    /**
     * Constructeur d'objets de classe JButtonObserver
     * 
     * @param nom
     *            le nom du bouton, jbo1, jbo2, jbo3, jmo1, jmo2, jmo3
     * @param contenu
     *            la zone de texte de l'applette
     */
    public JButtonObserver(String nom, TextArea contenu) {
        this.nom = nom;
        this.contenu = contenu;
    }

    public void actionPerformed(ActionEvent e) {
        String message = this.nom + ((JButton)e.getSource()).getText();
        contenu.append(message + "\n");
    }

}