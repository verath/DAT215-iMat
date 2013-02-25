/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * karusellPanel.java
 *
 * Created on Feb 24, 2013, 1:31:51 AM
 */
package StartPage;

/**
 *
 * @author Ernst
 */
public class CarouselPanelView extends javax.swing.JPanel {

    /** Creates new form karusellPanel */
    public CarouselPanelView() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        infoPanel = new javax.swing.JPanel();
        föregåendeButton = new javax.swing.JButton();
        nästaButton = new javax.swing.JButton();
        titel = new javax.swing.JLabel();
        karusellPanel = new javax.swing.JPanel();

        setBorder(javax.swing.BorderFactory.createEtchedBorder());
        setPreferredSize(new java.awt.Dimension(750, 190));

        infoPanel.setPreferredSize(new java.awt.Dimension(750, 20));

        föregåendeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Framsidan/vänsterpil.png"))); // NOI18N
        föregåendeButton.setContentAreaFilled(false);
        föregåendeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                föregåendeButtonActionPerformed(evt);
            }
        });

        nästaButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Framsidan/högerpil.png"))); // NOI18N
        nästaButton.setContentAreaFilled(false);
        nästaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nästaButtonActionPerformed(evt);
            }
        });

        titel.setFont(new java.awt.Font("Myriad Pro", 1, 15));
        titel.setText("Rekommenderat för dig");

        javax.swing.GroupLayout infoPanelLayout = new javax.swing.GroupLayout(infoPanel);
        infoPanel.setLayout(infoPanelLayout);
        infoPanelLayout.setHorizontalGroup(
            infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(föregåendeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(nästaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(210, 210, 210)
                .addComponent(titel)
                .addContainerGap(303, Short.MAX_VALUE))
        );
        infoPanelLayout.setVerticalGroup(
            infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoPanelLayout.createSequentialGroup()
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(föregåendeButton, javax.swing.GroupLayout.Alignment.LEADING, 0, 0, Short.MAX_VALUE)
                        .addComponent(nästaButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE))
                    .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(titel)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        karusellPanel.setPreferredSize(new java.awt.Dimension(750, 160));
        karusellPanel.setLayout(new java.awt.GridLayout(1, 4));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(infoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 746, Short.MAX_VALUE)
            .addComponent(karusellPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 746, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(karusellPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(infoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

private void föregåendeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_föregåendeButtonActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_föregåendeButtonActionPerformed

private void nästaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nästaButtonActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_nästaButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton föregåendeButton;
    private javax.swing.JPanel infoPanel;
    private javax.swing.JPanel karusellPanel;
    private javax.swing.JButton nästaButton;
    private javax.swing.JLabel titel;
    // End of variables declaration//GEN-END:variables
}
