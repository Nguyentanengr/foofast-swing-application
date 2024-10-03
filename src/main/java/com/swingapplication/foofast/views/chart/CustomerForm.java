package com.swingapplication.foofast.views.chart;

import java.awt.*;

/**
 *
 * @author Pham Tan Nguyen
 */
public class CustomerForm extends javax.swing.JPanel {

    /**
     * Creates new form RevenueForm
     */
    public CustomerForm() {
        initComponents();
        chart.addLegend("Tổng khách hàng tích lũy", new Color(180, 240, 255));
        chart.addLegend("Khách hàng mới trong tháng", new Color(0, 0, 255));
        chart.addLegend("Khách hàng có giao dịch", new Color(230,230,230));
//        chart.addLegend("Cost", new Color(139, 229, 222));

        chart.addData(new ModelChart("Tháng 1", new double[]{680, 26, 219}));
        chart.addData(new ModelChart("Tháng 2", new double[]{712, 32, 307}));
        chart.addData(new ModelChart("Tháng 3", new double[]{760, 58, 203}));
        chart.addData(new ModelChart("Tháng 4", new double[]{803, 43, 219}));
        chart.addData(new ModelChart("Tháng 5", new double[]{845, 42, 239}));
        chart.addData(new ModelChart("Tháng 6", new double[]{878, 33, 307}));
        chart.addData(new ModelChart("Tháng 7", new double[]{904, 26, 219}));
        chart.addData(new ModelChart("Tháng 8", new double[]{947,43, 486}));
//        chart.addData(new ModelChart("Tháng 9", new double[]{45}));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        chart = new Chart();
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(chart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(chart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

    }


    private Chart chart;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
