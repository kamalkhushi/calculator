package com.fukusha.calculator;

import android.util.Log;
import android.widget.Toast;

import java.util.EmptyStackException;
import java.util.Stack;
import java.lang.Math.*;

public class EvaluateString {
    public static double evaluate(String expression) {
        char[] tokens = expression.toCharArray();
        Log.d("expr", String.valueOf(tokens));

        // Stack for numbers: 'values'
        Stack<Double> values = new Stack<Double>();

        // Stack for Operators: 'ops'
        Stack<Character> ops = new Stack<Character>();

        for (int i = 0; i < tokens.length; i++) {
            // Current token is a whitespace, skip it
            if (tokens[i] == ' ')
                continue;

            // Current token is a number, push it to stack for numbers
            if (tokens[i] >= '0' && tokens[i] <= '9' || tokens[i] == '.') {
                StringBuffer sbuf = new StringBuffer();
                // There may be more than one digits in number
                try {
                    while (i < tokens.length && tokens[i] >= '0' && tokens[i] <= '9'|| tokens[i] == '.') {
                        sbuf.append(tokens[i++]);
                    }
                } catch (ArrayIndexOutOfBoundsException array) {
                    Log.d("Array except", "Something wrong at array pushing values to value stack");
                }
                values.push(Double.parseDouble(sbuf.toString()));
                Log.d("Stack vals:", String.valueOf(sbuf));
            }

            // Current token is an opening brace, push it to 'ops'
            else if (tokens[i] == '(')
                ops.push(tokens[i]);

                // Closing brace encountered, solve entire brace
            else if (tokens[i] == ')') {
                while (ops.peek() != '(')
                    values.push(applyOp(ops.pop(), values.pop(), values.pop()));
                ops.pop();
            }

            //Power evaluation
            else if (tokens[i] == '[')
                ops.push(tokens[i]);

                // Closing brace encountered power mode, solve entire brace
            else if (tokens[i] == ']') {
                while (ops.peek() != '[')
                    values.push(applyOp(ops.pop(), values.pop(), values.pop()));
                ops.pop();
            }

            // Current token is an operator.
            else if (tokens[i] == '+' || tokens[i] == '-' ||
                    tokens[i] == '*' || tokens[i] == '/' || tokens[i] == '^') {
                // While top of 'ops' has same or greater precedence to current token, which is an operator. Apply operator on top of 'ops' to top two elements in values stack
                while (!ops.empty() && hasPrecedence(tokens[i], ops.peek()))
                    values.push(applyOp(ops.pop(), values.pop(), values.pop()));

                // Push current token to 'ops'.
                ops.push(tokens[i]);
                Log.d("Op Stack:", String.valueOf(tokens[i]));
            }
        }

        // Entire expression has been parsed at this point, apply remaining ops to remaining values

        try {
            while (!ops.empty())
                values.push(applyOp(ops.pop(), values.pop(), values.pop()));

        } catch (EmptyStackException empty) {
            Log.d("stack", "check stacks");
        }

        // Top of 'values' contains result, return it
        return values.pop();
    }

    // Returns true if 'op2' has higher or same precedence as 'op1', otherwise returns false.
    public static boolean hasPrecedence(char op1, char op2)
    {
        if (op2 == '(' || op2 == ')' || op2 == '[' || op2 == ']')
            return false;
        if ((op1 == '^') && (op2 == '/' || op2 == '*' ||op2 == '+' ||op2 == '-'))
            return false;
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'))
            return false;
        else
            return true;
    }

    // A utility method to apply an operator 'op' on operands 'a' and 'b'. Return the result.

    public static double applyOp(char op, Double b, Double a)
    {

        switch (op)
        {
            case '+':
                if (b == null){
                    return a + 0;
                } else {
                    return a + b;
                }
            case '-':
                if (b == null){
                    return a - 0;
                } else {
                    return a - b;
                }
            case '*':
                if (b == null){
                    return a * 0;
                } else {
                    return a * b;
                }
            case '/':

                if (b == 0){
                    return 0;
                }else {
                    return a / b;
                }
            case '^':

                if (b == 0){
                    return Math.pow(a,0);
                } else {
                    return Math.pow(a,b);
                }
        }
        return 0;
    }
}
