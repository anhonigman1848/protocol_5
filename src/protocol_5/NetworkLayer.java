package protocol_5;

import java.util.*;

public class NetworkLayer extends Layer {
	
	// does the NetworkLayer ever need to call the LinkLayer?
	private LinkLayer link_layer;

	// store packets in Vector - can grow and shrink
	private Vector<Packet> nw_buffer;
	
	public NetworkLayer() {
		
		link_layer = null;
		
		nw_buffer = new Vector<Packet>();
		
	}
	
	public void connectLink(LinkLayer linkLayer) {
		
		link_layer = linkLayer;
		
	}
	
	public void makePackets(char[] data) {
		
		try {
			
			for(int i = 0; i < data.length; i += PACKET_SIZE) {
				
				int current_size = PACKET_SIZE;
				
				if(data.length - i < PACKET_SIZE) {
					
					current_size = data.length - i;
										
				}
				char[] packet_data = new char[current_size];
				
				System.arraycopy(data, i, packet_data, 0, current_size);
				
				Packet new_packet = new Packet(packet_data, PACKET_SIZE);
				
				nw_buffer.addElement(new_packet);
				
				System.out.println("Added " + new_packet.toString());
				
			}
			
		} catch(Exception ex) {}
		
	}
	
	public int packetsInBuffer() {
		
		return(nw_buffer.size());
		
	}
	
	public Packet nextPacket() {
		
		if(packetsInBuffer() > 0) {
			
			Packet nextPacket = nw_buffer.remove(0);
			
			return(nextPacket);
			
		} else { 
			
			return(null); 
			
		}
		
	}
	
}
