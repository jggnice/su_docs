package sortlist;


public class Person implements Comparable<Person> {
	private String name;
	private Integer order;
	public Person(){}
	public Person(String name,Integer order)
	{
		this.setName(name);
		this.setOrder(order);
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the order
	 */
	public Integer getOrder() {
		return order;
	}

	/**
	 * @param order
	 *            the order to set
	 */
	public void setOrder(Integer order) {
		this.order = order;
	}
	public String toString()
	{
		return this.getName() +" "+ this.getOrder();
	}

	@Override
	public int compareTo(Person arg0) {
		return this.getOrder().compareTo(arg0.getOrder());
	}

	/*public static void main(String[] args) {
		ArrayList<Person> listA = new ArrayList<Person>();
		Person p1 = new Person();
		Person p2 = new Person();
		Person p3 = new Person();

		p1.setName("name1");
		p1.setOrder(4);
		p2.setName("name2");
		p2.setOrder(3);
		p3.setName("name3");
		p3.setOrder(2);

		listA.add(p2);
		listA.add(p1);
		listA.add(p3);
		Collections.sort(listA);
		for (Person p : listA) {
			System.out.println(p.getName());
		}
	}*/
}