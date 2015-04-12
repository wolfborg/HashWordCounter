import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;

/**
 * @author chaplind
 */
public class HashWordCounter
{
	private HashTable<String,Integer> hashTable;
	
	public static void main(String[] args)
	{
		String fileName = "test.txt";
		new HashWordCounter(fileName);
	}
	
	public HashWordCounter(String fileName)
	{
		hashTable = new HashTable<String,Integer>();
		Scanner inputStream = null;
		
		try{
			inputStream = new Scanner(new File(fileName));
		}catch (FileNotFoundException e) {
			System.out.println("Error opening file: "+fileName);
			System.exit(0);
		}
		
		while(inputStream.hasNextLine()){
			String line = inputStream.nextLine();
			line.toLowerCase();
			String[] words = line.split("\\s+");
			for(int i=0;i<words.length;i++){
				System.out.println(words[i]);
				hashTable.contains(words[i]);
			}
			
			/*for(int i=0;i<words.length;i++){
				if(words[i]!=null){
					System.out.println(words[i]);
					boolean test = hashTable.contains(words[i]);
					System.out.println(test);
					if(test){
						int oldValue = hashTable.getValue(words[i]);
						hashTable.setValue(words[i], oldValue+1);
					}else{
						hashTable.add(words[i],1);
					}
					System.out.println("done");
				}
			}*/
		}
		
		inputStream.close();
	}
}
