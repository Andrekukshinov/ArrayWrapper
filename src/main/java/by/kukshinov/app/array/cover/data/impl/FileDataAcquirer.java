package by.kukshinov.app.array.cover.data.impl;

import by.kukshinov.app.array.cover.data.DataAcquirer;
import by.kukshinov.app.array.cover.util.parser.Parser;
import by.kukshinov.app.array.cover.wrapper.ArrayWrapper;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;

public class FileDataAcquirer implements DataAcquirer {
    private final String FILE_PATH;
    private final Parser<String> parser;

    public FileDataAcquirer(String filePath, Parser<String> parser) {
	   FILE_PATH = filePath;
	   this.parser = parser;
    }

    @Override
    public ArrayWrapper getData() throws IOException {
	   try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
		  String source = reader.readLine();
		  return parser.parseDataToArrayWrapper(source);
	   }
    }

    @Override
    public boolean equals(Object o) {
	   if (o == null || getClass() != o.getClass()) return false;
	   FileDataAcquirer that = (FileDataAcquirer) o;
	   return Objects.equals(FILE_PATH, that.FILE_PATH);
    }

}

