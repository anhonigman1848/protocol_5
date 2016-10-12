package protocol_5;

import java.util.*;

public class Protocol5_NW_Layer {
	
	private Vector<Packet> nw_buffer;
	
	private int packet_index;
	
	private Packet next_packet;
	
	private int packet_size;
	
	public Protocol5_NW_Layer(int packetSize) {
		
		nw_buffer = new Vector<Packet>();
		
		packet_index = 0;
		
		packet_size = packetSize;
		
	}
	
	public void makePackets(char[] data) {
		
		try {
			
			for(int i = 0; i < data.length; i += packet_size) {
				
				if(data.length - i < packet_size) {
					
					packet_size = data.length - i;
										
				}
				char[] packet_data = new char[packet_size];
				
				System.arraycopy(data, i, packet_data, 0, packet_size);
				
				Packet new_packet = new Packet(packet_data);
				
				nw_buffer.addElement(new_packet);
				
				System.out.println("Added " + new_packet.toString());
				
			}
			
		} catch(Exception ex) {}
		
	}

}
