import java.util.*;
/*
Leetcode link
https://leetcode.com/problems/evaluate-reverse-polish-notation/description/
 */

/*
Python solution

class Solution:

    def evalRPN(self, tokens: List[str]) -> int:
        truncate = lambda a : int(a) if a>=0 else -1*int(-1*a)
        val_stack = []
        op1=lambda a,b: a+b
        op2 = lambda a,b: a-b
        op3= lambda a,b: a*b
        op4= lambda a,b:truncate(a/b)
        op_dict = {'+':op1, '-':op2, '*': op3, "/": op4}
        op_set = set(op_dict.keys())
        for t in tokens:
            if t in op_set:
                op = op_dict[t]
                b = val_stack.pop()
                a = val_stack.pop()
                v = op(a,b)
                val_stack.append(v)
            else:
                val_stack.append(int(t))
        return val_stack.pop()
 */
public class lv150_revpolish {
    public int evalRPN(String[] tokens) {
        Stack<Integer> int_stack = new Stack<Integer>();
        int a1 = 0;
        int a2 = 0;
        for(String token:tokens) {
           switch(token){
               case "+":
                   a2 = int_stack.pop();
                   a1 = int_stack.pop();
                   int_stack.push((int)a1+a2);
                   break;
               case "*":
                   a2 = int_stack.pop();
                   a1 = int_stack.pop();
                   int_stack.push((int)a1*a2);
                   break;

               case "/":
                   a2 = int_stack.pop();
                   a1 = int_stack.pop();
                   int_stack.push((int)a1/a2);
                   break;
               case "-":
                   a2 = int_stack.pop();
                   a1 = int_stack.pop();
                   int_stack.push((int) a1-a2);
                   break;
               default:
                   int_stack.push(Integer.parseInt(token));

           }
        }
        return int_stack.pop();
    }

    public static void main(String[] args){
        lv150_revpolish l = new lv150_revpolish();
        String[] tokens = {"2","1","+","3","*"};
        System.out.println(l.evalRPN(tokens));
    }

}
