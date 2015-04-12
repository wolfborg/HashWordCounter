
/**
 * @author chaplind
 */
public interface HashTableInterface<K,V>
{
	public V add(K key, V value);
	public V remove(K key);
	public V getValue(K key);
	public boolean contains(K key);
	public boolean isEmpty();
	public int getHashIndex(K key);
	public int getSize();
	public void clear();
}
