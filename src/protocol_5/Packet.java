package protocol_5;

import java.util.Arrays;

public class Packet {

	int MAX_PKT = 4;
	
	char[] data;
	
	public Packet(char[] passed_data) {

			data = Arrays.copyOf(passed_data, MAX_PKT);
		
	}

	public int getMAX_PKT() {
		return MAX_PKT;
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
