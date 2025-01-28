package pro.edme;

public enum EnumCulcOperations {
    PLUS {
        @Override
        int calculate(int a, int b) {
            return a + b;
        }
    },
    MINUS {
        @Override
        int calculate(int a, int b) {
            return a - b;
        }
    },
    MULTIPLY {
        @Override
        int calculate(int a, int b) {
            return a * b;
        }
    },
    DIVIDE {
        @Override
        int calculate(int a, int b) {
            return a / b;
        }
    };

    abstract int calculate(int a, int b);

    static EnumCulcOperations valueOfBySign(String sign) {
        return switch (sign) {
            case "+" -> PLUS;
            case "-" -> MINUS;
            case "*" -> MULTIPLY;
            case "/" -> DIVIDE;
            default -> throw new IllegalArgumentException("Not found sign!");
        };
    }
}
