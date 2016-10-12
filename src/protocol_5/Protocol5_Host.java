package protocol_5;

public class Protocol5_Host {
	
	final int MAX_SEQ = 7;
	
	int next_frame_to_send;
	
	int ack_expected;
	
	int frame_expected;
	
	Frame r;
	
	Packet[] buffer;
	
	int nbuffered;
	
	int i;

	public Protocol5_Host() {
		
		ack_expected = 0;
		
		next_frame_to_send = 0;
		
		frame_expected = 0;
		
		nbuffered = 0;
		
		buffer = new Packet[MAX_SEQ];
		
		
		
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
