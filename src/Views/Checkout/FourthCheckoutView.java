/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FourthCheckoutView.java
 *
 * Created on Mar 1, 2013, 10:52:02 AM
 */
package Views.Checkout;

import Main.MainController;
import Main.NumberUtil;
import Main.ShoppingCartWrapper;
import java.util.List;
import se.chalmers.ait.dat215.project.Customer;
import se.chalmers.ait.dat215.project.IMatDataHandler;
import se.chalmers.ait.dat215.project.ShoppingCart;
import se.chalmers.ait.dat215.project.ShoppingItem;

/**
 *
 * @author Philip
 */
public class FourthCheckoutView extends javax.swing.JPanel {

    private IMatDataHandler imdh;
    private Customer c;
    
    /** Creates new form FourthCheckoutView */
    public FourthCheckoutView() {
        initComponents();
        imdh = IMatDataHandler.getInstance();
        c = imdh.getCustomer();
    }
    
    public void setThanksMessage () {
        thanksMessage.setText("Tack för att du valt att handla hos oss, " + c.getFirstName() +"!");
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        checkoutItemsHolder = new javax.swing.JPanel();
        thanksMessage = new javax.swing.JLabel();
        thanksMessage1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(Main.MainApp.class).getContext().getResourceMap(FourthCheckoutView.class);
        setBackground(resourceMap.getColor("Form.background")); // NOI18N
        setName("Form"); // NOI18N

        checkoutItemsHolder.setBorder(javax.swing.BorderFactory.createTitledBorder("Tack för ditt köp!"));
        checkoutItemsHolder.setName("checkoutItemsHolder"); // NOI18N
        checkoutItemsHolder.setOpaque(false);

        thanksMessage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        thanksMessage.setText(resourceMap.getString("thanksMessage.text")); // NOI18N
        thanksMessage.setName("thanksMessage"); // NOI18N

        thanksMessage1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        thanksMessage1.setName("thanksMessage1"); // NOI18N

        jButton1.setText(resourceMap.getString("jButton1.text")); // NOI18N
        jButton1.setName("jButton1"); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout checkoutItemsHolderLayout = new org.jdesktop.layout.GroupLayout(checkoutItemsHolder);
        checkoutItemsHolder.setLayout(checkoutItemsHolderLayout);
        checkoutItemsHolderLayout.setHorizontalGroup(
            checkoutItemsHolderLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(checkoutItemsHolderLayout.createSequentialGroup()
                .add(checkoutItemsHolderLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(checkoutItemsHolderLayout.createSequentialGroup()
                        .addContainerGap()
                        .add(checkoutItemsHolderLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(thanksMessage, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 422, Short.MAX_VALUE)
                            .add(thanksMessage1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 422, Short.MAX_VALUE)))
                    .add(checkoutItemsHolderLayout.createSequentialGroup()
                        .add(118, 118, 118)
                        .add(jButton1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 214, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        checkoutItemsHolderLayout.setVerticalGroup(
            checkoutItemsHolderLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(checkoutItemsHolderLayout.createSequentialGroup()
                .addContainerGap()
                .add(thanksMessage, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 91, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(thanksMessage1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 91, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(18, 18, 18)
                .add(jButton1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 59, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(70, Short.MAX_VALUE))
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(checkoutItemsHolder, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(137, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(checkoutItemsHolder, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(65, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    MainController.INSTANCE.showStartPanel();
}//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel checkoutItemsHolder;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel thanksMessage;
    private javax.swing.JLabel thanksMessage1;
    // End of variables declaration//GEN-END:variables
}
