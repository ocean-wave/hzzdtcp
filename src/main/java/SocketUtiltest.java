import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketUtiltest {

	public static void main(String[] args) {

		try {
			ServerSocket serverSocket = new ServerSocket(9066);
			System.out.println("***等待客户端连接***");
			while (true) {
				Socket socket = serverSocket.accept();
				InputStream is = socket.getInputStream();

				System.out.println("已接收到客户端连接:" + socket.getRemoteSocketAddress());
				
				byte[] datas = new byte[1024];
				int count = is.read(datas);

				int[] dataFormat = new int[count];
				for (int i = 0; i < datas.length; i++) {
					if (datas[i] < 0) {
						dataFormat[i] = datas[i] & 0xff;
					} else {
						dataFormat[i] = datas[i];
					}
					//System.out.println("已接收到客户端连接:" + dataFormat[i]);
				}
				
				for (int i = 0; i < dataFormat.length; i++) {
					System.out.print(dataFormat[i]);
					System.out.print(" ");
				}
				System.out.println("");
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
