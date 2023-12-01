package org.example.sorter;

import com.google.code.externalsorting.ExternalSort;

import java.io.File;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.Comparator;
import java.util.logging.Logger;

public class FileSorter {
    private static final Logger logger = Logger.getLogger(FileSorter.class.getName());

    private final String inputFileName;
    private final String outputFileName;
    private final Comparator<String> ipComparator;

    public FileSorter(String inputFileName) {
        this.inputFileName = inputFileName;
        this.outputFileName = inputFileName + "_SORTED";
        this.ipComparator = new IPAddressComparator();
    }

    public File startSort() throws IOException {
        var outputFile = new File(outputFileName);
        var numLinesWritten = ExternalSort.mergeSortedFiles(
                ExternalSort.sortInBatch(new File(inputFileName)),
                outputFile,
                ipComparator);

        logger.info(MessageFormat.format("Lines written in output file: {0}", numLinesWritten)); //TODO can't understand sonar

        return outputFile;
    }
}
