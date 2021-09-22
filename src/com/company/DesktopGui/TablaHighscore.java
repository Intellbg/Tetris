package com.company.DesktopGui;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;

public class TablaHighscore extends JTable{

    public TablaHighscore(Object[][] datos, Object[] nombresColumna){
        super(datos,nombresColumna);
        DefaultTableCellRenderer centrado = new DefaultTableCellRenderer();
        centrado.setHorizontalAlignment( JLabel.CENTER );
        setRowHeight(100);
        super.setFont(new Font("Arial", Font.PLAIN, 30));
        setCellSelectionEnabled(false);
        setFocusable(false);
        JTableHeader encabezado=getTableHeader();
        encabezado.setFont(new Font("Arial", Font.PLAIN, 30));
        encabezado.setReorderingAllowed(false);
        ((JLabel) encabezado.getDefaultRenderer()).setHorizontalAlignment( JLabel.CENTER );
        for (int i = 0; i < getColumnCount(); i++) {
            getColumnModel().getColumn(i).setCellRenderer(centrado);
        }
    }
}
