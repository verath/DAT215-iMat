/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * NewJPanel.java
 *
 * Created on Feb 24, 2013, 5:42:06 PM
 */
package Views.DetailedProduct;

import Main.MainController;
import Main.ShoppingCartWrapper;
import javax.swing.ImageIcon;
import se.chalmers.ait.dat215.project.IMatDataHandler;
import se.chalmers.ait.dat215.project.Product;

/**
 *
 * @author Ernst
 */
public class DetailedProductView extends javax.swing.JPanel {

    /**
     * Path to the icon used when the Product is favorite.
     */
    public static final String FAVOURITE_ICON = "/images/star.png";
    /**
     * Path to the icon used when it isn't a favorite.
     */
    public static final String NOT_FAVOURITE_ICON = "/images/star-empty.png";
    /**
     * Path to the icon used when it is hovered.
     */
    public static final String HOVER_FAVOURITE_ICON = "/images/star-half.png";
    
    
    private Product product;
    
    /** Creates new form NewJPanel */
    public DetailedProductView() {
        initComponents();
    }
    
    private void updateFavIcon() {
        if (IMatDataHandler.getInstance().isFavorite(product)) {
            favouriteLabel.setIcon(new ImageIcon(this.getClass().getResource(FAVOURITE_ICON)));
            favouriteLabel.setToolTipText("Ta bort som favorit");
        } else {
            favouriteLabel.setIcon(new ImageIcon(this.getClass().getResource(NOT_FAVOURITE_ICON)));
            favouriteLabel.setToolTipText("Lägg till som favorit");
        }
    }
    
    public void setProduct(Product p) {
        IMatDataHandler dh = IMatDataHandler.getInstance();
        imageLabel.setIcon(dh.getImageIcon(p, 200, 200));
        nameLabel.setText(p.getName());
        priceLabel.setText(p.getPrice() + " " + p.getUnit());
        suffixLabel.setText(p.getUnitSuffix());

        this.product = p;
        
        updateFavIcon();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nameLabel = new javax.swing.JLabel();
        bildPanel = new javax.swing.JPanel();
        imageLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        favouriteLabel = new javax.swing.JLabel();
        backButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        suffixLabel = new javax.swing.JLabel();
        buyButton = new javax.swing.JButton();
        priceLabel = new javax.swing.JLabel();
        amountSpinner = new javax.swing.JSpinner();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(770, 628));

        nameLabel.setBackground(new java.awt.Color(247, 221, 192));
        nameLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        nameLabel.setText("Banan");

        bildPanel.setBackground(new java.awt.Color(255, 255, 255));
        bildPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        bildPanel.setEnabled(false);
        bildPanel.setMaximumSize(new java.awt.Dimension(200, 200));
        bildPanel.setMinimumSize(new java.awt.Dimension(200, 200));
        bildPanel.setOpaque(false);
        bildPanel.setPreferredSize(new java.awt.Dimension(200, 200));
        bildPanel.setLayout(new javax.swing.BoxLayout(bildPanel, javax.swing.BoxLayout.LINE_AXIS));

        imageLabel.setBackground(new java.awt.Color(255, 255, 255));
        imageLabel.setMaximumSize(new java.awt.Dimension(198, 198));
        imageLabel.setMinimumSize(new java.awt.Dimension(198, 198));
        imageLabel.setPreferredSize(new java.awt.Dimension(198, 198));
        bildPanel.add(imageLabel);

        jScrollPane1.setBorder(null);

        jTextArea1.setLineWrap(true);
        jTextArea1.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis non arcu mauris, vitae imperdiet diam. Aenean eu sodales nisi. In hac habitasse platea dictumst. Sed erat tortor, ultricies ac convallis in, condimentum eu massa. Curabitur in ornare leo. Etiam diam augue, aliquet quis porta ut, dictum vel dui. Duis ac lacus id neque pretium accumsan non sit amet massa. Curabitur posuere pulvinar fringilla. Suspendisse potenti. Fusce mollis feugiat nisl et varius. Fusce quis velit sit amet diam pulvinar ornare. Donec congue aliquet hendrerit. Pellentesque dapibus scelerisque porttitor.\n\nAliquam fringilla, est a luctus tincidunt, velit lorem fringilla purus, in semper ligula purus nec elit. Nulla tortor nulla, congue at feugiat et, sagittis interdum risus. Donec ante lectus, congue sit amet imperdiet eget, semper at erat. Aenean justo sapien, consectetur ac interdum ut, bibendum et enim. Etiam commodo ornare fringilla. Morbi laoreet dictum justo ut porta. Nulla ut diam ipsum, at ultrices justo. Sed blandit ipsum vel eros scelerisque vitae placerat tortor laoreet. Mauris ac mauris sem, quis imperdiet ipsum. Aliquam sed mollis orci. Cras nibh est, suscipit a varius mattis, ultricies nec mi. Donec vel justo libero, id hendrerit dui.");
        jTextArea1.setWrapStyleWord(true);
        jScrollPane1.setViewportView(jTextArea1);

        favouriteLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/star-empty.png"))); // NOI18N
        favouriteLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                favouriteLabelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                favouriteLabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                favouriteLabelMouseExited(evt);
            }
        });

        backButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/arrow-180.png"))); // NOI18N
        backButton.setText("Tillbaka");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        jPanel1.setOpaque(false);

        suffixLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        suffixLabel.setText("Förp.");

        buyButton.setText("Köp");
        buyButton.setToolTipText("Lägg den här varan i kundvagnen");
        buyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buyButtonActionPerformed(evt);
            }
        });

        priceLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        priceLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        priceLabel.setText("90kr/st");

        amountSpinner.setModel(new javax.swing.SpinnerNumberModel(Double.valueOf(1.0d), Double.valueOf(1.0d), null, Double.valueOf(1.0d)));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(366, Short.MAX_VALUE)
                .addComponent(priceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(amountSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(suffixLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buyButton)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(priceLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(suffixLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(amountSpinner, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                        .addComponent(buyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel4.setText("Japan");

        jLabel2.setText("Färg:");

        jLabel1.setText("Land:");

        jLabel5.setText("Grön");

        jLabel6.setForeground(new java.awt.Color(204, 0, 0));
        jLabel6.setText("1345kj");

        jLabel3.setText("Kalorier:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 136, 0));
        jLabel7.setText("Snabbinformation");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(backButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(nameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 878, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(favouriteLabel))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bildPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jScrollPane1))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(favouriteLabel)
                        .addGap(5, 5, 5))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(backButton, javax.swing.GroupLayout.Alignment.LEADING, 0, 0, Short.MAX_VALUE)
                        .addComponent(nameLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bildPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(119, 119, 119))
        );
    }// </editor-fold>//GEN-END:initComponents

private void buyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buyButtonActionPerformed
    double amount = (Double) amountSpinner.getValue();
    ShoppingCartWrapper.INSTANCE.addProduct(product, amount);
}//GEN-LAST:event_buyButtonActionPerformed

private void favouriteLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_favouriteLabelMouseClicked
    // Handle click on the favorite icon
    if (IMatDataHandler.getInstance().isFavorite(product)) {
        IMatDataHandler.getInstance().removeFavorite(product);
    } else {
        IMatDataHandler.getInstance().addFavorite(product);
    }
}//GEN-LAST:event_favouriteLabelMouseClicked

private void favouriteLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_favouriteLabelMouseEntered
    // Handle hovering of the favorite icon.
    favouriteLabel.setIcon(new ImageIcon(this.getClass().getResource(HOVER_FAVOURITE_ICON)));
}//GEN-LAST:event_favouriteLabelMouseEntered

private void favouriteLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_favouriteLabelMouseExited
    updateFavIcon();
}//GEN-LAST:event_favouriteLabelMouseExited

private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
    MainController.INSTANCE.hideDetailedProductPanel();
}//GEN-LAST:event_backButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSpinner amountSpinner;
    private javax.swing.JButton backButton;
    private javax.swing.JPanel bildPanel;
    private javax.swing.JButton buyButton;
    private javax.swing.JLabel favouriteLabel;
    private javax.swing.JLabel imageLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JLabel priceLabel;
    private javax.swing.JLabel suffixLabel;
    // End of variables declaration//GEN-END:variables
}
