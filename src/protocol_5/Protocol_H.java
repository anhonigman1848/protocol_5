package protocol_5;

public class Protocol_H {
	
	public static void main(String[] args) {
		
		String test = "test1 test2 test3 blah blah";
		
		char[] test_array = test.toCharArray();
		
		NetworkLayer testnw = new NetworkLayer();
		
		LinkLayer testll = new LinkLayer();
		
		testnw.connectLink(testll);
		
		testll.connectNetwork(testnw);
		
		testnw.makePackets(test_array);
		
		testll.getPackets();
		
		//testll.sendDataFrame();
		
	}
	
}
