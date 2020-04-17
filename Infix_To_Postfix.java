import java.util.Scanner;
public class Infix_To_Postfix
{
    static char[] stack;
    static int topOfStack = -1;

    public void push(char ch)
    {
        topOfStack++;
        stack[topOfStack] = ch;
    }

    public void pop()
    {
        topOfStack--;
    }

    public static int precedence(char ch)
    {
        switch (ch) {
            case '+':
                return 1;
            case '-':
                return 1;
            case '*':
                return 2;
            case '/':
                return 2;
            case '%':
                return 2;
        }
        return 0;
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        Infix_To_Postfix obj = new Infix_To_Postfix();
        System.out.println("Enter an infix expression");
        String infix = sc.nextLine();
        stack = new char[infix.length()];
        String postfix="";
        if(infix.length()==0)
        {
            System.out.println("Empty infix expression");
        }
        else
        {
            for(int i=0;i<infix.length();i++)
            {
                if((infix.charAt(i)=='+' || infix.charAt(i)=='-' || infix.charAt(i)=='*' || infix.charAt(i)=='/' || infix.charAt(i)=='%') && (topOfStack==-1))
                {
                    obj.push(infix.charAt(i));
                }
                else if(infix.charAt(i)=='(')
                {
                    obj.push(infix.charAt(i));
                }
                else if(infix.charAt(i)==')')
                {
                    while(stack[topOfStack]!='(')
                    {
                        postfix=postfix+stack[topOfStack];
                        obj.pop();
                    }
                    obj.pop();          // pop the opening bracket from the stack
                }
                else if(precedence(infix.charAt(i))!=0)
                {
                    if(precedence(infix.charAt(i))>precedence(stack[topOfStack]))
                    {
                        obj.push(infix.charAt(i));
                    }
                    else
                    {
                        while(topOfStack!=-1 && stack[topOfStack]!='(' && (precedence(infix.charAt(i))<= precedence(stack[topOfStack])))
                        {
                            postfix=postfix+stack[topOfStack];
                            obj.pop();
                        }
                        obj.push(infix.charAt(i));
                    }
                }
                else        //If it's not an operator but any operand.
                {
                    postfix=postfix+infix.charAt(i);
                }
            }

            for(int i=topOfStack;i>=0;i--)
            {
                postfix=postfix+stack[i];
            }
            System.out.println("The equivalent postfix expression is : "+postfix);
        }

    }
}

