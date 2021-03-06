
/*
 * ShoppingListDetailed.java
 *
 * Created on Mar 1, 2013, 11:06:32 AM
 */
package Views.listOrderDetails;

import Main.MainController;
import Main.NumberUtil;
import Main.ShoppingCartWrapper;
import ShoppingList.ShoppingList;
import ShoppingList.ShoppingListItem;
import ShoppingList.ShoppingListsHandler;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import se.chalmers.ait.dat215.project.IMatDataHandler;
import se.chalmers.ait.dat215.project.Product;
import se.chalmers.ait.dat215.project.ShoppingItem;

/**
 *
 * @author Peter
 */
public class ShoppingListOrderDetailed extends javax.swing.JPanel {

    ShoppingList shoppingList;
    List<ShoppingListItem> shoppingItems;

    /** Creates new form ShoppingListDetailed */
    public ShoppingListOrderDetailed(Object object) {
        initComponents();

        shoppingItems = new LinkedList<ShoppingListItem>();

        if (object instanceof ShoppingList) {
            titleLabel.setText(object.toString());
            shoppingList = ((ShoppingList) object);

            // For each item, show a thumbnail and add to list of items
            for (ShoppingListItem si : shoppingList.getItems()) {
                final Product p = si.getProduct();

                // Add image
                JLabel img = new JLabel(IMatDataHandler.getInstance().getImageIcon(p));
                imagesContainer.add(img);

                // Add text
                JLabel txt = new JLabel("- " + p.getName() + " (" + si.getAmount() + " " + p.getUnitSuffix() + ")");
                txt.setFont(new Font("Verdana", Font.PLAIN, 16));
                // Also add an event listener to open detailed product desc.
                txt.addMouseListener(new MouseListener() {
                    public void mouseClicked(MouseEvent me) {
                    }
                    public void mousePressed(MouseEvent me) {
                        MainController.INSTANCE.showDetailedProductPanel(p);
                    }
                    public void mouseReleased(MouseEvent me) {
                    }
                    public void mouseEntered(MouseEvent me) {
                    }
                    public void mouseExited(MouseEvent me) {
                    }
                });
                txt.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                productsContainer.add(txt);

                // Add to list of products to add later
                shoppingItems.add(new ShoppingListItem(si.getProduct(), si.getAmount()));
            }
        } else if (object instanceof OrderWrapper) {
            titleLabel.setText(object.toString());
            OrderWrapper ow = ((OrderWrapper) object);

            // Hide remove button, can't remove orders
            removeButton.setVisible(false);

            // For each item, show a thumbnail and add to list of items
            for (ShoppingItem si : ow.getOrder().getItems()) {
                final Product p = si.getProduct();

                // Add image
                JLabel img = new JLabel(IMatDataHandler.getInstance().getImageIcon(p));
                imagesContainer.add(img);

                // Add text
                JLabel txt = new JLabel("- " + p.getName() + " (" + si.getAmount() + " " + p.getUnitSuffix() + ")");
                txt.setFont(new Font("Verdana", Font.PLAIN, 16));
                // Also add an event listener to open detailed product desc.
                txt.addMouseListener(new MouseListener() {
                    public void mouseClicked(MouseEvent me) {
                    }
                    public void mousePressed(MouseEvent me) {
                        MainController.INSTANCE.showDetailedProductPanel(p);
                    }
                    public void mouseReleased(MouseEvent me) {
                    }
                    public void mouseEntered(MouseEvent me) {
                    }
                    public void mouseExited(MouseEvent me) {
                    }
                });
                txt.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                productsContainer.add(txt);

                // Add to list of products to add later
                shoppingItems.add(new ShoppingListItem(si.getProduct(), si.getAmount()));
            }
        } else {
            setVisible(false);
            return;
        }

        int totalPrice = 0;
        for (ShoppingListItem si : shoppingItems) {
            totalPrice += si.getTotal();
        }
        totalLabel.setText(shoppingItems.size()
                + (shoppingItems.size() == 1 ? " vara, " : " varor, ")
                + NumberUtil.roundTwoDecimals(totalPrice) + "kr");

        imagesContainer.validate();
        imagesContainer.repaint();

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titleLabel = new javax.swing.JLabel();
        imagesContainer = new javax.swing.JPanel();
        productsContainer = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        addButton = new javax.swing.JButton();
        removeButton = new javax.swing.JButton();
        totalLabel = new javax.swing.JLabel();

        setName("Form"); // NOI18N
        setOpaque(false);

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(Main.MainApp.class).getContext().getResourceMap(ShoppingListOrderDetailed.class);
        titleLabel.setFont(resourceMap.getFont("titleLabel.font")); // NOI18N
        titleLabel.setText(resourceMap.getString("titleLabel.text")); // NOI18N
        titleLabel.setName("titleLabel"); // NOI18N

        imagesContainer.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        imagesContainer.setMaximumSize(new java.awt.Dimension(128, 128));
        imagesContainer.setMinimumSize(new java.awt.Dimension(128, 128));
        imagesContainer.setName("imagesContainer"); // NOI18N
        imagesContainer.setOpaque(false);
        imagesContainer.setLayout(new java.awt.GridLayout(2, 2));

        productsContainer.setName("productsContainer"); // NOI18N
        productsContainer.setOpaque(false);
        productsContainer.setLayout(new javax.swing.BoxLayout(productsContainer, javax.swing.BoxLayout.PAGE_AXIS));

        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N
        productsContainer.add(jLabel1);

        jPanel1.setName("jPanel1"); // NOI18N
        jPanel1.setOpaque(false);

        addButton.setText(resourceMap.getString("addButton.text")); // NOI18N
        addButton.setToolTipText(resourceMap.getString("addButton.toolTipText")); // NOI18N
        addButton.setMaximumSize(new java.awt.Dimension(77, 48));
        addButton.setMinimumSize(new java.awt.Dimension(77, 48));
        addButton.setName("addButton"); // NOI18N
        addButton.setPreferredSize(new java.awt.Dimension(77, 48));
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        removeButton.setText(resourceMap.getString("removeButton.text")); // NOI18N
        removeButton.setToolTipText(resourceMap.getString("removeButton.toolTipText")); // NOI18N
        removeButton.setActionCommand(resourceMap.getString("removeButton.actionCommand")); // NOI18N
        removeButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        removeButton.setName("removeButton"); // NOI18N
        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(removeButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(removeButton)
                    .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        totalLabel.setText(resourceMap.getString("totalLabel.text")); // NOI18N
        totalLabel.setName("totalLabel"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(titleLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 583, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(totalLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(imagesContainer, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(productsContainer, javax.swing.GroupLayout.DEFAULT_SIZE, 448, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(imagesContainer, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(totalLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(productsContainer, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
    for (ShoppingListItem si : shoppingItems) {
        ShoppingCartWrapper.INSTANCE.addProduct(si.getProduct(), si.getAmount());
    }
}//GEN-LAST:event_addButtonActionPerformed

private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed

    int dialogResult = JOptionPane.showConfirmDialog(null, "Är du säker på att du vill ta bort\n"
            + "den här inköpslistan?", "Ta bort inköpslista?", JOptionPane.YES_NO_OPTION);
    if (dialogResult == JOptionPane.YES_OPTION) {
        ShoppingListsHandler.INSTANCE.removeShoppingList(shoppingList);
        setVisible(false);
    }

}//GEN-LAST:event_removeButtonActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JPanel imagesContainer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel productsContainer;
    private javax.swing.JButton removeButton;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JLabel totalLabel;
    // End of variables declaration//GEN-END:variables
}
