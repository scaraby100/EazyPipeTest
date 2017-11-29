/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.scarabya.eazypipetest;

import java.io.IOException;
import java.util.Random;
import xyz.scarabya.eazypipe.ThreadPipe;

/**
 *
 * @author a.patriarca
 */
public class Producer
{
    private final char[] SUBSET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvwxyz".toCharArray();
    private final Random PRNG = new Random();
    
    public void produceFromIO(ThreadPipe pipe) throws IOException
    {
        DummyIO io = (DummyIO) pipe.args();
        while(pipe.run())
        {            
            pipe.output(io.input() + " TEST PRODUCER");
        }
    }
    
    public void produce(ThreadPipe pipe) throws IOException
    {
        while(pipe.run())
        {            
            pipe.output(randomString(256, false) + " TEST PRODUCER");
        }
    }
    
    private String randomString(int dimensione, boolean fissa)
    {
        if(!fissa) dimensione = PRNG.nextInt(dimensione+1);
        char[] chars = new char[dimensione];        
        for (int i = 0; i < dimensione; i++)
            chars[i] = SUBSET[PRNG.nextInt(62)];
        return new String(chars);
    }


}
