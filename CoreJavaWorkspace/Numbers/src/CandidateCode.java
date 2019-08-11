import java.awt.List;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class CandidateCode {
	
	public static void main(String args[] ) throws Exception {

		Scanner scanner = new Scanner(Paths.get("D://abc.txt"));
		int NumberOfRecords,CountOfRecords,temp;
		String data[];
		int intdata[];
		
		ArrayList<String> lines=new ArrayList<String>();

        while(scanner.hasNextLine())
         {
        	lines.add(scanner.nextLine());
         }
        for(String s:lines){
        	System.out.println(s);
        }
        if(lines.size()>0) {
        	NumberOfRecords=Integer.parseInt(lines.get(0));
        	if(NumberOfRecords != (lines.size()-1)/2) {
        		System.out.print("Number of lines as Input dont match as count number to process data");
        	}
        for(int i=1;i <= NumberOfRecords;i++) {
        	
        	System.out.println("Processing Record sets");
        	CountOfRecords=Integer.parseInt(lines.get(i*2-1));
        	data=lines.get(i*2).split("\\s+");
        	if(CountOfRecords != data.length) {
        		System.out.print("Ticket count does not match number of tickets passed to be processed");
        	}
        	intdata=new int[CountOfRecords];
        	for(int j=0;j<CountOfRecords;j++) {
        		intdata[j]=Integer.parseInt(data[j]);
        	}
        	
        	for(int k=CountOfRecords-1;k>=0;k--) {
        		System.out.print(intdata[k]);
        	if(k-2 >= 0) {
        		if(intdata[k] >= (intdata[k] + intdata[k-2])) {
        			temp=intdata[k];
        		}else {
        			
        		}
        	}
        	}
        	
        	
        	
        }
        }
  }

}
