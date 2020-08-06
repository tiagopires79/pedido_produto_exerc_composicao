package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Enter cliente data:");
        System.out.print("Name: ");
		String clientName = sc.nextLine();
		System.out.print("Email: ");
		String clientEmail = sc.nextLine();
		System.out.print("Birth Date (DD/MM/YYYY):");
		Date clientBirthDate = sdf.parse(sc.nextLine());
		
		
		//Instanciando Objetos
		Order order = new Order(new Date(), OrderStatus.PENDING_PAYMENT, new Client(clientName, clientEmail, clientBirthDate));
		
		System.out.println("Enter order data: ");
		order.setStatus(OrderStatus.PROCESSING);
		System.out.println("Status: " + order.getStatus());
		
		System.out.print("How many items to this order? ");
		int n = sc.nextInt();
		sc.nextLine();
		
		for (int i=1;i <=n; i++) {
			
			System.out.println("Enter #" + i + " item data: ");
			System.out.print("Product name: ");
			String productName = sc.nextLine();
			System.out.print("Product price: ");
			Double productPrice = sc.nextDouble();
			System.out.print("Quantity: ");
			Integer productQuantity = sc.nextInt();
			sc.nextLine();
			
			OrderItem item = new OrderItem(productQuantity, productPrice, new Product(productName, productPrice));
			order.addItem(item);
		}		
		
		System.out.println("ORDER SUMMARY: ");
		System.out.println(order.toString());
		for (OrderItem oi : order.getItems()) {
			System.out.println(oi.getProduct().getName() + ", $" + oi.getProduct().getPrice() + ", Quantity: " + 
		                       oi.getQuantity() + ", SubTotal: $" + oi.subTotal());
			
		}
		System.out.printf("Total Price: $ %.2f",order.total());
		sc.close();
	}

}
