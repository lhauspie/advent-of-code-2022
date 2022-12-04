package com.lhauspie.adventofcode.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ElfTest {

    @Test
    public void elfWithoutCaloryCountingShouldCarryNoCalories() {
        var elf = new Elf();
        Assertions.assertEquals(Quantity.of(0), elf.getCarriedCalories());
    }

    @Test
    public void elfCounting1000CaloriesShouldCarry1000Calories() {
        var elf = new Elf();
        elf.count(Quantity.of(1000));
        Assertions.assertEquals(Quantity.of(1000), elf.getCarriedCalories());
    }

    @Test
    public void elfCounting1000CaloriesThen2000CaloriesShouldCarry3000Calories() {
        var elf = new Elf();
        elf.count(Quantity.of(1000));
        elf.count(Quantity.of(2000));
        Assertions.assertEquals(Quantity.of(3000), elf.getCarriedCalories());
    }

    @Test
    public void elfCounting1000CaloriesThen2000CaloriesThen20000CaloriesShouldCarry3000Calories() {
        var elf = new Elf();
        elf.count(Quantity.of(1000));
        elf.count(Quantity.of(2000));
        elf.count(Quantity.of(20000));
        Assertions.assertEquals(Quantity.of(23000), elf.getCarriedCalories());
    }

    @Test
    public void elfCounting10000CaloriesCarriesMoreCaloriesThanElfCounting200Calories() {
        var elfCounting10000Calories = new Elf();
        elfCounting10000Calories.count(Quantity.of(10000));
        var elfCounting200Calories = new Elf();
        elfCounting200Calories.count(Quantity.of(200));

        Assertions.assertTrue(elfCounting10000Calories.carriesMoreCaloriesThan(elfCounting200Calories));
    }

    @Test
    public void elfCounting10CaloriesDoesntCarryMoreCaloriesThanElfCounting200Calories() {
        var elfCounting10Calories = new Elf();
        elfCounting10Calories.count(Quantity.of(10));
        var elfCounting200Calories = new Elf();
        elfCounting200Calories.count(Quantity.of(200));

        Assertions.assertFalse(elfCounting10Calories.carriesMoreCaloriesThan(elfCounting200Calories));
    }

    @Test
    public void elfCounting10CaloriesDoesntCarryMoreCaloriesThanElfCounting10Calories() {
        var elfCounting10Calories = new Elf();
        elfCounting10Calories.count(Quantity.of(10));

        Assertions.assertFalse(elfCounting10Calories.carriesMoreCaloriesThan(elfCounting10Calories));
    }
}
