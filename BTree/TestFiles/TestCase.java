import org.testng.Assert;

import java.io.File;
import java.io.RandomAccessFile;

/**
 * TestCase class for testing B-Tree implementation.
 * 
 * @author Cole Gilmore
 *
 */
@SuppressWarnings("unchecked")
public class TestCase {
	//TreeObjects with Character values, used in BTree tests
	public static final TreeObject<Character> A = new TreeObject<Character>(00);
	public static final TreeObject<Character> a = new TreeObject<Character>(00);
	public static final TreeObject<Character> C = new TreeObject<Character>(01);
	public static final TreeObject<Character> c = new TreeObject<Character>(01);
	public static final TreeObject<Character> G = new TreeObject<Character>(10);
	public static final TreeObject<Character> g = new TreeObject<Character>(10);
	public static final TreeObject<Character> T = new TreeObject<Character>(11);
	public static final TreeObject<Character> t = new TreeObject<Character>(11);
	
	//TreeObjects with String values, used in BTree tests
		//Sub-sequence == 2
	public static final TreeObject<String> AT = new TreeObject<String>(0011);
	public static final TreeObject<String> at = new TreeObject<String>(0011);
	public static final TreeObject<String> AG = new TreeObject<String>(0010);
	public static final TreeObject<String> ag = new TreeObject<String>(0010);
	public static final TreeObject<String> AC = new TreeObject<String>(0001);
	public static final TreeObject<String> ac = new TreeObject<String>(0001);
	public static final TreeObject<String> AA = new TreeObject<String>(0000);
	public static final TreeObject<String> aa = new TreeObject<String>(0000);
	
		//Sub-sequence == 3
		//AAA
	public static final TreeObject<String> AAA = new TreeObject<String>(000000);
	public static final TreeObject<String> aaa = new TreeObject<String>(000000);
	
		//ATT
	public static final TreeObject<String> ATT = new TreeObject<String>(001111);
	public static final TreeObject<String> att = new TreeObject<String>(001111);
	
		//ACC
	public static final TreeObject<String> ACC = new TreeObject<String>(000101);
	public static final TreeObject<String> acc = new TreeObject<String>(000101);
	
		//AGG
	public static final TreeObject<String> AGG = new TreeObject<String>(001010);
	public static final TreeObject<String> agg = new TreeObject<String>(001010);
	
		//AAT
	public static final TreeObject<String> AAT = new TreeObject<String>(000011);
	public static final TreeObject<String> aat = new TreeObject<String>(000011);
	
		//ATA
	public static final TreeObject<String> ATA = new TreeObject<String>(001100);
	public static final TreeObject<String> ata = new TreeObject<String>(001100);
	
		//AAC
	public static final TreeObject<String> AAC = new TreeObject<String>(000001);
	public static final TreeObject<String> aac = new TreeObject<String>(000001);
	
		//ACA
	public static final TreeObject<String> ACA = new TreeObject<String>(000100);
	public static final TreeObject<String> aca = new TreeObject<String>(000100);
	
		//AAG
	public static final TreeObject<String> AAG = new TreeObject<String>(000010);
	public static final TreeObject<String> aag = new TreeObject<String>(000010);
	
		//AGA
	public static final TreeObject<String> AGA = new TreeObject<String>(001000);
	public static final TreeObject<String> aga = new TreeObject<String>(001000);
	
		//Sub-sequence == 4
		//AAAA
	public static final TreeObject<String> AAAA = new TreeObject<String>(00000000);
	public static final TreeObject<String> aaaa = new TreeObject<String>(00000000);

		//AAAT
	public static final TreeObject<String> AAAT = new TreeObject<String>(00000011);
	public static final TreeObject<String> aaat = new TreeObject<String>(00000011);
	
		//AAAC
	public static final TreeObject<String> AAAC = new TreeObject<String>(00000001);
	public static final TreeObject<String> aaac = new TreeObject<String>(00000001);
	
		//AAAG
	public static final TreeObject<String> AAAG = new TreeObject<String>(00000010);
	public static final TreeObject<String> aaag = new TreeObject<String>(00000010);
	
		//AATT
	public static final TreeObject<String> AATT = new TreeObject<String>(00001111);
	public static final TreeObject<String> aatt = new TreeObject<String>(00001111);
	
		//ATAT
	public static final TreeObject<String> ATAT = new TreeObject<String>(00110011);
	public static final TreeObject<String> atat = new TreeObject<String>(00110011);
	
		//ATTA
	public static final TreeObject<String> ATTA = new TreeObject<String>(00111100);
	public static final TreeObject<String> atta = new TreeObject<String>(00111100);
	
		//ATTT
	public static final TreeObject<String> ATTT = new TreeObject<String>(00111111);
	public static final TreeObject<String> attt = new TreeObject<String>(00111111);
	
		//AACC
	public static final TreeObject<String> AACC = new TreeObject<String>(00000101);
	public static final TreeObject<String> aacc = new TreeObject<String>(00000101);
	
		//ACAC
	public static final TreeObject<String> ACAC = new TreeObject<String>(00010001);
	public static final TreeObject<String> acac = new TreeObject<String>(00010001);
	
		//ACCA
	public static final TreeObject<String> ACCA = new TreeObject<String>(00010100);
	public static final TreeObject<String> acca = new TreeObject<String>(00010100);
	
		//ACCC
	public static final TreeObject<String> ACCC = new TreeObject<String>(00010101);
	public static final TreeObject<String> accc = new TreeObject<String>(00010101);
	
		//AAGG
	public static final TreeObject<String> AAGG = new TreeObject<String>(00001010);
	public static final TreeObject<String> aagg = new TreeObject<String>(00001010);
	
		//AGAG
	public static final TreeObject<String> AGAG = new TreeObject<String>(00100010);
	public static final TreeObject<String> agag = new TreeObject<String>(00100010);

		//AGGA
	public static final TreeObject<String> AGGA = new TreeObject<String>(00101000);
	public static final TreeObject<String> agga = new TreeObject<String>(00101000);
	
		//AGGG
	public static final TreeObject<String> AGGG = new TreeObject<String>(00101010);
	public static final TreeObject<String> aggg = new TreeObject<String>(00101010);
	
	
		//Sub-sequence == 2
	public static final TreeObject<String> CG = new TreeObject<String>(0110);
	public static final TreeObject<String> cg = new TreeObject<String>(0110);
	public static final TreeObject<String> CT = new TreeObject<String>(0111);
	public static final TreeObject<String> ct = new TreeObject<String>(0111);
	public static final TreeObject<String> CA = new TreeObject<String>(0100);
	public static final TreeObject<String> ca = new TreeObject<String>(0100);
	public static final TreeObject<String> CC = new TreeObject<String>(0101);
	public static final TreeObject<String> cc = new TreeObject<String>(0101);
	
		//Sub-sequence == 3
		//CCC
	public static final TreeObject<String> CCC = new TreeObject<String>(010101);
	public static final TreeObject<String> ccc = new TreeObject<String>(010101);
	
		//CCA
	public static final TreeObject<String> CCA = new TreeObject<String>(010100);
	public static final TreeObject<String> cca = new TreeObject<String>(010100);
	
		//CAC
	public static final TreeObject<String> CAC = new TreeObject<String>(010001);
	public static final TreeObject<String> cac = new TreeObject<String>(010001);
	
		//CAA
	public static final TreeObject<String> CAA = new TreeObject<String>(010000);
	public static final TreeObject<String> caa = new TreeObject<String>(010000);
	
		//CCT
	public static final TreeObject<String> CCT = new TreeObject<String>(010111);
	public static final TreeObject<String> cct = new TreeObject<String>(010111);
	
		//CTC
	public static final TreeObject<String> CTC = new TreeObject<String>(011101);
	public static final TreeObject<String> ctc = new TreeObject<String>(011101);
	
		//CTT
	public static final TreeObject<String> CTT = new TreeObject<String>(011111);
	public static final TreeObject<String> ctt = new TreeObject<String>(011111);
	
		//CCG
	public static final TreeObject<String> CCG = new TreeObject<String>(010110);
	public static final TreeObject<String> ccg = new TreeObject<String>(010110);
	
		//CGC
	public static final TreeObject<String> CGC = new TreeObject<String>(011001);
	public static final TreeObject<String> cgc = new TreeObject<String>(011001);

		//CGG
	public static final TreeObject<String> CGG = new TreeObject<String>(011010);
	public static final TreeObject<String> cgg = new TreeObject<String>(011010);
	
		//CAT - ha
	public static final TreeObject<String> CAT = new TreeObject<String>(010011);
	public static final TreeObject<String> cat = new TreeObject<String>(010011);

	
	
		//Sub-sequence == 4
		//CCCC
	public static final TreeObject<String> CCCC = new TreeObject<String>(01010101);
	public static final TreeObject<String> cccc = new TreeObject<String>(01010101);

		//CCCA
	public static final TreeObject<String> CCCA = new TreeObject<String>(01010100);
	public static final TreeObject<String> ccca = new TreeObject<String>(01010100);

		//CCAC
	public static final TreeObject<String> CCAC = new TreeObject<String>(01010001);
	public static final TreeObject<String> ccac = new TreeObject<String>(01010001);
	
		//CACC
	public static final TreeObject<String> CACC = new TreeObject<String>(01000101);
	public static final TreeObject<String> cacc = new TreeObject<String>(01000101);
		
		//CCAA
	public static final TreeObject<String> CCAA = new TreeObject<String>(01010000);
	public static final TreeObject<String> ccaa = new TreeObject<String>(01010000);
	
		//CACA
	public static final TreeObject<String> CACA = new TreeObject<String>(01000100);
	public static final TreeObject<String> caca = new TreeObject<String>(01000100);
	
		//CAAC
	public static final TreeObject<String> CAAC = new TreeObject<String>(01000001);
	public static final TreeObject<String> caac = new TreeObject<String>(01000001);
		
		//CAAA
	public static final TreeObject<String> CAAA = new TreeObject<String>(01000000);
	public static final TreeObject<String> caaa = new TreeObject<String>(01000000);
	
		//CCCG
	public static final TreeObject<String> CCCG = new TreeObject<String>(01010110);
	public static final TreeObject<String> cccg = new TreeObject<String>(01010110);

	
		//Sub-sequence == 2
	public static final TreeObject<String> GC = new TreeObject<String>(1001);
	public static final TreeObject<String> gc = new TreeObject<String>(1001);
	public static final TreeObject<String> GA = new TreeObject<String>(1000);
	public static final TreeObject<String> ga = new TreeObject<String>(1000);
	public static final TreeObject<String> GT = new TreeObject<String>(1011);
	public static final TreeObject<String> gt = new TreeObject<String>(1011);
	public static final TreeObject<String> GG = new TreeObject<String>(1010);
	public static final TreeObject<String> gg = new TreeObject<String>(1010);
	
		//Sub-sequence == 3
		//GGG
	public static final TreeObject<String> GGG = new TreeObject<String>(101010);
	public static final TreeObject<String> ggg = new TreeObject<String>(101010);
	
		//GGA
	public static final TreeObject<String> GGA = new TreeObject<String>(101000);
	public static final TreeObject<String> gga = new TreeObject<String>(101000);

		//GAG - ha
	public static final TreeObject<String> GAG = new TreeObject<String>(100010);
	public static final TreeObject<String> gag = new TreeObject<String>(100010);

		//GAA
	public static final TreeObject<String> GAA = new TreeObject<String>(100000);
	public static final TreeObject<String> gaa = new TreeObject<String>(100000);
	
		//GGC
	public static final TreeObject<String> GGC = new TreeObject<String>(101001);
	public static final TreeObject<String> ggc = new TreeObject<String>(101001);

		//GCG
	public static final TreeObject<String> GCG = new TreeObject<String>(100110);
	
		//GCC
	public static final TreeObject<String> GCC = new TreeObject<String>(100101);
	
		//GGT
	public static final TreeObject<String> GGT = new TreeObject<String>(101011);
	
		//GTG
	public static final TreeObject<String> GTG = new TreeObject<String>(101110);

		//GTT
	public static final TreeObject<String> GTT = new TreeObject<String>(101111);
	
		//Sub-sequence == 4
		//GGGG
	public static final TreeObject<String> GGGG = new TreeObject<String>(10101010);
	
		//GGGA
	public static final TreeObject<String> GGGA = new TreeObject<String>(10101000);
	
		//GGAG
	public static final TreeObject<String> GGAG = new TreeObject<String>(10100010);
	
		//GAGG
	public static final TreeObject<String> GAGG = new TreeObject<String>(10001010);
	
		//GGAA
	public static final TreeObject<String> GGAA = new TreeObject<String>(10100000);
	
		//GAGA
	public static final TreeObject<String> GAGA = new TreeObject<String>(10001000);

	
		//Sub-sequence == 2
	public static final TreeObject<String> TA = new TreeObject<String>(1100);
	public static final TreeObject<String> TC = new TreeObject<String>(1101);
	public static final TreeObject<String> TG = new TreeObject<String>(1110);
	public static final TreeObject<String> TT = new TreeObject<String>(1111);

	
		//Sub-sequence == 3
		//TTT
	public static final TreeObject<String> TTT = new TreeObject<String>(111111);
	
		//TTA
	public static final TreeObject<String> TTA = new TreeObject<String>(111100);
	
		//TAT
	public static final TreeObject<String> TAT = new TreeObject<String>(110011);
	
		//TAA
	public static final TreeObject<String> TAA = new TreeObject<String>(110000);
	
		//TTC
	public static final TreeObject<String> TTC = new TreeObject<String>(111101);
	
		//TCT
	public static final TreeObject<String> TCT = new TreeObject<String>(110111);
	
		//TCC
	public static final TreeObject<String> TCC = new TreeObject<String>(110101);
	
		//TTG
	public static final TreeObject<String> TTG = new TreeObject<String>(111110);
	
		//TGT
	public static final TreeObject<String> TGT = new TreeObject<String>(111011);
	
		//TGG
	public static final TreeObject<String> TGG = new TreeObject<String>(111010);
	
		//Sub-sequence == 4
		//TTTT
	public static final TreeObject<String> TTTT = new TreeObject<String>(11111111);
	
		//TTAT
	public static final TreeObject<String> TTAT = new TreeObject<String>(11110011);
	
		//TATT
	public static final TreeObject<String> TATT = new TreeObject<String>(11001111);
		
		//TTAA
	public static final TreeObject<String> TTAA = new TreeObject<String>(11110000);
	
		//TATA
	public static final TreeObject<String> TATA = new TreeObject<String>(11001100);

	
	
		//TTCC
	public static final TreeObject<String> TTCC = new TreeObject<String>(11110101);
	
		//TCTC
	public static final TreeObject<String> TCTC = new TreeObject<String>(11011101);
	
		//TCCT
	public static final TreeObject<String> TCCT = new TreeObject<String>(11010111);
	
		//TCCC
	public static final TreeObject<String> TCCC = new TreeObject<String>(11010101);
	
		//TTTG
	public static final TreeObject<String> TTTG = new TreeObject<String>(11111110);
	
		//TTGT
	public static final TreeObject<String> TTGT = new TreeObject<String>(11111011);

		//TGTT
	public static final TreeObject<String> TGTT = new TreeObject<String>(11101111);
	
		//TTGG
	public static final TreeObject<String> TTGG = new TreeObject<String>(11111010);
	
		//TGTG
	public static final TreeObject<String> TGTG = new TreeObject<String>(11101110);
	
	
	
		//Stop Characters/Strings
	public static final TreeObject<Character> NU = new TreeObject<Character>(20);
	public static final TreeObject<Character> NL = new TreeObject<Character>(21);
	public static final TreeObject<String> SS = new TreeObject<String>(22);
	
		//Unknown Characters/Strings
	public static final TreeObject<Character> Y5 = new TreeObject<Character>(5);		
	public static final TreeObject<Character> Z15 = new TreeObject<Character>(15);
	
	
	//Objects for TreeNode tests
	public static final TreeNode<String> nodeA = new TreeNode<String>(1);
	public static final TreeNode<String> nodeC = new TreeNode<String>(1);
	public static final TreeNode<String> nodeG = new TreeNode<String>(1);
	public static final TreeNode<String> nodeT = new TreeNode<String>(1);
	public static final TreeNode<String> nodeAT = new TreeNode<String>(2);
	public static final TreeNode<String> nodeAG = new TreeNode<String>(2);
	public static final TreeNode<String> nodeCG = new TreeNode<String>(2);
	public static final TreeNode<String> nodeTG = new TreeNode<String>(2);
	public static final TreeNode<String> nodeAAG = new TreeNode<String>(3);
	public static final TreeNode<String> nodeCCG = new TreeNode<String>(3);
	public static final TreeNode<String> nodeCTG = new TreeNode<String>(3);
	public static final TreeNode<String> nodeTAG = new TreeNode<String>(3);
	public static final TreeNode<String> nodeGACT = new TreeNode<String>(4);
	public static final TreeNode<String> nodeTCAG = new TreeNode<String>(4);
	public static final TreeNode<String> nodeAAAA = new TreeNode<String>(4);
	public static final TreeNode<String> nodeCCAT = new TreeNode<String>(4);
	public static final TreeNode<String> nodeCGGCC = new TreeNode<String>(5);
	public static final TreeNode<String> nodeTTAAT = new TreeNode<String>(5);
	public static final TreeNode<String> nodeACGGC = new TreeNode<String>(5);
	public static final TreeNode<String> nodeACCTTT = new TreeNode<String>(6);
	public static final TreeNode<String> nodeCCATTA = new TreeNode<String>(6);
	public static final TreeNode<String> nodeGGCTTA = new TreeNode<String>(6);
	
	public static final TreeObject<String>[] K_E = (TreeObject<String>[]) new TreeObject[1];
	public static final TreeObject<String>[] K_AT = (TreeObject<String>[]) new TreeObject[] {AT};
	public static final TreeObject<String>[] K_AGAT = (TreeObject<String>[]) new TreeObject[] {AG, AT};
	public static final TreeObject<String>[] K_AACG = (TreeObject<String>[]) new TreeObject[] {AA, CG};
	public static final TreeObject<String>[] K_NAAN = (TreeObject<String>[]) new TreeObject[] {null, AA, null};
	public static final TreeObject<String>[] K_AGATCG = (TreeObject<String>[]) new TreeObject[] {AG, AT, CG};
	public static final TreeObject<String>[] K_AGATN = (TreeObject<String>[]) new TreeObject[] {AG, AT, null};
	public static final TreeObject<String>[] K_AACGN = (TreeObject<String>[]) new TreeObject[] {AA, CG, null};
	public static final TreeObject<String>[] K_AGATCGAA = (TreeObject<String>[]) new TreeObject[] {AG, AT, CG, AA};
	public static final TreeObject<String>[] K_AGATT = (TreeObject<String>[]) new TreeObject[] {AG, GC, AT, TC, TG};
	public static final TreeObject<String>[] K_GTTCCA = (TreeObject<String>[]) new TreeObject[] {GC, TT, TG, CA, CG, AT};
	
	public static final TreeObject<String>[] K_5N = (TreeObject<String>[]) new TreeObject[] {AG, AT, CG, AA, null};
	public static final TreeObject<String>[] K_5N1 = (TreeObject<String>[]) new TreeObject[] {null, TC, TG, null, null};
	
	public static final TreeObject<String>[] K_5F = (TreeObject<String>[]) new TreeObject[] {AG, AT, CG, AA, CC};
	public static final TreeObject<String>[] K_5N2 = (TreeObject<String>[]) new TreeObject[] {CA, null, TT, null, GG};
	
	public static final TreeObject<String>[] K_8N = (TreeObject<String>[]) new TreeObject[] {AGA, ATA, CGC, AAA, CCT, null, AAT};
	public static final TreeObject<String>[] K_8N2 = (TreeObject<String>[]) new TreeObject[] {null, TCT, TGT, null, null, null, null};
	public static final TreeObject<String>[] K_8N3 = (TreeObject<String>[]) new TreeObject[] {CAC, null, TTT, null, GGG, null, null};
	
	public static final TreeNode<String> nodeInv = new TreeNode<String>(1);
	public static final TreeNode<String> tNode = new TreeNode<String>(2);
	
	public static final long L_0 = 00;
	public static final long L_1 = 01;
	public static final long L_2 = 10;
	public static final long L_3 = 11;
	public static final long L_4 = 100;
	public static final long L_5 = 101;
	public static final long L_6 = 110;
	public static final long L_7 = 111;
	public static final long L_8 = 1000;
	
	//Objects for TreeObject tests
	public static final String S_AT = "AT"; 
	public static final String S_CG = "CG";
	public static final String S_CT = "CT";
	public static final String S_AG = "AG";
	public static final Long L_12 = (long) 12; 
	public static final Long L_34 = (long) 34;
	public static final Long L_56 = (long) 56;
	public static final Integer I_12 = 12; 
	public static final Integer I_34 = 34;
	public static final Integer I_56 = 56;
	public static final Double D_12 = 1.2; 
	public static final Double D_34 = 3.4;
	public static final Double D_56 = 5.6;
	public static final Float F_12	= (float) 1.2; 
	public static final Float F_34	= (float) 3.4; 
	public static final Float F_56	= (float) 5.6;
	public static final Character C_A = 'A';
	public static final Character C_B = 'B';
	public static final Character C_C = 'C';
	public static final Boolean B_true = true; 
	public static final Boolean B_false = false;
	public static final Byte B_12 = (byte) 12; 
	public static final Byte B_34 = (byte) 34;
	public static final Byte B_56 = (byte) 56;
	
	//Keys for TreeObject tests
	public static final int K_0 = 00;
	public static final int K_1 = 01; 
	public static final int K_2 = 10;
	public static final int K_3 = 11;
	public static final int K_4 = 0011;
	public static final int K_5 = 0110;
	public static final int K_6 = 0111;
	public static final int K_7 = 0010;
	
	                                                
	//********************************* BTree Tests *********************************//
	
	//Kind of need a more fleshed out, and agreed upon, set of methods before I can actually
		//implement any kind of worth while tests.
	
	/**
	 * Constructs new BTree with TreeObject<String> + TreeNode<String> objects for testing.
	 * 
	 * @param d - degree of BTree
	 * @param s - sequence length
	 * @param f - file name for gbk file
	 * 
	 * 
	 * @return new BTree<String>
	 */
	public static BTree<String> newBTree(int d, int s, String f)
	{
		//BTree object to run tests on
		BTree<String> newBTree = new BTree<String>(f, d, s);
		return newBTree;
	}
	
	/**
	 * Constructs new BTree with TreeObject<String> + TreeNode<String> objects for testing
	 *
	 * @param d - degree of BTree
	 * @param s - sequence length
	 * @param f - file name for gbk file
	 * @param i - debug level
	 * 
	 * @return new BTree<String>
	 */
	public static BTree<String> newBTree2(int d, int s, String f, int i)
	{
		BTree<String> newBTree = new BTree<String>(f, d, s, i);
		return newBTree;
	}
	
	/**
	 * Tests create method for String objects
	 *
	 * @param BTree - BTree<String> object
	 * @param RAF - RandomAccessFile to compare to
	 */
	public static void testCreate(BTree<String> BTree, RandomAccessFile RAF)
	{
		RandomAccessFile retVal = BTree.create();
		Assert.assertEquals(retVal, RAF);
	}
	
	/**
	 * Tests diskWrite method with TreeNode<String> object
	 *
	 * @param BTree - BTree<String> object
	 * @param TreeNode - TreeNode<String> object to write
	 */
	public static void testDiskWrite(BTree<String> BTree, TreeNode<String> TreeNode)
	{
		BTree.diskWrite(TreeNode);
		TreeNode<String> retVal = BTree.diskRead(TreeNode.getOffSet());
		
		if(retVal != null) {
			Assert.assertEquals(retVal.getKeys(), retVal.getKeys());
		} else {
			Assert.assertEquals(retVal, null);
		}
	}
	
	/**
	 * Tests diskRead method with BTree<String> object
	 * 
	 * @param BTree - BTree<String> object
	 * @param TreeNode - TreeNode<String> object
	 */
	public static void testDiskRead(BTree<String> BTree, TreeNode<String> TreeNode)
	{
		TreeNode<String> retVal = BTree.diskRead(TreeNode.getOffSet());
		if(retVal != null) {
			Assert.assertEquals(retVal.getKeys(), retVal.getKeys());
		} else {
			Assert.assertEquals(retVal, null);
		}
		
	}
	
	/**
	 * Tests inOrder method with TreeNode<String> object
	 * 
	 * @param BTree - BTree<String> object
	 * @param TreeNode - TreeNode<String> object
	 * @param s - expected string object
	 */
	public static void testInOrder(BTree<String> BTree, TreeNode<String> TreeNode, String s)
	{
		String retVal = BTree.inOrder(TreeNode);
		Assert.assertEquals(retVal, s);
	}
	
	
	/**
	 * Tests insert method for BTree<String> objects
	 * 
	 * @param bTree - BTree<String> object
	 * @param TreeNode - TreeNode<String> object
	 * @param key - TreeObject<String> object to insert
	 */
	public static void testInsert(BTree<String> bTree, TreeNode<String> TreeNode, TreeObject<String> TreeObject)
	{
		bTree.insert(TreeObject);
		TreeObject<String> tObj = bTree.search(bTree.getRoot(), TreeObject);
		Assert.assertEquals(tObj, tObj);
	}
	
	/**
	 * Tests splitChild method for BTree<String> objects
	 * 
	 * @param BTree - BTree<String> object
	 * @param TreeNode1 - TreeNode<String> object
	 * @param TreeNode2 - TreeNode<String> object
	 * @param i - integer value for offset
	 */
	public static void testSplitChild(BTree<String> BTree, TreeNode<String> TreeNode1, TreeNode<String> TreeNode2, int i)
	{
			BTree.splitChild(TreeNode1, i, TreeNode2);
			TreeNode<String> actual = BTree.diskRead(TreeNode1.getOffSet());
			TreeNode<String> actual2 = BTree.diskRead(TreeNode2.getOffSet());
			Assert.assertEquals(actual.getKeys(), actual.getKeys());
			Assert.assertEquals(actual2.getKeys(), actual2.getKeys());
	}
	
	/**
	 * Tests insertNonFull method for BTree<String> objects
	 * 
	 * @param BTree - BTree<String> object
	 * @param TreeNode - TreeNode<String> object
	 * @param l - key for node
	 */
	public static void testInsertNonFull(BTree<String> BTree, TreeNode<String> TreeNode, long l)
	{
		BTree.insertNonFull(TreeNode, l);
		TreeObject<String> search = new TreeObject<String>(l);
		TreeObject<String> retVal = BTree.search(TreeNode, search);
		Assert.assertEquals(retVal, retVal);
	}
	
	/**
	 * Tests search method for BTree<String> Objects
	 * 
	 * @param bTree- BTree<String> object
	 * @param TreeNode - TreeNode<String> object
	 * @param TreeObject - TreeObject<String> object
	 */
	public static void testSearch(BTree<String> bTree, TreeNode<String> TreeNode, TreeObject<String> TreeObject)
	{
		TreeObject<String> retVal = bTree.search(TreeNode, TreeObject);
		if(retVal != null) {
			Assert.assertEquals(retVal, TreeObject);
		} else {
			Assert.assertEquals(retVal, null);
		}
		
	}
	
	/**
	 * Tests delete method for BTree<String> Objects
	 * 
	 * @param BTree - BTree<String> object
	 * @param TreeNode - TreeNode<String> object
	 * @param NodeToDel - TreeObject<String> object
	 */
	public static void testDelete(BTree<String> BTree, TreeNode<String> TreeNode, TreeObject<String> NodeToDel)
	{
		TreeObject<String> retVal = BTree.delete(TreeNode, NodeToDel);
		if (retVal != null) {
			Assert.assertEquals(retVal.getKey(), NodeToDel.getKey());
		} else {
			Assert.assertEquals(retVal, null);
		}
	}
	
	/**
	 * Tests debug method for BTree<String> objects
	 * 
	 * @param BTree - BTree<String> object
	 * @param file - expected File object
	 */
	public static void testDebug(BTree<String> BTree, File file)
	{
		File retVal = BTree.debug();
		Assert.assertEquals(retVal, file);
	}
	
	/**
	 * Tests getRoot method for BTree<String> objects
	 * 
	 * @param BTree - BTree<String> object
	 * @param TreeNode - expected TreeNode<String> object
	 */
	public static void testGetRoot(BTree<String> BTree, TreeNode<String> TreeNode)
	{
		TreeNode<String> retVal = BTree.getRoot();
		Assert.assertEquals(retVal.getKeys(), TreeNode.getKeys());
	}
	
	/**
	 * Tests setRoot method for BTree<String> objects
	 * 
	 * @param BTree - BTree<String> object
	 * @param TreeNode - TreeNode<String> object to set to
	 */
	public static void testSetRoot(BTree<String> BTree, TreeNode<String> TreeNode)
	{
		BTree.setRoot(TreeNode);
		TreeNode<String> retVal = BTree.getRoot();
		Assert.assertEquals(retVal.getKeys(), TreeNode.getKeys());
	}
	
	/**
	 * Tests isEmpty method for BTree<String> objects
	 *
	 * @param BTree - BTree<String> object
	 * @param b - expected boolean value
	 */
	public static void testIsEmpty(BTree<String> BTree, boolean b)
	{
		boolean retVal = BTree.isEmpty();
		Assert.assertEquals(retVal, b);
	}
	
	/**
	 * Tests getSize method for BTree<String> objects
	 * 
	 * @param BTree - BTree<String> object
	 * @param i - expected integer value
	 */
	public static void testGetSize(BTree<String> BTree, int i)
	{
		int retVal = BTree.getSize();
		Assert.assertEquals(retVal, i);
	}
	
	/**
	 * Tests incSize method for BTree<String> objects
	 * 
	 * @param BTree - BTree<String> object
	 * @param i - expected integer value
	 */
	public static void testIncSize(BTree<String> BTree, int i)
	{
		BTree.incSize();
		int retVal = BTree.getSize();
		Assert.assertEquals(retVal, i);
	}
	
	/**
	 * Tests getHeight method for BTree<String> objects
	 * 
	 * @param BTree - BTree<String> object
	 * @param i - expected integer value
	 */
	public static void testGetHeight(BTree<String> BTree, int i)
	{
		int retVal = BTree.getHeight();
		Assert.assertEquals(retVal, i);
	}
	
	/**
	 * Tests getDegree method for BTree<String> objects
	 * 
	 * @param BTree - BTree<String> object
	 * @param i - expected integer value
	 */
	public static void testGetDegree(BTree<String> BTree, int i)
	{
		int retVal = BTree.getDegree();
		Assert.assertEquals(retVal, i);
	}
	
	/**
	 * Tests setDegree method for BTree<String> objects
	 * 
	 * @param BTree - BTree<String> object
	 * @param i - integer value to change degree
	 */
	public static void testSetDegree(BTree<String> BTree, int i)
	{
		BTree.setDegree(i);
		int retVal = BTree.getDegree();
		Assert.assertEquals(retVal, i);
	}
	
	/**
	 * Tests getCapacity method for BTree<String> objects
	 * 
	 * @param BTree - BTree<String> object
	 * @param i - expected integer value
	 */
	public static void testGetCapacity(BTree<String> BTree, int i)
	{
		int retVal = BTree.getCapacity();
		Assert.assertEquals(retVal, i);
	}
	
	/**
	 * Tests setCapacity method for BTree<String> objects
	 * 
	 * @param BTree - BTree<String> object
	 * @param i - integer value to change to
	 */
	public static void testSetCapacity(BTree<String> BTree, int i)
	{
		BTree.setCapacity(i);
		int retVal = BTree.getCapacity();
		Assert.assertEquals(retVal, i);
	}
	
	/**
	 * Tests getSeqLength method for BTree<String> objects
	 * 
	 * @param BTree - BTree<String> object
	 * @param i - expected integer value
	 */
	public static void testGetSeqLength(BTree<String> BTree, int i)
	{
		int retVal = BTree.getSeqLength();
		Assert.assertEquals(retVal, i);
	}
	
	/**
	 * Tests setSeqLength method for BTree<String> objects
	 * 
	 * @param BTree - BTree<String> object
	 * @param i - integer value to change to
	 */
	public static void testSetSeqLength(BTree<String> BTree, int i)
	{
		BTree.setSeqLength(i);
		int retVal = BTree.getSeqLength();
		Assert.assertEquals(retVal, i);
	}
	
	/**
	 * Tests getRAF method for BTree<String> objects
	 * 
	 * @param BTree - BTree<String> object
	 * @param RAF - expected RandomAccessFile object
	 */
	public static void testGetRAF(BTree<String> BTree, RandomAccessFile RAF)
	{
		RandomAccessFile retVal = BTree.getRAF();
		Assert.assertEquals(retVal, RAF);
	}
	
	/**
	 * Tests getRootOffset method for BTree<String> objects
	 * 
	 * @param BTree - BTree<String> object
	 * @param l - expected long offset value
	 */
	public static void testGetRootOffset(BTree<String> BTree, long l)
	{
		long retVal = BTree.getRootOffset();
		Assert.assertEquals(retVal, l);
	}
	
	
	
	//******************************* TreeNode Tests *****************************//
	
	/**
	 * Constructs new TreeNode with given degree and stores <String> objects for testing
	 * 
	 * @param d - Integer value for degree of node
	 * 
	 * @return tNode - new TreeNode<String>
	 */
	public static TreeNode<String> newTreeNode(int d)
	{
		TreeNode<String> tNode = new TreeNode<String>(d);
		return tNode;
	}
	
	/**
	 * Tests getLeaf method for String objects
	 *
	 * @param TreeNode - TreeNode<String> object
	 * @param l - expected integer value 
	 */
	public static void testGetLeaf(TreeNode<String> TreeNode, int l) 
	{
		int leaf = TreeNode.getLeaf();
		Assert.assertEquals(leaf, l);
	}
	
	/**
	 * Tests setLeaf method for String objects
	 *
	 * @param TreeNode - TreeNode<String> object
	 * @param l - integer value to set leaf to
	 */
	public static void testSetLeaf(TreeNode<String> TreeNode, int l) 
	{
		TreeNode.setLeaf(l);
		int leaf = TreeNode.getLeaf();
		Assert.assertEquals(leaf, l);
	}
	
	/**
	 * Tests getCount method for String objects
	 * 
	 * @param TreeNode - TreeNode<String> object
	 * @param i - expected integer value
	 */
	public static void testGetCount(TreeNode<String> TreeNode, int i)
	{
		int retVal = TreeNode.getCount();
		Assert.assertEquals(retVal, i);
	}
	
	/**
	 * Tests incCount method for String objects
	 *
	 * @param TreeNode - TreeNode<String> object
	 * @param i - expected integer value
	 */
	public static void testIncCount(TreeNode<String> TreeNode, int i)
	{
		TreeNode.incCount();
		int retVal = TreeNode.getCount();
		Assert.assertEquals(retVal, i);
	}
	
	/**
	 * Tests setCount method for String objects
	 * 
	 * @param TreeNode - TreeNode<String> object
	 * @param i1 - integer value to set count to
	 * @param i2 - expected integer value
	 */
	public static void testSetCount(TreeNode<String> TreeNode, int i1, int i2)
	{
		TreeNode.setCount(i1);
		int retVal = TreeNode.getCount();
		Assert.assertEquals(retVal, i2);
	}
	
	/**
	 * Tests getChildren method for String objects
	 * 
	 * @param TreeNode - TreeNode<String> object
	 * @param l - expected long[] value
	 */
	public static void testGetChildren(TreeNode<String> TreeNode, long[] l)
	{
		long[] children = TreeNode.getChildren();
		Assert.assertEquals(children, l);
	}
	
	/**
	 * Tests setChildren method for String objects
	 * 
	 * @param TreeNode - TreeNode<String> object
	 * @param l - long value to set for child
	 * @param i - integer index to set array slot to in the children array
	 */
	public static void testSetChildren(TreeNode<String> TreeNode, long l, int i)
	{
		TreeNode.setChildren(i, l);
		long[] children = TreeNode.getChildren();
		Assert.assertEquals(children[i], l);
	}
	
	/**
	 * Tests getKeys method for String objects
	 * 
	 * @param TreeNode - TreeNode<String> object
	 * @param keys - TreeObject<String>[] array of TreeObject key values
	 */
	public static void testGetKeys(TreeNode<String> TreeNode, TreeObject<String>[] keys)
	{
		TreeObject<String>[] nodeKeys = TreeNode.getKeys();
		Assert.assertEquals(nodeKeys, keys);
	}
	
	/**
	 * Tests setKeys method for String objects
	 * 
	 * @param TreeNode - TreeNode<String> object
	 * @param key - TreeObject<String> object to set a key value to
	 * @param i - integer index to change key to
	 */
	public static void testSetKeys(TreeNode<String> TreeNode, TreeObject<String> key, int i)
	{
		TreeNode.setKeys(i, key);
		TreeObject<String>[] keys = TreeNode.getKeys(); 
		Assert.assertEquals(keys[i], key);
	}
	
	/**
	 * Tests getOffSet method for String objects
	 * 
	 * @param TreeNode - TreeNode<String> object
	 * @param l - expected long value for offset
	 */
	public static void testGetOffSet(TreeNode<String> TreeNode, long l)
	{
		long offSet = TreeNode.getOffSet();
		Assert.assertEquals(offSet, l);
	}
	
	/**
	 * Tests setOffSet method for String objects
	 * 
	 * @param TreeNode - TreeNode<String> object
	 * @param l - long value to set offset to
	 */
	public static void testSetOffSet(TreeNode<String> TreeNode, long l)
	{
		TreeNode.setOffSet(l);
		long offSet = TreeNode.getOffSet();
		Assert.assertEquals(offSet, l);
	}
	
	
	
	//******************************* TreeObject Tests *****************************// 
	
	
	/**
	 * Tests getKey method for String objects 
	 * @param TreeObject - TreeObject<String> object 
	 * @param value - String object
	 * @param expectedKey - long value 
	 */
	public static void getKey(TreeObject<String> TreeObject, String value, long expectedKey)
	{
		long key = TreeObject.getKey(); 
		Assert.assertEquals(key, expectedKey);
	}
	
	/**
	 * Tests getKey method for Long objects 
	 * @param TreeObject - TreeObject<Long> object 
	 * @param value - Long object
	 * @param expectedKey - long value 
	 */
	public static void getKey(TreeObject<Long> TreeObject, Long value, long expectedKey)
	{
		long key = TreeObject.getKey(); 
		Assert.assertEquals(key, expectedKey);
	}
	
	/**
	 * Tests getKey method for Integer objects 
	 * @param TreeObject - TreeObject<Integer> object 
	 * @param value - Integer object
	 * @param expectedKey - long value 
	 */
	public static void getKey(TreeObject<Integer> TreeObject, Integer value, long expectedKey)
	{
		long key = TreeObject.getKey(); 
		Assert.assertEquals(key, expectedKey);
	}
	
	/**
	 * Tests getKey method for Double objects 
	 * @param TreeObject - TreeObject<Double> object 
	 * @param value - Double object
	 * @param expectedKey - long value 
	 */
	public static void getKey(TreeObject<Double> TreeObject, Double value, long expectedKey)
	{
		long key = TreeObject.getKey(); 
		Assert.assertEquals(key, expectedKey);
	}
	
	/**
	 * Tests getKey method for Float objects 
	 * @param TreeObject - TreeObject<Float> object 
	 * @param value - Float object
	 * @param expectedKey - long value 
	 */
	public static void getKey(TreeObject<Float> TreeObject, Float value, long expectedKey)
	{
		long key = TreeObject.getKey(); 
		Assert.assertEquals(key, expectedKey);
	}
	
	/**
	 * Tests getKey method for Character objects 
	 * @param TreeObject - TreeObject<Character> object 
	 * @param value - Character object
	 * @param expectedKey - long value 
	 */
	public static void getKey(TreeObject<Character> TreeObject, Character value, long expectedKey)
	{
		long key = TreeObject.getKey(); 
		Assert.assertEquals(key, expectedKey);
	}
	
	/**
	 * Tests getKey method for Boolean objects 
	 * @param TreeObject - TreeObject<Boolean> object
	 * @param value - Boolean object
	 * @param expectedKey - long value 
	 */
	public static void getKey(TreeObject<Boolean> TreeObject, Boolean value, long expectedKey)
	{
		long key = TreeObject.getKey(); 
		Assert.assertEquals(key, expectedKey);
	}
	
	/**
	 * Tests getKey method for Byte objects 
	 * @param TreeObject - TreeObject<Byte> object 
	 * @param value - Byte object
	 * @param expectedKey - long value 
	 */
	public static void getKey(TreeObject<Byte> TreeObject, Byte value, long expectedKey)
	{
		long key = TreeObject.getKey(); 
		Assert.assertEquals(key, expectedKey);
	}
	
	/**
	 * Tests getFrequency method for String objects
	 * @param TreeObject - TreeObject<String> object
	 * @param val - String object
	 * @param i - expected integer value
	 */
	public static void getFrequency(TreeObject<String> TreeObject, String val, int i)
	{
		int retVal = TreeObject.getFrequency();
		Assert.assertEquals(retVal, i);
	}
	
	/**
	 * Tests getFrequency method for Integer objects
	 * @param TreeObject - TreeObject<Integer> object
	 * @param val - Integer object
	 * @param i - expected integer value
	 */
	public static void getFrequency(TreeObject<Integer> TreeObject, Integer val, int i)
	{
		int retVal = TreeObject.getFrequency();
		Assert.assertEquals(retVal, i);
	}
	
	/**
	 * Tests getFrequency method for Long objects
	 * @param TreeObject - TreeObject<Long> object
	 * @param val - Long object
	 * @param i - expected integer value
	 */
	public static void getFrequency(TreeObject<Long> TreeObject, Long val, int i)
	{
		int retVal = TreeObject.getFrequency();
		Assert.assertEquals(retVal, i);
	}
	
	/**
	 * Tests getFrequency method for Float objects
	 * @param TreeObject - TreeObject<Float> object
	 * @param val - Float object
	 * @param i - expected integer value
	 */
	public static void getFrequency(TreeObject<Float> TreeObject, Float val, int i)
	{
		int retVal = TreeObject.getFrequency();
		Assert.assertEquals(retVal, i);
	}
	
	/**
	 * Tests getFrequency method for Double objects
	 * @param TreeObject - TreeObject<Double> object
	 * @param val - Double object
	 * @param i - expected integer value
	 */
	public static void getFrequency(TreeObject<Double> TreeObject, Double val, int i)
	{
		int retVal = TreeObject.getFrequency();
		Assert.assertEquals(retVal, i);
	}
	
	/**
	 * Tests getFrequency method for Character objects
	 * @param TreeObject - TreeObject<Character> object
	 * @param val - Character object
	 * @param i - expected integer value
	 */
	public static void getFrequency(TreeObject<Character> TreeObject, Character val, int i)
	{
		int retVal = TreeObject.getFrequency();
		Assert.assertEquals(retVal, i);
	}
	
	/**
	 * Tests getFrequency method for Boolean objects
	 * @param TreeObject - TreeObject<Boolean> object
	 * @param val - Boolean object
	 * @param i - expected integer value
	 */
	public static void getFrequency(TreeObject<Boolean> TreeObject, Boolean val, int i)
	{
		int retVal = TreeObject.getFrequency();
		Assert.assertEquals(retVal, i);
	}
	
	/**
	 * Tests getFrequency method for Byte objects
	 * @param TreeObject - TreeObject<Byte> object
	 * @param val - Byte object
	 * @param i - expected integer value
	 */
	public static void getFrequency(TreeObject<Byte> TreeObject, Byte val, int i)
	{
		int retVal = TreeObject.getFrequency();
		Assert.assertEquals(retVal, i);
	}
	
	/**
	 * Tests setFrequency method for String objects
	 * @param TreeObject - TreeObject<String> object
	 * @param val - String object
	 * @param i - integer value to change to
	 */
	public static void setFrequency(TreeObject<String> TreeObject, String val, int i)
	{
		TreeObject.setFrequency(i);
		int retVal = TreeObject.getFrequency();
		Assert.assertEquals(retVal, i);
	}
	
	/**
	 * Tests setFrequency method for Integer objects
	 * @param TreeObject - TreeObject<Integer> object
	 * @param val - Integer object
	 * @param i - integer value to change to
	 */
	public static void setFrequency(TreeObject<Integer> TreeObject, Integer val, int i)
	{
		TreeObject.setFrequency(i);
		int retVal = TreeObject.getFrequency();
		Assert.assertEquals(retVal, i);
	}
	
	/**
	 * Tests setFrequency method for Long objects
	 * @param TreeObject - TreeObject<Long> object
	 * @param val - Long object
	 * @param i - integer value to change to
	 */
	public static void setFrequency(TreeObject<Long> TreeObject, Long val, int i)
	{
		TreeObject.setFrequency(i);
		int retVal = TreeObject.getFrequency();
		Assert.assertEquals(retVal, i);
	}
	
	/**
	 * Tests setFrequency method for Float objects
	 * @param TreeObject - TreeObject<Float> object
	 * @param val - Float object
	 * @param i - integer value to change to
	 */
	public static void setFrequency(TreeObject<Float> TreeObject, Float val, int i)
	{
		TreeObject.setFrequency(i);
		int retVal = TreeObject.getFrequency();
		Assert.assertEquals(retVal, i);
	}
	
	/**
	 * Tests setFrequency method for Double objects
	 * @param TreeObject - TreeObject<Double> object
	 * @param val - Double object
	 * @param i - integer value to change to
	 */
	public static void setFrequency(TreeObject<Double> TreeObject, Double val, int i)
	{
		TreeObject.setFrequency(i);
		int retVal = TreeObject.getFrequency();
		Assert.assertEquals(retVal, i);
	}
	
	/**
	 * Tests setFrequency method for Character objects
	 * @param TreeObject - TreeObject<Character> object
	 * @param val - Character object
	 * @param i - integer value to change to
	 */
	public static void setFrequency(TreeObject<Character> TreeObject, Character val, int i)
	{
		TreeObject.setFrequency(i);
		int retVal = TreeObject.getFrequency();
		Assert.assertEquals(retVal, i);
	}
	
	/**
	 * Tests setFrequency method for Boolean objects
	 * @param TreeObject - TreeObject<Boolean> object
	 * @param val - Boolean object
	 * @param i - integer value to change to
	 */
	public static void setFrequency(TreeObject<Boolean> TreeObject, Boolean val, int i)
	{
		TreeObject.setFrequency(i);
		int retVal = TreeObject.getFrequency();
		Assert.assertEquals(retVal, i);
	}
	
	/**
	 * Tests setFrequency method for Byte objects
	 * @param TreeObject - TreeObject<Byte> object
	 * @param val - Byte object
	 * @param i - integer value to change to
	 */
	public static void setFrequency(TreeObject<Byte> TreeObject, Byte val, int i)
	{
		TreeObject.setFrequency(i);
		int retVal = TreeObject.getFrequency();
		Assert.assertEquals(retVal, i);
	}
	
	/**
	 * Tests incrementFrequency method for String objects
	 * @param TreeObject - TreeObject<String> object
	 * @param val - String object
	 * @param i - expected integer value
	 */
	public static void incFrequency(TreeObject<String> TreeObject, String val, int i)
	{
		TreeObject.incrementFreq();
		int retVal = TreeObject.getFrequency();
		Assert.assertEquals(retVal, i);
	}
	
	/**
	 * Tests incrementFrequency method for Integer objects
	 * @param TreeObject - TreeObject<Integer> object
	 * @param val - Integer object
	 * @param i - expected integer value
	 */
	public static void incFrequency(TreeObject<Integer> TreeObject, Integer val, int i)
	{
		TreeObject.incrementFreq();
		int retVal = TreeObject.getFrequency();
		Assert.assertEquals(retVal, i);
	}
	
	/**
	 * Tests incrementFrequency method for Long objects
	 * @param TreeObject - TreeObject<Long> object
	 * @param val - Long object
	 * @param i - expected integer value
	 */
	public static void incFrequency(TreeObject<Long> TreeObject, Long val, int i)
	{
		TreeObject.incrementFreq();
		int retVal = TreeObject.getFrequency();
		Assert.assertEquals(retVal, i);
	}
	
	/**
	 * Tests incrementFrequency method for Float objects
	 * @param TreeObject - TreeObject<Float> object
	 * @param val - Float object
	 * @param i - expected integer value
	 */
	public static void incFrequency(TreeObject<Float> TreeObject, Float val, int i)
	{
		TreeObject.incrementFreq();
		int retVal = TreeObject.getFrequency();
		Assert.assertEquals(retVal, i);
	}
	
	/**
	 * Tests incrementFrequency method for Double objects
	 * @param TreeObject - TreeObject<Double> object
	 * @param val - Double object
	 * @param i - expected integer value
	 */
	public static void incFrequency(TreeObject<Double> TreeObject, Double val, int i)
	{
		TreeObject.incrementFreq();
		int retVal = TreeObject.getFrequency();
		Assert.assertEquals(retVal, i);
	}
	
	/**
	 * Tests incrementFrequency method for Character objects
	 * @param TreeObject - TreeObject<Character> object
	 * @param val - Character object
	 * @param i - expected integer value
	 */
	public static void incFrequency(TreeObject<Character> TreeObject, Character val, int i)
	{
		TreeObject.incrementFreq();
		int retVal = TreeObject.getFrequency();
		Assert.assertEquals(retVal, i);
	}
	
	/**
	 * Tests incrementFrequency method for Boolean objects
	 * @param TreeObject - TreeObject<Boolean> object
	 * @param val - Boolean object
	 * @param i - expected integer value
	 */
	public static void incFrequency(TreeObject<Boolean> TreeObject, Boolean val, int i)
	{
		TreeObject.incrementFreq();
		int retVal = TreeObject.getFrequency();
		Assert.assertEquals(retVal, i);
	}
	
	/**
	 * Tests incrementFrequency method for Byte objects
	 * @param TreeObject - TreeObject<Byte> object
	 * @param val - Byte object
	 * @param i - expected integer value
	 */
	public static void incFrequency(TreeObject<Byte> TreeObject, Byte val, int i)
	{
		TreeObject.incrementFreq();
		int retVal = TreeObject.getFrequency();
		Assert.assertEquals(retVal, i);
	}
	
	/**
	 * Tests setKey method for String objects 
	 * @param TreeObject - TreeObject<String> object 
	 * @param value - String object
	 * @param key - long value 
	 */
	public static void setKey(TreeObject<String> TreeObject, String value, long key)
	{
		TreeObject.setKey(key);
		long expectedKey = TreeObject.getKey(); 
		Assert.assertEquals(key, expectedKey); 
	}
	
	/**
	 * Tests setKey method for Long objects 
	 * @param TreeObject - TreeObject<Long> object 
	 * @param value - Long object
	 * @param key - long value 
	 */
	public static void setKey(TreeObject<Long> TreeObject, Long value, long key)
	{
		TreeObject.setKey(key);
		long expectedKey = TreeObject.getKey(); 
		Assert.assertEquals(key, expectedKey); 
	}
	
	/**
	 * Tests setKey method for Integer objects 
	 * @param TreeObject - TreeObject<Integer> object 
	 * @param value - Integer object
	 * @param key - long value 
	 */
	public static void setKey(TreeObject<Integer> TreeObject, Integer value, long key)
	{
		TreeObject.setKey(key);
		long expectedKey = TreeObject.getKey(); 
		Assert.assertEquals(key, expectedKey); 
	}
	
	/**
	 * Tests setKey method for Double objects 
	 * @param TreeObject - TreeObject<Double> object 
	 * @param value - Double object
	 * @param key - long value 
	 */
	public static void setKey(TreeObject<Double> TreeObject, Double value, long key)
	{
		TreeObject.setKey(key);
		long expectedKey = TreeObject.getKey(); 
		Assert.assertEquals(key, expectedKey); 
	}
	
	/**
	 * Tests setKey method for Float objects 
	 * @param TreeObject - TreeObject<Float> object 
	 * @param value - Float object
	 * @param key - long value 
	 */
	public static void setKey(TreeObject<Float> TreeObject, Float value, long key)
	{
		TreeObject.setKey(key);
		long expectedKey = TreeObject.getKey(); 
		Assert.assertEquals(key, expectedKey); 
	}
	
	/**
	 * Tests setKey method for Character objects 
	 * @param TreeObject - TreeObject<Character> object 
	 * @param value - Character object
	 * @param key - long value 
	 */
	public static void setKey(TreeObject<Character> TreeObject, Character value, long key)
	{
		TreeObject.setKey(key);
		long expectedKey = TreeObject.getKey(); 
		Assert.assertEquals(key, expectedKey); 
	}
	
	/**
	 * Tests setKey method for Boolean objects 
	 * @param TreeObject - TreeObject<Boolean> object 
	 * @param value - Boolean object
	 * @param key - long value 
	 */
	public static void setKey(TreeObject<Boolean> TreeObject, Boolean value, long key)
	{
		TreeObject.setKey(key);
		long expectedKey = TreeObject.getKey(); 
		Assert.assertEquals(key, expectedKey); 
	}
	
	/**
	 * Tests setKey method for Byte objects 
	 * @param TreeObject - TreeObject<Byte> object 
	 * @param value - Byte object
	 * @param key - long value 
	 */
	public static void setKey(TreeObject<Byte> TreeObject, Byte value, long key)
	{
		TreeObject.setKey(key);
		long expectedKey = TreeObject.getKey(); 
		Assert.assertEquals(key, expectedKey); 
	}
	

	
	/**
	 * Tests toString method for String objects
	 * @param TreeObject - TreeObject<String> object
	 * @param s1 - String Object
	 * @param s2 - expected String value
	 */
	public static void toString(TreeObject<String> TreeObject, String s1, String s2)
	{
		String retVal = TreeObject.toString();
		Assert.assertEquals(retVal, s2);
	}
	
	/**
	 * Tests toString method for Long objects
	 * @param TreeObject - TreeObject<Long> object
	 * @param l - Long Object
	 * @param s - expected String value
	 */
	public static void toString(TreeObject<Long> TreeObject, Long l, String s)
	{
		String retVal = TreeObject.toString();
		Assert.assertEquals(retVal, s);
	}
	
	/**
	 * Tests toString method for Integer objects
	 * @param TreeObject - TreeObject<Integer> object
	 * @param i - Integer Object
	 * @param s - expected String value
	 */
	public static void toString(TreeObject<Integer> TreeObject, Integer i, String s)
	{
		String retVal = TreeObject.toString();
		Assert.assertEquals(retVal, s);
	}
	
	/**
	 * Tests toString method for Double objects
	 * @param TreeObject - TreeObject<Double> object
	 * @param d - Double Object
	 * @param s - expected String value
	 */
	public static void toString(TreeObject<Double> TreeObject, Double d, String s)
	{
		String retVal = TreeObject.toString();
		Assert.assertEquals(retVal, s);
	}
	
	/**
	 * Tests toString method for Float objects
	 * @param TreeObject - TreeObject<Float> object
	 * @param f - Float Object
	 * @param s - expected String value
	 */
	public static void toString(TreeObject<Float> TreeObject, Float f, String s)
	{
		String retVal = TreeObject.toString();
		Assert.assertEquals(retVal, s);
	}
	
	/**
	 * Tests toString method for Character objects
	 * @param TreeObject - TreeObject<Character> object
	 * @param c - Character Object
	 * @param s - expected String value
	 */
	public static void toString(TreeObject<Character> TreeObject, Character c, String s)
	{
		String retVal = TreeObject.toString();
		Assert.assertEquals(retVal, s);
	}
	
	/**
	 * Tests toString method for Boolean objects
	 * @param TreeObject - TreeObject<Boolean> object
	 * @param b - Boolean Object
	 * @param s - expected String value
	 */
	public static void toString(TreeObject<Boolean> TreeObject, Boolean b, String s)
	{
		String retVal = TreeObject.toString();
		Assert.assertEquals(retVal, s);
	}
	
	/**
	 * Tests toString method for Byte objects
	 * @param TreeObject - TreeObject<Byte> object
	 * @param b - Byte Object
	 * @param s - expected String value
	 */
	public static void toString(TreeObject<Byte> TreeObject, Byte b, String s)
	{
		String retVal = TreeObject.toString();
		Assert.assertEquals(retVal, s);
	}
	
}
