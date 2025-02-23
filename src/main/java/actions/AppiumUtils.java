package actions;

public class AppiumUtils {

	public Double getFormatteDouble(String amount)
	{
		Double cartSumtDouble = Double.parseDouble(amount.substring(1));
		return cartSumtDouble;
	}
	
	
	
}
