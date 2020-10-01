package by.kukshinov.app.array.cover.data.impl;

import by.kukshinov.app.array.cover.data.DataAcquirer;
import by.kukshinov.app.array.cover.util.parser.Parser;
import by.kukshinov.app.array.cover.wrapper.ArrayWrapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleDataAcquirer implements DataAcquirer {
    private final Parser<String> parser;

    public ConsoleDataAcquirer(Parser<String> parser) {
	   this.parser = parser;
    }

    private String getLength(BufferedReader reader) throws IOException {
	   System.out.println("Set array length");
	   return reader.readLine();
    }
//
    private String getValue(BufferedReader reader) throws IOException {
	   System.out.println("Set value");
	   return reader.readLine();
    }

    @Override
    public ArrayWrapper getData() throws IOException {
	   int length;
	   StringBuilder stringArrayData = new StringBuilder();
	   try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
		  length = parser.parseSingleString(getLength(reader));
		  for (int runner = 0; runner < length; ++runner) {
			 stringArrayData.append(getValue(reader));
		  }
		  return parser.parseDataToArrayWrapper(stringArrayData.toString());
	   }
    }

}
