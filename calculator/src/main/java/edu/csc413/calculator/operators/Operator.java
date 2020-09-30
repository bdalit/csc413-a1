package edu.csc413.calculator.operators;

import edu.csc413.calculator.evaluator.Operand;

import java.util.HashMap;

/**
 * Base class representing a mathematical operator used in an arithmetic expression. Every Operator has a precedence
 * which determines how expressions with multiple operands and operators should be evaluated.
 */
public abstract class Operator {
   private static HashMap<String, Operator> operators;
   static{
       operators = new HashMap<>();
       operators.put("+", new Add());
       operators.put("-", new Subtract());
       operators.put("*", new Multiply());
       operators.put("/", new Divide());
//       operators.put("(", new oParent());
//       operators.put(")", new cParent());
   }
    public abstract int precedence();

    /**
     * Evaluates an expression by applying this operator to the provided operands.
     *
     * @param lhs Left-hand side operand for this operation
     * @param rhs Right-hand side operand for this operation
     * @return A single Operand representing the result of applying the operator
     */
    public abstract Operand execute(Operand lhs, Operand rhs);

    /**
     * Creates a new Operator of the correct subtype (e.g. AddOperator) for the given token (e.g. "+"). If the token
     * does not represent a valid operator, null is returned.
     *
     * @param token String representation of an operator; we assume that isValid has already been used to verify that
     *              the token is a valid operator
     * @return Operator An instantiation of the Operator subclass corresponding to token or null if the token is invalid
     */
    public static Operator create(String token) {
        // TODO: Implement.
        operators.containsKey(token);
        return null;
    }
    public static Operator getOperator(String token){
//        if(getOperator(token)){
            return operators.get(token);
        }
//        return null;

    public static String getAllOperators(){
        String list = "";
        for (String key : operators.keySet()){
            list += key;
        }
        return list;
    }
}
    class Add extends Operator{
        @Override
        public int precedence() {
            return 1;
        }

        @Override
        public Operand execute(Operand lhs, Operand rhs){
        int sum = lhs.getValue() + rhs.getValue();
        Operand value = new Operand(sum) {
            @Override
            public int precedence() {
                return 0;
            }
        };
        return value;
    }
    }
        class Subtract extends Operator{
        @Override
        public int precedence(){
            return 1;
        }



        @Override
        public Operand execute(Operand lhs, Operand rhs){
            int subtract = lhs.getValue() - rhs.getValue();
            Operand value = new Operand(subtract) {
                @Override
                public int precedence() {
                    return 0;
                }
            };
            return value;
        }
    }
     class Multiply extends Operator {
    @Override
    public int precedence() {
        return 2;
    }


    @Override
    public Operand execute(Operand lhs, Operand rhs) {
        int subtract = lhs.getValue() * rhs.getValue();
        Operand value = new Operand(subtract) {
            @Override
            public int precedence() {
                return 0;
            }
        };
        return value;
    }
}
     class Divide extends Operator {
    @Override
    public int precedence() {
        return 2;
    }


    @Override
    public Operand execute(Operand lhs, Operand rhs) {
        int subtract = lhs.getValue()/rhs.getValue();
        Operand value = new Operand(subtract) {
            @Override
            public int precedence() {
                return 0;
            }
        };
        return value;
    }
}

