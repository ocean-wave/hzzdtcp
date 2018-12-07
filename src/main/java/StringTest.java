import java.util.Arrays;

public class StringTest {
	public static void main(String[] args) {
		String str = "683200320068c900100100000274000001005116";
		byte[] bytes = hex2byte(str);
		System.out.println(Arrays.toString(bytes));
		
		String str2 = bytesToHexString(bytes);
		System.out.println(str2);
	}

    public static String bytesToHexString(byte[] src) {
    	// System.out.println(Arrays.toString(src));
        StringBuilder stringBuilder = new StringBuilder("");
        if (src == null || src.length <= 0) {
            return null;
        }
        for (int i = 0; i < src.length; i++) {
            int v = src[i] & 0xFF;
            String hv = Integer.toHexString(v);
            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv);
        }
        return stringBuilder.toString();
    }

    
    public static byte[] hex2byte(String str) {   
    	if (str == null){
    		return null;
    	}  
    	str = str.trim();
    	int len = str.length();

    	if (len == 0 || len % 2 == 1){
    		return null;
    	}
    
    	byte[] b = new byte[len / 2];
    	try {
    		for (int i = 0; i < str.length(); i += 2) {
    			b[i / 2] = (byte) Integer.decode("0X" + str.substring(i, i + 2)).intValue();
    		}
    		return b;
    	} catch (Exception e) {
    		return null;  
    	}
    }
}
