package com.lhauspie.adventofcode.day13.model;

public class Element {
        private String signal;
        private Integer value;
        private boolean list;
        private boolean integer;

        private Element(String signal) {
            this.list = true;
            this.signal = signal;
        }

        private Element(String signal, Integer value) {
            this.integer = true;
            this.signal = signal;
            this.value = value;
        }

        public static Element ofList(String signal) {
            return new Element(signal);
        }

        public static Element ofInteger(String signal) {
            return new Element(signal, Integer.parseInt(signal));
        }

        public String getSignal() {
            return signal;
        }

        public boolean isList() {
            return list;
        }

        public boolean isInteger() {
            return integer;
        }

        public Integer getValue() {
            return value;
        }
    }
