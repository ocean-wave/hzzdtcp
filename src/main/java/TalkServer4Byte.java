

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

/**
 * Created by YUAN on 2016-09-17.
 */
public class TalkServer4Byte {
    
    private ServerSocket server;
    private int port = 9066;

    public TalkServer4Byte() {
        try {
            server = new ServerSocket(port);
        } catch (IOException e) {
        }
    }

    public void talk() {
        System.out.println("监控端口：" + port);
        Socket socket = null;
        while (true) {
            try {
                // 阻塞等待，每接收到一个请求就创建一个新的连接实例
                socket = server.accept();
                System.out.println("连接客户端地址：" + socket.getRemoteSocketAddress());

                // 装饰流BufferedReader封装输入流（接收客户端的流）
                BufferedInputStream bis = new BufferedInputStream(
                        socket.getInputStream());

                DataInputStream dis = new DataInputStream(bis);
                byte[] bytes = new byte[1]; // 一次读取一个byte
                String ret = "";
                while (dis.read(bytes) != -1) {
                    ret += bytesToHexString(bytes) + " ";
                    if (dis.available() == 0) { //一个请求
                        doSomething(ret, socket);
                    }
                }

            } catch (IOException e) {
                System.out.println(e.getMessage());
            } finally {
                try {
                    socket.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        }

    }
    
    public void doSomething(String ret, Socket socket) {
        System.out.println(ret);
        String res = "6832003200680b48607e1200006000000100a416";
        try {
        	byte[] bytes = hex2byte(res);
        	System.out.println(Arrays.toString(bytes));
        	System.out.println(bytesToHexString(bytes));
			sendBytes(socket, bytes, 0, res.length() / 2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Exception ");
			e.printStackTrace();
		}
    }

    public void sendBytes(Socket socket, byte[] myByteArray, int start, int len) throws IOException {
        if (len < 0)
            throw new IllegalArgumentException("Negative length not allowed");
        if (start < 0 || start >= myByteArray.length)
            throw new IndexOutOfBoundsException("Out of bounds: " + start);
        // Other checks if needed.

        // May be better to save the streams in the support class;
        // just like the socket variable.
        OutputStream out = socket.getOutputStream();
        DataOutputStream dos = new DataOutputStream(out);

        //dos.writeInt(len);
        if (len > 0) {
            dos.write(myByteArray, start, len);
        }
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
    
    public static String BytesHexString(byte[] b) {
        String ret = "";
        for (int i = 0; i < b.length; i++) {
            String hex = Integer.toHexString(b[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            ret += hex.toUpperCase();
        }
        return ret;
    }

    public static void main(String[] args) {
        TalkServer4Byte server = new TalkServer4Byte();
        server.talk();
    }
}