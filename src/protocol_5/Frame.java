package protocol_5;

public class Frame {
	
	int seq_nr;
	
	int ack_nr;
	
	Packet packet;
	
	String frame_kind;

	public Frame(int seqnr, int acknr, Packet pkt, String frkind) {
		
		seq_nr = seqnr;
		
		ack_nr = acknr;
		
		packet = pkt;
		
		frame_kind = frkind;
		
	}

	/**
	 * @return the seq_nr
	 */
	public int getSeq_nr() {
		return seq_nr;
	}

	/**
	 * @return the ack_nr
	 */
	public int getAck_nr() {
		return ack_nr;
	}

	/**
	 * @return the frame_kind
	 */
	public String getFrame_kind() {
		return frame_kind;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "Frame [seq_nr=" + seq_nr + ", ack_nr=" + ack_nr + ", packet="
				+ packet + ", frame_kind=" + frame_kind + "]";
	}
	
	

}
