import maximumGain.Calc;
import nextTitle.NextTitles;

public class App {

	public static void main(String[] args) {

		System.out.println(Calc.calcMaxGain(3, 1000));
		NextTitles.returnNextTitle()
		.forEach(System.out::println);
	}

}