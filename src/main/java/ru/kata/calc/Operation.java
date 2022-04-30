package ru.kata.calc;

enum Operation {
    division("/"),
    multiplication("*"),
    addition("+"),
    subtraction("-");

    private final String operationSymbol;

    Operation(String operationSymbol) {
        this.operationSymbol = operationSymbol;
    }

    public String getOperationSymbol() {
        return operationSymbol;
    }
}
