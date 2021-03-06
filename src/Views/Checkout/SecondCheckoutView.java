/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * SecondCheckoutView.java
 *
 * Created on Feb 27, 2013, 2:45:14 PM
 */
package Views.Checkout;

import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import se.chalmers.ait.dat215.project.CreditCard;
import se.chalmers.ait.dat215.project.Customer;
import se.chalmers.ait.dat215.project.IMatDataHandler;

/**
 *
 * @author Philip
 */
public class SecondCheckoutView extends javax.swing.JPanel {

    IMatDataHandler imdh = IMatDataHandler.getInstance();
    Customer customer;
    CreditCard creditCard;

    /** Creates new form SecondCheckoutView */
    public SecondCheckoutView() {
        initComponents();
        initCustomerSettings();
        initCardSettings();
    }

    private void initCustomerSettings() {
        customer = imdh.getCustomer();

        address.setText(customer.getAddress());
        city.setText(customer.getPostAddress());
        firstName.setText(customer.getFirstName());
        lastName.setText(customer.getLastName());
        phone.setText(customer.getPhoneNumber());
        postalCode.setText(customer.getPostCode());
    }

    public String getAddress() {
        return address.getText();
    }

    public String getPostalCode() {
        return postalCode.getText();
    }

    public String getCity() {
        return city.getText();
    }

    private void initCardSettings() {
        creditCard = imdh.getCreditCard();

        cardNumber.setText(creditCard.getCardNumber());
        cardHolderName.setText(creditCard.getHoldersName());

        if (creditCard.getVerificationCode() == 0) {
            cvc.setText("");
        } else {
            cvc.setText("" + creditCard.getVerificationCode());
        }

        if ("Visa".equalsIgnoreCase(creditCard.getCardType())) {
            visa.setSelected(true);
        } else if ("MasterCard".equalsIgnoreCase(creditCard.getCardType())) {
            masterCard.setSelected(true);
        } else {
            visa.setSelected(false);
            masterCard.setSelected(false);
        }
    }

    public boolean settingsSaved() {
        return saveSettingCheckbox.isSelected();
    }

    public void saveSettings() {
        if (saveSettingCheckbox.isSelected()) {
            customer.setAddress(address.getText());
            customer.setPostAddress(city.getText());
            customer.setFirstName(firstName.getText());
            customer.setLastName(lastName.getText());
            customer.setPhoneNumber(phone.getText());
            customer.setPostCode(postalCode.getText());

            creditCard.setCardNumber(cardNumber.getText());
            creditCard.setHoldersName(cardHolderName.getText());

            try {
                creditCard.setVerificationCode(Integer.parseInt(cvc.getText()));
            } catch (NumberFormatException ex) {
                creditCard.setVerificationCode(0);
            }

            if (visa.isSelected()) {
                creditCard.setCardType("Visa");
            } else if (masterCard.isSelected()) {
                creditCard.setCardType("MasterCard");
            }
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        firstNameLabel = new javax.swing.JLabel();
        lastNameLabel = new javax.swing.JLabel();
        postalCodeLabel = new javax.swing.JLabel();
        addressLabel = new javax.swing.JLabel();
        cityLabel = new javax.swing.JLabel();
        phoneLabel = new javax.swing.JLabel();
        firstName = new javax.swing.JTextField();
        lastName = new javax.swing.JTextField();
        address = new javax.swing.JTextField();
        postalCode = new javax.swing.JTextField();
        city = new javax.swing.JTextField();
        phone = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        cardNumber = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        cvc = new javax.swing.JTextField();
        visa = new javax.swing.JRadioButton();
        masterCard = new javax.swing.JRadioButton();
        jLabel9 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        cardHolderName = new javax.swing.JTextField();
        saveSettingCheckbox = new javax.swing.JCheckBox();

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(Main.MainApp.class).getContext().getResourceMap(SecondCheckoutView.class);
        setBackground(resourceMap.getColor("Form.background")); // NOI18N
        setName("Form"); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, resourceMap.getString("jPanel1.border.title"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, resourceMap.getFont("jPanel1.border.titleFont"))); // NOI18N
        jPanel1.setName("jPanel1"); // NOI18N
        jPanel1.setOpaque(false);

        firstNameLabel.setText(resourceMap.getString("firstNameLabel.text")); // NOI18N
        firstNameLabel.setName("firstNameLabel"); // NOI18N

        lastNameLabel.setText(resourceMap.getString("lastNameLabel.text")); // NOI18N
        lastNameLabel.setName("lastNameLabel"); // NOI18N

        postalCodeLabel.setText(resourceMap.getString("postalCodeLabel.text")); // NOI18N
        postalCodeLabel.setName("postalCodeLabel"); // NOI18N

        addressLabel.setText(resourceMap.getString("addressLabel.text")); // NOI18N
        addressLabel.setName("addressLabel"); // NOI18N

        cityLabel.setText(resourceMap.getString("cityLabel.text")); // NOI18N
        cityLabel.setName("cityLabel"); // NOI18N

        phoneLabel.setText(resourceMap.getString("phoneLabel.text")); // NOI18N
        phoneLabel.setName("phoneLabel"); // NOI18N

        firstName.setText(resourceMap.getString("firstName.text")); // NOI18N
        firstName.setName("firstName"); // NOI18N
        firstName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                onFieldFocus(evt);
            }
        });

        lastName.setText(resourceMap.getString("lastName.text")); // NOI18N
        lastName.setName("lastName"); // NOI18N
        lastName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                onFieldFocus(evt);
            }
        });

        address.setText(resourceMap.getString("address.text")); // NOI18N
        address.setName("address"); // NOI18N
        address.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                onFieldFocus(evt);
            }
        });

        postalCode.setText(resourceMap.getString("postalCode.text")); // NOI18N
        postalCode.setName("postalCode"); // NOI18N
        postalCode.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                onFieldFocus(evt);
            }
        });

        city.setText(resourceMap.getString("city.text")); // NOI18N
        city.setName("city"); // NOI18N
        city.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                onFieldFocus(evt);
            }
        });

        phone.setText(resourceMap.getString("phone.text")); // NOI18N
        phone.setName("phone"); // NOI18N
        phone.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                onFieldFocus(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(firstNameLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 137, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(firstName, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 190, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(postalCodeLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 137, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(postalCode, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 190, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(cityLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 137, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(city, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 190, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(lastNameLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 137, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(lastName, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 190, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(addressLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 137, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(address, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 190, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(phoneLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 137, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(phone, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 190, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(firstNameLabel)
                    .add(firstName, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(lastNameLabel)
                    .add(lastName, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(addressLabel)
                    .add(address, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(9, 9, 9)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(postalCodeLabel)
                    .add(postalCode, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(cityLabel)
                    .add(city, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(phoneLabel)
                    .add(phone, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, resourceMap.getString("jPanel2.border.title"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, resourceMap.getFont("jPanel2.border.titleFont"))); // NOI18N
        jPanel2.setName("jPanel2"); // NOI18N
        jPanel2.setOpaque(false);

        jLabel7.setText(resourceMap.getString("jLabel7.text")); // NOI18N
        jLabel7.setName("jLabel7"); // NOI18N

        cardNumber.setText(resourceMap.getString("cardNumber.text")); // NOI18N
        cardNumber.setName("cardNumber"); // NOI18N
        cardNumber.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                onFieldFocus(evt);
            }
        });

        jLabel8.setText(resourceMap.getString("jLabel8.text")); // NOI18N
        jLabel8.setName("jLabel8"); // NOI18N

        cvc.setText(resourceMap.getString("cvc.text")); // NOI18N
        cvc.setName("cvc"); // NOI18N
        cvc.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                onFieldFocus(evt);
            }
        });

        buttonGroup1.add(visa);
        visa.setText(resourceMap.getString("visa.text")); // NOI18N
        visa.setName("visa"); // NOI18N
        visa.setOpaque(false);

        buttonGroup1.add(masterCard);
        masterCard.setText(resourceMap.getString("masterCard.text")); // NOI18N
        masterCard.setName("masterCard"); // NOI18N
        masterCard.setOpaque(false);

        jLabel9.setText(resourceMap.getString("jLabel9.text")); // NOI18N
        jLabel9.setName("jLabel9"); // NOI18N

        jComboBox1.setMaximumRowCount(12);
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
        jComboBox1.setName("jComboBox1"); // NOI18N

        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2013", "2014", "2015", "2016", "2017" }));
        jComboBox2.setName("jComboBox2"); // NOI18N

        jLabel10.setText(resourceMap.getString("jLabel10.text")); // NOI18N
        jLabel10.setName("jLabel10"); // NOI18N

        cardHolderName.setName("cardHolderName"); // NOI18N
        cardHolderName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                onFieldFocus(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel2Layout = new org.jdesktop.layout.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel2Layout.createSequentialGroup()
                        .add(visa)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(masterCard))
                    .add(jPanel2Layout.createSequentialGroup()
                        .add(jLabel8, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 137, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(cvc, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 190, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(jPanel2Layout.createSequentialGroup()
                        .add(jLabel10, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 137, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(cardHolderName, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 190, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(jPanel2Layout.createSequentialGroup()
                        .add(jLabel7, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 137, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(cardNumber, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 190, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(jPanel2Layout.createSequentialGroup()
                        .add(jLabel9, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 137, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(jComboBox1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 59, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jLabel1)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jComboBox2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(visa)
                    .add(masterCard))
                .add(11, 11, 11)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel10)
                    .add(cardHolderName, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel8)
                    .add(cvc, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel7)
                    .add(cardNumber, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel9)
                    .add(jComboBox1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel1)
                    .add(jComboBox2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        saveSettingCheckbox.setText(resourceMap.getString("saveSettingCheckbox.text")); // NOI18N
        saveSettingCheckbox.setName("saveSettingCheckbox"); // NOI18N
        saveSettingCheckbox.setOpaque(false);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(saveSettingCheckbox)
                    .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                        .add(org.jdesktop.layout.GroupLayout.LEADING, jPanel2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(org.jdesktop.layout.GroupLayout.LEADING, jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(322, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jPanel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(saveSettingCheckbox)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

private void onFieldFocus(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_onFieldFocus
    if (evt.getSource() instanceof JTextField) {

        final JTextField field = (JTextField) evt.getSource();
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                field.selectAll();
            }
        });
    }
}//GEN-LAST:event_onFieldFocus
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField address;
    private javax.swing.JLabel addressLabel;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField cardHolderName;
    private javax.swing.JTextField cardNumber;
    private javax.swing.JTextField city;
    private javax.swing.JLabel cityLabel;
    private javax.swing.JTextField cvc;
    private javax.swing.JTextField firstName;
    private javax.swing.JLabel firstNameLabel;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField lastName;
    private javax.swing.JLabel lastNameLabel;
    private javax.swing.JRadioButton masterCard;
    private javax.swing.JTextField phone;
    private javax.swing.JLabel phoneLabel;
    private javax.swing.JTextField postalCode;
    private javax.swing.JLabel postalCodeLabel;
    private javax.swing.JCheckBox saveSettingCheckbox;
    private javax.swing.JRadioButton visa;
    // End of variables declaration//GEN-END:variables

    void updateCustomer() {
        initCustomerSettings();
        initCardSettings();
    }
}
