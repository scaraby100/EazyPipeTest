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
public class Consumer
{

    public void consume(ThreadPipe pipe)
    {
        while (pipe.run())
        {
            String s = (String) pipe.input();
            if (s != null)
            {
                if(pipe.args() != null)
                {
                    if(pipe.args().getClass() == Banana.class)
                    {
                        Banana banana = (Banana) pipe.args();
                        pipe.output(s + banana.getBanana());
                    }
                    else
                    {
                        pipe.output(s + pipe.args());
                    }
                }
                else
                {
                    pipe.output(s + " TEST CONSUMER");
                }
            }
        }
    }
}
