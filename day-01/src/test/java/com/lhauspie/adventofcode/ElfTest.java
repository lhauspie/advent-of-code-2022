package com.lhauspie.adventofcode;

import com.lhauspie.adventofcode.model.Elf;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ElfTest {

    @Test
    public void elfWithoutCaloryCountingShouldCarryNoCalories() {
        var elf = new Elf();
        Assertions.assertEquals(0, elf.getCarriedCalories());
    }
}
