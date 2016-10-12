package protocol_5;

import java.util.Arrays;

public class Packet {

	char[] data;
	
	public Packet(char[] passedData, int PACKET_SIZE) {

			data = Arrays.copyOf(passedData, PACKET_SIZE);
		
	}

	public char[] getData() {
		return data;
	}

	public String toString() {
		return "Packet [data="
				+ (data != null ? arrayToString(data, data.length) : null)
				+ "]";
	}

	private String arrayToString(Object array, int len) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("[");
		for (int i = 0; i < len; i++) {
			if (i > 0)
				buffer.append(", ");
			if (array instanceof char[])
				buffer.append(((char[]) array)[i]);
		}
		buffer.append("]");
		return buffer.toString();
	}
	
}
