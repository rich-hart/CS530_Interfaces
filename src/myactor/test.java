/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package myactor;

/**
 *
 * @author richardhart
 */
public class test {
    public static void main(String[] args){
        String s = "1000d";
        s=s.replaceAll("[\\D]", "");
        System.out.println(s.length());
    Integer  i = Integer.valueOf(s);
    System.out.println(i);
    
    Initiater initiater = new Initiater();
        Responder responder = new Responder();

        initiater.addListener(responder);

        initiater.sayHello();
    }
}
