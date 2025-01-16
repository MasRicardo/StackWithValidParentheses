import java.util.*;

class Stack {
    private LinkedList<Character> stack;

    public Stack() {
        stack = new LinkedList<>();
    }

    public int push(char item) {
        stack.addLast(item);
        return stack.size();
    }

    public char pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stack.removeLast();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public char peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stack.getLast();
    }

    public int length() {
        return stack.size();
    }
}

public class ValidParentheses {

    public static boolean isValid(String s) {
        Stack stack = new Stack();
        
        for (char c : s.toCharArray()) {
            
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                
                if (stack.isEmpty()) return false;
                char top = stack.pop();
                if ((c == ')' && top != '(') ||
                    (c == ']' && top != '[') ||
                    (c == '}' && top != '{')) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        
        System.out.println(isValid("()"));       
        System.out.println(isValid("()[]{}"));  
        System.out.println(isValid("(]"));      
        System.out.println(isValid("([])"));    
    }
}
