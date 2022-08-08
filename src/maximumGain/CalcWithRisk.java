package maximumGain;

import java.util.List;
import java.util.stream.Collectors;

import nextTitle.NextTitles;
import nextTitle.TitleModel;

public class CalcWithRisk {

	private static double risk1MaxValue;
	private static double risk2MaxValue;
	private static double risk3MaxValue;

	public static double risk1(double capitaleDaInvestire) {

		List<TitleModel> risk1 = NextTitles.returnListTitles().filter(data -> data.getRisk() == 1)
				.collect(Collectors.toList());

		risk1.forEach(data -> {
			// System.out.println(data);
			risk1MaxValue += ((capitaleDaInvestire * data.getValue()) * data.getInterest() * 12) / 12;
			// Capitale Investito * Tasso di Interesse * Duration / 12
		});

		return risk1MaxValue;
	}

	public static double risk2(double capitaleDaInvestire) {

		List<TitleModel> risk2 = NextTitles.returnListTitles().filter(data -> data.getRisk() == 2)
				.collect(Collectors.toList());

		risk2.forEach(data -> {
			// System.out.println(data);
			risk2MaxValue += ((capitaleDaInvestire * data.getValue()) * data.getInterest() * 12) / 12;
		});

		return risk2MaxValue;
	}

	public static double risk3(double capitaleDaInvestire) {

		List<TitleModel> risk3 = NextTitles.returnListTitles().filter(data -> data.getRisk() == 3)
				.collect(Collectors.toList());

		risk3.forEach(data -> {
			// System.out.println(data);
			risk3MaxValue += ((capitaleDaInvestire * data.getValue()) * data.getInterest() * 12) / 12;
		});

		return risk3MaxValue;
	}

}
