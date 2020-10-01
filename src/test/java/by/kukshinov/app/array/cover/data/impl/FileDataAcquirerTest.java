package by.kukshinov.app.array.cover.data.impl;

import by.kukshinov.app.array.cover.constants.FilePaths;
import by.kukshinov.app.array.cover.data.DataAcquirer;
import by.kukshinov.app.array.cover.util.parser.Parser;
import by.kukshinov.app.array.cover.util.parser.impl.StringParser;
import by.kukshinov.app.array.cover.wrapper.ArrayWrapper;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class FileDataAcquirerTest {
    @Test
    public void shouldReadDataFromFileAndReturnFilledArrayWrapper() throws IOException {
        //given
	   Parser<String> stringParser = new StringParser();
	   DataAcquirer fileDataAcquirer = new FileDataAcquirer(FilePaths.TEST_ARRAY_DATA_FILE_PATH, stringParser);
	   ArrayWrapper toCompare = new ArrayWrapper(new int[]{123, 122, 947, 6, -7, 437, 327, 900, 653, 239, -98, 89});
	   //when
	   ArrayWrapper wrapper = fileDataAcquirer.getData();
	   //then
	   Assert.assertEquals(toCompare, wrapper);
    }
}
