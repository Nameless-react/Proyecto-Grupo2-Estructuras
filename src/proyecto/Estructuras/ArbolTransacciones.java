/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.Estructuras;

import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import proyecto.Transaccion;

/**
 *
 * @author joel
 */
public class ArbolTransacciones {
    private NodoArbolTransacciones root;
    private Object[][] table = new Object[0][3]; 
    private int size = 0;
   
   public boolean isEmpty(){
      return this.root == null;
   }
   
   
   public Transaccion add(Transaccion transaccion){
      NodoArbolTransacciones newNode = new NodoArbolTransacciones(transaccion);
      this.size++;
      if(this.isEmpty()) this.root = newNode;
      else return add(this.root, newNode);
      return transaccion;
   }
   public Transaccion add(NodoArbolTransacciones root,NodoArbolTransacciones newNode){
      if(newNode.getData().getPrice() <= root.getData().getPrice()){
         if(root.getLeft() == null) {
             root.setLeft(newNode);
             return newNode.getData();
         } 
         else add(root.getLeft(), newNode);
      } else {
         if(root.getRight() == null) {
              root.setRight(newNode);
              return newNode.getData();
         }
         else add(root.getRight(), newNode);
      }
      
      return newNode.getData();
   }
   
   
   public Object[][] fillTable() {
       if (this.table.length == this.size) return this.table;
       this.table = new Object[0][3];
       
       if (this.isEmpty()) return new Object[0][0];
       return this.fillTable(this.root);
   }
   
   public Object[][] fillTable(NodoArbolTransacciones node) {
       if (node == null) return new Object[0][0];
       Object[][] newTable = new Object[this.table.length + 1][3];
        System.arraycopy(this.table, 0, newTable, 0, this.table.length);
       
       Transaccion current = node.getData();
       
       newTable[newTable.length - 1] = new Object[] {
           String.valueOf(current.getStudent().getIdentification()),
           String.valueOf(current.getStudent()),
           String.valueOf(current.getPrice()),
           current.getDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"))
       };
       
       
       this.table = newTable;
       this.fillTable(node.getRight());
       this.fillTable(node.getLeft());
       return this.table;
   }
   
   
}
