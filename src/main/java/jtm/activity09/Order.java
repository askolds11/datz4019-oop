package jtm.activity09;


/* Hints:
 * 
 * 2. When implementing .equals() method, rely on compareTo() method, as for sane design
 * .equals() == true, if compareTo() == 0 (and vice versa).
 * 
 * 3. Also Ensure that .hashCode() is the same, if .equals() == true for two orders.
 * 
 */

import java.util.Objects;

public class Order implements Comparable<Order> {
	String customer; // Name of the customer
	String name; // Name of the requested item
	int count; // Count of the requested items

	// constructor of the Order
	public Order(String orderer, String itemName, Integer count) {
		this.customer = orderer;
		this.name = itemName;
		if (count != null) {
			this.count = count;
		}
	}

	// comparison implementation
	// 1. When comparing orders, compare their values in following order:
	// 	- Item name
	// 	- Customer name
	// 	- Count of items
	// If item or customer is closer to start of alphabet, it is considered "smaller"
	@Override
	public int compareTo(Order order) {
		int equals;
		if (name != null && order.name != null) {
			equals = name.compareTo(order.name);
			if (equals != 0) {
				return equals;
			}
		} else if (name == null && order.name != null) {
			return -1;
		} else if (name != null) {
			return 1;
		}
		if (customer != null && order.customer != null) {
			equals = customer.compareTo(order.customer);
			if (equals != 0) {
				return equals;
			}
		} else if (customer == null && order.customer != null) {
			return -1;
		} else if (customer != null) {
			return 1;
		}
		return count - order.count;
	}

	// check equality of orders
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Order order = (Order) o;
		return count == order.count && Objects.equals(customer, order.customer) && Objects.equals(name, order.name);
	}

	// to be able to handle it in some hash... collection
	@Override
	public int hashCode() {
		return Objects.hash(customer, name, count);
	}

	// string in following form: "ItemName: OrdererName: Count"
	public String toString() {
		return name + ": " + customer + ": " + count;
	}
}
