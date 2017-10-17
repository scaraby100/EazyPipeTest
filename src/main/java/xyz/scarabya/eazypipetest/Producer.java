/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.scarabya.eazypipetest;

import xyz.scarabya.eazypipe.ThreadPipe;

/**
 *
 * @author a.patriarca
 */
public class Producer
{
    public void produce(ThreadPipe pipe)
    {
        DummyIO io = (DummyIO) pipe.args();
        while(pipe.run())
        {            
            if(!io.isBlocked())
                pipe.output(io.input() + " TEST PRODUCER");
        }
    }
}
