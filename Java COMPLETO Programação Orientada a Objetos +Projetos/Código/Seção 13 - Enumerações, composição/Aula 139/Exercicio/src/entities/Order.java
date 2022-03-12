package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {

	private Date moment;
	private OrderStatus status;
	private Client client;
	private List<OrderItem> items;
	
	public Order(Date moment, OrderStatus status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
		this.items = new ArrayList<OrderItem>();
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<OrderItem> getItems() {
		return items;
	}

	@Override
	public String toString() {
		
		SimpleDateFormat sdf;
		StringBuilder sb = new StringBuilder();
		
		sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		sb.append("Order moment: " + sdf.format(moment) + "\n");
		sb.append("Order status: " + status + "\n");
		sdf = new SimpleDateFormat("dd/MM/yyyy");
		sb.append("Client: " + client.getName() + " (" 
				+ sdf.format(client.getBirthDate()) + ") - " 
				+ client.getEmail() + "\n");
		sb.append("Order items:\n");
		
		for (OrderItem item : items) {
			sb.append(item + "\n");
		}
		
		sb.append("Total price: $" + String.format("%.2f", total()) + "\n");
		
		return sb.toString();
	}
	
	public void addItem(OrderItem item) {
		items.add(item);
	}
	
	public void removeItem(OrderItem item) {
		items.remove(item);
	}
	
	public Double total() {
		Double total = 0.0;
		for (OrderItem item: items) {
			total += item.subTotal();
		}
		return total;
	}
	
}
