import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;

/**
 * @author chaplind
 */
public class HashWordCounter
{	
	public static void main(String[] args)
	{
		new HashWordCounter("test1.txt");
		new HashWordCounter("test2.txt");
		new HashWordCounter("test3.txt");
	}
	
	
	public HashWordCounter(String fileName)
	{
		HashTable<String,Integer> hashTable = new HashTable<String,Integer>();
		hashTable.contains("test");
		Scanner inputStream = null;
		int total = 0;
		int unique = 0;
		
		try{
			inputStream = new Scanner(new File(fileName));
		}catch (FileNotFoundException e) {
			System.out.println("Error opening file: "+fileName);
			System.exit(0);
		}
		
		System.out.println("Reading '"+fileName+"' ... ");
		while(inputStream.hasNextLine()){
			String line = inputStream.nextLine();
			line = line.toLowerCase();
			String[] words = line.trim().split("\\s+");
			
			for(int i=0;i<words.length;i++){
				char[] word = words[i].toCharArray();
				for(int j=0;j<word.length;j++){
					if(word[j]==','||word[j]=='.'||word[j]=='"'||word[j]=='~'||word[j]=='<'||
					word[j]=='('||word[j]==')'||word[j]=='!'||word[j]==':'||word[j]==';'||
					word[j]=='\\'||word[j]=='/'||word[j]=='['||word[j]==']'||word[j]=='>'||
					word[j]=='\n'||word[j]=='?'){
						word[j] = '\u0000';
					}
				}
				
				if(word.length>0){
					if(word[word.length-1]=='-'){ word[word.length-1] = '\u0000'; }
					if(word[0]=='-'){ word[0] = '\u0000'; }
				}
				
				words[i] = "";
				
				for(int j=0;j<word.length;j++){
					if(word[j]!='\u0000'){
						words[i] += word[j];
					}
				}
			}
			
			
			for(int i=0;i<words.length;i++){
				if(words[i]!=null&&words[i]!=""){
					if(hashTable.contains(words[i])){
						int oldValue = hashTable.getValue(words[i]);
						hashTable.setValue(words[i], oldValue+1);
					}else{
						hashTable.add(words[i],1);
						unique++;
					}
		
					total++;
				}
			}
		}
		
		inputStream.close();
		
		hashTable.display();
		
		System.out.println("Total Unique Words: "+unique);
		System.out.println("Total Word Count: "+total);
		
		System.out.println();
		System.out.println();
	}
}
