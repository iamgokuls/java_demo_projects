package springAnnotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Redmi implements Phone{
	
	@Value("6")
	private int RAM;
	
	@Autowired
	@Qualifier("camera48")
	private Camera CAM;
	
	@Value("K20")
	private String MODEL;
	
	public void setRAM(int rAM) {
		this.RAM = rAM;
	}



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


