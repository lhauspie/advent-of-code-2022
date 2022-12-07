package com.lhauspie.adventofcode.model.filesystem;

import com.lhauspie.adventofcode.model.Size;

public class File {
    private Size size;

    public File(Size size) {
        this.size = size;
    }

    public Size getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "(file, size=" + size + ")";
    }
}
