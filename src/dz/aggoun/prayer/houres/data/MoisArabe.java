package dz.aggoun.prayer.houres.data;

public enum MoisArabe   {
	janvier("janvier", "جانفي") ,	
	fevrier("février", " 	فيفري") ,	
	mars("mars", "مارس") ,	
	avril ("avril", " أفريل"),	
	mai ("mai", " ماي"),	
	juin("juin", "جوان") ,	
	juillet("juillet", "جويلية") ,	
	aout("août", " أوت") ,	
	septembre("septembre", "سبتمبر") ,	
	octobre ("octobre", "أكتوبر")	,
	novembre ("novembre", " 	نوفمبر"),	
	decembre("décembre", "ديسمبر");
	
	 private String moisF = "";
	  private String moisA = "";
	
	  MoisArabe(String moisF,String moisA){
		this.moisF=moisF;
		this.moisA=moisA;
	}
	
	public String toMoisA(){
	    return moisA;
	  }
	 
	public String toMoisF(){
	    return moisF;
	  }
}
