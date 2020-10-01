package by.kukshinov.app.array.cover.util.parser;

import by.kukshinov.app.array.cover.wrapper.ArrayWrapper;

public interface Parser<T> {
    ArrayWrapper parseDataToArrayWrapper(T source);
    int parseSingleString(String s);

    //TODO refactor return type to ArrayWrapper
    // and create methods that accept int and int[]
    //and write tests
}
