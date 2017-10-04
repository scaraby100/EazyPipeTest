/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.scarabya.eazypipetest;

import java.util.logging.Level;
import java.util.logging.Logger;
import xyz.scarabya.eazypipe.EazyPipe;
import xyz.scarabya.eazypipe.ThreadPipe;

/**
 *
 * @author a.patriarca
 */
public class Producer
{
    public void produce(ThreadPipe pipe)
    {
        while(true)
        {
            pipe.output("TEST PRODUCER");
            try
            {
                Thread.sleep(Math.round(Math.random()*1000));
            }
            catch (InterruptedException ex)
            {
                Logger.getLogger(EazyPipe.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
