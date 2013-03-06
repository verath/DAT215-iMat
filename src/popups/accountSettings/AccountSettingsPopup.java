/*
 * AccountSettingsPopup.java
 *
 * Created on Feb 21, 2013, 4:37:10 PM
 */
package popups.accountSettings;

import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JDialog;
import se.chalmers.ait.dat215.project.CreditCard;
import se.chalmers.ait.dat215.project.Customer;
import se.chalmers.ait.dat215.project.IMatDataHandler;

/**
 *
 * @author Ernst, Peter
 */
public class AccountSettingsPopup extends javax.swing.JPanel {

    private JDialog dialogFrame;
    private Customer customer = IMatDataHandler.getInstance().getCustomer();
    private CreditCard creditCard = IMatDataHandler.getInstance().getCreditCard();
    public static final Dimension PREFERRED_SIZE = new Dimension(700, 400);
    public static final String DIALOG_TITLE = "Kontoinställningar";

    /** Creates new form AccountSettingsView */
    public AccountSettingsPopup() {
        initComponents();

        // Get saved info for the account settings fields
        accNameField.setText(customer.getFirstName());
        accLastNameField.setText(customer.getLastName());
        accPhoneField.setText(customer.getPhoneNumber());
        accPostalCodeField.setText(customer.getPostCode());
        accCityField.setText(customer.getPostAddress());
        accAddressField.setText(customer.getAddress());

        // And get info for the card settings fields
        cardNumberField.setText(creditCard.getCardNumber());
        cardNameField.setText(creditCard.getHoldersName());
        if (creditCard.getVerificationCode() > 0) {
            cardCSVField.setText("" + creditCard.getVerificationCode());
        }

        // Card type
        if (creditCard.getCardType().equalsIgnoreCase("MASTERCARD")) {
            cardTypeMasterRadioButton.setSelected(true);
        } else {
            cardTypeVisaRadioButton.setSelected(true);
        }

        // Card expire date
        cardMonthComboBox.setSelectedItem("" + creditCard.getValidMonth());
        cardYearComboBox.setSelectedItem("" + creditCard.getValidYear());

    }

    public AccountSettingsPopup(JDialog dialogFrame) {
        this();
        this.dialogFrame = dialogFrame;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cardTypeButtonGroup = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        accountSettingContainer = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        accNameField = new javax.swing.JTextField();
        accLastNameField = new javax.swing.JTextField();
        accAddressField = new javax.swing.JTextField();
        accPostalCodeField = new javax.swing.JTextField();
        accCityField = new javax.swing.JTextField();
        accPhoneField = new javax.swing.JTextField();
        cardSettingContainer = new javax.swing.JPanel();
        cardTypeVisaRadioButton = new javax.swing.JRadioButton();
        cardTypeMasterRadioButton = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cardNumberField = new javax.swing.JTextField();
        cardNameField = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        cardCSVField = new javax.swing.JTextField();
        dontSaveCardCheckBox = new javax.swing.JCheckBox();
        jLabel12 = new javax.swing.JLabel();
        cardYearComboBox = new javax.swing.JComboBox();
        jLabel13 = new javax.swing.JLabel();
        cardMonthComboBox = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        cancelButton = new javax.swing.JButton();
        saveSettingsButton = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(800, 600));
        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.Y_AXIS));

        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.X_AXIS));

        accountSettingContainer.setBorder(javax.swing.BorderFactory.createTitledBorder("Kontouppgifter"));
        accountSettingContainer.setPreferredSize(new java.awt.Dimension(400, 355));

        jLabel1.setFont(new java.awt.Font("Myriad Pro", 0, 12));
        jLabel1.setText("Förnamn:");

        jLabel2.setFont(new java.awt.Font("Myriad Pro", 0, 12));
        jLabel2.setText("Efternamn:");

        jLabel3.setFont(new java.awt.Font("Myriad Pro", 0, 12));
        jLabel3.setText("Adress:");

        jLabel4.setFont(new java.awt.Font("Myriad Pro", 0, 12));
        jLabel4.setText("Postnummer:");

        jLabel5.setFont(new java.awt.Font("Myriad Pro", 0, 12));
        jLabel5.setText("Ort:");

        jLabel6.setFont(new java.awt.Font("Myriad Pro", 0, 12));
        jLabel6.setText("Telefon:");

        accNameField.setFont(new java.awt.Font("Myriad Pro", 0, 12));

        accLastNameField.setFont(new java.awt.Font("Myriad Pro", 0, 12));

        accAddressField.setFont(new java.awt.Font("Myriad Pro", 0, 12));

        accPostalCodeField.setFont(new java.awt.Font("Myriad Pro", 0, 12));

        accCityField.setFont(new java.awt.Font("Myriad Pro", 0, 12));

        accPhoneField.setFont(new java.awt.Font("Myriad Pro", 0, 12));

        javax.swing.GroupLayout accountSettingContainerLayout = new javax.swing.GroupLayout(accountSettingContainer);
        accountSettingContainer.setLayout(accountSettingContainerLayout);
        accountSettingContainerLayout.setHorizontalGroup(
            accountSettingContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(accountSettingContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(accountSettingContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(accountSettingContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(accPhoneField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
                    .addComponent(accCityField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
                    .addComponent(accPostalCodeField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
                    .addComponent(accAddressField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
                    .addComponent(accLastNameField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
                    .addComponent(accNameField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE))
                .addContainerGap())
        );
        accountSettingContainerLayout.setVerticalGroup(
            accountSettingContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(accountSettingContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(accountSettingContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(accNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(accountSettingContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(accLastNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(accountSettingContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(accAddressField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(accountSettingContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(accPostalCodeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(accountSettingContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(accCityField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(accountSettingContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(accPhoneField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addContainerGap(120, Short.MAX_VALUE))
        );

        jPanel1.add(accountSettingContainer);

        cardSettingContainer.setBorder(javax.swing.BorderFactory.createTitledBorder("Kortuppgifter"));
        cardSettingContainer.setFont(new java.awt.Font("Myriad Pro", 0, 11));
        cardSettingContainer.setPreferredSize(new java.awt.Dimension(400, 355));

        cardTypeButtonGroup.add(cardTypeVisaRadioButton);
        cardTypeVisaRadioButton.setFont(new java.awt.Font("Myriad Pro", 0, 12));
        cardTypeVisaRadioButton.setText("VISA");

        cardTypeButtonGroup.add(cardTypeMasterRadioButton);
        cardTypeMasterRadioButton.setFont(new java.awt.Font("Myriad Pro", 0, 12));
        cardTypeMasterRadioButton.setText("Mastercard");

        jLabel7.setFont(new java.awt.Font("Myriad Pro", 0, 12));
        jLabel7.setLabelFor(cardNumberField);
        jLabel7.setText("Kortnummer:");

        jLabel8.setFont(new java.awt.Font("Myriad Pro", 0, 12));
        jLabel8.setLabelFor(cardNameField);
        jLabel8.setText("Namn:");

        jLabel10.setLabelFor(cardTypeVisaRadioButton);
        jLabel10.setText("Korttyp:");

        cardNumberField.setFont(new java.awt.Font("Myriad Pro", 0, 12));

        cardNameField.setFont(new java.awt.Font("Myriad Pro", 0, 12));

        jLabel11.setLabelFor(cardCSVField);
        jLabel11.setText("CSV:");

        cardCSVField.setFont(new java.awt.Font("Myriad Pro", 0, 12));

        dontSaveCardCheckBox.setFont(new java.awt.Font("Myriad Pro", 0, 12));
        dontSaveCardCheckBox.setText("Spara inte mitt kort");
        dontSaveCardCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dontSaveCardCheckBoxActionPerformed(evt);
            }
        });

        jLabel12.setText("Giltigt till:");

        cardYearComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "År", "2013", "2014", "2015", "2016", "2017" }));

        jLabel13.setText("/");

        cardMonthComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Månad", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));

        javax.swing.GroupLayout cardSettingContainerLayout = new javax.swing.GroupLayout(cardSettingContainer);
        cardSettingContainer.setLayout(cardSettingContainerLayout);
        cardSettingContainerLayout.setHorizontalGroup(
            cardSettingContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardSettingContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(cardSettingContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cardSettingContainerLayout.createSequentialGroup()
                        .addGroup(cardSettingContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(cardSettingContainerLayout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(12, 12, 12))
                            .addGroup(cardSettingContainerLayout.createSequentialGroup()
                                .addGroup(cardSettingContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel12))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(cardSettingContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(cardSettingContainerLayout.createSequentialGroup()
                                .addComponent(cardTypeVisaRadioButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cardTypeMasterRadioButton))
                            .addComponent(cardNameField, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
                            .addGroup(cardSettingContainerLayout.createSequentialGroup()
                                .addComponent(cardNumberField, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cardCSVField, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(cardSettingContainerLayout.createSequentialGroup()
                                .addComponent(cardMonthComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cardYearComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(dontSaveCardCheckBox))
                .addContainerGap())
        );
        cardSettingContainerLayout.setVerticalGroup(
            cardSettingContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardSettingContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(cardSettingContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cardTypeVisaRadioButton)
                    .addComponent(cardTypeMasterRadioButton)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(cardSettingContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cardNumberField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel11)
                    .addComponent(cardCSVField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(cardSettingContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cardNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(cardSettingContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(cardMonthComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(cardYearComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(dontSaveCardCheckBox)
                .addContainerGap(144, Short.MAX_VALUE))
        );

        jPanel1.add(cardSettingContainer);

        add(jPanel1);

        cancelButton.setText("Avbryt");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        saveSettingsButton.setText("Spara Uppgifter");
        saveSettingsButton.setMaximumSize(new java.awt.Dimension(123, 50));
        saveSettingsButton.setMinimumSize(new java.awt.Dimension(123, 50));
        saveSettingsButton.setPreferredSize(new java.awt.Dimension(123, 50));
        saveSettingsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveSettingsButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(567, Short.MAX_VALUE)
                .addComponent(cancelButton)
                .addGap(18, 18, 18)
                .addComponent(saveSettingsButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(121, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveSettingsButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelButton))
                .addContainerGap())
        );

        add(jPanel2);
    }// </editor-fold>//GEN-END:initComponents

private void dontSaveCardCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dontSaveCardCheckBoxActionPerformed
    for (Component c : cardSettingContainer.getComponents()) {
        if (!c.equals(evt.getSource())) {
            c.setEnabled(!dontSaveCardCheckBox.isSelected());
        }
    }
}//GEN-LAST:event_dontSaveCardCheckBoxActionPerformed

private void saveSettingsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveSettingsButtonActionPerformed
    customer.setFirstName(accNameField.getText());
    customer.setLastName(accLastNameField.getText());
    customer.setPhoneNumber(accPhoneField.getText());
    customer.setPostCode(accPostalCodeField.getText());
    customer.setPostAddress(accCityField.getText());
    customer.setAddress(accAddressField.getText());

    if (dontSaveCardCheckBox.isSelected()) {
        // Clear all saved credit card info if user don't want it saved
        creditCard.setCardNumber("");
        creditCard.setCardType("");
        creditCard.setHoldersName("");
        creditCard.setValidMonth(-1);
        creditCard.setValidYear(-1);
        creditCard.setVerificationCode(0);
    } else {
        creditCard.setCardNumber(cardNumberField.getText());
        if (cardTypeMasterRadioButton.isSelected()) {
            creditCard.setCardType("MASTERCARD");
        } else {
            creditCard.setCardType("VISA");
        }
        creditCard.setHoldersName(cardNameField.getText());


        try {
            creditCard.setValidMonth(Integer.parseInt((String) cardMonthComboBox.getSelectedItem()));
        } catch (NumberFormatException ex) {
            creditCard.setValidMonth(-1);
        }
        try {
            creditCard.setValidYear(Integer.parseInt((String) cardYearComboBox.getSelectedItem()));
        } catch (NumberFormatException ex) {
            creditCard.setValidYear(-1);
        }

        try {
            creditCard.setVerificationCode(Integer.parseInt(cardCSVField.getText()));
        } catch (NumberFormatException ex) {
            creditCard.setVerificationCode(0);
        }

    }

    closeDialog();
}//GEN-LAST:event_saveSettingsButtonActionPerformed

private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
    closeDialog();
}//GEN-LAST:event_cancelButtonActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField accAddressField;
    private javax.swing.JTextField accCityField;
    private javax.swing.JTextField accLastNameField;
    private javax.swing.JTextField accNameField;
    private javax.swing.JTextField accPhoneField;
    private javax.swing.JTextField accPostalCodeField;
    private javax.swing.JPanel accountSettingContainer;
    private javax.swing.JButton cancelButton;
    private javax.swing.JTextField cardCSVField;
    private javax.swing.JComboBox cardMonthComboBox;
    private javax.swing.JTextField cardNameField;
    private javax.swing.JTextField cardNumberField;
    private javax.swing.JPanel cardSettingContainer;
    private javax.swing.ButtonGroup cardTypeButtonGroup;
    private javax.swing.JRadioButton cardTypeMasterRadioButton;
    private javax.swing.JRadioButton cardTypeVisaRadioButton;
    private javax.swing.JComboBox cardYearComboBox;
    private javax.swing.JCheckBox dontSaveCardCheckBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton saveSettingsButton;
    // End of variables declaration//GEN-END:variables

    private void closeDialog() {
        if (dialogFrame != null) {
            dialogFrame.setVisible(false);
        }
    }
}
