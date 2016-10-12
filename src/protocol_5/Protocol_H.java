package protocol_5;

public class Protocol_H {
	
	public static void main(String[] args) {
		
		String test = " ";
		
		char[] test_array = test.toCharArray();
		
		Packet packet = new Packet(test_array);
		
		String str = packet.toString();
		
		System.out.println(str);
		
		Protocol5_NW_Layer testlayer = new Protocol5_NW_Layer(4);
		
		testlayer.makePackets(test_array);
		
	}
	
}
