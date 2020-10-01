package by.kukshinov.app.array.cover.factory;

import by.kukshinov.app.array.cover.constants.FilePaths;
import by.kukshinov.app.array.cover.data.DataAcquirer;
import by.kukshinov.app.array.cover.data.impl.FileDataAcquirer;
import by.kukshinov.app.array.cover.enums.DataAcquirerType;
import by.kukshinov.app.array.cover.util.parser.Parser;
import by.kukshinov.app.array.cover.util.parser.impl.StringParser;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class DataAcquirerCreatorTest {
    @Test
    public void shouldCreateFileDataAcquirer() {
        //given
	   DataAcquirerCreator dataAcquirerCreator = new DataAcquirerCreator();
	   Parser<String> parser = new StringParser();
	   DataAcquirer acquirer = new FileDataAcquirer(FilePaths.TEST_ARRAY_DATA_FILE_PATH, parser);
	   //when
	   DataAcquirer compared = dataAcquirerCreator.createDataAcquirer(DataAcquirerType.FILE, FilePaths.TEST_ARRAY_DATA_FILE_PATH);
	   //then
	   Assert.assertEquals(acquirer, compared);
    }

}
