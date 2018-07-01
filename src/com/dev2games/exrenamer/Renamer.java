package com.dev2games.exrenamer;

import com.dev2games.exrenamer.io.Directories;
import com.dev2games.exrenamer.io.Service;

import java.util.ArrayList;

/**
 * <p> Renames all files in the directory </p>
 */

public class Renamer {

    public ArrayList<String> files = new ArrayList<>();

    public static final boolean MULTI_THREAD = false;

    public static Service service;


    public static void main(String args[]) {
        String directory = args[0];
        String currentExtension = args[1];
        String renameTo = args[2];
        boolean recursive = Boolean.valueOf(args[3]);

        service = new Service();

        Directories.readAllFiles(directory, currentExtension, renameTo, recursive);
    }

}
