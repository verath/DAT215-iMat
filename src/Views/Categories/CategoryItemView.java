/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * CategoryItemView.java
 *
 * Created on Feb 25, 2013, 9:46:54 AM
 */
package Views.Categories;

import Main.MainController;
import Search.SearchQuery;
import java.awt.Color;
import java.awt.Font;
import java.util.Set;
import se.chalmers.ait.dat215.project.ProductCategory;

/**
 *
 * @author Peter
 */
public class CategoryItemView extends javax.swing.JPanel {

    /**
     * A set of categories this menu item represents
     */
    private Set<ProductCategory> productCategories = null;
    private boolean isFavLabel = false;
    private SearchQuery searchQuery;
    private String name = "";

    /** Creates new form CategoryItemView */
    public CategoryItemView() {
        initComponents();
    }

    public void setCategoryName(String name) {
        this.name = name;
        nameLabel.setText(name);
    }

    public void setIsFavoriteLabel(boolean isFavLabel) {
        this.isFavLabel = isFavLabel;
    }

    public void setSearchCategories(Set<ProductCategory> categories) {
        productCategories = categories;
    }

    public void onSearchChange(SearchQuery sq) {
        if (searchQuery != null && sq.equals(searchQuery)) {
            setActiveState();
        } else {
            unsetActiveState();
        }
    }

    public void onShoppingListShown() {
        if (isShoppingListLabel) {
            setActiveState();
        } else {
            unsetActiveState();
    
        }
    }

    public void setActiveState() {
        container.setBackground(new Color(102, 153, 0));
        nameLabel.setForeground(Color.white);
    }

    public void unsetActiveState() {
        container.setBackground(Color.white);
        nameLabel.setForeground(Color.BLACK);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        container = new javax.swing.JPanel();
        nameLabel = new javax.swing.JLabel();

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(Main.MainApp.class).getContext().getResourceMap(CategoryItemView.class);
        setBackground(resourceMap.getColor("Form.background")); // NOI18N
        setMaximumSize(new java.awt.Dimension(32767, 48));
        setName("Form"); // NOI18N
        setOpaque(false);

        container.setBackground(resourceMap.getColor("container.background")); // NOI18N
        container.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        container.setName("container"); // NOI18N
        container.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                containerMouseClicked(evt);
            }
        });

        nameLabel.setFont(resourceMap.getFont("nameLabel.font")); // NOI18N
        nameLabel.setText(resourceMap.getString("nameLabel.text")); // NOI18N
        nameLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        nameLabel.setName("nameLabel"); // NOI18N
        nameLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nameLabelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout containerLayout = new javax.swing.GroupLayout(container);
        container.setLayout(containerLayout);
        containerLayout.setHorizontalGroup(
            containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        containerLayout.setVerticalGroup(
            containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nameLabel)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(container, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(container, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

private void nameLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nameLabelMouseClicked
    containerMouseClicked(evt);
}//GEN-LAST:event_nameLabelMouseClicked

private void containerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_containerMouseClicked
    if (isShoppingListLabel) {
        MainController.INSTANCE.showShoppingLists();
    } else {
        searchQuery = new SearchQuery(null, null, productCategories, isFavLabel, name);
        MainController.INSTANCE.search(searchQuery);
    }
}//GEN-LAST:event_containerMouseClicked
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel container;
    private javax.swing.JLabel nameLabel;
    // End of variables declaration//GEN-END:variables
    private boolean isShoppingListLabel = false;

    void setIsShoppingListLabel(boolean b) {
        isShoppingListLabel = b;
    }

    void onOtherNavigation() {
        unsetActiveState();
    }
}
