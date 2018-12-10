/*
 To change this license header, choose License Headers in Project Properties.
 To change this template file, choose Tools | Templates
 and open the template in the editor.
 */
package vista;

import controlador.Gestor;
import java.awt.event.ItemEvent;
import javax.swing.JOptionPane;
import modelo.Material;
import modelo.Silla;

/**

 @author Arlen
 */
public class Seat extends javax.swing.JInternalFrame
{

    /** Creates new form Seat */
    public Seat(Pp p)
    {
        initComponents();
        this.p = p;
        Gestor.updateMateriales();
        Gestor.loadSillas();
    }

    /** This method is called from within the constructor to
     initialize the form.
     WARNING: Do NOT modify this code. The content of this method is
     always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cmbMaterial = new javax.swing.JComboBox<>();
        btnInsert = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        cmbEstilo = new javax.swing.JComboBox<>();
        chkGira = new javax.swing.JCheckBox();
        chkReclina = new javax.swing.JCheckBox();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        cmbSilla = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cmbMaterial1 = new javax.swing.JComboBox<>();
        cmbEstilo1 = new javax.swing.JComboBox<>();
        chkGira1 = new javax.swing.JCheckBox();
        chkReclina1 = new javax.swing.JCheckBox();
        btnUpdate = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        cmbSilla1 = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        btnDelete = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setVisible(true);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        jLabel1.setText("NUEVA SILLA");

        jLabel2.setText("MATERIAL");

        cmbMaterial.setModel(Gestor.materiales);

        btnInsert.setText("INSERTAR");
        btnInsert.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnInsertActionPerformed(evt);
            }
        });

        jLabel3.setText("ESTILO");

        cmbEstilo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Moderno", "Rustico", "Clásico" }));

        chkGira.setText("Giratoria");

        chkReclina.setText("Reclinable");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cmbMaterial, 0, 180, Short.MAX_VALUE)
                                    .addComponent(cmbEstilo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(chkGira)
                                .addGap(18, 18, 18)
                                .addComponent(chkReclina)))))
                .addContainerGap(36, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnInsert)
                .addGap(102, 102, 102))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cmbMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cmbEstilo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chkGira)
                    .addComponent(chkReclina))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(btnInsert)
                .addGap(25, 25, 25))
        );

        jTabbedPane1.addTab("Nueva silla", jPanel1);

        jLabel4.setText("Silla");

        cmbSilla.setModel(Gestor.sillas);
        cmbSilla.addItemListener(new java.awt.event.ItemListener()
        {
            public void itemStateChanged(java.awt.event.ItemEvent evt)
            {
                cmbSillaItemStateChanged(evt);
            }
        });

        jLabel5.setText("MATERIAL");

        jLabel6.setText("ESTILO");

        cmbMaterial1.setModel(Gestor.materiales);

        cmbEstilo1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Moderno", "Rustico", "Clásico" }));

        chkGira1.setText("Giratoria");

        chkReclina1.setText("Reclinable");

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnUpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel6))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(cmbMaterial1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(cmbEstilo1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cmbSilla, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                    .addComponent(chkGira1)
                                    .addGap(18, 18, 18)
                                    .addComponent(chkReclina1)))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(129, 129, 129)
                        .addComponent(btnUpdate)))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cmbSilla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cmbMaterial1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cmbEstilo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chkGira1)
                    .addComponent(chkReclina1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(btnUpdate)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Update", jPanel2);

        cmbSilla1.setModel(Gestor.sillas);
        cmbSilla1.addItemListener(new java.awt.event.ItemListener()
        {
            public void itemStateChanged(java.awt.event.ItemEvent evt)
            {
                cmbSilla1ItemStateChanged(evt);
            }
        });

        jLabel7.setText("Silla");

        btnDelete.setText("DELETE");
        btnDelete.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(cmbSilla1, 0, 180, Short.MAX_VALUE)
                .addGap(59, 59, 59))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnDelete)
                .addGap(119, 119, 119))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cmbSilla1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(btnDelete)
                .addContainerGap(109, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Delete", jPanel3);

        getContentPane().add(jTabbedPane1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnInsertActionPerformed
    {//GEN-HEADEREND:event_btnInsertActionPerformed
        int gira = 0;
        int reclina = 0;
        if(chkGira.isSelected())
        {
            gira = 1;
        }
        if(chkReclina.isSelected())
        {
            reclina = 1;
        }
        Gestor.insertSilla(
                ((Material)cmbMaterial.getSelectedItem()).getCod(),
                String.valueOf(cmbEstilo.getSelectedItem()),
                gira,reclina
        );
        JOptionPane.showMessageDialog(this,"Producto guardado correctamente");
        Gestor.updateSillas();
        chkGira.setSelected(false);
        chkReclina.setSelected(false);
       cmbEstilo.setSelectedIndex(0);
       cmbMaterial.setSelectedIndex(0);
        // TODO add your handling code here:
    }//GEN-LAST:event_btnInsertActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnUpdateActionPerformed
    {//GEN-HEADEREND:event_btnUpdateActionPerformed
        int gira = 0;
        int reclina = 0;
        if(chkGira1.isSelected())
        {
            gira = 1;
        }
        if(chkReclina1.isSelected())
        {
            reclina = 1;
        }
        Gestor.updateSeat(
                ((Material)cmbMaterial1.getSelectedItem()).getCod(),
                ((Silla)cmbSilla.getSelectedItem()).getId(),
                cmbEstilo.getSelectedItem().toString(),
                gira,reclina
        );
          JOptionPane.showMessageDialog(this,"Producto modificado correctamente");
        Gestor.updateSillas();
         chkGira1.setSelected(false);
        chkReclina1.setSelected(false);
       cmbEstilo1.setSelectedIndex(0);
       cmbMaterial1.setSelectedIndex(0);
        // TODO add your handling code here:
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void cmbSillaItemStateChanged(java.awt.event.ItemEvent evt)//GEN-FIRST:event_cmbSillaItemStateChanged
    {//GEN-HEADEREND:event_cmbSillaItemStateChanged
        if(evt.getStateChange() == ItemEvent.SELECTED)
        {
            Silla s = (((Silla)cmbSilla.getSelectedItem()));
            cmbEstilo1.getModel().setSelectedItem(s.getEstilo());
            cmbMaterial1.setSelectedItem(Gestor.getMaterial(s.getCod()));
            if(s.getGiratoria() == 1)
            {
                chkGira1.setSelected(true);
            }
            else
            {
                chkGira1.setSelected(false);
            }
            if(s.getReclinable() == 1)
            {
                chkReclina1.setSelected(true);
            }
            else
            {
                chkReclina1.setSelected(false);
            }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbSillaItemStateChanged

    private void cmbSilla1ItemStateChanged(java.awt.event.ItemEvent evt)//GEN-FIRST:event_cmbSilla1ItemStateChanged
    {//GEN-HEADEREND:event_cmbSilla1ItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbSilla1ItemStateChanged

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnDeleteActionPerformed
    {//GEN-HEADEREND:event_btnDeleteActionPerformed
if(Gestor.delete("delete from silla where id="+((Silla)cmbSilla1.getSelectedItem()).getId())==0){
    JOptionPane.showMessageDialog(this,"Registro eliminado correctamente");
}
Gestor.updateSillas();
        

// TODO add your handling code here:
    }//GEN-LAST:event_btnDeleteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnInsert;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JCheckBox chkGira;
    private javax.swing.JCheckBox chkGira1;
    private javax.swing.JCheckBox chkReclina;
    private javax.swing.JCheckBox chkReclina1;
    private javax.swing.JComboBox<String> cmbEstilo;
    private javax.swing.JComboBox<String> cmbEstilo1;
    private javax.swing.JComboBox<modelo.Material> cmbMaterial;
    private javax.swing.JComboBox<modelo.Material> cmbMaterial1;
    private javax.swing.JComboBox<Silla> cmbSilla;
    private javax.swing.JComboBox<Silla> cmbSilla1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
Pp p;

}
