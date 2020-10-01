package by.kukshinov.app.array.cover.data;

import by.kukshinov.app.array.cover.wrapper.ArrayWrapper;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface DataAcquirer {
    ArrayWrapper getData() throws IOException;
}
