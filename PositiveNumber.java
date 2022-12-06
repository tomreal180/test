package hausaufgabe9;

public class PositiveNumber {
	//Attribut
	private int value;
	public void setDecimal(String s) {
		boolean check=true;
		for (int i=0;i<=s.length()-1;i++) {
			char cha=s.charAt(i);
			if ((int) cha<48 ||(int) cha>57) {
				check=false;
				break;
			}
		
		if (check) {
			this.value=Integer.parseInt(s);
		}else {
			throw new NumberFormatException("Fehler:Das Charakter ist unmöglich");
		}
		
		if (this.value<0 || this.value>Integer.MAX_VALUE) {//Exception
			throw new ArithmeticException("Fehler:Die Zahl ist unmöglich");
		}
		
		}
	}
	public void setBinary(String s) {
		this.value=0;
		int length=s.length()-1;//Index
		for (int i=0;i<=length;i++) {
			//überprüfen jedes Charakter in String
			char cha=s.charAt(length-i);
			if ((int) cha!=48 && (int) cha!=49) {
				throw new NumberFormatException("Fehler:Das Charakter ist unmöglich");
			}else {
				int num=Integer.parseInt(""+cha);
				this.value+=num*Math.pow(2,i);//value+=nummer*16^(von 0 bis Länger-1)
			}	
		}
		if (this.value<0 || this.value>Integer.MAX_VALUE) {//Exception
			throw new ArithmeticException("Fehler:Die Zahl ist unmöglich");
		}
	}
	
	public void setHexadecimal(String s) {
		this.value=0;
		s.toLowerCase();//nehmen nur kleines Charakter nehmen
		int length=s.length()-1,num;//Index
		for (int i=0;i<=length;i++) {
			//überprüfen jedes Charakter in String
			char cha=s.charAt(length-i);
			if (cha=='a'){
				num=10;
			}else if((int) cha>102 || (int) cha<48||((int) cha>57&&(int) cha<97)) {//Exception
				throw new NumberFormatException("Fehler:Das Charakter ist unmöglich");
			}else if(cha=='b') {
				num=11;
			}else if(cha=='c') {
				num=12;
			}else if(cha=='d') {
				num=13;
			}else if(cha=='e') {
				num=14;
			}else if(cha=='f') {
				num=15;
			}else {
				num=Integer.valueOf(i);
			}
			this.value+=num*Math.pow(16,i);//value+=nummer*16^(von 0 bis Länger-1)	
		}
		if (this.value<0 || this.value>Integer.MAX_VALUE) {//Exception
			throw new ArithmeticException("Fehler:Die Zahl ist unmöglich");
		}
	}
	
	public String getDecimal() {
		return ""+value;
	}
	
	public String getBinary() {
		String res=""+(this.value%2);
		this.value=this.value/2;
		if (this.value==0) {
			return res ;
		}else {
			return (getBinary()+res).toUpperCase();
		}
	}
	
	public String getHexadecimal() {
		int num=value%16;
		String res="";
		if (num==10) {
			res+="a";
		}else if (num==11) {
			res+="b";
		}else if (num==12) {
			res+="c";
		}else if (num==13) {
			res+="d";
		}else if (num==14) {
			res+="e";
		}else if (num==15) {
			res+="f";
		}else {
			res+=String.valueOf(num);
		}
		this.value=this.value/16;
		if (this.value!=0) {
			return (getHexadecimal()+res).toUpperCase() ;
		}else {
			return res;
		}
	}

}
