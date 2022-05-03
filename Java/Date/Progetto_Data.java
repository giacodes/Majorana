/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package progetto_data;

import java.io.IOException;

/**
 *
 * @author Martino Giacovazzo
 */
public class Progetto_Data {

    /**
     * @param args the command line argument
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        Data a=new Data();
        Data b=new Data();
        System.out.println("(Data minore)");         
        a.Acquisisci();
        System.out.println("(Data maggiore)");
        b.Acquisisci();
        System.out.println("I giorni intercorrenti fra le due date sono: "+a.GiorniIntercorrentiDate(a, b));
       }
  }

