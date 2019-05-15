/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.scarabya.eazypipetest;

import java.io.FileNotFoundException;
import java.util.concurrent.ConcurrentLinkedQueue;
import xyz.scarabya.eazypipe.EazyPipe;
import xyz.scarabya.eazypipe.EazyPipeStart;
import xyz.scarabya.eazypipe.Pipeable;

/**
 *
 * @author a.patriarca
 */
public class VerticalTest
{

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException
    {
        Producer prod = new Producer();
        
        Consumer cons = new Consumer();
        
        Pipeable finalCons = new Pipeable(cons, "consume", 1);
        Pipeable prodPipe = new Pipeable(prod, "produceRandomString", 1, 10);
        
        EazyPipe vout = EazyPipeStart.runPipe(prodPipe).runPipe(finalCons);
        
        printChannel(vout);
        
        
    }
    
    public static void printChannel(EazyPipe channel)
    {
        ConcurrentLinkedQueue queue=channel.getOutput();
        while (!channel.areAllReady() || !queue.isEmpty())
        {
            String s = (String) queue.poll();
            if(s!=null)
            {
                System.out.println(s);
            }
        }
    }
    
}
