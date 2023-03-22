package itemMuW;

import java.util.ArrayList;
import java.util.Scanner;

public class ItemMuW {

	Scanner scan = new Scanner(System.in);

	int choose;
	String name;
	String type;
	int price;
	int quantity;
	String buyAll;
	int total;

	ArrayList<String> nameList = new ArrayList<String>();
	ArrayList<String> typeList = new ArrayList<String>();
	ArrayList<Integer> priceList = new ArrayList<Integer>();
	ArrayList<Integer> quantityList = new ArrayList<Integer>();

	public ItemMuW() {
		menu();

	}

	public void menu() {

		do {
			System.out.println("+========================+");
			System.out.println("|          MENU          |");
			System.out.println("+========================+");
			System.out.println("1. Insert Product");
			System.out.println("2. Buy Product");
			System.out.println("3. Exit");
			System.out.print(">> ");
			try {
				choose = scan.nextInt(); scan.nextLine();
			} catch (Exception e) {
				choose = 0;
			}
		} while (choose > 3 || choose < 1);

		if (choose == 1) {
			insert();
		} else if (choose == 2) {
			buy();
		} else if (choose == 3) {
			System.exit(0);
		}

	}

	public void insert() {

		do {
			System.out.print("Input product name [ 6 - 20 characters ] : ");
			name = scan.nextLine();
		} while (name.length() < 6 || name.length() > 20);

		do {
			System.out.print("Input product type [ Currency | Item | Account ] : ");
			type = scan.nextLine();
		} while (!type.equals("Currency") && !type.equals("Item") && !type.equals("Account"));

		do {
			System.out.print("Input product price [ 10000 - 1000000 ] : ");
			price = scan.nextInt();
		} while (price > 1000000 || price < 10000);

		do {
			System.out.print("Input product quantity [ 1 - 50 ] :");
			quantity = scan.nextInt();
		} while (quantity > 50 || quantity < 1);

		nameList.add(name);
		typeList.add(type);
		priceList.add(price);
		quantityList.add(quantity);

		System.out.println();
		System.out.println("Product added !! Press Enter to continue..");
		scan.nextLine();
		menu();

	}

	public void buy() {

		if (nameList.isEmpty()) {
			System.out.println("There's no product..");
			System.out.println("Press Enter to continue..");
			scan.nextLine();
			menu();
		} else {
			for (int i = 0; i < nameList.size(); i++) {

				int prc = priceList.get(i);
				int qty = quantityList.get(i);
				int subTotal = prc * qty;
				
				System.out.println();
				System.out.println((i + 1) + ". " + nameList.get(i) + ", " + typeList.get(i) + ", " + priceList.get(i) + ", "
						+ quantityList.get(i) + ", " + subTotal);
			}
			do {
				System.out.print("Buy All ? [ Y / N ] : ");
				buyAll = scan.nextLine();
				System.out.println();
			} while (!buyAll.equals("Y") && !buyAll.equals("N"));
		}

		if (buyAll.equals("N")) {
			menu();
		} else if (buyAll.equals("Y")) {

			for (int i = 0; i < nameList.size(); i++) {
				
				int price = priceList.get(i);
				int qty = quantityList.get(i);
				int subtotal = price * qty;
				total += subtotal;
				int discount = total * 10 / 100;
				int tax = total * 5 / 100;
				int grandTotal = total - discount + tax;
				
				System.out.println();
				System.out.println("=====================================");
				System.out.println("               Receipt               ");
				System.out.println("=====================================");
				System.out.println("Total                 : " + total);
				System.out.println("Discount [ 10% ]      : " + discount);
				System.out.println("Tax [ 5% ]            : " + tax);
				System.out.println("grandTotal            : " + grandTotal);
				System.out.println("=====================================");
				System.out.println("Thank You for purchasing !!");
				System.out.println("=====================================");
				
				nameList.clear();
				typeList.clear();
				priceList.clear();
				quantityList.clear();
				
				System.out.println("press enter to continue..");
				scan.nextLine();
				menu();
				
			}
		}
	}

	public static void main(String[] args) {
		new ItemMuW();

	}

}
