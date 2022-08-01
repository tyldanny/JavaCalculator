package com.tyldanny.javacalculator.operation;

import com.tyldanny.javacalculator.gui.GUI;

public class SubtractionOperation implements IOperation {
    private final GUI gui;

    public SubtractionOperation(GUI gui) {
        this.gui = gui;
    }

    @Override
    public void handle(String buttonText) {
        if (getHistory(gui).contains("-")) {
            try {
                double previousValue = Double.parseDouble(getHistory(gui).replace("-", ""));
                double nextValue = Double.parseDouble(getDisplay(gui));
                setHistory(gui, clean((previousValue - nextValue) + "") + "-");
                setDisplay(gui, "0");
                return;
            } catch (NumberFormatException ignore) {}
            return;
        }

        setHistory(gui, getHistory(gui).replaceAll("[^0-9]", ""));

        if (!getHistory(gui).equals("0")) {
            setHistory(gui, getHistory(gui) + "-");
            return;
        }

        setHistory(gui, getDisplay(gui) + "-");
        setDisplay(gui, "0");
    }
}
