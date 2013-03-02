/*
 * ShoppingCartItemView.java
 *
 * Created on Feb 20, 2013, 1:05:28 PM
 */
package Views.ShoppingCart;

import Main.NumberUtil;
import Main.ShoppingCartWrapper;
import java.awt.Color;
import se.chalmers.ait.dat215.project.Product;
import se.chalmers.ait.dat215.project.ShoppingItem;

/**
 *
 * @author Philip
 */
public class ShoppingCartItemView extends javax.swing.JPanel {
    
    /**
     * The shoppingItem this view is representing
     */
    private ShoppingItem shoppingItem;

    /** Creates new ShoppingCartItemView */
    public ShoppingCartItemView() {
        initComponents();
    }
    
    /**
     * Sets the ShoppingItem this view is representing
     * @param shoppingItem 
     */
    public void setShoppingItem(ShoppingItem shoppingItem) {
        if(shoppingItem == null || shoppingItem.getProduct() == null ) {
            this.setVisible(false);
            return;
        }
        
        this.shoppingItem = shoppingItem;

        Product product = shoppingItem.getProduct();
        
        double amount = shoppingItem.getAmount();
        double totalPrice = shoppingItem.getTotal();
        
        // Set the labels to the new value.
        nameLabel.setText(product.getName());
        unitMeasureLabel.setText(product.getUnitSuffix());
        priceLabel.setText(NumberUtil.roundTwoDecimals(totalPrice) + " kr");
        countSpinner.setValue(amount);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        nameLabel = new javax.swing.JLabel();
        countSpinner = new javax.swing.JSpinner();
        unitMeasureLabel = new javax.swing.JLabel();
        RemoveButton = new javax.swing.JLabel();
        priceLabel = new javax.swing.JLabel();

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(Main.MainApp.class).getContext().getResourceMap(ShoppingCartItemView.class);
        jButton1.setText(resourceMap.getString("jButton1.text")); // NOI18N
        jButton1.setName("jButton1"); // NOI18N

        setMaximumSize(new java.awt.Dimension(287, 33));
        setMinimumSize(new java.awt.Dimension(287, 33));
        setName("Form"); // NOI18N
        setPreferredSize(new java.awt.Dimension(287, 33));

        jPanel1.setName("jPanel1"); // NOI18N
        jPanel1.setOpaque(false);

        nameLabel.setFont(resourceMap.getFont("unitMeasureLabel.font")); // NOI18N
        nameLabel.setText(resourceMap.getString("nameLabel.text")); // NOI18N
        nameLabel.setName("nameLabel"); // NOI18N

        countSpinner.setModel(new javax.swing.SpinnerNumberModel(Double.valueOf(1.0d), Double.valueOf(0.009999999776482582d), null, Double.valueOf(1.0d)));
        countSpinner.setName("countSpinner"); // NOI18N
        countSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                countSpinnerStateChanged(evt);
            }
        });

        unitMeasureLabel.setFont(resourceMap.getFont("unitMeasureLabel.font")); // NOI18N
        unitMeasureLabel.setText(resourceMap.getString("unitMeasureLabel.text")); // NOI18N
        unitMeasureLabel.setName("unitMeasureLabel"); // NOI18N

        RemoveButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        RemoveButton.setText(resourceMap.getString("RemoveButton.text")); // NOI18N
        RemoveButton.setName("RemoveButton"); // NOI18N
        RemoveButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RemoveButtonMouseClicked(evt);
            }
        });

        priceLabel.setFont(resourceMap.getFont("unitMeasureLabel.font")); // NOI18N
        priceLabel.setText(resourceMap.getString("priceLabel.text")); // NOI18N
        priceLabel.setName("priceLabel"); // NOI18N

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(nameLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 81, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(countSpinner, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 52, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(2, 2, 2)
                .add(unitMeasureLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 31, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(priceLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 51, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(RemoveButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 18, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.CENTER)
                .add(nameLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                .add(countSpinner, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                .add(unitMeasureLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                .add(priceLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                .add(RemoveButton, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE))
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(40, 40, 40))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

private void RemoveButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RemoveButtonMouseClicked
    // When the Remove "button" is clicked, remove our product from the shopping
    // cart and hide the the item itself.
    ShoppingCartWrapper.INSTANCE.removeProduct(shoppingItem.getProduct());
    this.setVisible(false);
}//GEN-LAST:event_RemoveButtonMouseClicked

private void countSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_countSpinnerStateChanged
    double val = (Double)countSpinner.getValue();
    if( val != shoppingItem.getAmount() ){
        ShoppingCartWrapper.INSTANCE.updateProduct(shoppingItem.getProduct(), val);
    }
}//GEN-LAST:event_countSpinnerStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel RemoveButton;
    private javax.swing.JSpinner countSpinner;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JLabel priceLabel;
    private javax.swing.JLabel unitMeasureLabel;
    // End of variables declaration//GEN-END:variables

    void setIsEven(boolean even) {
        if( even ) {
            setBackground(Color.WHITE);
        }
    }
}
