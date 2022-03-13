import java.util.Scanner;
import java.util.Random;

public class FermatsLittleTheorem{
	public boolean isPrime(long n, int iteration){
		if(n == 0 || n == 1){
			return false;
		}

		if(n == 2){
			return true;
		}

		if(n % 2 == 0){
			return false;
		}

		Random rand = new Random();

		for(int i=0; i<iteration; i++){
			long r = Math.abs(rand.nextLong());
			long a = r % (n - 1) + 1;
			if(modPow(a, n - 1, n) != 1){
				return false;
			}
		}
		return true;
	}

	public long modPow(long a, long b, long c){
		long res = 1;
		for(int i=0; i<b; i++){
			res *= a;
			res %= c;
		}
		return res % c;
	}

	public static void main (String[] args){
		Scanner scan = new Scanner(System.in);
		System.out.println("Fermat Primality Algorithm Test");
		
		FermatsLittleTheorem fl = new FermatsLittleTheorem();
		
		System.out.print("Enter number : \t");
		long num = scan.nextLong();

		System.out.print("Enter number of iterations : \t");
		int k = scan.nextInt();

		boolean prime = fl.isPrime(num, k);
		if(prime){
			System.out.println(num + " is prime");
		}else{
			System.out.println(num + " is composite");
		}
	}
}
  
