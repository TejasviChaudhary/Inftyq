import java.util.*;
public class unbounded_knapsack 
{
    public void output(int value[], int weight[], int W)
    {
        int i;
        int t = value.length;
        System.out.println("Length: " + t);
        double ratio[] = new double[t];
        double max = 0.0;
        for(i=0;i<t;i++)
        {
            ratio[i] = value[i]/(double)weight[i];
        }
        for(i=0;i<t;++i)
        {
            for(int j=i+1;j<t;++j)
            {
                if(ratio[i]<ratio[j])
                {
                    double swap1 = ratio[i];
                    ratio[i] = ratio[j];
                    ratio[j] = swap1;

                    int swap2 = value[i];
                    value[i] = value[j];
                    value[j] = swap2;

                    int swap3 = weight[i];
                    weight[i] = weight[j];
                    weight[j] = swap3;

                }
            }   
        }

        double output_val = 0.0;
        int x = W/weight[0];
        int temp_W = 0;
        temp_W = temp_W + x*weight[0];
        output_val = output_val + x*value[0];
        int space = W - temp_W;
        output_val = output_val + (space/(double)weight[0])*value[0];

        System.out.println(output_val);
        System.out.println(x + " complete units of item 1 plus " + space + "/" + weight[0] + " units of item 1");        
    }
    
    public static void main(String[] args)
    {
        Scanner ob = new Scanner(System.in);
        System.out.print("Enter number of items: ");
        int n = ob.nextInt();
        System.out.println(" ");
        int v[] = new int[n];
        int w[] = new int[n];
        System.out.print("Enter target: ");
        System.out.println(" ");
        int W=ob.nextInt();
        for(int i=0;i<n;i++)
        {
            System.out.println("Enter value  " + (i+1) + ": ");
            v[i] = ob.nextInt();
            System.out.println("Enter weight " + (i+1) + ": ");
            w[i] = ob.nextInt();
        }

         
        unbounded_knapsack k = new unbounded_knapsack();
        k.output(v, w, W);
    }
}
