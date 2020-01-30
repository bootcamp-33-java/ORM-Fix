/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

/**
 *
 * @author aqira
 */
public class MainView extends javax.swing.JFrame {

    JobView j = new JobView();
    RegionView r = new RegionView();
    DepartmentView d = new DepartmentView();
    CountryView c = new CountryView();
    LocationView l = new LocationView();
    EmployeeView e = new EmployeeView();

    /**
     * Creates new form MainView
     */
    public MainView() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuRegion = new javax.swing.JMenuItem();
        menuDepartment = new javax.swing.JMenuItem();
        menuCountry = new javax.swing.JMenuItem();
        menuLocation = new javax.swing.JMenuItem();
        menuEmployee = new javax.swing.JMenuItem();
        menuJob = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1145, Short.MAX_VALUE)
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 489, Short.MAX_VALUE)
        );

        jMenuBar1.setToolTipText("");

        jMenu1.setText("Menu");

        menuRegion.setText("Region");
        menuRegion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuRegionActionPerformed(evt);
            }
        });
        jMenu1.add(menuRegion);

        menuDepartment.setText("Department");
        menuDepartment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuDepartmentActionPerformed(evt);
            }
        });
        jMenu1.add(menuDepartment);

        menuCountry.setText("Country");
        menuCountry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCountryActionPerformed(evt);
            }
        });
        jMenu1.add(menuCountry);

        menuLocation.setText("Location");
        menuLocation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuLocationActionPerformed(evt);
            }
        });
        jMenu1.add(menuLocation);

        menuEmployee.setText("Employee");
        menuEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuEmployeeActionPerformed(evt);
            }
        });
        jMenu1.add(menuEmployee);

        menuJob.setText("Job");
        menuJob.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuJobActionPerformed(evt);
            }
        });
        jMenu1.add(menuJob);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuRegionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuRegionActionPerformed
        refresh();
        this.mainPanel.add(r);
        r.show();
    }//GEN-LAST:event_menuRegionActionPerformed

    private void menuDepartmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuDepartmentActionPerformed
        // TODO add your handling code here:
        refresh();
        this.mainPanel.add(d);
        d.show();
    }//GEN-LAST:event_menuDepartmentActionPerformed

    private void menuCountryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCountryActionPerformed
        // TODO add your handling code here:
        refresh();
        this.mainPanel.add(c);
        c.show();
    }//GEN-LAST:event_menuCountryActionPerformed

    private void menuLocationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuLocationActionPerformed
        // TODO add your handling code here:
        refresh();
        this.mainPanel.add(l);
        l.show();
    }//GEN-LAST:event_menuLocationActionPerformed

    private void menuEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEmployeeActionPerformed
        // TODO add your handling code here:
        refresh();
        this.mainPanel.add(e);
        e.show();
    }//GEN-LAST:event_menuEmployeeActionPerformed

    private void menuJobActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuJobActionPerformed
        // TODO add your handling code here:
        refresh();
        this.mainPanel.add(j);
        j.show();
    }//GEN-LAST:event_menuJobActionPerformed

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
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainView().setVisible(true);
            }
        });
    }

    public void refresh() {
        j.hide();
        r.hide();
        d.hide();
        e.hide();
        c.hide();
        d.hide();
        l.hide();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JMenuItem menuCountry;
    private javax.swing.JMenuItem menuDepartment;
    private javax.swing.JMenuItem menuEmployee;
    private javax.swing.JMenuItem menuJob;
    private javax.swing.JMenuItem menuLocation;
    private javax.swing.JMenuItem menuRegion;
    // End of variables declaration//GEN-END:variables
}
