
/*
 * ShoppingCart.java
 *
 * Created on Feb 20, 2013, 12:49:32 PM
 */
package Views.ShoppingCart;

import Main.NumberUtil;
import Main.ShoppingCartWrapper;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import se.chalmers.ait.dat215.project.ShoppingItem;

/**
 *
 * @author Philip
 */
public class ShoppingCartView extends javax.swing.JPanel {

    /**
     * The controller for our view.
     */
    private ShoppingCartController scController;
    /**
     * A list mapping shoppingItems to views, used when updating
     */
    private Map<ShoppingItem, ShoppingCartItemView> shoppingItemViews = new HashMap<ShoppingItem, ShoppingCartItemView>();

    /** Creates new form ShoppingCart */
    public ShoppingCartView() {
        initComponents();

        scController = new ShoppingCartController(this);
        scController.listenForShoppingEvents();
    }

    /**
     * Removes all ShoppingCartItemView from the shoppingCart.
     */
    private void clearShoppingCart() {
        shoppingItemsContainer.removeAll();
        shoppingItemViews.clear();
    }

    /**
     * Adds a ShoppingCartItemView to the cart
     * @param si 
     */
    private void addItemToCart(ShoppingItem si, boolean even) {
        ShoppingCartItemView sciv = new ShoppingCartItemView();
        sciv.setIsEven(even);
        sciv.setShoppingItem(si);
        shoppingItemViews.put(si, sciv);
        shoppingItemsContainer.add(sciv);
    }

    /**
     * Updates the total labels
     */
    private void updateTotals() {
        totalPriceLabel.setText(NumberUtil.roundTwoDecimals(ShoppingCartWrapper.INSTANCE.getTotal())
                + " kr");
        numItemsLabel.setText("" + ShoppingCartWrapper.INSTANCE.getNumItems());
    }

    /**
     * Takes a list of ShoppingItems and displays them as the
     * cart.
     * @param items 
     */
    public void setItemsInCart(List<ShoppingItem> items) {
        if (items == null) {
            return;
        }

        // We first remove all items in the cart
        clearShoppingCart();

        // Then we add all new ones
        int count = 0;
        for (ShoppingItem si : items) {
            addItemToCart(si, (count%2 == 0));
            
            count ++;
        }

        // Set total price/number of items.
        updateTotals();

        // Refresh view
        shoppingItemsContainer.validate();
        shoppingItemsContainer.repaint();
        scroll.validate();
        scroll.repaint();
    }

    /**
     * When an item is updated, but not added. Only update labels
     * instead of redrawing everything.
     * @param shoppingItem 
     */
    void shoppingCartItemUpdated(ShoppingItem shoppingItem) {
        // Pass the event forward
        ShoppingCartItemView siv = shoppingItemViews.get(shoppingItem);
        if (siv != null) {
            siv.setShoppingItem(shoppingItem);
        }

        // Update totals
        updateTotals();
    }
    
    public void setButtonsEnable(boolean enable) {
        checkoutButton.setEnabled(enable);
        saveCartButton.setEnabled(enable);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        titleLabel = new javax.swing.JLabel();
        scroll = new javax.swing.JScrollPane();
        shoppingItemsContainer = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        saveCartButton = new javax.swing.JButton();
        checkoutButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        numItemsLabel = new javax.swing.JLabel();
        totalPriceLabel = new javax.swing.JLabel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.setName("jTable1"); // NOI18N
        jScrollPane1.setViewportView(jTable1);

        jPanel1.setName("jPanel1"); // NOI18N

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 100, Short.MAX_VALUE)
        );

        jScrollPane2.setName("jScrollPane2"); // NOI18N

        setMaximumSize(new java.awt.Dimension(290, 32767));
        setMinimumSize(new java.awt.Dimension(290, 362));
        setName("Form"); // NOI18N
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(290, 362));

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(Main.MainApp.class).getContext().getResourceMap(ShoppingCartView.class);
        titleLabel.setFont(resourceMap.getFont("titleLabel.font")); // NOI18N
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel.setText(resourceMap.getString("titleLabel.text")); // NOI18N
        titleLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        titleLabel.setName("titleLabel"); // NOI18N

        scroll.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        scroll.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setMaximumSize(new java.awt.Dimension(287, 32767));
        scroll.setMinimumSize(new java.awt.Dimension(287, 33));
        scroll.setName("scroll"); // NOI18N
        scroll.setOpaque(false);
        scroll.setPreferredSize(new java.awt.Dimension(287, 33));

        shoppingItemsContainer.setBackground(resourceMap.getColor("shoppingItemsContainer.background")); // NOI18N
        shoppingItemsContainer.setMaximumSize(new java.awt.Dimension(287, 28000));
        shoppingItemsContainer.setMinimumSize(new java.awt.Dimension(287, 33));
        shoppingItemsContainer.setName("shoppingItemsContainer"); // NOI18N
        shoppingItemsContainer.setLayout(new javax.swing.BoxLayout(shoppingItemsContainer, javax.swing.BoxLayout.PAGE_AXIS));
        scroll.setViewportView(shoppingItemsContainer);

        jSeparator1.setName("jSeparator1"); // NOI18N

        saveCartButton.setText(resourceMap.getString("saveCartButton.text")); // NOI18N
        saveCartButton.setToolTipText(resourceMap.getString("saveCartButton.toolTipText")); // NOI18N
        saveCartButton.setEnabled(false);
        saveCartButton.setName("saveCartButton"); // NOI18N
        saveCartButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveCartButtonActionPerformed(evt);
            }
        });

        checkoutButton.setText(resourceMap.getString("checkoutButton.text")); // NOI18N
        checkoutButton.setToolTipText(resourceMap.getString("checkoutButton.toolTipText")); // NOI18N
        checkoutButton.setEnabled(false);
        checkoutButton.setName("checkoutButton"); // NOI18N
        checkoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkoutButtonActionPerformed(evt);
            }
        });

        jLabel2.setText(resourceMap.getString("jLabel2.text")); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N

        jLabel3.setText(resourceMap.getString("jLabel3.text")); // NOI18N
        jLabel3.setName("jLabel3"); // NOI18N

        numItemsLabel.setText(resourceMap.getString("numItemsLabel.text")); // NOI18N
        numItemsLabel.setName("numItemsLabel"); // NOI18N

        totalPriceLabel.setText(resourceMap.getString("totalPriceLabel.text")); // NOI18N
        totalPriceLabel.setName("totalPriceLabel"); // NOI18N

        filler1.setName("filler1"); // NOI18N

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jSeparator1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
                    .add(titleLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                            .add(org.jdesktop.layout.GroupLayout.LEADING, jLabel3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(org.jdesktop.layout.GroupLayout.LEADING, jLabel2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(numItemsLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(totalPriceLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
                        .add(102, 102, 102))
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(layout.createSequentialGroup()
                                .add(126, 126, 126)
                                .add(filler1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 19, Short.MAX_VALUE)
                                .add(23, 23, 23))
                            .add(layout.createSequentialGroup()
                                .add(saveCartButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 126, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)))
                        .add(checkoutButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 98, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .add(org.jdesktop.layout.GroupLayout.TRAILING, scroll, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(titleLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 29, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(scroll, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                .add(18, 18, 18)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel3)
                    .add(numItemsLabel))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel2)
                    .add(totalPriceLabel))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jSeparator1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 10, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                        .add(checkoutButton)
                        .add(saveCartButton))
                    .add(filler1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(17, 17, 17))
        );
    }// </editor-fold>//GEN-END:initComponents

private void checkoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkoutButtonActionPerformed
    scController.onCheckoutButtonActionPerformed(evt);
}//GEN-LAST:event_checkoutButtonActionPerformed

private void saveCartButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveCartButtonActionPerformed
    scController.onSaveCartButtonActionPerformed(evt);
}//GEN-LAST:event_saveCartButtonActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton checkoutButton;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel numItemsLabel;
    private javax.swing.JButton saveCartButton;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JPanel shoppingItemsContainer;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JLabel totalPriceLabel;
    // End of variables declaration//GEN-END:variables
}
