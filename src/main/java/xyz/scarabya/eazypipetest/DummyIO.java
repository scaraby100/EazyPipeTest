/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.scarabya.eazypipetest;

import java.util.logging.Level;
import java.util.logging.Logger;
import xyz.scarabya.eazypipe.EazyPipe;

/**
 *
 * @author a.patriarca
 */
public class DummyIO
{
    private boolean block = false;
    public synchronized String input()
    {
        block = true;
        try
        {
            Thread.sleep(Math.round(Math.random()*10));
        }
        catch (InterruptedException ex)
        {
            Logger.getLogger(EazyPipe.class.getName()).log(Level.SEVERE, null, ex);
        }
        block = false;
        return String.valueOf(System.currentTimeMillis());
    }
    
    public synchronized boolean isBlocked()
    {
        return block;
    }
}
