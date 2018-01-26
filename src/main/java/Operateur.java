public class Operateur {

    Integer op(int a, char op, int b) {

        switch (op) {

            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                return a / b;

            default:

                break;
        }

        return 0;
    }

}
