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

    @Test
    public void elfCounting1000CaloriesThen2000CaloriesShouldCarry3000Calories() {
        var elf = new Elf();
        elf.count(1000);
        elf.count(2000);
        Assertions.assertEquals(3000, elf.getCarriedCalories());
    }

    @Test
    public void elfCounting1000CaloriesThen2000CaloriesThen20000CaloriesShouldCarry3000Calories() {
        var elf = new Elf();
        elf.count(1000);
        elf.count(2000);
        elf.count(20000);
        Assertions.assertEquals(23000, elf.getCarriedCalories());
    }

    @Test
    public void elfCounting10000CaloriesCarriesMoreCaloriesThanElfCounting200Calories() {
        var elfCounting10000Calories = new Elf();
        elfCounting10000Calories.count(10000);
        var elfCounting200Calories = new Elf();
        elfCounting200Calories.count(200);

        Assertions.assertTrue(elfCounting10000Calories.carriesMoreCaloriesThan(elfCounting200Calories));
    }

    @Test
    public void elfCounting10CaloriesDoesntCarryMoreCaloriesThanElfCounting200Calories() {
        var elfCounting10Calories = new Elf();
        elfCounting10Calories.count(10);
        var elfCounting200Calories = new Elf();
        elfCounting200Calories.count(200);

        Assertions.assertFalse(elfCounting10Calories.carriesMoreCaloriesThan(elfCounting200Calories));
    }
}
