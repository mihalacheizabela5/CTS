package ro.ase.cts.g1099.clean.code.stage7.main;

import ro.ase.cts.g1099.clean.code.stage7.models.DiscountStrategy;
import ro.ase.cts.g1099.clean.code.stage7.models.ProductType;
import ro.ase.cts.g1099.clean.code.stage7.models.marketing.MarketingStrategy;
import ro.ase.cts.g1099.clean.code.stage7.models.marketing.SummerMarketingStrategy;

public class Main {

	public static void main(String[] args) {
		
		//test DIP
		DiscountStrategy discountStrategy = 
				new DiscountStrategy();
		
		discountStrategy.setMarketingStrategy(new MarketingStrategy());
		float finalPrice = 
				discountStrategy.getFinalPrice(ProductType.ON_SALE, 1000, 10);
		System.out.println("Final price is " + finalPrice);
		
		discountStrategy.setMarketingStrategy(new SummerMarketingStrategy());
		
		finalPrice = 
				discountStrategy.getFinalPrice(ProductType.ON_SALE, 1000, 10);
		System.out.println("Final summer price is " + finalPrice);
		
	}

}