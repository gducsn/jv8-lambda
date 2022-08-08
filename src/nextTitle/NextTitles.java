package nextTitle;

import java.util.stream.Stream;

public class NextTitles {

	public static Stream<TitleModel> returnListTitles() {
		return MockModel.generate().stream().filter(data -> data != null);

	}

	public static Stream<TitleModel> returnNextTitle() {

		return MockModel.generate().stream().filter(data -> data != null)
				.sorted((a, b) -> b.getInterest() - a.getInterest());
				

	}

}
