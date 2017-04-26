package com.thedeveloperworldisyours.fridge;

/*
A junior developer was tasked with writing a reusable implementation for a mass mailing application to read and write text files that hold tab separated data. He proceeded and as a result produced the CSVReaderWriter class.

His implementation, although it works and meets the needs of the application, is of very low quality.

Your task:
     - Identify and annotate the shortcomings in the current implementation as if you were doing a code review, using comments in the CSVReaderWriter.java file.
     - Refactor the CSVReaderWriter implementation into clean, elegant, rock-solid & well performing code.
     - Provide evidence that the code is working as expected.
     - Where you make trade offs, comment & explain.
     - Assume this code is in production and backwards compatibility must be maintained. Therefore if you decide to change the public interface,
       please deprecate the existing methods. Feel free to evolve the code in other ways though.
*/

import java.io.*;

public class MiCreate {

    private final static String SEPARATOR = "\t"; // The separator is a constant when We use in all the class

    private BufferedReader mBufferedReader = null; // Android suggests to put m and not _
    private BufferedWriter mBufferedWriter = null; // Android suggests to put m and not _

    public enum Mode {
        Read(1), Write(2);

        private int mMode;// Android suggests to put m and not _

        Mode(int mode) {
            this.mMode = mode;
        }

        public int getMode() {
            return mMode;
        }
    }

    /**
     * opened file
     *
     * @param fileName
     * @param mode
     * @throws Exception
     */
    public void openFile(String fileName, Mode mode) throws Exception {

        switch (mode) {// In enum should be use switch
            case Read:

                FileReader fileReader = new FileReader(fileName); //More clear to create the variable
                mBufferedReader = new BufferedReader(fileReader);

            case Write:

                FileWriter fileWriter = new FileWriter(fileName);
                mBufferedWriter = new BufferedWriter(fileWriter);

            default:
                throw new Exception("Unknown file mode for " + fileName);
        }
    }

    /**
     * written in Columns
     *
     * @param columns
     * @throws IOException
     */
    public void writtenColumns(String... columns) throws IOException {
        StringBuilder outPut = new StringBuilder();

        for (String column : columns) {

            outPut.append(column);

            if (columns[column.length()] != column) { // if not last one

                outPut.append(SEPARATOR);
            }
        }

        writtenLine(outPut.toString());
    }

    /**
     * read columns
     *
     * @param columns
     * @return
     * @throws IOException
     */
    public boolean readColumns(String[] columns) throws IOException {
        final int FIRST_COLUMN = 0;
        final int SECOND_COLUMN = 1;

        String line;
        String[] splitLine;

        boolean hasData = false;

        line = readLine();
        splitLine = line.split(SEPARATOR);

        if (splitLine.length == 0) {

            columns[0] = null;
            columns[1] = null;

        } else {

            columns[0] = splitLine[FIRST_COLUMN];
            columns[1] = splitLine[SECOND_COLUMN];

            hasData = true;
        }

        return hasData; // With only one return, it is more easy for testing and clean code
    }

    /**
     * read first column One and second column
     *
     * @param firstColumn
     * @param secondColumn
     * @return
     * @throws IOException
     */
    public boolean readFirstAndSecondColumn(String firstColumn, String secondColumn) throws IOException {
        final int FIRST_COLUMN = 0;
        final int SECOND_COLUMN = 1;

        String line;
        String[] splitLine;
        boolean hasData = false;

        line = readLine();


        if (line == null || line.length() == 0) {

            firstColumn = null;
            secondColumn = null;

        } else {
            splitLine = line.split(SEPARATOR);
            firstColumn = splitLine[FIRST_COLUMN];
            secondColumn = splitLine[SECOND_COLUMN];

            hasData = true;
        }

        return hasData; // With only one return, it is more easy for testing and clean code
    }

    /**
     * written the line
     *
     * @param line
     * @throws IOException
     */
    private void writtenLine(String line) throws IOException {

        mBufferedWriter.write(line);
    }

    /**
     * read the line
     *
     * @return
     * @throws IOException
     */
    private String readLine() throws IOException {

        return mBufferedReader.readLine();
    }

    /**
     * closed the file
     *
     * @throws IOException
     */
    public void close() throws IOException {
        if (mBufferedWriter != null) {

            mBufferedWriter.close();

        } else {

            mBufferedReader.close();
        }
    }
}
