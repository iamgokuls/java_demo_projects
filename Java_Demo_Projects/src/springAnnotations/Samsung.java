package springAnnotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;

public class Samsung implements Phone{
	
	@Value("4")
	private int RAM;
	private Camera CAM;
	
	@Value("M-30")
	private String MODEL;
	
	public void setRAM(int rAM) {
		this.RAM = rAM;
	}


	@Autowired
	@Qualifier("camera64")
	public void setCAM(Camera cAM) {
		this.CAM = cAM;
	}



	public void setMODEL(String mODEL) {
		this.MODEL = mODEL;
	}
	
	@Override
	public void showInfo() {
		System.out.println("RAM: "+this.RAM+" GB\n"+"CAM: "+this.CAM+"\nMODEL: "+this.MODEL);
	}

}
