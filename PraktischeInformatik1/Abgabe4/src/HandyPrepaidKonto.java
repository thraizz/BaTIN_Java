
public class HandyPrepaidKonto {
	public double guthaben;
	
	public HandyPrepaidKonto(){
		guthaben = 10.0;
	}
	
	public HandyPrepaidKonto(double uebergebenesGuthaben) {
		guthaben = uebergebenesGuthaben;
	}
	
	public void aufladen(int option) {
		if(option==1 || option == 2 || option==3) {
			if(option==1) {
				guthaben=guthaben+2.00;
			}
			if(option==2) {
				guthaben=guthaben+5.00;
			}
			if(option==3) {
				guthaben=guthaben+10.00;
			}			
		}
	}

	public boolean SmsAbbuchen() {
		if(guthaben-0.03<0) {
			return false;
		}
		else{
			guthaben=guthaben-0.03;
			return true;
		}
	}
	
	public boolean GespraechAbbuchen(int gespraechsDauer) {
		double kosten = (double) (0.04/60)*gespraechsDauer;
		if(guthaben-kosten<0) {
			return false;
		}
		else{
			guthaben=guthaben-kosten;
			return true;
		}
	}
	
	public double GuthabenAbfragen() {
		return guthaben;
	}
	
	public int VerbleibendeSms() {
		int verbleibendeSms = (int) (guthaben / 0.03);
		return verbleibendeSms;
	}
	
	public int VerbleibendeGespraechssekunden() {
		int verbleibendeSekunden = (int) (guthaben / (0.04/60));
		return verbleibendeSekunden;
	}	

	
}
