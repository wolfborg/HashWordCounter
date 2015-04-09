import java.util.List;


/**
 * @author chaplind
 */
@SuppressWarnings("unused")
public class HashTable<K,V> implements HashTableInterface<K,V>
{
	private class TableEntry<S,T>
	{
		private S key;
		private T value;
		private boolean inTable;
		private List<T> chain;
		
		private TableEntry(S searchKey, T dataValue)
		{
			key = searchKey;
			chain.add(dataValue);
			inTable = true;
		}
		
		private S getKey()
		{
			return key;
		}
		
		private T getValue()
		{
			return value;
		}
		
		private void setValue(T newDataValue)
		{
			value = newDataValue;
		}
		
		private boolean isIn()
		{
			return inTable;
		}
		
		private boolean isRemoved()
		{
			if(!isIn()){
				return true;
			}
			
			return false;
		}
		
		private void setToIn()
		{
			inTable = true;
		}
		
		private void setToRemoved()
		{
			inTable = false;
		}
	}
	
	
	private TableEntry<K,V>[] hashTable;
	private int numberOfEntries;
	private int locationsUsed;
	private static final int DEFAULT_SIZE = 101;
	private static final double MAX_LOAD_FACTOR = 0.5;
	
	private int locate(int index, K key)
	{
		int result = -1;
		boolean found = false;
		
		while(!found && (hashTable[index] != null))
		{
			if(hashTable[index].isIn() && key.equals(hashTable[index].getKey())){
				found = true;
			}else{
				index = (index+1)%hashTable.length;
			}
		}
		
		if(found){
			result = index;
		}
		
		return result;
	}
	
	
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
		V oldValue;
		
		if(isFull()){
			rehash();
		}
		
		int index = getHashIndex(key);
		index = probe(index,key);
		
		if((hashTable[index]==null)||(hashTable[index].isRemoved())){
			hashTable[index] = new TableEntry<K,V>(key,value);
			numberOfEntries++;
			locationsUsed++;
			oldValue = null;
		}else{
			oldValue = hashTable[index].getValue();
			hashTable[index].setValue(value);
		}
		
		return oldValue;
	}

	private int probe(int index, K key)
	{
		int removedStateIndex = -1;
		boolean found = false;
		
		while(!found && (hashTable[index]!=null)){
			if(hashTable[index].isIn()){
				if(key.equals(hashTable[index].getKey())){
					found = true;
				}else{
					index = (index+1)%hashTable.length;
				}
			}else{
				if(removedStateIndex == -1){
					removedStateIndex = index;
				}
				
				index = (index+1)%hashTable.length;
			}
		}
		
		if(found||(removedStateIndex == -1)){
			return index;
		}else{
			return removedStateIndex;
		}
	}

	private boolean isFull()
	{
		if(hashTable.length==numberOfEntries){
			return true;
		}
		
		return false;
	}

	@SuppressWarnings("unchecked")
	private void rehash()
	{
		TableEntry<K,V>[] oldTable = hashTable;
		
		int oldSize = oldTable.length;
		int newSize = getNextPrime(oldSize*2);
		
		hashTable = new TableEntry[newSize];
		numberOfEntries = 0;
		locationsUsed = 0;
		
		for(int i=0;i<oldSize;i++){
			if((oldTable[i]!=null)&&(oldTable[i].isIn())){
				add(oldTable[i].getKey(), oldTable[i].getValue());
			}
		}
	}

	public V remove(K key)
	{
		V removedValue = null;
		
		int index = getHashIndex(key);
		index = locate(index,key);
		
		if(index != -1){
			removedValue = hashTable[index].getValue();
			hashTable[index].setToRemoved();
			numberOfEntries--;
		}
		
		return removedValue;
	}

	public V getValue(K key)
	{
		V result = null;
		
		int index = getHashIndex(key);
		index = locate(index,key);
		
		if(index != -1){
			result = hashTable[index].getValue();
		}
		
		return result;
	}

	public int getHashIndex(K key)
	{
		String s = key.toString();
		return s.hashCode() % hashTable.length;
	}

	public boolean contains(K key)
	{
		int index = getHashIndex(key);
		
		
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

	public void clear()
	{
		int index = 0;
		while(!isEmpty()){
			remove(hashTable[index].getKey());
			index++;
		}
	}
}
