/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

/**
 *
 * @author FIKRI
 */
public class MainView extends javax.swing.JFrame {

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

        jiMainView = new javax.swing.JInternalFrame();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        mRegion = new javax.swing.JMenu();
        miRegion = new javax.swing.JMenuItem();
        miCountry = new javax.swing.JMenuItem();
        miLocation = new javax.swing.JMenuItem();
        miJob = new javax.swing.JMenuItem();
        miDepartment = new javax.swing.JMenuItem();
        miEmployee = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jiMainView.setClosable(true);
        jiMainView.setVisible(true);

        javax.swing.GroupLayout jiMainViewLayout = new javax.swing.GroupLayout(jiMainView.getContentPane());
        jiMainView.getContentPane().setLayout(jiMainViewLayout);
        jiMainViewLayout.setHorizontalGroup(
            jiMainViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1279, Short.MAX_VALUE)
        );
        jiMainViewLayout.setVerticalGroup(
            jiMainViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 856, Short.MAX_VALUE)
        );

        jLabel1.setText("jLabel1");

        jLabel2.setText("jLabel2");

        jLabel3.setText("CRUD HR SCHEMA");

        mRegion.setBackground(new java.awt.Color(153, 153, 255));
        mRegion.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, java.awt.Color.lightGray, null));
        mRegion.setText("Main");
        mRegion.setAlignmentX(4.0F);
        mRegion.setAlignmentY(4.0F);

        miRegion.setText("Regions");
        miRegion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miRegionActionPerformed(evt);
            }
        });
        mRegion.add(miRegion);

        miCountry.setText("Countries");
        miCountry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miCountryActionPerformed(evt);
            }
        });
        mRegion.add(miCountry);

        miLocation.setText("Locations");
        miLocation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miLocationActionPerformed(evt);
            }
        });
        mRegion.add(miLocation);

        miJob.setText("Jobs");
        miJob.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miJobActionPerformed(evt);
            }
        });
        mRegion.add(miJob);

        miDepartment.setText("Departments");
        miDepartment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miDepartmentActionPerformed(evt);
            }
        });
        mRegion.add(miDepartment);

        miEmployee.setText("Employees");
        miEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miEmployeeActionPerformed(evt);
            }
        });
        mRegion.add(miEmployee);

        jMenuBar1.add(mRegion);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(581, 581, 581))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jiMainView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jiMainView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void miCountryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miCountryActionPerformed
//        CountryView countryView = new CountryView();
//        this.jiMainView.add(countryView);
//        countryView.show();
    }//GEN-LAST:event_miCountryActionPerformed

    private void miRegionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miRegionActionPerformed
//        RegionView regionView = new RegionView();
//        this.jiMainView.add(regionView);
//        regionView.show();
    }//GEN-LAST:event_miRegionActionPerformed

    private void miLocationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miLocationActionPerformed
//        LocationView locationView = new LocationView();
//        this.jiMainView.add(locationView);
//        locationView.show();
    }//GEN-LAST:event_miLocationActionPerformed

    private void miJobActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miJobActionPerformed
//        JobView jobView = new JobView();
//        this.jiMainView.add(jobView);
//        jobView.show();
    }//GEN-LAST:event_miJobActionPerformed

    private void miDepartmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miDepartmentActionPerformed
        DepartmentView departmentView = new DepartmentView();
        this.jiMainView.add(departmentView);
        departmentView.show();
    }//GEN-LAST:event_miDepartmentActionPerformed

    private void miEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miEmployeeActionPerformed
//        EmployeeView employeeView = new EmployeeView();
//        this.jiMainView.add(employeeView);
//        employeeView.show();
    }//GEN-LAST:event_miEmployeeActionPerformed

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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JInternalFrame jiMainView;
    private javax.swing.JMenu mRegion;
    private javax.swing.JMenuItem miCountry;
    private javax.swing.JMenuItem miDepartment;
    private javax.swing.JMenuItem miEmployee;
    private javax.swing.JMenuItem miJob;
    private javax.swing.JMenuItem miLocation;
    private javax.swing.JMenuItem miRegion;
    // End of variables declaration//GEN-END:variables
}
