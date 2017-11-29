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
import xyz.scarabya.eazypipe.ThreadPipeManager;

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
        
        Pipeable finalCons = new Pipeable(cons, "consume", 10, true);
        
        Banana banana = new Banana();
        
        
        
        //DummyIO ioDisk = new DummyIO();
        
        EazyPipe vout = EazyPipeStart.runPipe(new Pipeable(prod, "produce", 10, true))
                .runPipe(new Pipeable(cons, "consume", 10, banana, true))
                .runPipe(finalCons);
        
        //EazyPipe vout = vert.runPipe(new Pipeable(prod, "produce"));
        
        ThreadPipeManager.startAutoManager(vout);
        
        printChannel(vout.getOutput());
        
        
    }
    
    public static void printChannel(ConcurrentLinkedQueue channel)
    {
        while (true)
        {
            String s = (String) channel.poll();
            if(false)
            {
                if (s != null)
                    System.out.println(s);
            }
        }
    }
    
}
