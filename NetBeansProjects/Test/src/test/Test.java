/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;
/**
 *
 * @author AlexClevenger
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        float d= 0;
        double acceleration= 100;
        while(d < 100.000){
            float t=(float) .5;
            acceleration=acceleration+0.001;
            d=d+t;
            System.out.println(d*acceleration);
            //break;
        }
    }
    
}
