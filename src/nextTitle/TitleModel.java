package nextTitle;

import java.util.Objects;

public class TitleModel {

	private String id;
	private String name;
	private int quantity;
	private double value;
	private int duration;
	private int interest;
	private int imin;
	private int risk;
	
	public TitleModel() {}

	public TitleModel(String id, String name, int quantity, double value, int duration,  int interest, int imin, int risk) {
		super();
		this.id = id;
		this.name = name;
		this.quantity = quantity;
		this.value = value;
		this.duration = duration;
		this.interest = interest;
		this.imin = imin;
		this.risk = risk;
	}
	
	
	
	



	@Override
	public int hashCode() {
		return Objects.hash(duration, id, imin, interest, name, quantity, risk, value);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TitleModel other = (TitleModel) obj;
		return duration == other.duration && Objects.equals(id, other.id) && imin == other.imin
				&& interest == other.interest && Objects.equals(name, other.name) && quantity == other.quantity
				&& risk == other.risk && Double.doubleToLongBits(value) == Double.doubleToLongBits(other.value);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getInterest() {
		return interest;
	}

	public void setInterest(int interest) {
		this.interest = interest;
	}

	public int getImin() {
		return imin;
	}

	public void setImin(int imin) {
		this.imin = imin;
	}

	public int getRisk() {
		return risk;
	}

	public void setRisk(int risk) {
		this.risk = risk;
	}

	@Override
	public String toString() {
		return "Titels: [id=" + id + ", name=" + name + ", duration=" + duration + ", quantity=" + quantity + ", value="
				+ value + ", interest=" + interest + ", imin=" + imin + ", risk=" + risk + "]";
	}
}