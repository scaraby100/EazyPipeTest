/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.scarabya.eazypipetest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author a.patriarca
 */
public class DummyIO
{
    private final File file = new File("C:\\Users\\a.patriarca\\Documents\\1milione.csv");
    public String input()
    {
        BufferedReader br;
        String searchFor = String.valueOf(Math.round(Math.random()*1000000));
        try
        {
            try (FileReader fr = new FileReader(file))
            {
                br = new BufferedReader(new FileReader(file));
                String line = br.readLine();
                while (line != null && !line.startsWith(";"))
                {
                    line = br.readLine();
                }
                br.close();
            }
        }
        catch (FileNotFoundException ex)
        {
            Logger.getLogger(DummyIO.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IOException ex)
        {
            Logger.getLogger(DummyIO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return searchFor;                
    }
}
