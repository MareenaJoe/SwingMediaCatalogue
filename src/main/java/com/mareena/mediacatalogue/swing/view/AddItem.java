/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mareena.mediacatalogue.swing.view;

import com.mareena.mediacatalogue.MediaFactory;
import com.mareena.mediacatalogue.model.json.*;
import com.mareena.mediacatalogue.swing.model.BaseModel;

/**
 *
 * @author mareenathomas
 */
public class AddItem extends javax.swing.JFrame {
    final BaseModel baseModel;
    String[] yearArr = {"1989", "1990", "1992", "1999", "1996", "2000", "2005", "2010", "2015", "2019", "2020"};
    /**
     * Creates new form AddItem
     */
    public AddItem(BaseModel baseModel) {
        this.baseModel = baseModel;
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

    jPanel2 = new javax.swing.JPanel();
    jLabel5 = new javax.swing.JLabel();
    jPanel3 = new javax.swing.JPanel();
    jLabel1 = new javax.swing.JLabel();
    titleTextField = new javax.swing.JTextField();
    jLabel2 = new javax.swing.JLabel();
    jScrollPane1 = new javax.swing.JScrollPane();
    descriptionTextArea = new javax.swing.JTextArea();
    jLabel3 = new javax.swing.JLabel();
    yearCombo = new javax.swing.JComboBox<>();
    jLabel4 = new javax.swing.JLabel();
    jScrollPane2 = new javax.swing.JScrollPane();
    genreTextArea = new javax.swing.JTextArea();
    jLabel6 = new javax.swing.JLabel();
    directorTextArea = new javax.swing.JTextField();
    jLabel7 = new javax.swing.JLabel();
    jScrollPane3 = new javax.swing.JScrollPane();
    castTextArea = new javax.swing.JTextArea();
    jLabel8 = new javax.swing.JLabel();
    tvSeriesCheckBox = new java.awt.Checkbox();
    saveButton = new javax.swing.JButton();

    getContentPane().setLayout(null);

    jPanel2.setBackground(new java.awt.Color(248, 148, 6));

    jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    jLabel5.setForeground(new java.awt.Color(255, 255, 255));
    jLabel5.setText("Add Item");

    javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
    jPanel2.setLayout(jPanel2Layout);
    jPanel2Layout.setHorizontalGroup(
      jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel2Layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(297, Short.MAX_VALUE))
    );
    jPanel2Layout.setVerticalGroup(
      jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel2Layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jLabel5)
        .addContainerGap(17, Short.MAX_VALUE))
    );

    getContentPane().add(jPanel2);
    jPanel2.setBounds(0, 0, 410, 40);

    jPanel3.setBackground(new java.awt.Color(44, 62, 80));

    jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
    jLabel1.setForeground(new java.awt.Color(236, 240, 241));
    jLabel1.setText("Title: ");

    titleTextField.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        titleTextFieldActionPerformed(evt);
      }
    });

    jLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
    jLabel2.setForeground(new java.awt.Color(236, 240, 241));
    jLabel2.setText("Description: ");

    descriptionTextArea.setColumns(20);
    descriptionTextArea.setRows(5);
    jScrollPane1.setViewportView(descriptionTextArea);

    jLabel3.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
    jLabel3.setForeground(new java.awt.Color(236, 240, 241));
    jLabel3.setText("Year:");

    yearCombo.setModel(new javax.swing.DefaultComboBoxModel<>(yearArr));

    jLabel4.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
    jLabel4.setForeground(new java.awt.Color(236, 240, 241));
    jLabel4.setText("Genre: ");

    genreTextArea.setColumns(20);
    genreTextArea.setRows(5);
    jScrollPane2.setViewportView(genreTextArea);

    jLabel6.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
    jLabel6.setForeground(new java.awt.Color(236, 240, 241));
    jLabel6.setText("Director: ");

    jLabel7.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
    jLabel7.setForeground(new java.awt.Color(236, 240, 241));
    jLabel7.setText("Cast: ");

    castTextArea.setColumns(20);
    castTextArea.setRows(5);
    jScrollPane3.setViewportView(castTextArea);

    jLabel8.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
    jLabel8.setForeground(new java.awt.Color(236, 240, 241));
    jLabel8.setText("TV Series: ");

    tvSeriesCheckBox.setLabel("checkbox1");

    saveButton.setBackground(new java.awt.Color(34, 167, 240));
    saveButton.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
    saveButton.setText("Save");
    saveButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        saveButtonActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
    jPanel3.setLayout(jPanel3Layout);
    jPanel3Layout.setHorizontalGroup(
      jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel3Layout.createSequentialGroup()
        .addGap(24, 24, 24)
        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jLabel2)
          .addComponent(jLabel4)
          .addComponent(jLabel6)
          .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jLabel8)
          .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(37, 37, 37)
        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(yearCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addGroup(jPanel3Layout.createSequentialGroup()
            .addComponent(tvSeriesCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(62, 62, 62)
            .addComponent(saveButton))
          .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
            .addComponent(directorTextArea, javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(titleTextField, javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
        .addContainerGap(44, Short.MAX_VALUE))
    );
    jPanel3Layout.setVerticalGroup(
      jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel3Layout.createSequentialGroup()
        .addGap(10, 10, 10)
        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel1)
          .addComponent(titleTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(18, 18, 18)
        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jLabel2)
          .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(18, 18, 18)
        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(yearCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(18, 18, 18)
        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jLabel4)
          .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(21, 21, 21)
        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel6)
          .addComponent(directorTextArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(29, 29, 29)
        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jLabel7)
          .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jLabel8)
          .addComponent(tvSeriesCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(saveButton))
        .addGap(13, 13, 13))
    );

    getContentPane().add(jPanel3);
    jPanel3.setBounds(0, 40, 410, 440);

    pack();
  }// </editor-fold>//GEN-END:initComponents

    private void titleTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_titleTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_titleTextFieldActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        Media media = buildMediaAndUpdateModel();
        System.out.println("Created new media model: " +media);
        baseModel.getVideoCatalogueController().actionAddNewMedia();
        baseModel.getVideoCatalogueController().actionAddMediaItemDisable();
    }//GEN-LAST:event_saveButtonActionPerformed

  /**
   * Add new media object & update it to the media state model by calling the factory
   * @return
   */
    private Media buildMediaAndUpdateModel() {
      Media media = MediaFactory.createMedia(titleTextField.getText(),
              yearCombo.getSelectedItem().toString(),
              castTextArea.getText(),genreTextArea.getText(),
              directorTextArea.getText(),
              descriptionTextArea.getText(),
              tvSeriesCheckBox.getState()
              );
      return media;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JTextArea castTextArea;
  private javax.swing.JTextArea descriptionTextArea;
  private javax.swing.JTextField directorTextArea;
  private javax.swing.JTextArea genreTextArea;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JLabel jLabel5;
  private javax.swing.JLabel jLabel6;
  private javax.swing.JLabel jLabel7;
  private javax.swing.JLabel jLabel8;
  private javax.swing.JPanel jPanel2;
  private javax.swing.JPanel jPanel3;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JScrollPane jScrollPane2;
  private javax.swing.JScrollPane jScrollPane3;
  private javax.swing.JButton saveButton;
  private javax.swing.JTextField titleTextField;
  private java.awt.Checkbox tvSeriesCheckBox;
  private javax.swing.JComboBox<String> yearCombo;
  // End of variables declaration//GEN-END:variables
}
