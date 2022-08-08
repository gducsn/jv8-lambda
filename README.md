

La traccia richiede di scrivere due funzioni. La prima ritorna una lista 
di titoli presenti nella banca e come ultimo risultato ‘null’.
La seconda funziona richiede di ritornare il massimo guadagno che un 
cliente potrebbe ottenere investendo nei vari titoli. Ogni titolo ha una 
classe di rischio, quindi per ogni classe di rischio deve ritornare il 
massimo guadagno. 
Dobbiamo calcolare il guadagno di ognuno e sommarlo per tutte le classi 
con lo stesso rischio.

La formula è:

*`Capitale Investito * Tasso di Interesse * Duration / 12`*

La lista deve essere ritornata in ordine discendente in base al valore 
dell’interesse e tutto deve essere scritto in Java 8.

Struttura:

- nextTitle → TitleModel.java -  MockModel.java - NextTitles.java
- maximumGain → Calc.java - CalcWithRisk.java
- App.java

---

TitleModel è la classe bean che ci servirà da model per costruire i nostri 
titoli:

```java
public class TitleModel {

	private String id;
	private String name;
	private int quantity;
	private double value;
	private int duration;
	private int interest;
	private int imin;
	private int risk;

//get,set, others...
}
```

La classe MockModel contiene il metodo per creare e ritornare la lista di 
titoli:

```java
public static List<TitleModel> generate() {
		List<TitleModel> titles = new ArrayList<TitleModel>(11);

		TitleModel fo12 = new TitleModel("FO12", "Fondo 
Obbbligazionario 12M", 50000, 1.00, 12, 7, 2, 1);
		TitleModel fo24 = new TitleModel("FO24", "Fondo 
Obbbligazionario 24M", 50000, 1.00, 24, 8, 3, 2);
		TitleModel ai = new TitleModel("AI", "Azioni Italia", 
10000, 2.00, 36, 14, 5, 3);
		TitleModel as = new TitleModel("AS", "Azioni di Enti 
statali", 20000, 1.00, 36, 12, 5, 3);
		TitleModel oi = new TitleModel("OI", "Obbligazioni 
Italia", 70000, 2.00, 24, 10, 3, 1);
		TitleModel fa = new TitleModel("FA", "Fondo Azionario", 
30000, 2.00, 24, 10, 3, 2);
		TitleModel ae = new TitleModel("AE", "Azioni Estero", 
5000, 2.00, 36, 15, 5, 3);
		TitleModel fm = new TitleModel("FM", "Fondo Misto", 40000, 
1.50, 24, 9, 3, 2);
		TitleModel o3 = new TitleModel("OE", "Obbligazioni 
Estero", 60000, 1.50, 12, 6, 2, 1);
		TitleModel os = new TitleModel("OS", "Obbligazioni di 
Stato", 80000, 1.00, 12, 2, 2, 1);

		Collections.addAll(titles, fo12, fo24, ai, as, oi, fa, ae, 
fm, o3, os, null);

		return titles;

	}
```

La lista titles è una ArrayList con dimensione definita e di tipo 
‘TitleModel’. Creati tutti i titoli che le relative informazioni possiamo 
aggiungerli alla lista. 

Il metodo della classe Collections ci permette di selezionare la lista 
come primo argomento e aggiungere tutti gli elementi dal secondo argomento 
in poi. Così facendo abbiamo aggiunto tutti i nostri titoli con una sola 
linea di codice.

La classe NextTitles contiene due metodi che ci permettono di ritornare la 
lista. Il primo ci serve per poter utilizzare la lista in altre classi. Il 
secondo ritorno la lista in ordine decrescente.

```java
public static Stream<TitleModel> returnListTitles() {
		return MockModel.generate().stream().filter(data -> data 
!= null);

	}

	public static Stream<TitleModel> returnNextTitle() {

		return MockModel.generate().stream().filter(data -> data 
!= null)
				.sorted((a, b) -> b.getInterest() - 
a.getInterest());
				

	}
```

Utilizziamo gli stream. Gli stream sono una delle caratteristiche aggiunte 
in Java 8. Astraggono il concetto di flusso, ci permettono di utilizzare 
una risorsa e di applicare ad essa metodi.
I metodi sono di due tipo: intermediate - terminal.

I primi sono quelli che restituiscono, una volta operato su i dati, un 
nuovo stream. Questi metodi ci permettono di concatenare altri metodi di 
natura simile per poter poi gestire e ottenere dati nel modo che più 
preferiamo.

I secondi, detti terminali, sono quelle funzioni che restituisco il dato 
modificato dalle precedenti e che non permettono la concatenazione di 
altre funzioni.

Tra i metodi intermedi troviamo:

- map()
- filter()
- distinct()
- sorted()
- limit()
- skip()

Tra i metodi terminali troviamo:

- forEach()
- toArray()
- reduce()
- collect()
- min()
- max()
- count()
- anyMatch()
- allMatch()
- noneMatch()
- findFirst()
- findAny()

Ritornando ai due metodi, sia il primo che il secondo, devono evitare il 
valore ‘null’, altrimenti per ogni azione rischieremmo di inalzare 
l’errore ‘NullPointerException’. Possiamo utilizzare il metodo filter con 
le lambda expression.

Le lambda expression sono la forma ridotta delle classi anonime. 

Possiamo quindi dichiarare una nuova funzione in modo molto coinciso:

`() → <stuff>`

Il metodo reduce si mostra così:

```java
return MockModel.generate().stream().filter(data -> data != null);
```

Richiamiamo la lista ma ritorniamo solo e soltanto valori diversi da null.

Nella funzione filter infatti abbiamo definito un nuovo argomento ‘data’ 
(il nome potrebbe essere qualsiasi), abbiamo aggiunto la definizione di 
lamba expression ‘→) e abbiamo detto: se quel dato è diverso da null è 
true, quindi puoi restituirlo. Così facendo tutti quelli diversi da null 
saranno ritornati e avremo la lista senza errori.

Nel secondo metodo invece:

```java
.stream().filter(data -> data != null)
				.sorted((a, b) -> b.getInterest() - 
a.getInterest());
```

Oltre a filtrare quelli non ‘null’ dobbiamo ordinarli in un certo ordine. 
La bellezza delle lamba expression sta anche nel fatto di non dover 
dichiarare, per ogni argomento, il tipo in quanto è lo stesso compilatore 
a farlo. Questo processo viene detto ‘autoboxing’ del dato.

Il metodo ‘sorted’ prede in considerazione il rapporto tra due argomenti. 
In questo caso stiamo ordinando in ordine decrescente in base alle 
proprietà ‘Interest’ presente in ogni model.

---

La classe Calc nel package maximumGain ci permette di selezionare, in base 
al numero della classe di rischio, il relativo metodo che calcola il 
guadagno massimo. 

```java
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
```

Il metodo prende due argomenti, la classe di rischio e il capitale da 
investire.

Utilizziamo lo switch/case per selezionare il metodo giusto per ogni 
classe. Non utilizziamo un singolo metodo per calcolare perché ogni classe 
di rischio ha valori diversi. Così facendo abbiamo tutto separato e più 
mantenibile. 

Anche nello switch utilizziamo le lamba expression per ridurre di molto il 
codice. 

Infine il metodo ritorna il valore count che è il massimo guadagno.

L’implementazione dei metodi si trova nella classe ‘calcWithrisk’:

```java
	private static double risk1MaxValue;
	private static double risk2MaxValue;
	private static double risk3MaxValue;

	public static double risk1(double capitaleDaInvestire) {

		List<TitleModel> risk1 = 
NextTitles.returnListTitles().filter(data -> data.getRisk() == 1)
				.collect(Collectors.toList());

		risk1.forEach(data -> {
			// System.out.println(data);
			risk1MaxValue += ((capitaleDaInvestire * 
data.getValue()) * data.getInterest() * 12) / 12;
			// Capitale Investito * Tasso di Interesse * 
Duration / 12
		});

		return risk1MaxValue;
	}

	public static double risk2(double capitaleDaInvestire) {

		List<TitleModel> risk2 = 
NextTitles.returnListTitles().filter(data -> data.getRisk() == 2)
				.collect(Collectors.toList());

		risk2.forEach(data -> {
			// System.out.println(data);
			risk2MaxValue += ((capitaleDaInvestire * 
data.getValue()) * data.getInterest() * 12) / 12;
		});

		return risk2MaxValue;
	}

	public static double risk3(double capitaleDaInvestire) {

		List<TitleModel> risk3 = 
NextTitles.returnListTitles().filter(data -> data.getRisk() == 3)
				.collect(Collectors.toList());

		risk3.forEach(data -> {
			// System.out.println(data);
			risk3MaxValue += ((capitaleDaInvestire * 
data.getValue()) * data.getInterest() * 12) / 12;
		});

		return risk3MaxValue;
	}
```

Ogni metodo è più o meno simile, la differenza sta nel selezionare dalla 
lista di titoli quelli che hanno la stessa classe. Possiamo farlo 
utilizzando il metodo filter() come in precedenza.

Una volta fatto questo possiamo ciclare la lista con il forEach e sommare 
per ogni ciclo, quindi per ogni classe i vari valori così da ottenere la 
somma del massimo guadagno. Una volta finito ritorniamo il valore.

---

Infine la classe App nella quale facciamo partire i nostri metodi per 
ottenere il valore massimo di guadagno e la lista dei titoli ordinati.

```java
public static void main(String[] args) {

		System.out.println(Calc.calcMaxGain(3, 1000));
		NextTitles.returnNextTitle()
		.forEach(System.out::println);
	}
```

La linea prima stampa il risultato, la seconda itera e stampa ogni 
elemento della lista ordinata.
