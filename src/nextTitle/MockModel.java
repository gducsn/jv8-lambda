package nextTitle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MockModel {

	public static List<TitleModel> generate() {
		List<TitleModel> titles = new ArrayList<TitleModel>(11);

		TitleModel fo12 = new TitleModel("FO12", "Fondo Obbbligazionario 12M", 50000, 1.00, 12, 7, 2, 1);
		TitleModel fo24 = new TitleModel("FO24", "Fondo Obbbligazionario 24M", 50000, 1.00, 24, 8, 3, 2);
		TitleModel ai = new TitleModel("AI", "Azioni Italia", 10000, 2.00, 36, 14, 5, 3);
		TitleModel as = new TitleModel("AS", "Azioni di Enti statali", 20000, 1.00, 36, 12, 5, 3);
		TitleModel oi = new TitleModel("OI", "Obbligazioni Italia", 70000, 2.00, 24, 10, 3, 1);
		TitleModel fa = new TitleModel("FA", "Fondo Azionario", 30000, 2.00, 24, 10, 3, 2);
		TitleModel ae = new TitleModel("AE", "Azioni Estero", 5000, 2.00, 36, 15, 5, 3);
		TitleModel fm = new TitleModel("FM", "Fondo Misto", 40000, 1.50, 24, 9, 3, 2);
		TitleModel o3 = new TitleModel("OE", "Obbligazioni Estero", 60000, 1.50, 12, 6, 2, 1);
		TitleModel os = new TitleModel("OS", "Obbligazioni di Stato", 80000, 1.00, 12, 2, 2, 1);

		Collections.addAll(titles, fo12, fo24, ai, as, oi, fa, ae, fm, o3, os, null);

		return titles;

	}

}
