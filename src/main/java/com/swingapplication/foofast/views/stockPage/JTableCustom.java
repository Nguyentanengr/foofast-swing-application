package com.swingapplication.foofast.views.stockPage;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author eramisme
 */
public class JTableCustom extends JTable {

    private int selectedRow = -1;

    public JTableCustom() {
        // Show horizontal and vertical grid lines
        setShowHorizontalLines(true);
        setShowVerticalLines(true);  // Ensure vertical lines are also shown
        setGridColor(new Color(230, 230, 230));  // Set grid color (light gray)
        setRowHeight(40);
        setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // Configure table header
        getTableHeader().setReorderingAllowed(false);
        getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bin, boolean bln1, int i, int i1) {
                TablezHeader header = new TablezHeader(o + "");
                header.setHorizontalAlignment(JLabel.CENTER);  // Center-align header text
                return header;
            }
        });

        // Set custom renderer for table cells
        setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component com = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                // Set default background and foreground
                com.setBackground(Color.WHITE);  // Set white background for all rows
                com.setForeground(new Color(102, 102, 102));  // Set default text color (gray)

                // When row is selected
                if (isSelected) {
                    com.setForeground(Color.WHITE);  // Change text color to white when selected
                    com.setBackground(new Color(15, 89, 140));  // Change background to blue when selected
                }

                setBorder(noFocusBorder);  // No focus border
                return com;
            }
        });

        // Add mouse click event to toggle row selection
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = getSelectedRow();
                if (row == selectedRow) {
                    clearSelection();
                    selectedRow = -1;
                } else {
                    selectedRow = row;
                }
            }
        });
    }

    // Method to add rows to the table
    public void addRow(Object[] row) {
        DefaultTableModel model = (DefaultTableModel) getModel();
        model.addRow(row);
    }

    // Custom header class
    private static class TablezHeader extends JLabel {

        public TablezHeader(String text) {
            super(text);
            setOpaque(true);
            setBackground(Color.WHITE);  // Set header background to white
            setFont(new Font("sansserif", 1, 12));  // Set font for header text
            setForeground(new Color(102, 102, 102));  // Set header text color (gray)
            setBorder(new EmptyBorder(10, 5, 10, 5));  // Padding for header cells
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(new Color(230, 230, 230));  // Light gray border color
            g.drawLine(0, getHeight() - 1, getWidth(), getHeight() - 1);  // Draw bottom border
        }
    }
}
