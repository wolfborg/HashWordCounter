import java.util.Iterator;


/**
 * @author chaplind
 */
@SuppressWarnings("unused")
public class HashTable<K,V> implements DictionaryInterface<K,V>
{
	private class TableEntry<S,T>
	{
		private S key;
		private T value;
		private boolean inTable;
		
		private TableEntry(S searchKey, T dataValue)
		{
			key = searchKey;
			value = dataValue;
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

	private int getNextPrime(int tableSize)
	{
		return 0;
	}

	public V add(K key, V value)
	{
		return null;
	}

	public V remove(K key, V value)
	{
		return null;
	}

	public V getValue(K key)
	{
		return null;
	}

	public boolean contains(K key)
	{
		return false;
	}

	public Iterator<V> getValueIterator()
	{
		return null;
	}

	public boolean isEmpty()
	{
		return false;
	}

	public int getSize()
	{
		return 0;
	}

	public void clear()
	{
		
	}
}
