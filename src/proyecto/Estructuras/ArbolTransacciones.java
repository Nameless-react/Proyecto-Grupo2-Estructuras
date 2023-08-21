/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.Estructuras;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import proyecto.Cajas;
import proyecto.Handler;
import proyecto.RegistroCajas;
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
   
   
   public Transaccion find(int id){
      if(this.isEmpty()) {
          Handler.showMessage("El registro de transacciones está vacio", "Vacio", Handler.ERROR);
          return null;    
      }
      
      return this.find(this.root, id);
   }
   
   public Transaccion find(NodoArbolTransacciones node, int id){
       Transaccion current = node.getData();
       
       if (current.getStudent().getIdentification() == id) return current;
       this.find(node.getRight(), id);
       this.find(node.getLeft(), id);
      
       Handler.showMessage("La transacción " + id + "no existe", "No encontrada", Handler.ERROR);
      return null;
   }
   
   
   public void payment(int id) {
       if(this.isEmpty()) {
          Handler.showMessage("El registro de transacciones está vacio", "Vacio", Handler.ERROR);
          return;
      }
       
       NodoArbolTransacciones removedNode = this.cancel(id, this.root);
       //Falta registrar los ingresos de esa trnasacción
       Handler.showMessage("Pago efectuado existosamente", "Completado", Handler.INFORMATION);
   }
   
   public void cancel(int id) {
       if(this.isEmpty()) {
          Handler.showMessage("El registro de transacciones está vacio", "Vacio", Handler.ERROR);
          return;
      }
       
       
       this.root = this.cancel(id, this.root);
       Handler.showMessage("Transacción cancelada exitosamente", "Completado", Handler.INFORMATION);
   }
   
   public NodoArbolTransacciones cancel(int id, NodoArbolTransacciones node) {
       if (node.getData().getId() > id) {
           node.setLeft(this.cancel(id, node.getLeft())); 
           return node;
       } else if (node.getData().getId() < id) {
           node.setRight(this.cancel(id, node.getRight()));
           return node;
       }
       
       if (node.getRight() == null) return node.getLeft();
       else if (node.getLeft() == null) return node.getRight();
       else {
           
           NodoArbolTransacciones parent = node.getRight();
           
           NodoArbolTransacciones successor = node.getLeft();
           
           while (successor != null) {
               parent = successor;
               successor = successor.getLeft();
           }
           
           if (parent != node) parent.setLeft(successor.getRight());
           else parent.setRight(successor.getLeft());
           
           node.setData(successor.getData());
           
           
           
       }
       this.size--;
       return node;
   }
   
   
   
   public double inOrden(LocalDateTime fecha){
        double money = 0;
        if(!isEmpty()){
            if(root.getData().getDate().isEqual(fecha) ){
                money += root.getData().getPrice();
            }
            inOrdenR(root, fecha, money);
            
            return money;
        }else{
            JOptionPane.showMessageDialog(null,"No hubieron ingresos!");
            return money;
        }
        
    }
    
    public void inOrdenR(NodoArbolTransacciones root, LocalDateTime fecha, double money){
        if(root!=null){
            if(root.getLeft().getData().getDate().isEqual(fecha)){
                money+= root.getLeft().getData().getPrice();
                inOrdenR(root.getLeft(), fecha, money);
            }
           
            if(root.getRight().getData().getDate().isEqual(fecha)){
                money+= root.getRight().getData().getPrice();
                inOrdenR(root.getRight(), fecha, money);
            }
            
        }
    }
    
}