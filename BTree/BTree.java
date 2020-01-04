import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;

public class BTree<B>{

	private TreeNode<B> root;
	private long rootOffset;
	private int count;
	private int frequency;
	private static int degree;
	private int height;
	private int capacity;
	private int seqLength;
	private TreeNode<B> lastSearchedNode;
	private File dump;
	private int debugLevel;
	private static int m;
	private static RandomAccessFile RAF;//File that stores the actual B-Tree.
	
	//Still need a constructor for BTree, create isn't the constructor, it's just supposed to create the file when the BTree is filled.
	@SuppressWarnings("unused")
	public BTree(String fileName, int degree, int seqLength)
	{
		//Still need to instantiate storage array here, should be 'about' the size of capacity
		this.degree = degree;
		this.seqLength = seqLength;
		//int number = (int) Math.pow(4, seqLength); //removed cast of seqLength to double
		//frequency = new int[number];
		if (degree != 0)
		{
			capacity = (2 * degree) - 1;
			m = 2 * degree;
		}
		else
		{
			m = 204; // 16 + 8*m + (m-1)*12 = 4096, m = 204.8, we want the floor value of it, thus 204
			capacity = m - 1;
			degree = m/2;
		}
		root = new TreeNode<B>(degree);
		for(TreeObject<B> key: root.getKeys())
		{
			TreeObject<B> placeHolder = new TreeObject<B>(-1L);
			key = placeHolder;
		}
		for(long child: root.getChildren())
		{
			child = -1L;
		}
		root.setOffSet(-1L);
		rootOffset = 24L;
		count = 0;
		height = 0;
		try {
			RAF = new RandomAccessFile(fileName + ".btree.data." + seqLength + "." + degree, "rw");
		} catch (FileNotFoundException e) {
			System.out.println("Error: File not found.");
		}
		lastSearchedNode=null;
		debugLevel = 0;
	}
	
	@SuppressWarnings("unused")
	public BTree(String fileName, int degree, int seqLength, int debugLevel)
	{
		//Still need to instantiate storage array here, should be 'about' the size of capacity
		this.degree = degree;
		this.seqLength = seqLength;
		if (degree != 0)
		{
			capacity = (2 * degree) - 1;
			m = 2 * degree;
		}
		else
		{
			m = 204; // 16 + 8*m + (m-1)*12 = 4096, m = 204.8, we want the floor value of it, thus 204
			capacity = m - 1;
			degree = m/2;
		}
		root = new TreeNode<B>(degree);
		for(TreeObject<B> key: root.getKeys())
		{
			TreeObject<B> placeHolder = new TreeObject<B>(-1L);
			key = placeHolder;
		}
		for(long child: root.getChildren())
		{
			child = -1L;
		}
		root.setOffSet(-1L);
		rootOffset = 24L;
		count = 0;
		height = 0;
	
		try {
			RAF = new RandomAccessFile(fileName + ".btree.data." + seqLength + "." + degree, "rw");
		} catch (FileNotFoundException e) {
			System.out.println("Error: File not found.");
		}
		lastSearchedNode=null;
		this.debugLevel = debugLevel;
		if(debugLevel == 1)
			dump = new File("dump.txt");
	}
	
	@SuppressWarnings("unused")
	public BTree(String fileName, int degree, int seqLength, boolean flag)
	{
		//Still need to instantiate storage array here, should be 'about' the size of capacity
		this.degree = degree;
		this.seqLength = seqLength;
		if (degree != 0)
		{
			capacity = (2 * degree) - 1;
			m = 2 * degree;
		}
		else
		{
			m = 204; // 16 + 8*m + (m-1)*12 = 4096, m = 204.8, we want the floor value of it, thus 204
			capacity = m - 1;
			degree = m/2;
		}
		root = new TreeNode<B>(degree);
		for(TreeObject<B> key: root.getKeys())
		{
			TreeObject<B> placeHolder = new TreeObject<B>(-1L);
			key = placeHolder;
		}
		for(long child: root.getChildren())
		{
			child = -1L;
		}
		root.setOffSet(-1L);
		rootOffset = 24L;
		count = 0;
		height = 0;
		try {
			RAF = new RandomAccessFile(fileName, "rw");
		} catch (FileNotFoundException e) {
			System.out.println("Error: File not found.");
		}
		lastSearchedNode=null;
		this.debugLevel = debugLevel;
		if(debugLevel == 1)
			dump = new File("dump.txt");
	}
	
	public RandomAccessFile create() 
	{
		try {
		//Write metadata for entire B-Tree at beginning of the binary file
		RAF.seek(0);
		RAF.writeInt(degree);//1st int is the degree
		RAF.writeInt(seqLength);//2nd int is the sequenceLength
		RAF.writeInt(count);//3rd int is the number of nodes in the tree
		RAF.writeInt(16 + (m*8) + (capacity * 12)); //# of bytes for a node's meta data, keys, and children
		RAF.writeLong(-1);// LONG offset to the root node
			
		//Root Node
		root.setLeaf(1);
		//diskWrite(root); //We won't write until the very end, root will be last node in file, root is always held in memory.
		}catch ( IOException e) {
			System.out.println(" There was problem opening or closing the file.");
		}
		
		return RAF;
		
	}
	
	public void diskWrite(TreeNode<B> node) 
	{
		try {
		//Metadata for the node to be written
		if(node.getOffSet() == -1)
		{
			RAF.seek(rootOffset);
		}
		else
		{
			RAF.seek(node.getOffSet());
		}
		RAF.writeLong(node.getOffSet());//Current offset to new Node to be written to
		RAF.writeInt(node.getLeaf());//2nd int is whether or not it is a leaf
		RAF.writeInt(node.getCount());//3rd int is the amount of keys
		//Actual data for the node
		for(TreeObject<B> key : node.getKeys())
		{
			if(key == null)
				RAF.writeLong(-1L);
			else
			{
				RAF.writeLong(key.getKey());
				 			}
		}
		for(TreeObject<B> frequency : node.getKeys())
		{
			if( frequency== null)
				RAF.writeInt(-1);// this would be for the frequency connected to a specific key

			else
			{
				
				RAF.writeInt(frequency.getFrequency()); // this would be for the frequency connected to a specific key
			}
		}
		
		//Children of the node
		for(long childOffSet : node.getChildren())
		{
			if(childOffSet == 0)
				RAF.writeLong(-1L);
			else
			{
				RAF.writeLong(childOffSet);
			}
		}
		}catch ( IOException e) {
			System.out.println(" There was problem opening or closing the file.");
		}
	}
	
	public static TreeNode diskRead(long offset) 
	
	{
		TreeNode readOne = new TreeNode(degree);
		try {
		RAF.seek(offset);
		readOne.setOffSet(RAF.readLong());
		readOne.setLeaf(RAF.readInt());
		readOne.setCount(RAF.readInt());
		int i=0;
		while(i<=m-2) {
			long key = RAF.readLong();
			if(!(key == -1L)) {
				TreeObject temp = new TreeObject(key);
				readOne.setKeys(i, temp);
			}
			i++;
		}
		i=0;
		while(i<=m-2) {
			int frequency = RAF.readInt();
			if(!(frequency == -1L)) {
				//TreeObject<B> temp = new TreeObject<B>(key);
				readOne.getKeys()[i].setFrequency(frequency); // WAS [i] before
			}
			i++;
		}
		i=0;
		while(i<=m-1) {
			long off = RAF.readLong();
			if(!(off  == -1L)) {
				
				readOne.setChildren(i, off );
			}
			i++;
		
		}
		}catch ( IOException e) {
			System.out.println(" There was problem opening or closing the file.");
		}
		
		return readOne;
		
	}
	
	public void insert(TreeObject<B> newValue)
	{
		try {    
			TreeObject<B>  temper = search(root, newValue);
			if(!(null==temper)) {
				for(int i = 0; i<m-1; i++) {
					if(lastSearchedNode.getKeys()[i].equals(temper)) {
						lastSearchedNode.getKeys()[i].incrementFreq();
						break;
					}
					
					
				}
				diskWrite(lastSearchedNode);
				return;
			}
		TreeNode<B> r = this.root;
			if(r.getCount() == m - 1)
			{
				long temp = rootOffset;
				TreeNode<B> s = new TreeNode<B>(degree);
				this.root = s;
				s.setLeaf(0);
				s.setCount(0);
				RAF.seek(RAF.length());
				r.setOffSet(rootOffset);
				rootOffset = RAF.getFilePointer();
				s.setOffSet(-1); //S will become the new root, so its offset will be -1
				s.setChildren(0, temp);
				splitChild(s, 1, r);
				insertNonFull(s, newValue.getKey());
			}
			else
				insertNonFull(r, newValue.getKey());
			}catch ( IOException e) {
				System.out.println(" There was problem opening or closing the file.");
			}
		
			count++;
		}
	
	public void splitChild(TreeNode<B> x, int i, TreeNode<B> y) 
	{
		TreeNode<B> z = new TreeNode<B>(degree);
		z.setLeaf(y.getLeaf());
		z.setCount(degree - 1);
			try {
				RAF.seek(RAF.length());
				//Gets the offset where it will be after being written
				z.setOffSet(RAF.getFilePointer() + 16L + ((long) m * 8L) + ( (long) capacity * 12L));
			} catch (IOException e) {
				System.out.println(" There was problem opening or closing the file.");
			}
		
		for(int j = 1; j <= degree - 1; j++)
		{
			z.setKeys(j - 1, y.getKeys()[j - 1 + degree]);
			z.getKeys()[j - 1].setFrequency(y.getKeys()[j - 1 + degree].getFrequency());
		}
		if(y.getLeaf() == 0)
		{
			for(int j = 1; j <= degree; j++)
			{
				z.setChildren(j - 1, y.getChildren()[j - 1 + degree]);
			}
		}
		y.setCount(degree - 1);
		
		////Page Break////
		
		for(int j = x.getCount() + 1; j >= i + 1; j--)
		{
			x.setChildren(j -1 + 1, x.getChildren()[j - 1]);
			
		}
		x.setChildren(i - 1 + 1, z.getOffSet());//Going to have to set offset for Z in the first place
		for(int j = x.getCount(); j > i - 1; j--)
		{
			x.setKeys(j + 1 - 1, x.getKeys()[j - 1]);
			x.getKeys()[j - 1].setFrequency(x.getKeys()[j + 1 - 1].getFrequency());
		}
		x.setKeys(i - 1, y.getKeys()[degree - 1]);
		x.getKeys()[i - 1].setFrequency(y.getKeys()[degree - 1].getFrequency());
		
		for(int j = y.getCount(); j < m-1; j++)
		{
			y.setKeys(j, null);
			y.setChildren(j + 1, 0);
		}
		
		x.incCount();
		diskWrite(y);
		diskWrite(z);
		diskWrite(x);
	}
	
	public void insertNonFull(TreeNode<B> nodeX, long key) 
	{
		int i = nodeX.getCount();
		if(nodeX.getLeaf() == 1) { //Is it a leaf
			while (i>=1 && key < nodeX.getKeys()[i - 1].getKey()) {
				nodeX.setKeys(i + 1 - 1, nodeX.getKeys()[i-1] );
				nodeX.getKeys()[i + 1 - 1].setFrequency(nodeX.getKeys()[i - 1].getFrequency());
				i--;
			}
			nodeX.getKeys()[i + 1 - 1]= new TreeObject<B>(key);
			nodeX.getKeys()[i + 1 - 1].setFrequency(1);
			nodeX.incCount();
			diskWrite(nodeX);
		}
		
		//Page Break///
		
			else {
				while (i >= 1 && key < nodeX.getKeys()[i - 1].getKey()) {
					i--;
				}
				i++;
				TreeNode<B> child = diskRead(nodeX.getChildren()[i - 1]);
				if(child.getCount() == m - 1) {
					splitChild(nodeX, i, diskRead(nodeX.getChildren()[i - 1]));
					if(key > nodeX.getKeys()[i - 1].getKey()) {
						i++;
					}
				}
				insertNonFull(diskRead(nodeX.getChildren()[i - 1]),key);
			
		}
	}
	
	public TreeObject<B> search(TreeNode<B> start, TreeObject<B> value)
	{
		int i=1;
		
		while (i<=start.getCount() && value.getKey() > start.getKeys()[i - 1].getKey()) {
			i++;
		}
		if(i <= start.getCount() && value.getKey() == start.getKeys()[i - 1].getKey()) {
			lastSearchedNode=start;
			return start.getKeys()[i - 1];
		}
		if(start.getLeaf() == 1) { //If its a leaf
			lastSearchedNode=null;
			return null; 
		}
		if(start.getChildren()[i - 1] != 0L) {
			start = diskRead(start.getChildren()[i - 1]);
			return search(start, value);
		}
		else
		{
			return null;
		}
		
	}
	
	public TreeObject<B> delete(TreeNode<B> start, TreeObject<B> value) 
	{
		TreeNode<B> y = new TreeNode<B>(degree);
		TreeNode<B> z = new TreeNode<B>(degree);
		TreeObject<B> temp = value;
		if(!(null==start)){
			
			if(start.getLeaf() == 0)
			{
				y=start;
				z= start;

				if(y.getCount()>degree-1) {
					TreeObject<B> temper = y.getKeys()[0];
					 moveKey(y, temper, start) ;
					 
				}
				else if(z.getCount()>degree-1) {
					TreeObject<B> temper = z.getKeys()[0];
					 moveKey(z, temper, start) ;
				}
				else {
					MergesNodes(y,z);
					RemoveChild(start, z);
					
					if(start.getOffSet()==-1L) {
						makeRoot(y);
					}
					
				}
			}else {
				TreeNode<B> child = new TreeNode<B>(degree);
				if(child.getCount()>degree-1) {
					TreeNode<B> lsibling= child;
					TreeNode<B> rsibling= child;
					if(lsibling.getCount()>degree-1) {
						TreeObject<B> temper = z.getKeys()[0];
						 moveKey(z, temper, start) ;
					}else if(rsibling.getCount()>degree-1) {
						TreeObject<B> temper = y.getKeys()[0];
						 moveKey(y, temper, start) ;
					}else {
						MergesNodes(child,z);
						RemoveChild(start, z);
						
						if(start.getOffSet()==-1L) {
							makeRoot(child);
						}
					}
					

				}
				
			}
			
		}
		return temp; 
		
	}
	 private void makeRoot(TreeNode<B> child) {
		 TreeNode<B> rooter= child;
		 rooter.getCount();
	 }
	private void RemoveChild(TreeNode<B> z , TreeNode<B> y) {
		z=null;
		y.getCount();
	}
	private void MergesNodes( TreeNode<B> y , TreeNode<B> x) {
		int j=0;
		y.getKeys()[j+1]=y.getKeys()[j];
		x.getKeys()[j+1]=x.getKeys()[j];
		j++;
	}
	
	private void moveKey(TreeNode<B> y,TreeObject<B> temper,TreeNode<B> x) {
		int i=0;
		y.getKeys()[i+1]=y.getKeys()[i];
		x.getKeys()[i+1]=x.getKeys()[i];
		i++;
	}
	

	public File debug() {
		String info = inOrder(root);
		try {
			PrintWriter writer = new PrintWriter(dump);
			writer.println(info);
			writer.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error writing to dump file.");
		}
		return dump;
	}
	
	public String inOrder(TreeNode<B> node)
	{
		String result = "";
		if(node != null) {
			for(int i = 0; i < m; i++)
			{
				if(node.getChildren()[i] != 0)
				{
					TreeNode temp = diskRead(node.getChildren()[i]);
					result += inOrder(diskRead(node.getChildren()[i]));
					if(i < node.getCount())
					{
						result += node.getKeys()[i].getFrequency() + " " + translator(node.getKeys()[i].getKey()) + "\n";
					}
				}
				else if(i < m - 1)
				{
					if(node.getKeys()[i] != null)
						result += node.getKeys()[i].getFrequency() + " " + translator(node.getKeys()[i].getKey()) + "\n";
				}
			}
		}
		return result;
	}
	
	
	private String translator(long key) {
		String d = Long.toBinaryString(key);
		 int seqLength= this.seqLength;
		 String r = "";
		 String zero = "0";
		 int j=d.length();
		 if(d.length()<(seqLength*2)) {
			while(j<(seqLength*2)) {
				j++;
				r+=zero;
			}
		 }
			r+=d;
			String num= "";
			for (int i=0; i<seqLength*2; i++) {
			switch (r.substring(i,i+2)) {
			case "00":
				num += "a";
				i++;
				break;
			case "01":
				num += "c";
				i++;
				break;
			case "10":
				num += "g";
				i++;
				break;
			case "11":
				num += "t";
				i++;
				break;
		}
			}
	return num;
	}
	
	public TreeNode<B> getRoot(){
		return this.root;
	}
	
	public void setRoot(TreeNode<B> r) {
		this.root = r;
	}
	
	public boolean isEmpty() {
		return (this.count == 0);
	}
	
	public int getSize() {
		return this.count;
	}
	
	public void incSize() {
		count = (count + 1);
	}
	
	public int getHeight() {
		//Need to do some calculations here to get exact height of tree
			//Recursively or iteratively?
		return this.height;
	}
	
	public int getDegree() {
		return this.degree;
	}
	
	public void setDegree(int i) {
		this.degree = i;
	}
	
	public int getCapacity() {
		return this.capacity;
	}
	
	public void setCapacity(int i) {
		this.capacity = i;
	}
	
	public int getSeqLength() {
		return this.seqLength;
	}
	
	public void setSeqLength(int i) {
		this.seqLength = i;
	}
	
	public RandomAccessFile getRAF() {
		return this.RAF;
	}
	
	public long getRootOffset()
	{
		return rootOffset;
	}
	
	
	@Override
	public boolean equals(Object a1){
		//Still trying to figure out what object would be a good way to override this method
		return false;
	}
}
