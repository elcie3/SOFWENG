/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sofweng;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import static java.lang.Float.parseFloat;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author PauloSenires
 */
public class InputGrades extends javax.swing.JFrame {

    public String ID = "11500001";
    public String subject = "ENGPHY1";
    public String section = "EA";
    public String soGrade = "";
    public String rawScores = "";
    float finalGrade;
    public String[] soList;
    public String[] bdArray;
    public String[] gradesList;
    public String[] soGradesList;
    public String[] rawScoresList;
    public JTextField[] soGradeFieldList;
    int soCount = 0;
    int subjectCount = 0;
    int qaScore, feScore, pgScore, ogScore;

    /**
     * Creates new form InputGrades
     */
    public InputGrades() throws SQLException {
        initComponents();
        fetchSOs(subject);
        fetchStudent(ID);
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation((size.width - this.getSize().width) / 2, (size.height - this.getSize().height) / 2);

    }

    public InputGrades(String ID, String subject, String sec) throws SQLException {
        this.ID = ID;
        this.subject = subject;
        section = sec;
        initComponents();
        fetchSOs(subject);
        fetchStudent(ID);
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation((size.width - this.getSize().width) / 2, (size.height - this.getSize().height) / 2);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        subjectLabel = new javax.swing.JLabel();
        studentNumberLabel = new javax.swing.JLabel();
        sectionLabel = new javax.swing.JLabel();
        subjectPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        qaPercentageLabel = new javax.swing.JLabel();
        fePercentageLabel = new javax.swing.JLabel();
        pgPercentageLabel = new javax.swing.JLabel();
        ogPercentageLabel = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        quizAverage = new javax.swing.JTextField();
        finalExam = new javax.swing.JTextField();
        projectGrade = new javax.swing.JTextField();
        othersGrade = new javax.swing.JTextField();
        finalGradeLabel = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        updateButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        soPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        subjectLabel.setText("subjectName");

        studentNumberLabel.setText("studentNumber");

        sectionLabel.setText("Section");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(subjectLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(sectionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(studentNumberLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(subjectLabel)
                    .addComponent(studentNumberLabel)
                    .addComponent(sectionLabel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Breakdown of Grades");

        jLabel4.setText("Quiz Average");

        jLabel5.setText("Final Exam");

        jLabel6.setText("Project");

        jLabel7.setText("Others");

        qaPercentageLabel.setText("(#)%");

        fePercentageLabel.setText("(#)%");

        pgPercentageLabel.setText("(#)%");

        ogPercentageLabel.setText("(#)%");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setText("Final Grade");

        quizAverage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quizAverageActionPerformed(evt);
            }
        });

        finalExam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finalExamActionPerformed(evt);
            }
        });

        projectGrade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                projectGradeActionPerformed(evt);
            }
        });

        othersGrade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                othersGradeActionPerformed(evt);
            }
        });

        finalGradeLabel.setText("finalGrade");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setText("Student Outcomes");

        updateButton.setText("Update");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout soPanelLayout = new javax.swing.GroupLayout(soPanel);
        soPanel.setLayout(soPanelLayout);
        soPanelLayout.setHorizontalGroup(
            soPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 277, Short.MAX_VALUE)
        );
        soPanelLayout.setVerticalGroup(
            soPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 150, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout subjectPanelLayout = new javax.swing.GroupLayout(subjectPanel);
        subjectPanel.setLayout(subjectPanelLayout);
        subjectPanelLayout.setHorizontalGroup(
            subjectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(subjectPanelLayout.createSequentialGroup()
                .addGroup(subjectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(subjectPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(subjectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1)
                            .addGroup(subjectPanelLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(subjectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(subjectPanelLayout.createSequentialGroup()
                                        .addGroup(subjectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel7))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(subjectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, subjectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(pgPercentageLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                                                .addComponent(fePercentageLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addComponent(ogPercentageLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(subjectPanelLayout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(qaPercentageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(subjectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(quizAverage, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(finalExam, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(projectGrade, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(othersGrade, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(subjectPanelLayout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(finalGradeLabel)))
                .addGroup(subjectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(subjectPanelLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel14))
                    .addGroup(subjectPanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(soPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(subjectPanelLayout.createSequentialGroup()
                .addGap(172, 172, 172)
                .addComponent(backButton)
                .addGap(18, 18, 18)
                .addComponent(updateButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        subjectPanelLayout.setVerticalGroup(
            subjectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(subjectPanelLayout.createSequentialGroup()
                .addGroup(subjectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(subjectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(subjectPanelLayout.createSequentialGroup()
                        .addGroup(subjectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(qaPercentageLabel)
                            .addComponent(quizAverage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(subjectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(fePercentageLabel)
                            .addComponent(finalExam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(subjectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(pgPercentageLabel)
                            .addComponent(projectGrade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(subjectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(ogPercentageLabel)
                            .addComponent(othersGrade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(subjectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(finalGradeLabel)))
                    .addComponent(soPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(subjectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(updateButton)
                    .addComponent(backButton))
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(subjectPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(subjectPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void quizAverageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quizAverageActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_quizAverageActionPerformed

    private void projectGradeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_projectGradeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_projectGradeActionPerformed

    private void othersGradeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_othersGradeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_othersGradeActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        // TODO add your handling code here:
        int errorCount=0;
        soGrade = "";
        soGradesList = new String[soCount];
        gradesList = new String[soCount];
    
            try {
                    Integer.parseInt(quizAverage.getText());
                    Integer.parseInt(finalExam.getText());
                    Integer.parseInt(projectGrade.getText());
                    Integer.parseInt(othersGrade.getText());
                    
                    System.out.println("An integer");
                    
                    for (int i = 0; i < soCount; i++) {
                        
                    soGradesList[i] = soGradeFieldList[i].getText();
                        Integer.parseInt(soGradesList[i]);
                    if (Integer.parseInt(quizAverage.getText())>100 || Integer.parseInt(quizAverage.getText())<0
                        || Integer.parseInt(finalExam.getText())>100 || Integer.parseInt(finalExam.getText())<0
                        || Integer.parseInt(projectGrade.getText())>100 || Integer.parseInt(projectGrade.getText())<0
                        || Integer.parseInt(othersGrade.getText())>100 || Integer.parseInt(othersGrade.getText())<0
                        || Integer.parseInt(soGradesList[i])<0||Integer.parseInt(soGradesList[i])>100) {
                    errorCount++;
                    }
                    } 
                   }
                   catch (NumberFormatException e) {
                        errorCount++;
                   }
        
        if(errorCount==0){
        
        for (int i = 0; i < soCount; i++) {
            soGradesList[i] = soGradeFieldList[i].getText();
            if (i < soCount - 1) {
                soGrade = soGrade + soGradesList[i] + ",";
            } else {
                soGrade = soGrade + soGradesList[i];
            }
        }
        qaScore = Integer.parseInt(quizAverage.getText()) * Integer.parseInt(bdArray[0]) / 100;
        feScore = Integer.parseInt(finalExam.getText()) * Integer.parseInt(bdArray[1]) / 100;
        pgScore = Integer.parseInt(projectGrade.getText()) * Integer.parseInt(bdArray[2]) / 100;
        ogScore = Integer.parseInt(othersGrade.getText()) * Integer.parseInt(bdArray[3]) / 100;
        rawScores = (quizAverage.getText() + "," + finalExam.getText() + "," + projectGrade.getText() + "," + othersGrade.getText());
        int totalGrade = qaScore + feScore + pgScore + ogScore;
        if (totalGrade >= 95) {
            finalGrade = (float) 4.0;
        } else if (totalGrade >= 90 && totalGrade < 95) {
            finalGrade = (float) 3.5;
        } else if (totalGrade >= 85 && totalGrade < 90) {
            finalGrade = (float) 3.0;
        } else if (totalGrade >= 80 && totalGrade < 85) {
            finalGrade = (float) 2.5;
        } else if (totalGrade >= 75 && totalGrade < 80) {
            finalGrade = (float) 2.0;
        } else if (totalGrade >= 70 && totalGrade < 75) {
            finalGrade = (float) 1.5;
        } else if (totalGrade >= 65 && totalGrade < 70) {
            finalGrade = (float) 1.0;
        } else if (totalGrade < 65) {
            finalGrade = (float) 0.0;
        }
        //System.out.println(totalGrade);
        finalGradeLabel.setText(String.valueOf(finalGrade));
        //System.out.println(soGrade);

        try {
            updateDatabase(ID);
        } catch (SQLException ex) {
            Logger.getLogger(InputGrades.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        else{
            JOptionPane.showMessageDialog(null, "Invalid inputs.\nGrades must be numerical values from 0-100");
        }
    }//GEN-LAST:event_updateButtonActionPerformed

    private void finalExamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finalExamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_finalExamActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:

        this.dispose();
    }//GEN-LAST:event_backButtonActionPerformed

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
            java.util.logging.Logger.getLogger(InputGrades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InputGrades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InputGrades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InputGrades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new InputGrades().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(InputGrades.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    private void fetchSOs(String subject) throws SQLException {
        try {
            java.lang.Class.forName("com.mysql.jdbc.Driver");

            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cpe_database?" + "user=root&password=");

            PreparedStatement pst = conn.prepareStatement("Select * from classes where Name = ?");
            pst.setString(1, subject);
            ResultSet rs = pst.executeQuery();
            rs.next();

            String studentOutcomes = rs.getString("SO");
            String[] soArray = studentOutcomes.split(",");
            //System.out.println("" + soArray);

            String breakDown = rs.getString("percent");
            String[] breakdownArray = breakDown.split(",");
            //System.out.println("" + breakdownArray);
            qaPercentageLabel.setText(breakdownArray[0] + "%");
            fePercentageLabel.setText(breakdownArray[1] + "%");
            pgPercentageLabel.setText(breakdownArray[2] + "%");
            ogPercentageLabel.setText(breakdownArray[3] + "%");
            bdArray = breakdownArray;

            //System.out.println(soArray.length);
            soList = new String[soArray.length];
            soGradeFieldList = new JTextField[soArray.length];
            for (int i = 0; i < soArray.length; i++) {
                soList[i] = ("SO " + (soArray[i]));
                //System.out.println(soList[i]);
            }
            soPanel.setLayout(new GridLayout(5, 1));

            for (String studentOutcome : soList) {
                JLabel soLabel = new JLabel(studentOutcome);
                JTextField soTextField = new JTextField();
                soGradeFieldList[soCount] = soTextField;
                soLabel.setVisible(true);
                soPanel.add(soLabel);
                soPanel.add(soTextField);
                soCount++;
            }

            soPanel.validate();
            soPanel.repaint();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(InputGrades.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void fetchStudent(String ID) throws SQLException {
        try {
            java.lang.Class.forName("com.mysql.jdbc.Driver");

            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cpe_database?" + "user=root&password=");

            PreparedStatement pst = conn.prepareStatement("Select * from students where ID = ?");
            pst.setString(1, ID);
            ResultSet rs = pst.executeQuery();
            rs.next();

            while (!subject.equals(rs.getString("subject" + (subjectCount + 1))) && subjectCount < 10) {
                //System.out.println(rs.getString("subject"+(subjectCount+1)));
                subjectCount++;
                if (subjectCount == 10) {
                    break;
                }
            }
            section = rs.getString("section" + (subjectCount + 1));
            subjectLabel.setText(subject);
            studentNumberLabel.setText(ID);
            sectionLabel.setText(section);

            if (rs.getString("grade" + (subjectCount + 1)).equals("na") || rs.getString("grade" + (subjectCount + 1)) == null) {
                finalGrade = (float) 0.0;
            } else {
                finalGrade = parseFloat(rs.getString("grade" + (subjectCount + 1)));
            }
            finalGradeLabel.setText(String.valueOf(finalGrade));

            rawScores = rs.getString("rawScore" + (subjectCount + 1));
            if (rawScores.equals("na") || rawScores == null) {
                rawScores = "0,0,0,0";
            }
            String[] rawScoresArray = rawScores.split(",");
            quizAverage.setText(rawScoresArray[0]);
            finalExam.setText(rawScoresArray[1]);
            projectGrade.setText(rawScoresArray[2]);
            othersGrade.setText(rawScoresArray[3]);

            String studentOutcomes = rs.getString("so" + (subjectCount + 1));
            System.out.println(studentOutcomes);
            String[] soGradesArray = studentOutcomes.split(",");
            System.out.println(Arrays.toString(soGradesArray));
            if (soGradesArray.length > 1) {
                for (int i = 0; i < soCount; i++) {
                    soGradeFieldList[i].setText(soGradesArray[i]);
                }
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(InputGrades.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateDatabase(String ID) throws SQLException {
        try {
            java.lang.Class.forName("com.mysql.jdbc.Driver");

            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cpe_database?" + "user=root&password=");

            Statement data = conn.createStatement();
            data.execute("use cpe_database;");
            data.execute("update students set so" + (subjectCount + 1) + "='" + soGrade + "' where ID ='" + ID + "';");
            data.execute("update students set grade" + (subjectCount + 1) + "='" + finalGrade + "' where ID='" + ID + "';");
            data.execute("update students set rawScore" + (subjectCount + 1) + "='" + rawScores + "' where ID='" + ID + "';");

            String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
            //System.out.println(timeStamp);
            data.execute("update students set time" + (subjectCount + 1) + "='" + timeStamp + "' where ID='" + ID + "';");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(InputGrades.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JLabel fePercentageLabel;
    private javax.swing.JTextField finalExam;
    private javax.swing.JLabel finalGradeLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel ogPercentageLabel;
    private javax.swing.JTextField othersGrade;
    private javax.swing.JLabel pgPercentageLabel;
    private javax.swing.JTextField projectGrade;
    private javax.swing.JLabel qaPercentageLabel;
    private javax.swing.JTextField quizAverage;
    private javax.swing.JLabel sectionLabel;
    private javax.swing.JPanel soPanel;
    private javax.swing.JLabel studentNumberLabel;
    private javax.swing.JLabel subjectLabel;
    private javax.swing.JPanel subjectPanel;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}
