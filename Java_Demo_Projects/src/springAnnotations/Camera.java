package springAnnotations;

public class Camera {
	
	private int RearCam;
	private int FrontCam;
	private String Sensor;
	
	
	public void setRearCam(int rearCam) {
		RearCam = rearCam;
	}
	public void setFrontCam(int frontCam) {
		FrontCam = frontCam;
	}
	public void setSensor(String sensor) {
		Sensor = sensor;
	}
	
	@Override
	public String toString() {
		return "Camera [RearCam=" + RearCam + ", FrontCam=" + FrontCam + ", Sensor=" + Sensor + "]";
	}
	
	
}
