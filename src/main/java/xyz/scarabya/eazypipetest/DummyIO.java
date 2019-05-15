/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.scarabya.eazypipetest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author a.patriarca
 */
public class DummyIO {

    //private final File file = new File("C:\\Users\\a.patriarca\\Documents\\1milione.csv");
    private final File file = new File("C:\\Users\\a.patriarca\\Documents\\testFile.dat");
    private final boolean random = true;
    private final int numOfBlocks = 10;
    private final int blockSize = 4096;
    private final RandomAccessFile rAccFile;
    private final byte[] blockArr = new byte[blockSize];

    public DummyIO() throws FileNotFoundException {
        rAccFile = new RandomAccessFile(file, "rws");
        for (int b = 0; b < blockArr.length; b++) {
            if (b % 2 == 0) {
                blockArr[b] = (byte) 0xFF;
            }
        }
    }

    public synchronized String input() throws IOException {
        for (int b = 0; b < numOfBlocks; b++) {
            long rLoc = Math.round(Math.random() * (numOfBlocks - 1));
            rAccFile.seek(rLoc * blockSize);
            rAccFile.write(blockArr, 0, blockSize);
        }
        return "Done ";
    }
}
