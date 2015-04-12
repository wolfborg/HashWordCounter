import java.util.LinkedList;
import java.util.List;


/**
 * @author chaplind
 */
@SuppressWarnings("unused")
public class HashTable<K,V> implements HashTableInterface<K,V>
{
	private class Node<S,T>
	{
		private S key;
		private T value;
		
		private Node(S searchKey, T dataValue)
		{
			key = searchKey;
			value = dataValue;
		}
		
		private S getKey()
		{
			return key;
		}
		
		private T getValue()
		{
			return value;
		}
		
		private void setValue(T newValue)
		{
			value = newValue;
		}
		
	}
	
	private class TableEntry<S,T>
	{
		private List<Node<S,T>> chain;
		
		private TableEntry(S searchKey, T startChainValue)
		{
			chain = new LinkedList<Node<S,T>>();
			chain.add(new Node<S,T>(searchKey,startChainValue));
		}
		
		private T getValue(S searchKey)
		{
			T result = null;
			
			int position = searchChain(searchKey);
			
			if(position!=-1){
				result = chain.get(position).getValue();
			}
			
			return result;
		}
		
		private void setValue(S searchKey, T newValue)
		{
			if(isIn(searchKey)){
				int position = searchChain(searchKey);
				chain.get(position).setValue(newValue);
			}
		}
		
		private int searchChain(S searchKey)
		{
			int result = -1;
			
			for(int i=0;i<chain.size();i++){
				if((chain.get(i).getKey()).equals(searchKey)){
					result = i;
				}
			}
			
			return result;
		}
		
		private boolean isIn(S searchKey)
		{
			if(searchChain(searchKey)!=-1){
				return true;
			}
			
			return false;
		}
	}
	
	
	private TableEntry<K,V>[] hashTable;
	private int numberOfEntries;
	private int locationsUsed;
	private static final int DEFAULT_SIZE = 101;
	private static final double MAX_LOAD_FACTOR = 0.5;
	
	public HashTable()
	{
		this(DEFAULT_SIZE);
	}
	
	@SuppressWarnings("unchecked")
	public HashTable(int tableSize)
	{
		int primeSize = getNextPrime(tableSize);
		hashTable = new TableEntry[primeSize];
		numberOfEntries = 0;
		locationsUsed = 0;
	}

	public int getNextPrime(int n)
	{
		int nextPrime = n;
		
		while(!isPrime(nextPrime)){
			nextPrime++;
		}
		
		return nextPrime;
	}
	
	public boolean isPrime(int n)
	{
		for(int i=2;2*i<n;i++){
			if(n%i==0){
				return false;
			}
		}
		
		return true;
	}

	public V add(K key, V value)
	{
		int index = getHashIndex(key);
		
		if(hashTable[index]==null){
			hashTable[index] = new TableEntry<K,V>(key,value);
			numberOfEntries++;
			locationsUsed++;
		}else{
			if(!hashTable[index].isIn(key)){
				hashTable[index].chain.add(new Node<K,V>(key,value));
				numberOfEntries++;
			}else{
				int position = hashTable[index].searchChain(key);
				hashTable[index].chain.get(position).setValue(value);
			}
		}
		
		return hashTable[index].getValue(key);
	}

	public V remove(K key)
	{
		V removedValue = null;
		
		int index = getHashIndex(key);
		int position = hashTable[index].searchChain(key);
		
		if(index != -1){
			removedValue = hashTable[index].chain.get(position).getValue();
			hashTable[index].chain.remove(position);
			numberOfEntries--;
		}
		
		return removedValue;
	}

	public V getValue(K key)
	{
		int index = getHashIndex(key);
		V result = hashTable[index].getValue(key);
		return result;
	}
	
	public void setValue(K key, V newValue)
	{
		int index = getHashIndex(key);
		hashTable[index].setValue(key, newValue);
	}

	public int getHashIndex(K key)
	{
		String s = key.toString();
		int index = s.hashCode() % hashTable.length;
		
		if(index<0){
			index += hashTable.length;
		}
		
		return index;
	}

	public boolean contains(K key)
	{
		if(key!=null){
			int index = getHashIndex(key);
			int result = hashTable[index].searchChain(key);
			
			if(result!=-1){
				return true;
			}
		}
		
		return false;
	}

	public boolean isEmpty()
	{
		if(numberOfEntries==0){
			return true;
		}
		
		return false;
	}

	public int getSize()
	{
		return numberOfEntries;
	}
	
	public void setSize(int newSize){
		numberOfEntries = newSize;
	}

	public void clear()
	{
		for(int i=0;i<hashTable.length;i++){
			if(isEmpty()){
				break;
			}else{
				hashTable[i] = null;
				numberOfEntries--;
			}
		}
	}
	
	public void display()
	{
		if(numberOfEntries>0){
			for(int i=0;i<hashTable.length;i++){
				if(hashTable[i]!=null){
					for(int j=0;j<hashTable[i].chain.size();j++){
						System.out.println(
						"Index: "+i+", "+
						"Key: '"+hashTable[i].chain.get(j).getKey()+"', "+
						"Value: "+hashTable[i].chain.get(j).getValue());
					}
				}
			}
		}else{
			System.out.println("Hash table is empty.");
		}
		
		System.out.println();
	}
}
