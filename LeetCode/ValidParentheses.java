import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
     ValidParentheses vd = new ValidParentheses();
     System.out.println(vd.isValid("(])"));
    }

//    public boolean isValid(String s) {
//
//        Stack<Character> stack = new Stack<>();
//        for(int i = 0; i < s.length(); i++){
//            Character ch = s.charAt(i);
//            if (ch == '(' || ch == '{' || ch == '[' || ch == ' '){
//                stack.push(ch);
//            } else {
//                if (stack.isEmpty()){
//                    return false;
//                }else if ((ch - stack.peek() == 1) || ch - stack.peek() == 2 || ch - stack.peek() == 0){
//                    stack.pop();
//                }else{
//                    return false;
//                }
//            }
//        }
//      return stack.isEmpty() ? true : false;
//    }



// better solution
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }
}
