package jtm.activity09;


/*-
 * Implement Iterator interface with Orders class
 * Hint! Use generic type argument of iterateable items in form: Iterator<Order>
 */

import java.util.*;

public class Orders implements Iterator<Order> {
	/*-
	 * Create data structure to hold:
	 *   1. some kind of collection of Orders (e.g. some List)
	 *   2. index to the current order for iterations through the Orders in Orders
	 *   Hints:
	 *   1. you can use your own implementation or rely on .iterator() of the List
	 *   2. when constructing list of orders, set number of current order to -1
	 *      (which is usual approach when working with iterateable collections).
	 */
	private final List<Order> orders;
	private final ListIterator<Order> iter;

	// create new empty Orders
	public Orders() {
		orders = new ArrayList<>();
		iter = orders.listIterator();
	}
	// add passed order to the Orders
	public void add(Order item) {
		iter.add(item);
		iter.previous();
	}
	// List of all customer orders
	public List<Order> getItemsList() {
		return orders;
	}
	// calculated Set of Orders from list (look at description below)
	// When implementing getItemsSet() method, join all requests for the same item from different customers
	// in following way: if there are two requests:
	// 	- ItemN: Customer1: 3
	// 	- ItemN: Customer2: 1
	// Set of orders should be:
	// 	ItemN: Customer1,Customer2: 4
	public Set<Order> getItemsSet() {
		// resulting set
		Set<Order> itemsSet = new HashSet<>();
		// unique item names
		Set<String> itemNameSet = new HashSet<>();
		for (Order order : orders) {
			itemNameSet.add(order.name);
		}
		// make a new order for each unique item name
		for (String itemName: itemNameSet) {
			// unique customers for  item
			Set<String> customers = new HashSet<>();
			// total count for item
			int count = 0;
			// find matching orders by item name
			for (Order order : orders) {
				// if item name is different - skip
				if (!itemName.equals(order.name)) {
					continue;
				}
				// add customer, total count
				customers.add(order.customer);
				count += order.count;
			}
			//sort customers
			List<String> sortedCustomers = new ArrayList<>(customers);
			Collections.reverse(sortedCustomers);
			// add new item to sets
			itemsSet.add(new Order(String.join(",", sortedCustomers), itemName, count));
		}

		// for some reason set needs to be sorted - not mentioned in reqs
		List<Order> sortedItemsSet = new ArrayList<>(itemsSet);
		Collections.sort(sortedItemsSet);
		itemsSet = new LinkedHashSet<>(sortedItemsSet);

		return itemsSet;
	}
	// sort list of orders according to the sorting rules
	// Use built in Collections.sort(...) method to sort list of orders
	public void sort() {
		Collections.sort(orders);
	}
	// check is there next Order in Orders
	public boolean hasNext() {
		return iter.hasNext();
	}
	// get next Order from Orders, throw NoSuchElementException if can't
	public Order next() {
		return iter.next();
	}
	// remove current Order (order got by previous next()) from list, throw IllegalStateException if can't
	public void remove() {
		iter.remove();
	}
	// show list of Orders as a String
	// 1. To convert Orders to String, reuse .toString() method of List.toString()
	public String toString() {
		return orders.toString();
	}
}
