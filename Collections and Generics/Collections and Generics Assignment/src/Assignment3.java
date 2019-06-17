import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

abstract class priceable {
	public abstract double getPrice();
}

public class Assignment3<T extends priceable> implements Comparable<Assignment3>{
	
	List <T> items = new ArrayList<>();
	
	public Assignment3(List<T> items) {
		super();
		this.items = items;
	}

	public List<T> getItems() {
		return items;
	}

	public void setItems(List<T> items) {
		this.items = items;
	}
	
	public void addItems(T t) {
		this.items.add(t);
	}
	
	public double getTotal(List<T> t) {
		Iterator<T> iterator =  t.iterator();
		double sum = 0;
		while(iterator.hasNext())
		{
			sum += iterator.next().getPrice();
		}
		return sum;
	}
	public static void main(String[] args) {
		
		Car c1 = new Car("Hyundai Eon", 4.5);
		Car c2 = new Car("Tata Nano", 1.8);
		Car c3 = new Car("Ferrari Black Spider", 400);
		
		List<Car> carList1 = new ArrayList<Car>();
		carList1.add(c1);
		carList1.add(c2);
		carList1.add(c3);
		
		Assignment3<Car> b1 = new Assignment3<Car>(carList1);
		System.out.println("Cars in collection 1 are : ");
		for(Car c : b1.items) {
			System.out.println(c.toString());
		}
		System.out.println(" ");
		Car c4 = new Car("Maruti Suzuki 800", 6);
		Car c5 = new Car("Tata Sumo", 4);
		Car c6 = new Car("Porshe 911GT", 150);
		List<Car> carList2 = new ArrayList<Car>();
		carList2.add(c4);
		carList2.add(c5);
		carList2.add(c6);
		
		Assignment3<Car> b2 = new Assignment3<Car>(carList2);
		System.out.println("Cars in collection 2 are : ");
		for(Car c : b2.items) {
			System.out.println(c.toString());
		}
		System.out.println(" ");
		
		System.out.println("Calling the equals method for car collection 1 and 2 = " + b1.equals(b2));
		System.out.println("Calling the compareTo method for car collection 1 and 2 = " + b1.compareTo(b2));
		
		System.out.println(" ");
		
		System.out.println("Adding new car to collection 2");
		b2.addItems(new Car("McLaren F1c ", 246.3));
		
		System.out.println(" ");
		
		System.out.println("Calling the equals method for car collection 1 and 2 = " + b1.equals(b2));
		System.out.println("Calling the compareTo method for car collection 1 and 2 = " + b1.compareTo(b2));
	}

	@Override
	public int compareTo(Assignment3 o) {
		// TODO Auto-generated method stub
		Double sum1 = (Double)this.getTotal(this.getItems());
		Double sum2 = (Double)o.getTotal(o.getItems());
		System.out.println("Total price of car collection 1 = "+sum1 + "  and collection 2 = " + sum2);
		return sum1.compareTo(sum2);
	}
	
		
	}

class Car extends priceable{
	
	private String company;
	private double price;
	public Car(String company, double price) {
		super();
		this.company = company;
		this.price = price;
	}
	public String getCompany() {
		return company;
	}
	public void setColor(String company) {
		this.company = company;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		if (company == null) {
			if (other.company != null)
				return false;
		} else if (!company.equals(other.company))
			return false;
		if (price != other.price)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Car  from Company " + company + " has a price Rs. " + price + " Lakhs only!!!";
	}
}
