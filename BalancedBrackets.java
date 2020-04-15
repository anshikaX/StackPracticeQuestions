import java.util.Scanner;
public class BalancedBrackets
{
    static int topOfStack = -1;
    static int flag = 1;
    static char stack[];

    public void push(char ch)
    {
        topOfStack++;
        stack[topOfStack] = ch;
    }

    public void pop()
    {
        topOfStack--;
    }

    public void balancedBracket(String exp)
    {
        if (exp.length() == 0)
        {
            System.out.println("The expression is empty");
        } else
            {
            for (int i = 0; i < exp.length(); i++)
            {
                if (exp.charAt(i) == '{' || exp.charAt(i) == '[' || exp.charAt(i) == '(')
                {
                    push(exp.charAt(i));
                } else if ((exp.charAt(i) == '}' || exp.charAt(i) == ']' || exp.charAt(i) == ')') && topOfStack == -1)
                {
                    flag = 0;
                    break;

                } else if ((exp.charAt(i)== '}' && stack[topOfStack] == '{') || (exp.charAt(i)==')' && stack[topOfStack]=='(') || (exp.charAt(i)=='}' && stack[topOfStack]=='{'))
                {
                    pop();
                }
                else if(exp.charAt(i)!= ' ')
                {
                    flag = 0;
                    break;
                }
                else
                {
                    continue;
                }
            }
            if(flag==1 && topOfStack==-1)
            {
                System.out.println("Balanced Expression");
            }
            else
            {
                System.out.println("Unbalanced Expression");
            }
        }

    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        BalancedBrackets obj = new BalancedBrackets();
        System.out.println("Enter the expression");
        String exp = sc.nextLine();
        stack = new char[exp.length()];
        obj.balancedBracket(exp);


    }
}
