/*
*	Rahnuma Islam Nishat - January 17, 2018
*/
import java.util.Scanner;
import java.io.File;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;


public class Stock{

	public static int[] CalculateSpan(int[] p){
		int[] spanArr = new int[p.length];//array used for storing span values
		int max;//used to calculate span on any given day
		boolean lesserThan;
		Stack<Integer> spans = new Stack<>();//stack to store values to calculate span
		for(int index = 0;index < p.length;index++){//traverses n times
			lesserThan = false;//used to exit while loop when true
			while(!(spans.empty() || lesserThan)){//used to determine span of current day
				if(p[index] >= p[spans.peek()]){//increases span if todays value is greater than previous values
					spans.pop();
				}
				else{//exits loop if todays value is less than a previous value
					lesserThan = true;
				}
			}
			if(spans.empty()){//indicates maximum span
				max = -1;//-1 used for indexing purposes
			}
			else{//gives the span of the current day
				max = spans.peek();
			}
			spanArr[index] = index - max;//calculates today's span
			spans.push(index);//populates the span stack
		}
		return spanArr;//returns full span array
	}

	public static int[] readInput(Scanner s){
		Queue<Integer> q = new LinkedList<Integer>();
		int n=0;
		if(!s.hasNextInt()){
			return null;
		}
		int temp = s.nextInt();
		while(temp>=0){
			q.offer(temp);
			temp = s.nextInt();
			n++;
		}
		int[] inp = new int[q.size()];
		for(int i=0;i<n;i++){
			inp[i]= q.poll();
		}
		return inp;
	}
	public static void main(String[] args){
		Scanner s;
        Stock m = new Stock();
        if (args.length > 0){
        	try{
        		s = new Scanner(new File(args[0]));
        	} catch(java.io.FileNotFoundException e){
        		System.out.printf("Unable to open %s\n",args[0]);
        		return;
        	}
        	System.out.printf("Reading input values from %s.\n", args[0]);
        }else{
        	s = new Scanner(System.in);
        	System.out.printf("Enter a list of non-negative integers. Enter a negative value to end the list.\n");
        }

        int[] price = m.readInput(s);
        System.out.println("The stock prices are:");
        for(int i=0;i<price.length;i++){
        	System.out.print(price[i]+ (((i+1)==price.length)? ".": ", "));
        }

        if(price!=null){
        	int[] span = m.CalculateSpan(price);
        	if(span!=null){
        		System.out.println("The spans are:");
        		for(int i=0;i<span.length;i++){
        			System.out.print(span[i]+ (((i+1)==span.length)? ".": ", "));
        		}
        	}
        }
    }
}
