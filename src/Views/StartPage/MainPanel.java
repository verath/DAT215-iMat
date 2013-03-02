/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * MainPanel.java
 *
 * Created on Feb 27, 2013, 10:37:46 AM
 */
package Views.StartPage;

/**
 *
 * @author ernst
 */
public class MainPanel extends javax.swing.JPanel {

    /** Creates new form MainPanel */
    public MainPanel() {
        initComponents();
        //.setCarousel(carouselPanelView1);
        //carouselPanelSwitcher2.setCarousel(carouselPanelView2);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        featurePanelView2 = new Views.StartPage.FeaturePanelView();
        carouselPanelView1 = new Views.StartPage.CarouselPanelView();
        carouselPanelView2 = new Views.StartPage.CarouselPanelView();

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(Main.MainApp.class).getContext().getResourceMap(MainPanel.class);
        setBackground(resourceMap.getColor("Form.background")); // NOI18N
        setMaximumSize(new java.awt.Dimension(7706, 6436));
        setName("Form"); // NOI18N

        featurePanelView2.setName("featurePanelView2"); // NOI18N

        carouselPanelView1.setBackground(resourceMap.getColor("carouselPanelView1.background")); // NOI18N
        carouselPanelView1.setMinimumSize(new java.awt.Dimension(728, 230));
        carouselPanelView1.setName("carouselPanelView1"); // NOI18N
        carouselPanelView1.setOpaque(true);

        carouselPanelView2.setBackground(resourceMap.getColor("carouselPanelView2.background")); // NOI18N
        carouselPanelView2.setName("carouselPanelView2"); // NOI18N
        carouselPanelView2.setOpaque(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(featurePanelView2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 869, Short.MAX_VALUE)
                    .addComponent(carouselPanelView2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 869, Short.MAX_VALUE)
                    .addComponent(carouselPanelView1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 869, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(featurePanelView2, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(carouselPanelView1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(carouselPanelView2, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Views.StartPage.CarouselPanelView carouselPanelView1;
    private Views.StartPage.CarouselPanelView carouselPanelView2;
    private Views.StartPage.FeaturePanelView featurePanelView2;
    // End of variables declaration//GEN-END:variables
}
