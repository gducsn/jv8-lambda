package maximumGain;

public class Calc {

	public static double calcMaxGain (int risk, double capitaleDaInvestire) {
		double count = 0;
		
		switch(risk) {
		
		case 1 -> count = CalcWithRisk.risk1(capitaleDaInvestire);
		case 2 -> count = CalcWithRisk.risk2(capitaleDaInvestire);
		case 3 -> count = CalcWithRisk.risk3(capitaleDaInvestire);		
		default -> count = 0;	
		}
	
		return count;
		
	}

	
}
