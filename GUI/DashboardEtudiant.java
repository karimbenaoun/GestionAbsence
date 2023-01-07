package GUI;

import javax.swing.JFrame;
import javax.swing.JTable;

public class DashboardEtudiant extends JFrame {

    JFrame frame;
    JTable jt;

    public DashboardEtudiant() {

        frame = new JFrame();

        /* table */
        Object data[][] = { 
                { "101", "Amit", "670000" },
                { "102", "Jai", "780000" },
                { "101", "Sachin", "700000" } 
        };
        String titre[] = { "ID", "NAME", "SALARY" };
        jt = new JTable(data, titre);
        jt.setBounds(30, 40, 200, 300);
        getContentPane().add(jt);
        /* table */

        setTitle("Gestion Absence ~ Etudiant Dashboard");
        add(jt);
        setSize(600, 500);
        setLayout(null);
        setVisible(true);
    }

}
