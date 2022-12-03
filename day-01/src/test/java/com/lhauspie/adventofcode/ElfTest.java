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

    @Test
    public void elfCounting1000CaloriesShouldCarry1000Calories() {
        var elf = new Elf();
        elf.count(1000);
        Assertions.assertEquals(1000, elf.getCarriedCalories());
    }
}
