/*
 * Decompiled with CFR 0.152.
 */
package org.jacorb.idl;

import java.util.HashMap;
import org.jacorb.idl.lexer;

public class ConstExprEvaluator {
    protected static Operator[] operators = null;
    private Node node = null;
    private String expression = null;
    private HashMap variables = new HashMap();

    public ConstExprEvaluator() {
        this.init();
    }

    public ConstExprEvaluator(String string) {
        this.init();
        this.setExpression(string);
    }

    private void init() {
        if (operators == null) {
            this.initializeOperators();
        }
    }

    public void setExpression(String string) {
        this.expression = string;
    }

    public void reset() {
        this.node = null;
        this.expression = null;
        this.variables = new HashMap();
    }

    public Double getValue() {
        if (this.expression == null) {
            return null;
        }
        try {
            this.node = new Node(this.expression);
            return ConstExprEvaluator.evaluate(this.node);
        }
        catch (Exception exception) {
            lexer.emit_error("unexpected exception: " + exception.getMessage());
            return null;
        }
    }

    private static Double evaluate(Node node) {
        if (node.hasOperator() && node.hasChild()) {
            if (node.getOperator().getType() == 1) {
                node.setValue(ConstExprEvaluator.evaluateExpression(node.getOperator(), ConstExprEvaluator.evaluate(node.getLeft()), null));
            } else if (node.getOperator().getType() == 2) {
                node.setValue(ConstExprEvaluator.evaluateExpression(node.getOperator(), ConstExprEvaluator.evaluate(node.getLeft()), ConstExprEvaluator.evaluate(node.getRight())));
            }
        }
        return node.getValue();
    }

    private static Double evaluateExpression(Operator operator, Double d, Double d2) {
        String string = operator.getOperator();
        Double d3 = null;
        if ("+".equals(string)) {
            d3 = new Double(d + d2);
        } else if ("-".equals(string)) {
            d3 = new Double(d - d2);
        } else if ("*".equals(string)) {
            d3 = new Double(d * d2);
        } else if ("/".equals(string)) {
            d3 = new Double(d / d2);
        } else if ("%".equals(string)) {
            d3 = new Double(d % d2);
        } else if ("|".equals(string)) {
            d3 = new Double(Double.longBitsToDouble(Double.doubleToLongBits(d) | Double.doubleToLongBits(d2)));
        } else if ("&".equals(string)) {
            d3 = new Double(Double.longBitsToDouble(Double.doubleToLongBits(d) & Double.doubleToLongBits(d2)));
        } else if ("^".equals(string)) {
            d3 = new Double(Double.longBitsToDouble(Double.doubleToLongBits(d) ^ Double.doubleToLongBits(d2)));
        } else if ("<<".equals(string)) {
            d3 = new Double(Double.longBitsToDouble(Double.doubleToLongBits(d) << (int)Double.doubleToLongBits(d2)));
        } else if (">>".equals(string)) {
            d3 = new Double(Double.longBitsToDouble(Double.doubleToLongBits(d) >> (int)Double.doubleToLongBits(d2)));
        }
        return d3;
    }

    private void initializeOperators() {
        operators = new Operator[10];
        ConstExprEvaluator.operators[0] = new Operator("|", 2, 0);
        ConstExprEvaluator.operators[1] = new Operator("^", 2, 2);
        ConstExprEvaluator.operators[2] = new Operator("&", 2, 4);
        ConstExprEvaluator.operators[3] = new Operator(">>", 2, 6);
        ConstExprEvaluator.operators[4] = new Operator("<<", 2, 6);
        ConstExprEvaluator.operators[5] = new Operator("+", 2, 8);
        ConstExprEvaluator.operators[6] = new Operator("-", 2, 8);
        ConstExprEvaluator.operators[7] = new Operator("*", 2, 10);
        ConstExprEvaluator.operators[8] = new Operator("/", 2, 10);
        ConstExprEvaluator.operators[9] = new Operator("%", 2, 10);
    }

    public Double getVariable(String string) {
        return (Double)this.variables.get(string);
    }

    private Double getDouble(String string) {
        if (string == null) {
            return null;
        }
        Double d = null;
        try {
            d = new Double(Double.parseDouble(string));
        }
        catch (Exception exception) {
            return this.getVariable(string);
        }
        return d;
    }

    protected Operator[] getOperators() {
        return operators;
    }

    protected class Node {
        public String nString = null;
        public Operator nOperator = null;
        public Node nLeft = null;
        public Node nRight = null;
        public Node nParent = null;
        public int nLevel = 0;
        public Double nValue = null;

        public Node(String string) throws Exception {
            this.init(null, string, 0);
        }

        public Node(Node node, String string, int n) throws Exception {
            this.init(node, string, n);
        }

        private void init(Node node, String string, int n) throws Exception {
            string = this.removeIllegalCharacters(string);
            string = this.removeBrackets(string);
            if (this.checkBrackets(string = this.addZero(string)) != 0) {
                throw new Exception("Wrong number of brackets in [" + string + "]");
            }
            this.nParent = node;
            this.nString = string;
            this.nValue = ConstExprEvaluator.this.getDouble(string);
            this.nLevel = n;
            int n2 = string.length();
            int n3 = 0;
            int n4 = 0;
            for (int i = 0; i < n2; ++i) {
                Operator operator;
                if (string.charAt(i) == '(') {
                    ++n3;
                    continue;
                }
                if (string.charAt(i) == ')') {
                    --n3;
                    continue;
                }
                if (n3 != 0 || (operator = this.getOperator(this.nString, i)) == null || this.nOperator != null && this.nOperator.getPriority() < operator.getPriority()) continue;
                this.nOperator = operator;
                n4 = i;
            }
            if (this.nOperator != null) {
                if (n4 == 0 && this.nOperator.getType() == 1) {
                    if (this.checkBrackets(string.substring(this.nOperator.getOperator().length())) == 0) {
                        this.nLeft = new Node(this, string.substring(this.nOperator.getOperator().length()), this.nLevel + 1);
                        this.nRight = null;
                        return;
                    }
                    throw new Exception("Error during parsing... missing brackets in [" + string + "]");
                }
                if (n4 > 0 && this.nOperator.getType() == 2) {
                    this.nLeft = new Node(this, string.substring(0, n4), this.nLevel + 1);
                    this.nRight = new Node(this, string.substring(n4 + this.nOperator.getOperator().length()), this.nLevel + 1);
                }
            }
        }

        private Operator getOperator(String string, int n) {
            Operator[] operatorArray = ConstExprEvaluator.this.getOperators();
            String string2 = string.substring(n);
            string2 = this.getNextWord(string2);
            for (int i = 0; i < operatorArray.length; ++i) {
                if (!string2.startsWith(operatorArray[i].getOperator())) continue;
                return operatorArray[i];
            }
            return null;
        }

        private String getNextWord(String string) {
            int n = string.length();
            for (int i = 1; i < n; ++i) {
                char c = string.charAt(i);
                if (c <= 'z' && c >= 'a' || c <= '9' && c >= '0') continue;
                return string.substring(0, i);
            }
            return string;
        }

        protected int checkBrackets(String string) {
            int n = string.length();
            int n2 = 0;
            for (int i = 0; i < n; ++i) {
                if (string.charAt(i) == '(' && n2 >= 0) {
                    ++n2;
                    continue;
                }
                if (string.charAt(i) != ')') continue;
                --n2;
            }
            return n2;
        }

        protected String addZero(String string) {
            if (string.startsWith("+") || string.startsWith("-")) {
                int n = string.length();
                for (int i = 0; i < n; ++i) {
                    if (this.getOperator(string, i) == null) continue;
                    return "0" + string;
                }
            }
            return string;
        }

        protected boolean hasChild() {
            return this.nLeft != null || this.nRight != null;
        }

        protected boolean hasOperator() {
            return this.nOperator != null;
        }

        protected boolean hasLeft() {
            return this.nLeft != null;
        }

        protected Node getLeft() {
            return this.nLeft;
        }

        protected boolean hasRight() {
            return this.nRight != null;
        }

        protected Node getRight() {
            return this.nRight;
        }

        protected Operator getOperator() {
            return this.nOperator;
        }

        protected int getLevel() {
            return this.nLevel;
        }

        protected Double getValue() {
            return this.nValue;
        }

        protected void setValue(Double d) {
            this.nValue = d;
        }

        protected String getString() {
            return this.nString;
        }

        public String removeBrackets(String string) {
            String string2 = string;
            if (string.length() > 2 && string2.startsWith("(") && string2.endsWith(")") && this.checkBrackets(string.substring(1, string.length() - 1)) == 0) {
                string2 = string2.substring(1, string2.length() - 1);
            }
            if (string2 != string) {
                return this.removeBrackets(string2);
            }
            return string2;
        }

        public String removeIllegalCharacters(String string) {
            char[] cArray = new char[]{' '};
            String string2 = string;
            for (int i = 0; i < cArray.length; ++i) {
                int n = string2.lastIndexOf(cArray[i], string2.length());
                while (n != -1) {
                    String string3 = string2;
                    string2 = string3.substring(0, n);
                    string2 = string2 + string3.substring(n + 1);
                    n = string2.lastIndexOf(cArray[i], string.length());
                }
            }
            return string2;
        }
    }

    protected class Operator {
        private String op;
        private int type;
        private int priority;

        public Operator(String string, int n, int n2) {
            this.op = string;
            this.type = n;
            this.priority = n2;
        }

        public String getOperator() {
            return this.op;
        }

        public void setOperator(String string) {
            this.op = string;
        }

        public int getType() {
            return this.type;
        }

        public int getPriority() {
            return this.priority;
        }
    }
}

