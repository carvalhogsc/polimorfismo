package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner inputData = new Scanner(System.in);
		
		List<Product> products = new ArrayList<>();
		
		System.out.print("Enter the number of products: ");
		int quantityProducts = inputData.nextInt();
		
		for(int i = 1 ; i <= quantityProducts; i++ ) {
			
			System.out.println("Product #" + i + " data:");
			System.out.print("Common, used or imported (c/u/i)? ");
			
			char typeProduct = inputData.next().charAt(0);
			
			switch (typeProduct) {
			case 'c':
			{
				System.out.print("Name: ");
				inputData.nextLine();
				String nameProduct = inputData.nextLine();
				System.out.print("Price: ");
				Double priceProduct = inputData.nextDouble();
				
				products.add(new Product(nameProduct, priceProduct));
			}
				
				break;
				
			case 'u':
			{
				System.out.print("Name: ");
				inputData.nextLine();
				String nameProduct = inputData.nextLine();
				System.out.print("Price: ");
				Double priceProduct = inputData.nextDouble();
				System.out.print("Manufacture date (DD/MM/YYYY): ");
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyy");
				Date manufactureDate = dateFormat.parse(inputData.next());
				
				products.add(new UsedProduct(nameProduct, priceProduct, manufactureDate));
			}
				
				break;
				
			case 'i':
			{
				System.out.print("Name: ");
				inputData.nextLine();
				String nameProduct = inputData.nextLine();
				System.out.print("Price: ");
				Double priceProduct = inputData.nextDouble();
				System.out.print("Customs fee: ");
				double customsFeeProduct = inputData.nextDouble();
				
				products.add(new ImportedProduct(nameProduct, priceProduct, customsFeeProduct));
			}
				
				break;
			}
			
		}
		
		System.out.println();
		System.out.println("PRICE TAGS:");		
		for(Product product : products) {
			System.out.println(product.priceTag());
		}
		
		inputData.close();
	}

}
