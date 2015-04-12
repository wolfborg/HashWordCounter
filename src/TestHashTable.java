
public class TestHashTable
{
	public static void main(String[] args)
	{
		HashTable<String,Integer> test = new HashTable<String,Integer>();
		
		testIsEmpty(test,true);
		testGetSize(test,0);
		testAdd(test,"test",1);
		testIsEmpty(test,false);
		testGetSize(test,1);
		System.out.println(test.getValue("test"));
	}
	
	
	public static void testAdd(HashTableInterface<String,Integer> hashTable, String key, int value)
	{
		System.out.println("Testing add method:");
		
		System.out.print("Adding "+key+" with value "+value+" ... ");
		int result = hashTable.add(key, value);
		if(result==value){
			System.out.println("OK");
		}else{
			System.out.println("ERROR");
		}
		
		System.out.println();
	}
	
	public static void testRemove(HashTableInterface<String,Integer> hashTable, boolean correct)
	{
		System.out.println("Testing remove method:");
		System.out.print("Removing ...");
		System.out.println();
		System.out.println();
	}
	
	public static void testIsEmpty(HashTableInterface<String,Integer> hashTable, boolean correct)
	{
		System.out.print("Testing isEmpty method with ");
		if(correct){
			System.out.println("an empty hash table:");
		}else{
			System.out.println("a non-empty hash table:");
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
		System.out.println("Testing getSize method on a hash table length "+correct+":");
		
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
		System.out.println("Testing getValue method for the value of the "+key+" key:");
		
		System.out.print("getValue returns "+hashTable.getValue(key)+": ");
		if(hashTable.getValue(key)==correct){
			System.out.println("OK");
		}else{
			System.out.println("ERROR");
		}
		
		System.out.println();
	}
	
	public static void testGetHashIndes(HashTableInterface<String,Integer> hashTable, boolean correct)
	{
		
	}
	
	public static void testContains(HashTableInterface<String,Integer> hashTable, boolean correct)
	{
		
	}
}
