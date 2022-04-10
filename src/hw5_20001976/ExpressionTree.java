package hw5_20001976;

import hw4_20001976.bai2.LinkedListStack;
import hw5_20001976.bai1.LinkedBinaryTree;

import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class ExpressionTree extends LinkedBinaryTree<ExpressionTree.Operand> {

    int count = -1;

    public ExpressionTree(String expression) {
        setExpression(expression);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Input Expression: ");
        String function = input.nextLine();
        ExpressionTree et = new ExpressionTree(function);
        print(et.root(), 0, et);
        System.out.println(et);
    }

    public static void print(Node<Operand> position, int space, LinkedBinaryTree<Operand> list) {


        if (list.isEmpty())
            return;
        space += 1;
        // process right

        if (list.right(position) != null)
            print(list.right(position), space, list);
        //print self
        System.out.print("\n");
        for (int i = 1; i < space; i++)
            System.out.print("\t");
        System.out.printf("%s\n", list.value(position).toString());
        // process left
        if (list.left(position) != null)
            print(list.left(position), space, list);
    }

    public void setExpression(String function) {
        validateInputExpression(function);
    }

    public void validateInputExpression(String function) {
        if (function == null || function.length() == 0) {
            System.out.println("Input is null");
            return;
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
        if (!status) return;

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
        if (!status) return;
        if (!validatePositionOfOperand(converted)) return;
        cleanExpression(converted);
        ArrayList<Operand> tree = getPrefix(converted);
        arrayToTree(this.addRoot(null), tree);
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
            } else if (i == converted.size() - 1 && !temp.isNum() && !temp.isClose()) {
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

    public void cleanExpression(ArrayList<Operand> expression) {
        if (expression == null || expression.isEmpty()) {
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

    public void arrayToTree(Node<Operand> node, ArrayList<Operand> tree) {
        count += 1;
        if (count < tree.size()) {
            this.set(node, tree.get(count));
            if (tree.get(count).isOperator()) {
                arrayToTree(this.addLeft(node, null), tree);
            } else return;
            arrayToTree(this.addRight(node, null), tree);
        }
    }

    public ArrayList<Operand> getPrefix(ArrayList<Operand> expression) {
        if (expression == null || expression.isEmpty()) {
            return null;
        }
        Collections.reverse(expression);
        ArrayList<Operand> result = new ArrayList<>();
        LinkedListStack<Operand> temp = new LinkedListStack<>();
        for (Operand operand : expression) {
            if (operand.isNum())
                result.add(operand);
            else if (operand.isClose()) {
                temp.push(operand);
            } else if (operand.isOpen()) {
                while (temp.top().isNotBracketPair(operand)) {
                    result.add(temp.pop());
                }
                temp.pop();
            } else if (operand.isOperator()) {
                if (!temp.isEmpty() && hasHigherOrder(operand, temp.top())) {
                    result.add(temp.pop());
                    temp.push(operand);
                } else temp.push(operand);
            }
        }
        while (!temp.isEmpty())
            result.add(temp.pop());
        Collections.reverse(result);
        return result;
    }

    public String getExpression(Node<Operand> p) {
        StringBuilder s = new StringBuilder();
        System.setOut(new PrintStream(OutputStream.nullOutputStream()));
        if (this.value(p) != null) {
            //left
            if (this.left(p) != null) {
                s.append("(  ");
                s.append(this.getExpression(this.left(p)));
            }
            //root
            s.append(this.value(p)).append(" ");
            //right
            if (this.right(p) != null) {
                s.append(this.getExpression(this.right(p)));
                s.append(")");
            }
            return s.toString();
        }
        return "";
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
    }

    public Operand evaluate(Node<Operand> node) {
        if (node == null || this.isEmpty()) {
            return new Operand(0.0);
        }
        if (this.value(node).isNum())
            return this.value(node);
        else
            return calc(this.value(node), evaluate(this.right(node)), evaluate(this.left(node)));
    }

    @Override
    public String toString() {
        return getExpression(node) + "  =  " + evaluate(node);
    }

    protected static class Operand {
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
