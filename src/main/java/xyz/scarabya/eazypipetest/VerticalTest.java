/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.scarabya.eazypipetest;

import java.util.concurrent.ConcurrentLinkedQueue;
import xyz.scarabya.eazypipe.EazyPipe;
import xyz.scarabya.eazypipe.ThreadPipe;

/**
 *
 * @author a.patriarca
 */
public class VerticalTest
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        EazyPipe vert = new EazyPipe();
        
        Producer prod = new Producer();
        
        Consumer cons = new Consumer();
        
        ThreadPipe finalCons = new ThreadPipe(cons, "consume");
        
        Banana banana = new Banana();
        
        EazyPipe vout = vert.runPipe(new ThreadPipe(prod, "produce", 3))
                .runPipe(new ThreadPipe(cons, "consume", banana))
                .runPipe(finalCons);
        
        printChannel(vout.getOutput());
        
        
    }
    
    public static void printChannel(ConcurrentLinkedQueue channel)
    {
        while (true)
        {
            String s = (String) channel.poll();
            if (s != null)
                System.out.println(s);
        }
    }
    
}