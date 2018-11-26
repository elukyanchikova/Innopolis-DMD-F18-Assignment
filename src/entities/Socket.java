package entities;

public class Socket {
	private float SocketSize;
	private String SocketShape;

	public Socket(float socketSize, String socketShape) {
		setSocketSize(socketSize);
		setSocketShape(socketShape);
	}

	public float getSocketSize() {
		return SocketSize;
	}

	public void setSocketSize(float socketSize) {
		SocketSize = socketSize;
	}

	public String getSocketShape() {
		return SocketShape;
	}

	public void setSocketShape(String socketShape) {
		SocketShape = socketShape;
	}
}
