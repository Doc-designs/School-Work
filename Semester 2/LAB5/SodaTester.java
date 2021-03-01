public class SodaTester 
{
	public static void main(String[] args)
	{
		Soda coke  = new Soda("Coke",35,355);
		Soda pepsi = new Soda("Pepsi",42,355);
		
		System.out.println("Sugar in Coke: " + coke.getSugar() + " grams" );
		System.out.println("Sugar in Pepsi: " + pepsi.getSugar() + " grams" );
		System.out.println(coke.compareSugar(pepsi));
		System.out.println("Expected:\nSugar in Coke: 35 grams\nSugar in Pepsi: 42 grams\nPepsi is sweeter than Coke");
		System.out.println(pepsi.compareSugar(coke));
		System.out.println("Expected:\nPepsi is sweeter than Coke");
		
		System.out.println(coke.compareSugar(coke));
		System.out.println("Expected:\nCoke has the same sweetness as Coke");
	}
}
