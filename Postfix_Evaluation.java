import java.util.Scanner;
public class Postfix_Evaluation
{
    static double[] stack;
    static int topOfStack=-1;

    public void push(double d)
    {
        topOfStack++;
        stack[topOfStack]=d;
    }

    public void pop()
    {
        topOfStack--;

    }

    public static double performOperation(double operand1 ,double operand2,char ch)
    {
        switch(ch)
        {
            case '+':
                return operand1+operand2;
            case '-':
                return operand2-operand1;
            case '*':
                return operand1*operand2;
            case '/':
                return operand2/operand1;
        }
        return 0;
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        Postfix_Evaluation obj = new Postfix_Evaluation();
        System.out.println("Enter the postfix expression");
        String postfix = sc.nextLine();
        stack= new double[postfix.length()];
        if(postfix.length()==0)
        {
            System.out.println("Empty expression");
        }
        else
        {
            for(int i=0;i<postfix.length();i++)
            {

                if(postfix.charAt(i)>=48 && postfix.charAt(i)<=57 )
                {
                    double temp=0;
                    while(postfix.charAt(i)!=' ')
                    {
                        temp=temp*10+(postfix.charAt(i)-48);
                        i++;
                    }
                    obj.push(temp);
                }
                else if(postfix.charAt(i)!=' ')
                {
                    Double operand1 =stack[topOfStack];
                    obj.pop();
                    Double operand2 = stack[topOfStack];
                    obj.pop();
                    Double result= obj.performOperation(operand1,operand2,postfix.charAt(i));
                    obj.push(result);
                }

            }
            System.out.println(stack[topOfStack]);

        }





    }
}
