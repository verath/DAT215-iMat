/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * karusellPanel.java
 *
 * Created on Feb 24, 2013, 1:31:51 AM
 */
package Views.StartPage;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import se.chalmers.ait.dat215.project.IMatDataHandler;
import se.chalmers.ait.dat215.project.Product;

/**
 *
 * @author Ernst
 */
public class CarouselPanelView extends javax.swing.JPanel {

    /**
     * The number of Products to keep in a CarouselPanelView
     */
    public static final int TOTAL_ITEMS = 12;
    /**
     * The number of Products visible at a time
     */
    public static final int VISIBLE_ITEMS = 4;
    /**
     * The featured items displayed in this view
     */
    private List<FeatureItemView> featureItemViews = new LinkedList<FeatureItemView>();
    private int currentPage = 0;

    /** Creates new form CarouselPanelView */
    public CarouselPanelView() {
        initComponents();
        generateFeatureItems();
        showFeatureItems();
        updatePageLabel();
    }

    /**
     * Generates FeatureItemView to display, 
     * prefers favorite marked ones over non-favorite.
     */
    private void generateFeatureItems() {
        // Grab favorites in random order
        List<Product> featuredItems = new LinkedList<Product>(
                IMatDataHandler.getInstance().favorites());
        Collections.shuffle(featuredItems);

        // Pad with random Products if not enough favorites
        int requiredItems = TOTAL_ITEMS - featuredItems.size();
        if (requiredItems > 0) {
            List<Product> randProducts = new LinkedList<Product>(
                    IMatDataHandler.getInstance().getProducts());
            Collections.shuffle(randProducts);
            
            for (int i = 0; requiredItems > 0; i++) {
                if(!featuredItems.contains(randProducts.get(i))) {
                    featuredItems.add(randProducts.get(i));
                    requiredItems--;
                }
            }
        }

        // Create TOTAL_ITEMS FeatureItemViews and store them
        for (int i = 0; i < TOTAL_ITEMS; i++) {
            FeatureItemView item = new FeatureItemView();
            item.setProduct(featuredItems.get(i));
            featureItemViews.add(item);
            if (i % 2 == 0) {
                item.changeColour();
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

        featureItemContainer = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        prevButton = new javax.swing.JButton();
        pageNumLabel = new javax.swing.JLabel();
        nextButton = new javax.swing.JButton();
        titleLabel = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(32767, 277));
        setMinimumSize(new java.awt.Dimension(0, 277));
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(750, 277));
        setRequestFocusEnabled(false);

        featureItemContainer.setBackground(new java.awt.Color(255, 255, 255));
        featureItemContainer.setMaximumSize(new java.awt.Dimension(750, 182));
        featureItemContainer.setMinimumSize(new java.awt.Dimension(0, 182));
        featureItemContainer.setOpaque(false);
        featureItemContainer.setPreferredSize(new java.awt.Dimension(750, 182));
        featureItemContainer.setLayout(new javax.swing.BoxLayout(featureItemContainer, javax.swing.BoxLayout.X_AXIS));

        jPanel1.setMinimumSize(new java.awt.Dimension(0, 40));
        jPanel1.setOpaque(false);
        jPanel1.setPreferredSize(new java.awt.Dimension(726, 40));
        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 40, 0));

        prevButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/arrow-180.png"))); // NOI18N
        prevButton.setText("Förra");
        prevButton.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        prevButton.setMargin(new java.awt.Insets(0, 5, 0, 5));
        prevButton.setMaximumSize(new java.awt.Dimension(80, 27));
        prevButton.setMinimumSize(new java.awt.Dimension(80, 27));
        prevButton.setPreferredSize(new java.awt.Dimension(80, 27));
        prevButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prevButtonActionPerformed(evt);
            }
        });
        jPanel1.add(prevButton);

        pageNumLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pageNumLabel.setText("Varor 1-4 (12)");
        pageNumLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        pageNumLabel.setMaximumSize(new java.awt.Dimension(99, 24));
        pageNumLabel.setMinimumSize(new java.awt.Dimension(99, 24));
        pageNumLabel.setPreferredSize(new java.awt.Dimension(99, 24));
        jPanel1.add(pageNumLabel);

        nextButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/arrow.png"))); // NOI18N
        nextButton.setText("Nästa");
        nextButton.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        nextButton.setMargin(new java.awt.Insets(0, 5, 0, 5));
        nextButton.setMaximumSize(new java.awt.Dimension(80, 27));
        nextButton.setMinimumSize(new java.awt.Dimension(80, 27));
        nextButton.setPreferredSize(new java.awt.Dimension(80, 27));
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });
        jPanel1.add(nextButton);

        titleLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        titleLabel.setText("Titel");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(titleLabel)
                    .addComponent(featureItemContainer, javax.swing.GroupLayout.DEFAULT_SIZE, 726, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 726, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(featureItemContainer, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

private void prevButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prevButtonActionPerformed
    prevPage();
}//GEN-LAST:event_prevButtonActionPerformed

private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonActionPerformed
    nextPage();
}//GEN-LAST:event_nextButtonActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel featureItemContainer;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton nextButton;
    private javax.swing.JLabel pageNumLabel;
    private javax.swing.JButton prevButton;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables

    public void nextPage() {
        setNewPage(currentPage + 1);
    }

    public void prevPage() {
        setNewPage(currentPage - 1);
    }

    private void setNewPage(int page) {
        int numPages = (int) (Math.ceil(TOTAL_ITEMS / (double) VISIBLE_ITEMS));
        // It gets a bit weird with negative numbers, but this works
        // http://stackoverflow.com/questions/4412179/best-way-to-make-javas-modulus-behave-like-it-should-with-negative-numbers
        currentPage = (page % numPages + numPages) % numPages;

        showFeatureItems();
        updatePageLabel();
    }

    /**
     * Shows VISIBLE_ITEMS number of feature items at currentPage
     */
    private void showFeatureItems() {
        // Make sure our index is within the number of items we have
        int index = (currentPage * VISIBLE_ITEMS) % TOTAL_ITEMS;

        // Remove all previous items from the container        
        featureItemContainer.removeAll();

        // Place VISIBLE_ITEMS new ones, add a filler to both
        // sides of it to make scaling possible
        for (int i = 0; i < VISIBLE_ITEMS; i++) {

            featureItemContainer.add(new javax.swing.Box.Filler(
                    new java.awt.Dimension(0, 20), new java.awt.Dimension(0, 20),
                    new java.awt.Dimension(32767, 20)));

            featureItemContainer.add(featureItemViews.get(index));

            featureItemContainer.add(new javax.swing.Box.Filler(
                    new java.awt.Dimension(0, 20), new java.awt.Dimension(0, 20),
                    new java.awt.Dimension(32767, 20)));

            index = (index + 1) % TOTAL_ITEMS;
        }

        featureItemContainer.validate();
        featureItemContainer.repaint();
    }

    private void updatePageLabel() {
        pageNumLabel.setText(String.format(
                "Varor %d-%d (%d)",
                currentPage * VISIBLE_ITEMS + 1,
                (currentPage + 1) * VISIBLE_ITEMS,
                TOTAL_ITEMS));
    }
    
    public void setTitle(String title) {
        titleLabel.setText(title);
    }
}
