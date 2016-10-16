package protocol_5;

public class LinkLayer extends Layer {
	
	private NetworkLayer network_layer;

	final int WINDOW_SIZE = 1;
	
	int next_frame_to_send;
	
	int ack_expected;
	
	int frame_expected;
	
	Frame r;
	
	Packet[] link_buffer;
	
	int nbuffered;
	
	int buffer_index;
	
	int i;

	public LinkLayer() {
		
		ack_expected = 0;
		
		next_frame_to_send = 0;
		
		frame_expected = 0;
		
		nbuffered = 0;
		
		link_buffer = new Packet[WINDOW_SIZE];
		
		buffer_index = 0;
		
		network_layer = null;
		
	}
	
	public void connectNetwork(NetworkLayer networkLayer) {
		
		network_layer = networkLayer;
		
	}
	
	public void advanceBufferIndex() {
		
		buffer_index++;
		
		if(buffer_index == WINDOW_SIZE) {
			
			buffer_index = 0;
			
		}
		
	}
	
	public void advanceNextFrameToSend() {
		
		next_frame_to_send++;
		
		if(next_frame_to_send > WINDOW_SIZE) {
			
			next_frame_to_send = 0;
			
		}
		
	}
	
	public boolean bufferIsFull() {
		
		if(nbuffered == WINDOW_SIZE) {
			
			return(true);
			
		} else {
			
			return(false);
		}
		
	}
	
	public void addToBuffer(Packet packet) {
		
		link_buffer[nbuffered] = packet;
		
		System.out.println("Accepted packet " + nbuffered + " from nw layer");
		
		Packet ppkt = link_buffer[nbuffered];
		
		System.out.println(ppkt.toString());

		nbuffered++;
		
	}
	
	// get packets from network layer
	public void getPackets() {
		
		while(network_layer.packetsInBuffer() > 0) {
			
			// if buffer is full, must send a frame first
			if(bufferIsFull()) {
				
				sendDataFrame();
				
			}
			
			Packet next_packet = network_layer.nextPacket();
			
			addToBuffer(next_packet);
			
		}
		
	}
	
	// take packet and put it into a data frame with header
	public Frame makeDataFrame(Packet pkt) {
		
		Packet packet = pkt;
		
		String kind = "data";
		
		Frame frame = new Frame(next_frame_to_send, ack_expected, packet, kind);
		
		return(frame);
		
	}
	
	// send data frame from link buffer
	// advance buffer_index and next_frame_to_send
	public void sendDataFrame() {
		
		Packet next_packet = link_buffer[buffer_index];
		
		link_buffer[buffer_index] = null;
		
		Frame frame = makeDataFrame(next_packet);
		
		// print frame_report to simulate sending frame
		String frame_report = frame.toString();
		System.out.println(frame_report);
		
		advanceBufferIndex();
		
		advanceNextFrameToSend();
		
		nbuffered--;
		
	}

	static boolean between(int a, int b, int c) {
		
		if(		((a <= b) && (b < c)) || 
				((c < a) && (a <= b)) ||
				((b < c) && (c < a))) {
			
			return(true);
			
		} else {
			
			return(false);
		}
		
	}
		
}
