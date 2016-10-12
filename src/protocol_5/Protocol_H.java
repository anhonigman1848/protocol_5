package protocol_5;

public class Protocol_H {
	
	public static void main(String[] args) {
		
		final int PACKET_SIZE = 5;
		
		String test = "konsert nr 2 for violin och orkester";
		
		char[] test_array = test.toCharArray();
		
		Packet packet = new Packet(test_array, PACKET_SIZE);
		
		String str = packet.toString();
		
		System.out.println(str);
		
		Protocol5_NW_Layer testlayer = new Protocol5_NW_Layer(PACKET_SIZE);
		
		testlayer.makePackets(test_array);
		
	}
	
}
