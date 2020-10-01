package by.kukshinov.app.array.cover.view.impl;

import by.kukshinov.app.array.cover.constants.FilePaths;
import by.kukshinov.app.array.cover.consts.ArrayWrapperConst;
import by.kukshinov.app.array.cover.exception.ArrayException;
import by.kukshinov.app.array.cover.util.processor.ArrayWrapperProcessor;
import by.kukshinov.app.array.cover.wrapper.ArrayWrapper;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;

public class FileDataPrinterTest {
    private String readFileData(String filePath) {
	   String data = "";
	   StringBuilder result = new StringBuilder();
	   try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
	       while ((data = reader.readLine()) != null)
		  result.append(data).append("\n");
	   } catch (IOException e) {
		  throw new RuntimeException(e);
	   }
	   return result.toString();
    }

    @Test
    public void testFileDataWriterShouldWriteDataToSpecifiedFile() throws IOException {
	   //given
	   FileDataPrinter printer = new FileDataPrinter(FilePaths.TEST_ARRAY_DATA_WRITER_FILE_PATH);
	   ArrayWrapper wrapper = ArrayWrapperConst.WRAPPER;
	   int[] toPrint = ArrayWrapperConst.SORTED_ONE_INT_ARRAY_ASC;
	   //when
	   printer.printData(wrapper, toPrint);
	   //then
	   String result = readFileData(FilePaths.TEST_ARRAY_DATA_WRITER_FILE_PATH);
	   Assert.assertEquals((wrapper.toString() + "\n" + Arrays.toString(toPrint) + "\n"), result);
    }

}
