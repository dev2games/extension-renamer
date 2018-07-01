package com.dev2games.exrenamer.io;

import com.dev2games.exrenamer.Renamer;

import java.io.File;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * <p> Handles methods related to specific directories </p>
 *
 * @author Nelson Sanchez
 */

public class Directories {

    private static AtomicInteger count = new AtomicInteger();


    /**
     * Finds all files in the directory
     * @param directory the directory which we are searching in
     * @param currentExtension the extension that we are currently on
     * @param toExtension the extension we want to change to
     * @param recursive whether or not we want to only change the extension from one directory, or all directorie
     */

    public static void readAllFiles(String directory, String currentExtension, String toExtension, boolean recursive) {

        File folder = new File(directory);
        File[] files = folder.listFiles();



        //If no files or directories were found, terminate the program
        if (files == null) {
            System.out.println("There are no files or directories to search...");
            System.exit(0);
            return;
        }

        for (File file : files) {
            if (file.isFile()) {

                //If the file does not contain the extension we are looking for, then skip it
                if (!file.getName().endsWith(currentExtension))
                    continue;

                count.addAndGet(1);
                //String changedName = file.getName();
                final String changedName = getChangedName(file.getName(), toExtension);
                //The path our file will  be placed at
                final String path = file.getParent() + File.separator +  changedName;
                //Renames the file
                final boolean rename = file.renameTo(new File(path));
                //List the files in the directory
                if (rename)
                    System.out.println("File ( " + count.get() + " ): " + file.getName() + " -> " + changedName);
            } else if (file.isDirectory()) {
                //If the recursive parameter was detected, then search the new folder on a new thread.
                String newFolder = file.getParent() + File.separator + file.getName();
                if (recursive && Renamer.MULTI_THREAD) {
                    Renamer.service.getService().submit(() -> readAllFiles(newFolder, currentExtension, toExtension, true));
                } else {
                    readAllFiles(newFolder, currentExtension, toExtension, true);
                }
            }
        }
    }

    /**
     * Using StringBuilder this method generates the new name for the file. Specifically replacing the extension
     * @param currentName the current name of the file
     * @param toExtension the name of the extension we want to change to
     * @return the new name of the file
     */

    private static String getChangedName(String currentName, String toExtension) {
        StringBuilder changedName = new StringBuilder();
        changedName.append(currentName);
        changedName.setLength(changedName.length() - toExtension.length());
        changedName.append(toExtension);
        return changedName.toString();
    }

}
