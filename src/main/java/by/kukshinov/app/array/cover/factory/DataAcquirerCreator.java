package by.kukshinov.app.array.cover.factory;

import by.kukshinov.app.array.cover.data.DataAcquirer;
import by.kukshinov.app.array.cover.data.impl.ConsoleDataAcquirer;
import by.kukshinov.app.array.cover.data.impl.FileDataAcquirer;
import by.kukshinov.app.array.cover.data.impl.RandomDataAcquirer;
import by.kukshinov.app.array.cover.enums.DataAcquirerType;
import by.kukshinov.app.array.cover.exception.NoSuchDataAcquirerTypeException;
import by.kukshinov.app.array.cover.util.parser.Parser;
import by.kukshinov.app.array.cover.util.parser.impl.IntParser;
import by.kukshinov.app.array.cover.util.parser.impl.StringParser;

public class DataAcquirerCreator {
    public DataAcquirer createDataAcquirer(DataAcquirerType type, String filePath){
        switch (type){
		  case FILE: return new FileDataAcquirer(filePath, new StringParser());
		  case CONSOLE: return new ConsoleDataAcquirer(new StringParser());
		  case RANDOM: return new RandomDataAcquirer(new IntParser());
		  default: throw  new NoSuchDataAcquirerTypeException();
	   }
    }
}
