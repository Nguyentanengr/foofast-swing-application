/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.swingapplication.foofast.views.stockPage;

/**
 *
 * @author eramisme
 */

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class Combobox<E> extends JComboBox<E> {

    private String labelText = "Label";
    private Color lineColor = new Color(3, 155, 216);

    public String getLabelText() {
        return labelText;
    }

    public void setLabelText(String labelText) {
        this.labelText = labelText;
    }

    public Color getLineColor() {
        return lineColor;
    }

    public void setLineColor(Color lineColor) {
        this.lineColor = lineColor;
    }

    @Override
    public void updateUI() {
        super.updateUI();
        installUI();
    }

    private void installUI() {
        setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                Component com = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                setBorder(new EmptyBorder(5, 5, 5, 5));
                if (isSelected) {
                    com.setBackground(new Color(240, 240, 240));
                }
                return com;
            }
        });
    }

    public Combobox() {
        setBackground(Color.WHITE);
        setBorder(new EmptyBorder(10, 3, 5, 3));
        installUI();
        addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent fe) {
                setBackground(new Color(220, 240, 255));
            }

            @Override
            public void focusLost(FocusEvent fe) {
                setBackground(Color.WHITE);
            }
        });
    }
}

