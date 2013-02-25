/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * HeaderBar.java
 *
 * Created on Feb 21, 2013, 9:20:15 PM
 */
package HeaderBar;

/**
 *
 * @author Peter
 */
public class HeaderBarView extends javax.swing.JPanel {

    private HeaderBarController hbController;

    /** Creates new form HeaderBar */
    public HeaderBarView() {
        initComponents();

        hbController = new HeaderBarController(this);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        SearchInputField = new javax.swing.JTextField();
        SearchButton = new javax.swing.JButton();

        setName("Form"); // NOI18N
        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.LINE_AXIS));

        jPanel1.setName("jPanel1"); // NOI18N
        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.LINE_AXIS));

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(Main.MainApp.class).getContext().getResourceMap(HeaderBarView.class);
        SearchInputField.setFont(resourceMap.getFont("SearchInputField.font")); // NOI18N
        SearchInputField.setText(resourceMap.getString("SearchInputField.text")); // NOI18N
        SearchInputField.setName("SearchInputField"); // NOI18N
        SearchInputField.setPreferredSize(new java.awt.Dimension(219, 29));
        SearchInputField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                SearchInputFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                SearchInputFieldFocusLost(evt);
            }
        });
        SearchInputField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SearchInputFieldKeyReleased(evt);
            }
        });
        jPanel1.add(SearchInputField);

        SearchButton.setText(resourceMap.getString("SearchButton.text")); // NOI18N
        SearchButton.setName("SearchButton"); // NOI18N
        SearchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchButtonActionPerformed(evt);
            }
        });
        jPanel1.add(SearchButton);

        add(jPanel1);
    }// </editor-fold>//GEN-END:initComponents

private void SearchInputFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_SearchInputFieldFocusGained
    hbController.onSearchFieldFocusGained(evt);
    SearchInputField.setSelectionStart(0);
    SearchInputField.setSelectionEnd(SearchInputField.getText().length());
}//GEN-LAST:event_SearchInputFieldFocusGained

private void SearchInputFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_SearchInputFieldFocusLost
    hbController.onSearchFieldFocusLost(evt);
}//GEN-LAST:event_SearchInputFieldFocusLost

private void SearchInputFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchInputFieldKeyReleased
    hbController.onSearchFieldKeyUp(evt);
}//GEN-LAST:event_SearchInputFieldKeyReleased

private void SearchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchButtonActionPerformed
    hbController.onSearchButtonActionPerformed(evt);
}//GEN-LAST:event_SearchButtonActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton SearchButton;
    private javax.swing.JTextField SearchInputField;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    public String getSearchText() {
        return SearchInputField.getText();
    }

    public void setSearchText(String text) {
        SearchInputField.setText(text);
    }

    void setSearchButtonEnabled() {
        SearchButton.setEnabled(true);
    }

    void setSearchButtonDisabled() {
        SearchButton.setEnabled(false);
    }
}
