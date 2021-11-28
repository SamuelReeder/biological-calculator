/*
 * WARNING: There is nothing in this file for students to edit or change.
 *          This file is intended to have no student-serviceable code.
 *
 * "Draw" your GUI using the "Design" tab, and remember to give
 * them memorable variable names in the "Properties" panel
 * as well as make them public variables.
 * 
 * For convenience, you may want to set the default visibility of 
 * GUI elements to be public by going to:
 *    The NetBeans Preferences or Settings menu -> Miscellaneous -> GUI Builder
 * Then set Variables Modifier to public.
 */
package cs20viewcontroller;

import cs20models.AllModelsForView;

/**
 * WARNING: Do NOT modify or write any code in this file!
 *
 * @author cheng
 */
public class DrawnView extends AllModelsForView {
    // WARNING: Do NOT modify or write any code in this file!
    // <editor-fold defaultstate="collapsed" desc="Generated Code">

    public DrawnView() {
        initComponents();
    }// </editor-fold>

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        typeSelectorField = new javax.swing.JComboBox<>();
        inputField = new javax.swing.JTextField();
        clearButton = new javax.swing.JButton();
        submitButton = new javax.swing.JButton();
        typeSelectorField1 = new javax.swing.JComboBox<>();
        outputField = new javax.swing.JTextField();
        saveButton = new javax.swing.JButton();
        openButton = new javax.swing.JButton();
        formatButton = new javax.swing.JButton();
        deFormatButton = new javax.swing.JButton();
        infoButton = new javax.swing.JButton();
        errorButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        typeSelectorField.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "DNA", "mRNA", "tRNA" }));

        inputField.setToolTipText("Enter your sequence");
        inputField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        clearButton.setText("Clear");

        submitButton.setText("Submit");

        typeSelectorField1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "DNA", "DNA Complementary Strand", "mRNA", "tRNA", "Amino Acid" }));

        outputField.setEditable(false);
        outputField.setToolTipText("Enter your sequence");

        saveButton.setText("Save");

        openButton.setText("Open");

        formatButton.setText("Format");

        deFormatButton.setText("Un-format");

        infoButton.setText("Info");

        errorButton.setText("Resolve error");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(submitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(clearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(formatButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deFormatButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(errorButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(infoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(openButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(typeSelectorField, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(typeSelectorField1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(outputField, javax.swing.GroupLayout.DEFAULT_SIZE, 446, Short.MAX_VALUE)
                            .addComponent(inputField))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(typeSelectorField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(typeSelectorField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(outputField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clearButton)
                    .addComponent(submitButton)
                    .addComponent(saveButton)
                    .addComponent(openButton)
                    .addComponent(formatButton)
                    .addComponent(deFormatButton)
                    .addComponent(infoButton)
                    .addComponent(errorButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // WARNING: Do NOT modify or write any code in this file!
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton clearButton;
    public javax.swing.JButton deFormatButton;
    public javax.swing.JButton errorButton;
    public javax.swing.JButton formatButton;
    public javax.swing.JButton infoButton;
    public javax.swing.JTextField inputField;
    public javax.swing.JButton openButton;
    public javax.swing.JTextField outputField;
    public javax.swing.JButton saveButton;
    public javax.swing.JButton submitButton;
    public javax.swing.JComboBox<String> typeSelectorField;
    public javax.swing.JComboBox<String> typeSelectorField1;
    // End of variables declaration//GEN-END:variables
}