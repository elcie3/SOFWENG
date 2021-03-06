package sofweng;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author iwcnrlee1
 */
public class QC_Screen extends javax.swing.JFrame {

    /**
     * Creates new form QualityCoordinator
     */
    ArrayList<String> courseList = new ArrayList<String>();
    ArrayList<String> subjectList = new ArrayList<String>();
    public int count;
    JButton courseBtn, subjectBtn, studentBtn;
    int height = 40; //Height of Buttons
    int space = 0;
    Font font = new Font("Arial", Font.BOLD, 20);

    public QC_Screen() {
        initComponents();
        this.setSize(900, 700);
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation((size.width - this.getSize().width) / 2, (size.height - this.getSize().height) / 2);
        fetchCourseList();
        viewCourseList(courseList, 0);
    }

    public void fetchCourseList() {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cpe_database?" + "user=root&password=");
            PreparedStatement pst = conn.prepareStatement("Select distinct department from `classes` order by department");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String str1 = rs.getString("department");
                courseList.add(str1);
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(QC_Screen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void fetchSubjectList(int count) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cpe_database?" + "user=root&password=");
            PreparedStatement pst = conn.prepareStatement("SELECT name FROM `classes` WHERE Department='" + courseList.get(count - 1) + "'");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String str1 = rs.getString("name");
                subjectList.add(str1);
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(QC_Screen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void btnConfig(JButton btn, int indent) {
        btn.setFont(font);
        btn.setHorizontalAlignment(JLabel.LEFT);
        btn.setSize(850 - indent * 2, height);
        btn.setLocation(btn.getX() + indent * 2, btn.getY() + space);
        space = space + height;
    }

    public void viewCourseList(ArrayList list, int open) {
        MainPane.removeAll();
        MainPane.revalidate();
        MainPane.repaint();
        MainPane.setPreferredSize(new Dimension(MainPane.getWidth(), MainPane.getHeight()));
        ScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        for (int i = 1; i < list.size() + 1; i++) {
            courseBtn = new JButton(list.get(i - 1) + " Department");
            courseBtn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    for (int j = 0; j < list.size(); j++) {
                        if (e.getActionCommand().contains("" + list.get(j))) {
                            if (count == j + 1) {
                                count = 0;
                            } else {
                                count = j + 1;
                            }
                            viewCourseList(list, count);
                        }
                    }
                }
            });
            MainPane.add(courseBtn);
            btnConfig(courseBtn, 0);
            if (count == i) {
                generateSubjects(i);
            }
        }
        studentBtn = new JButton("Student Database");
        studentBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                java.awt.EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        JFrame frame = new JFrame();
                        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        StudentGraph studentGraph = new StudentGraph("");
                        frame.add(studentGraph);
                        frame.setVisible(true);
                        frame.setSize(750, 600);
                        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
                        int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
                        int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
                        frame.setLocation(x, y);
                        studentGraph.start();
                    }
                });
            }
        });
        MainPane.add(studentBtn);
        btnConfig(studentBtn, 0);
        space = space + height;
        Dimension size = new Dimension(900, space);
        MainPane.setPreferredSize(size);
        space = 0;

    }

    public void generateSubjects(int count) {
        subjectList.clear();
        fetchSubjectList(count);
        JLabel header = new JLabel("Subjects:");
        header.setFont(font);
        header.setSize(MainPane.getWidth(), height);
        header.setLocation(header.getX() + 50, header.getY() + space);
        space = space + height;
        MainPane.add(header);
        for (int i = 1; i < subjectList.size() + 1; i++) {
            subjectBtn = new JButton(subjectList.get(i - 1));
            subjectBtn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    for (int j = 0; j < subjectList.size(); j++) {
                        if (e.getActionCommand().contains("" + subjectList.get(j))) {
                            String subject = subjectList.get(j);
                            java.awt.EventQueue.invokeLater(new Runnable() {
                                public void run() {
                                    new QC_SubjectList(subject).setVisible(true);
                                    dispose();
                                }
                            });
                        }
                    }
                }
            });
            MainPane.add(subjectBtn);
            btnConfig(subjectBtn, 25);
            subjectBtn.setVisible(true);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ScrollPane = new javax.swing.JScrollPane();
        MainPane = new javax.swing.JPanel();
        HeaderPane = new javax.swing.JPanel();
        Greeting = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(900, 700));
        setResizable(false);

        ScrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        MainPane.setMaximumSize(new java.awt.Dimension(498, 1000));
        MainPane.setMinimumSize(new java.awt.Dimension(498, 1000));
        MainPane.setPreferredSize(new java.awt.Dimension(498, 1000));
        MainPane.setRequestFocusEnabled(false);

        javax.swing.GroupLayout MainPaneLayout = new javax.swing.GroupLayout(MainPane);
        MainPane.setLayout(MainPaneLayout);
        MainPaneLayout.setHorizontalGroup(
            MainPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 851, Short.MAX_VALUE)
        );
        MainPaneLayout.setVerticalGroup(
            MainPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1000, Short.MAX_VALUE)
        );

        ScrollPane.setViewportView(MainPane);

        Greeting.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        Greeting.setText("Welcome, Quality Coordinator");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Gokongwei College of Engineering");

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton1.setText("<<");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout HeaderPaneLayout = new javax.swing.GroupLayout(HeaderPane);
        HeaderPane.setLayout(HeaderPaneLayout);
        HeaderPaneLayout.setHorizontalGroup(
            HeaderPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HeaderPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(HeaderPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(HeaderPaneLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(527, Short.MAX_VALUE))
                    .addGroup(HeaderPaneLayout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Greeting)
                        .addGap(20, 20, 20))))
        );
        HeaderPaneLayout.setVerticalGroup(
            HeaderPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HeaderPaneLayout.createSequentialGroup()
                .addGroup(HeaderPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(HeaderPaneLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Greeting))
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ScrollPane)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(HeaderPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(40, 40, 40))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(HeaderPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 541, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
                dispose();
            }
        });
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(QC_Screen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QC_Screen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QC_Screen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QC_Screen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QC_Screen().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Greeting;
    private javax.swing.JPanel HeaderPane;
    private javax.swing.JPanel MainPane;
    private javax.swing.JScrollPane ScrollPane;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
