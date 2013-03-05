/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * favoritvaruPanel.java
 *
 * Created on Feb 24, 2013, 2:08:13 AM
 */
package Views.StartPage;

import Main.MainController;
import Main.ShoppingCartWrapper;
import java.awt.Color;
import se.chalmers.ait.dat215.project.IMatDataHandler;
import se.chalmers.ait.dat215.project.Product;

/**
 *
 * @author Ernst
 */
public class FeatureItemView extends javax.swing.JPanel {

    private Product product;
    
    /** Creates new form favoritvaruPanel */
    public FeatureItemView() {
        initComponents();
    }

    public void setProduct(Product p) {
        IMatDataHandler dh = IMatDataHandler.getInstance();
        imageLabel.setIcon(dh.getImageIcon(p, 180, 180));
        nameLabel.setText(p.getName());
        priceLabel.setText(p.getPrice() + " " + p.getUnit());
        suffixLabel.setText(p.getUnitSuffix());
        
        this.product = p;
    }
    
    public void changeColour(){
      //nameLabel.setBackground(new java.awt.Color(255,187,51));  //ljust
      // setBackground(new java.awt.Color(247,193,128));
    }   
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        imageLabel = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        infoPanel = new javax.swing.JPanel();
        suffixLabel = new javax.swing.JLabel();
        priceLabel = new javax.swing.JLabel();
        buyButton = new javax.swing.JButton();
        amountSpinner = new javax.swing.JSpinner();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setMaximumSize(new java.awt.Dimension(180, 180));
        setMinimumSize(new java.awt.Dimension(180, 180));
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(180, 180));
        setRequestFocusEnabled(false);

        jLayeredPane1.setBackground(new java.awt.Color(255, 255, 255));
        jLayeredPane1.setMaximumSize(new java.awt.Dimension(178, 178));
        jLayeredPane1.setMinimumSize(new java.awt.Dimension(178, 178));
        jLayeredPane1.setName(""); // NOI18N

        imageLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/banan.png"))); // NOI18N
        imageLabel.setMaximumSize(new java.awt.Dimension(180, 180));
        imageLabel.setMinimumSize(new java.awt.Dimension(180, 180));
        imageLabel.setName(""); // NOI18N
        imageLabel.setPreferredSize(new java.awt.Dimension(180, 180));
        imageLabel.setBounds(0, 0, 180, 180);
        jLayeredPane1.add(imageLabel, javax.swing.JLayeredPane.DEFAULT_LAYER);

        nameLabel.setBackground(new java.awt.Color(255, 136, 0));
        nameLabel.setFont(new java.awt.Font("Myriad Pro", 0, 18)); // NOI18N
        nameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nameLabel.setText("Banan");
        nameLabel.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        nameLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        nameLabel.setMaximumSize(new java.awt.Dimension(180, 24));
        nameLabel.setMinimumSize(new java.awt.Dimension(180, 24));
        nameLabel.setOpaque(true);
        nameLabel.setPreferredSize(new java.awt.Dimension(180, 24));
        nameLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nameLabelMouseClicked(evt);
            }
        });
        nameLabel.setBounds(0, 0, 180, 24);
        jLayeredPane1.add(nameLabel, new Integer(1));

        infoPanel.setBackground(new java.awt.Color(255, 255, 255));
        infoPanel.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 0, 0, new java.awt.Color(0, 0, 0)));
        infoPanel.setMaximumSize(new java.awt.Dimension(178, 22));
        infoPanel.setMinimumSize(new java.awt.Dimension(164, 22));
        infoPanel.setPreferredSize(new java.awt.Dimension(178, 22));

        suffixLabel.setFont(new java.awt.Font("Myriad Pro", 0, 10));
        suffixLabel.setText("förp.");

        priceLabel.setFont(new java.awt.Font("Myriad Pro", 0, 10));
        priceLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        priceLabel.setText("8.50kr");

        buyButton.setFont(new java.awt.Font("Myriad Pro", 0, 10)); // NOI18N
        buyButton.setText("Köp");
        buyButton.setToolTipText("Lägg den här varan i din kundvagn");
        buyButton.setMargin(new java.awt.Insets(1, 8, 1, 8));
        buyButton.setMaximumSize(new java.awt.Dimension(39, 20));
        buyButton.setMinimumSize(new java.awt.Dimension(39, 20));
        buyButton.setOpaque(false);
        buyButton.setPreferredSize(new java.awt.Dimension(39, 20));
        buyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buyButtonActionPerformed(evt);
            }
        });

        amountSpinner.setFont(new java.awt.Font("Myriad Pro", 0, 10));
        amountSpinner.setModel(new javax.swing.SpinnerNumberModel(Double.valueOf(1.0d), Double.valueOf(0.01d), null, Double.valueOf(1.0d)));

        javax.swing.GroupLayout infoPanelLayout = new javax.swing.GroupLayout(infoPanel);
        infoPanel.setLayout(infoPanelLayout);
        infoPanelLayout.setHorizontalGroup(
            infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, infoPanelLayout.createSequentialGroup()
                .addComponent(priceLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(amountSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(suffixLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buyButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        infoPanelLayout.setVerticalGroup(
            infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoPanelLayout.createSequentialGroup()
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(priceLabel)
                    .addComponent(buyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(suffixLabel)
                    .addComponent(amountSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        infoPanel.setBounds(0, 157, 178, 22);
        jLayeredPane1.add(infoPanel, new Integer(2));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

private void buyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buyButtonActionPerformed
    double amount = (Double) amountSpinner.getValue();
    ShoppingCartWrapper.INSTANCE.addProduct(product, amount);
}//GEN-LAST:event_buyButtonActionPerformed

private void nameLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nameLabelMouseClicked
    MainController.INSTANCE.showDetailedProductPanel(product);
}//GEN-LAST:event_nameLabelMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSpinner amountSpinner;
    private javax.swing.JButton buyButton;
    private javax.swing.JLabel imageLabel;
    private javax.swing.JPanel infoPanel;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JLabel priceLabel;
    private javax.swing.JLabel suffixLabel;
    // End of variables declaration//GEN-END:variables
}
