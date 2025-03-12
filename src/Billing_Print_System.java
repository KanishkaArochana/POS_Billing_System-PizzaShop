import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author kanis
 */
public class Billing_Print_System extends javax.swing.JFrame {

    /**
     * Creates new form Billing_Print_System
     */

        public void addTable(String Name,Double Price){    
       
        String Qty = JOptionPane.showInputDialog(null,"Plese Enter Your Quantity","1");
       
        
        Double tqty = Double.valueOf(Qty);
        Double Tot_prc = Price * tqty;
        
         System.out.println(Tot_prc);
         
         //Add Product To Cart
         DefaultTableModel dt = (DefaultTableModel) jTable1.getModel();//Table data get
         
         Vector v = new Vector();//Import To Vector() and Create Object
         
         v.add(Name);
         v.add(Qty);
         v.add(Tot_prc);
         dt.addRow(v);
         
         cart_total();
         
    }

        
    public void cart_total(){
        
      int numofrow = jTable1.getRowCount();
       double total = 0;

       for (int i = 0; i < numofrow; i++) {
    try {
        double value = Double.valueOf(jTable1.getValueAt(i, 2).toString());
        total += value;
    } catch (NumberFormatException e) {
        // Handle the case where the conversion fails (e.g., the cell value is not a valid double)
        System.err.println("Error converting value to double in row " + i + ": " + e.getMessage());
    }
    
    DecimalFormat df = new DecimalFormat("00.00");  //fix above issue
    String d1 = df.format(total);
    
    bill_tot.setText(d1);  //sub total
    
    //Total
    double tx = Double.valueOf(tax.getText());
    double ds = Double.valueOf(dis.getText());
    
    double allTot = total + tx - ds;
    
    DecimalFormat dff = new DecimalFormat("00.00");  //fix above issue
    String d2 = dff.format(allTot);
    
    full_total.setText(d2);
}
