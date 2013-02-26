/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * SearchResultItemView.java
 *
 * Created on Feb 23, 2013, 3:59:42 PM
 */
package SearchResults;

import Main.LocaleHandler;
import Main.MainController;
import Main.ShoppingCartWrapper;
import Search.SearchQuery;
import java.util.HashSet;
import java.util.Set;
import javax.swing.ImageIcon;
import se.chalmers.ait.dat215.project.IMatDataHandler;
import se.chalmers.ait.dat215.project.Product;
import se.chalmers.ait.dat215.project.ProductCategory;

/**
 * A view for a single result of a search.
 * 
 * @author Peter
 */
public class SearchResultItemView extends javax.swing.JPanel {

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
    /**
     * The Product this view is representing
     */
    private Product product;

    /** Creates new form SearchResultItemView */
    public SearchResultItemView() {
        initComponents();
    }

    /**
     * Updates the favorite icon depending on if the product is a 
     * favorite or not.
     */
    private void updateFavIcon() {
        if (IMatDataHandler.getInstance().isFavorite(product)) {
            favouriteLabel.setIcon(new ImageIcon(this.getClass().getResource(FAVOURITE_ICON)));
            favouriteLabel.setToolTipText("Ta bort som favorit");
        } else {
            favouriteLabel.setIcon(new ImageIcon(this.getClass().getResource(NOT_FAVOURITE_ICON)));
            favouriteLabel.setToolTipText("Lägg till som favorit");
        }
    }

    /**
     * Sets the Product this view is representing and redraws the view.
     * @param p 
     */
    public void setProduct(Product p) {
        IMatDataHandler dh = IMatDataHandler.getInstance();
        imageLabel.setIcon(dh.getImageIcon(p, 128, 128));
        nameLabel.setText(p.getName());
        priceLabel.setText(p.getPrice() + " " + p.getUnit());
        unitLabel.setText(p.getUnitSuffix());
        categoryLabel.setText("<html>Kategori: <u style=\"color:blue\">"
                + LocaleHandler.INSTANCE.getProductCategoryName(p.getCategory()));

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

        imageLabel = new javax.swing.JLabel();
        amountSpinner = new javax.swing.JSpinner();
        addButton = new javax.swing.JButton();
        unitLabel = new javax.swing.JLabel();
        favouriteLabel = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        nameLabel = new javax.swing.JLabel();
        categoryLabel = new javax.swing.JLabel();
        priceLabel = new javax.swing.JLabel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 20), new java.awt.Dimension(0, 20), new java.awt.Dimension(32767, 20));

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(Main.MainApp.class).getContext().getResourceMap(SearchResultItemView.class);
        setBackground(resourceMap.getColor("Form.background")); // NOI18N
        setBorder(javax.swing.BorderFactory.createEtchedBorder());
        setMaximumSize(new java.awt.Dimension(32767, 128));
        setMinimumSize(new java.awt.Dimension(200, 0));
        setName("Form"); // NOI18N
        setPreferredSize(new java.awt.Dimension(300, 128));

        imageLabel.setBackground(resourceMap.getColor("imageLabel.background")); // NOI18N
        imageLabel.setText(resourceMap.getString("imageLabel.text")); // NOI18N
        imageLabel.setName("imageLabel"); // NOI18N
        imageLabel.setOpaque(true);
        imageLabel.setPreferredSize(new java.awt.Dimension(128, 128));

        amountSpinner.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));
        amountSpinner.setName("amountSpinner"); // NOI18N

        addButton.setText(resourceMap.getString("addButton.text")); // NOI18N
        addButton.setName("addButton"); // NOI18N
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        unitLabel.setText(resourceMap.getString("unitLabel.text")); // NOI18N
        unitLabel.setName("unitLabel"); // NOI18N

        favouriteLabel.setIcon(resourceMap.getIcon("favouriteLabel.icon")); // NOI18N
        favouriteLabel.setText(resourceMap.getString("favouriteLabel.text")); // NOI18N
        favouriteLabel.setName("favouriteLabel"); // NOI18N
        favouriteLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                favouriteLabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                favouriteLabelMouseExited(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                favouriteLabelMouseClicked(evt);
            }
        });

        jPanel1.setName("jPanel1"); // NOI18N
        jPanel1.setOpaque(false);

        nameLabel.setFont(resourceMap.getFont("nameLabel.font")); // NOI18N
        nameLabel.setText(resourceMap.getString("nameLabel.text")); // NOI18N
        nameLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        nameLabel.setFocusable(false);
        nameLabel.setName("nameLabel"); // NOI18N

        categoryLabel.setText(resourceMap.getString("categoryLabel.text")); // NOI18N
        categoryLabel.setName("categoryLabel"); // NOI18N
        categoryLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                categoryLabelMouseClicked(evt);
            }
        });

        priceLabel.setFont(resourceMap.getFont("priceLabel.font")); // NOI18N
        priceLabel.setText(resourceMap.getString("priceLabel.text")); // NOI18N
        priceLabel.setName("priceLabel"); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nameLabel)
                    .addComponent(priceLabel)
                    .addComponent(categoryLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nameLabel)
                .addGap(18, 18, 18)
                .addComponent(priceLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(categoryLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        filler1.setName("filler1"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(imageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(filler1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(amountSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(favouriteLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(unitLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(favouriteLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(unitLabel)
                    .addComponent(amountSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
    // Add a product when the add button is pressed
    ShoppingCartWrapper.INSTANCE.addProduct(product, (Integer) amountSpinner.getValue());
}//GEN-LAST:event_addButtonActionPerformed

private void categoryLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_categoryLabelMouseClicked
    // Show the entier category if the category link is pressed
    Set<ProductCategory> categoryFilter = new HashSet<ProductCategory>();
    categoryFilter.add(product.getCategory());
    MainController.INSTANCE.search(new SearchQuery("", null, categoryFilter));
}//GEN-LAST:event_categoryLabelMouseClicked

private void favouriteLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_favouriteLabelMouseEntered
    // Handle hovering of the favorite icon.
    favouriteLabel.setIcon(new ImageIcon(this.getClass().getResource(HOVER_FAVOURITE_ICON)));
}//GEN-LAST:event_favouriteLabelMouseEntered

private void favouriteLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_favouriteLabelMouseExited
    updateFavIcon();
}//GEN-LAST:event_favouriteLabelMouseExited

private void favouriteLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_favouriteLabelMouseClicked
    // Handle click on the favorite icon
    if (IMatDataHandler.getInstance().isFavorite(product)) {
        IMatDataHandler.getInstance().removeFavorite(product);
    } else {
        IMatDataHandler.getInstance().addFavorite(product);
    }
}//GEN-LAST:event_favouriteLabelMouseClicked
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JSpinner amountSpinner;
    private javax.swing.JLabel categoryLabel;
    private javax.swing.JLabel favouriteLabel;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JLabel imageLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JLabel priceLabel;
    private javax.swing.JLabel unitLabel;
    // End of variables declaration//GEN-END:variables
}
