
public class TestHashTable
{
	public static void main(String[] args)
	{
		HashTable<String,Integer> test = new HashTable<String,Integer>();
		
		test.display();
		testIsEmpty(test,true);
		testGetSize(test,0);
		
		testGetHashIndex(test,"test",86);
		
		testAdd(test,"test",1);
		testIsEmpty(test,false);
		testGetSize(test,1);
		testGetValue(test, "test", 1);
		testContains(test,"test",true);
		
		testRemove(test,"test");
		testIsEmpty(test,true);
		testGetSize(test,0);
		testContains(test,"test",false);
		
		testAdd(test,"cat",1);
		testAdd(test,"cat",2);
		testAdd(test,"aaw",1);
		testGetValue(test,"cat",2);
		testGetValue(test,"aaw",1);
		testGetSize(test,2);
		
		testRemove(test,"cat");
		testContains(test,"cat",false);
		testContains(test,"aaw",true);
		testGetSize(test,1);
		
		testAdd(test,"dragon",5);
		testAdd(test,"pixie",3);
		testAdd(test,"sam",1);
		testGetSize(test,4);
		
		test.display();
		
		testClear(test);
		testIsEmpty(test,true);
		testGetSize(test,0);
		
		test.display();
	}
	
	
	public static void testAdd(HashTableInterface<String,Integer> hashTable, String key, int value)
	{
		System.out.println("Testing add method: ");
		
		System.out.print("Adding "+key+" with value "+value+" ... ");
		int result = hashTable.add(key, value);
		if(result==value){
			System.out.println("OK");
		}else{
			System.out.println("ERROR");
		}
		
		System.out.println();
	}
	
	public static void testRemove(HashTableInterface<String,Integer> hashTable, String key)
	{
		System.out.println("Testing remove method: ");
		
		System.out.print("Removing '"+key+"' ... ");
		hashTable.remove(key);
		if(!hashTable.contains(key)){
			System.out.println("OK");
		}else{
			System.out.println("ERROR");
		}
		
		System.out.println();
	}
	
	public static void testIsEmpty(HashTableInterface<String,Integer> hashTable, boolean correct)
	{
		System.out.print("Testing isEmpty method with ");
		if(correct){
			System.out.println("an empty hash table: ");
		}else{
			System.out.println("a non-empty hash table: ");
		}
		
		System.out.print("isEmpty returns "+hashTable.isEmpty()+": ");
		if(hashTable.isEmpty()==correct){
			System.out.println("OK");
		}else{
			System.out.println("ERROR");
		}
		
		System.out.println();
	}
	
	
	public static void testGetSize(HashTableInterface<String,Integer> hashTable, int correct)
	{
		System.out.println("Testing getSize method on a hash table length "+correct+": ");
		
		System.out.print("getSize returns "+hashTable.getSize()+": ");
		if(hashTable.getSize()==correct){
			System.out.println("OK");
		}else{
			System.out.println("ERROR");
		}
		
		System.out.println();
	}
	
	public static void testGetValue(HashTableInterface<String,Integer> hashTable, String key, int correct)
	{
		System.out.println("Testing getValue method for the value of the '"+key+"' key:");
		
		System.out.print("getValue returns "+hashTable.getValue(key)+": ");
		if(hashTable.getValue(key)==correct){
			System.out.println("OK");
		}else{
			System.out.println("ERROR");
		}
		
		System.out.println();
	}
	
	public static void testGetHashIndex(HashTableInterface<String,Integer> hashTable, String key, int correct)
	{
		System.out.println("Testing getHashIndex method with '"+key+"' key: ");
		
		int result = hashTable.getHashIndex(key);
		System.out.print("getHashIndex returns "+result+": ");
		if(result==correct){
			System.out.println("OK");
		}else{
			System.out.println("ERROR");
		}
		
		System.out.println();
	}
	
	public static void testContains(HashTableInterface<String,Integer> hashTable, String key, boolean correct)
	{
		System.out.println("Testing contains method for the '"+key+"' key:");
		
		boolean result = hashTable.contains(key);
		
		System.out.print("contains returns "+result+": ");
		if(result==correct){
			System.out.println("OK");
		}else{
			System.out.println("ERROR");
		}
		
		System.out.println();
	}
	
	public static void testClear(HashTableInterface<String,Integer> hashTable)
	{
		System.out.println("Testing clear method: ");
		
		System.out.print("Clearing ... ");
		hashTable.clear();
		if(hashTable.isEmpty()){
			System.out.println("OK");
		}else{
			System.out.println("ERROR");
		}
		
		System.out.println();
	}
}
