package hw4_20001976;

import hw4_20001976.bai2.LinkedListStack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Bai4 {
    private ArrayList<Operand> expression = new ArrayList<>();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Input Expression: ");
        String function = input.nextLine();
        Bai4 bai4 = new Bai4(function);
        System.out.println(bai4);
    }

    public Bai4(String expression) {
        setExpression(expression);
    }

    public void setExpression(String function) {
        this.expression = validateInputExpression(function);
        cleanExpression();
    }

    public ArrayList<Operand> validateInputExpression(String function) {
        if (function == null || function.length() == 0) {
            System.out.println("Input is null");
            return null;
        }
        boolean status = true;

        // validate mismatch character
        StringBuilder sb = new StringBuilder();
        for (Character c : function.toCharArray()) {
            if (Operand.isBracketOrOperator(c))
                sb.append(" ").append(c).append(" ");
            else if (c >= 46 && c <= 57 && c != 47)
                sb.append(c);
            else if (c == ' ') ;
            else {
                System.out.println("IllegalArgumentException: Unknown character at " + c);
                status = false;
            }
        }
        if (!status) return null;

        // validate input number
        ArrayList<Operand> converted = new ArrayList<>();
        String[] split = sb.toString().trim().split("\\s+");
        for (String operand : split) {
            if (operand.equals("")) {
                continue;
            }
            if (Operand.isBracketOrOperator(operand.charAt(0))) {
                Operand c = new Operand(operand.charAt(0));
                if (converted.size() > 0 &&
                        (converted.get(converted.size() - 1).isNum() || converted.get(converted.size() - 1).isClose())
                        && c.isOpen())
                    converted.add(new Operand('*'));
                converted.add(c);
            } else {
                try {
                    double d = Double.parseDouble(operand);
                    converted.add(new Operand(d));
                } catch (NumberFormatException e) {
                    System.out.println("NumberFormatException: Undentify number: " + operand);
                    status = false;
                }
            }
        }
        if (!status) return null;
        if (!validatePositionOfOperand(converted)) return null;
        return converted;
    }

    public boolean validatePositionOfOperand(ArrayList<Operand> converted) {
        if (converted == null || converted.size() == 0) {
            System.out.println("Input is null");
            return false;
        }
        LinkedListStack<Operand> brackets = new LinkedListStack<>();
        boolean status = true;
        for (int i = 0; i < converted.size(); i++) {
            Operand temp = converted.get(i);
            // check first char
            if (i == 0 && !temp.isPlusAndSubtract() && !temp.isOpen() && !temp.isNum()) {
                System.out.println("InputMismatchException: number or open bracket must be first");
                status = false;
                // check bracket
            } else if (temp.isOpen())
                brackets.push(temp);
            else if (temp.isClose() && !brackets.isEmpty() && temp.isNotBracketPair(brackets.pop())) {
                System.out.println("InputMismatchException: Unknown close bracket at " + i);
                status = false;
            } else if (i + 1 < converted.size()) {
                if (temp.isOperator() && (temp.data == 3 || temp.data == 4)
                        && converted.get(i + 1).isNum() && converted.get(i + 1).data == 0) {
                    System.out.println("ArithmeticException: Divide by zero at " + i);
                    status = false;
                } else if (temp.isOperator() && converted.get(i + 1).isClose()) {
                    System.out.println("InputMismatchException: don't have numbers between operator and bracket at " + (i + 1));
                    status = false;
                } else if (temp.isOperator() && converted.get(i + 1).isOperator() &&
                        !converted.get(i + 1).isPlusAndSubtract()) {
                    System.out.println("InputMismatchException: don't have numbers between 2 operators at position " + i);
                    status = false;
                } else if (temp.isOpen() && converted.get(i + 1).isOperator() && !converted.get(i + 1).isPlusAndSubtract()) {
                    System.out.println("InputMismatchException: don't have numbers between bracket and operator at " + i);
                    status = false;
                } else if (temp.isOpen() && converted.get(i + 1).isClose()) {
                    System.out.println("InputMismatchException: bracket closed but don't have anything inside at " + i);
                    status = false;
                }
            }
            else if (i == converted.size() - 1 && !temp.isNum() && !temp.isClose()) {
                System.out.println("InputMismatchException: number or close bracket must be last");
                status = false;
            }
        }
        if (!brackets.isEmpty()) {
            System.out.println("Warning: Some bracket are not closed. Auto close");
            while (!brackets.isEmpty()) {
                Operand close = brackets.pop();
                close.data += 3;
                converted.add(close);
            }
        }
        return status;
    }

    public void cleanExpression() {
        if (this.expression == null || this.expression.isEmpty()) {
            return;
        }
        int i = 0;
        //combine + - next to each other
        while (i < expression.size()) {
            if (expression.get(i).isOperator() || expression.get(i).isOpen() && expression.get(i + 1).isPlusAndSubtract()) {
                int positive = 1;
                while (expression.get(i + 1).isPlusAndSubtract()) {
                    positive = positive * ((expression.get(i + 1).data == 0) ? 1 : -1);
                    expression.remove(i + 1);
                }
                expression.get(i + 1).data *= positive;
            }
            i++;
        }
        if (expression.get(0).isPlusAndSubtract()) {
            expression.get(1).data *= ((expression.get(0).data == 0) ? 1 : -1);
            expression.remove(0);
        }
    }

    public String getExpression() {
        if (this.expression == null || this.expression.isEmpty()) {
            return "Nothing ";
        }
        StringBuilder sb = new StringBuilder();
        for (Operand o : this.expression) {
            sb.append(o.toString());
        }
        sb.append("= ");
        return sb.toString();
    }

    public boolean hasHigherOrder(Operand op1, Operand op2) {
        if (op2.isOpen() || op2.isClose())
            return false;
        return op1.isPlusAndSubtract() ||
                !op2.isPlusAndSubtract();
    }

    public Operand calc(Operand op, Operand b, Operand a) {
        //minimum jdk14
        return new Operand(switch (op.getData()) {
            case '+' -> a.data + b.data;
            case '-' -> a.data - b.data;
            case '*' -> a.data * b.data;
            case '/' -> a.data / b.data;
            case '%' -> a.data % b.data;
            default -> 0;
        });
//        use this if cant compiler
//        switch (op.getData()) {
//            case '+' : return new Operand(a.data + b.data);
//            case '-' : return new Operand(a.data - b.data);
//            case '*' : return new Operand(a.data * b.data);
//            case '/' : return new Operand(a.data / b.data);
//            case '%' : return new Operand(a.data % b.data);
//            default : return new Operand( 0);
//        }
    }


    public double evaluate() {
        if (this.expression == null || this.expression.isEmpty()) {
            return 0.0;
        }
        LinkedListStack<Operand> values = new LinkedListStack<>();
        LinkedListStack<Operand> operators = new LinkedListStack<>();
        for (Operand operand : expression) {
            if (operand.isNum())
                values.push(operand);
            else if (operand.isOpen()) {
                operators.push(operand);
            } else if (operand.isClose()) {
                while (operators.top().isNotBracketPair(operand))
                    values.push(calc(operators.pop(), values.pop(), values.pop()));
                operators.pop();
            } else if (operand.isOperator()) {
                while (!operators.isEmpty() && hasHigherOrder(operand, operators.top()))
                    values.push(calc(operators.pop(), values.pop(), values.pop()));
                operators.push(operand);
            }
        }
        while (!operators.isEmpty())
            values.push(calc(operators.pop(), values.pop(), values.pop()));
        return values.pop().data;
    }

    @Override
    public String toString() {
        return getExpression() + evaluate();
    }

    private static class Operand {
        private static final ArrayList<Character> ACCENT = new ArrayList<>(
                Arrays.asList('+', '-', '*', '/', '%', '(', '[', '{', ')', ']', '}'));
        double data;
        int type;

        public Operand(char notNumber) {
            data = ACCENT.indexOf(notNumber);
            type = 1;
        }

        public Operand(double number) {
            this.data = number;
        }

        static boolean isBracketOrOperator(char c) {
            return ACCENT.contains(c);
        }

        public boolean isNum() {
            return type == 0;
        }

        public boolean isOpen() {
            return type == 1 && data >= 5 && data <= 7;
        }

        public boolean isClose() {
            return type == 1 && data >= 8 && data <= 10;
        }

        public boolean isOperator() {
            return type == 1 && data >= 0 && data <= 4;
        }

        public boolean isNotBracketPair(Operand op) {
            return type != 1 || op.type != 1 || (data + 3 != op.data && data - 3 != op.data);
        }

        public boolean isPlusAndSubtract() {
            return type == 1 && (data == 0 || data == 1);
        }

        public char getData() {
            if (type == 1) {
                return ACCENT.get((int) data);
            } else return 0;
        }

        @Override
        public String toString() {
            return type == 0 ? data + " " : ACCENT.get((int) data) + " ";
        }
    }
}
