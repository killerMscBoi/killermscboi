import java.util.*;

	class des_ip
	{
		// Initial Permutation table
		private static final byte[] IP =
		{ 
			58, 50, 42, 34, 26, 18, 10, 2,
			60, 52, 44, 36, 28, 20, 12, 4,
			62, 54, 46, 38, 30, 22, 14, 6,
			64, 56, 48, 40, 32, 24, 16, 8,
			57, 49, 41, 33, 25, 17, 9,  1,
			59, 51, 43, 35, 27, 19, 11, 3,
			61, 53, 45, 37, 29, 21, 13, 5,
			63, 55, 47, 39, 31, 23, 15, 7
		};
		

		public static void main(String args[])
		{
			System.out.println("Enter the input as a 16 character hexadecimal value:");
			String input = new Scanner(System.in).nextLine();
			int inputBits[] = new int[64];
			for(int i=0 ; i < 16 ; i++)
			{
				String s = Integer.toBinaryString(Integer.parseInt(input.charAt(i) + "", 16));
				while(s.length() < 4)
				{
					s = "0" + s;
				}
				// Add the 4 bits we have extracted into the array of bits.
				for(int j=0 ; j < 4 ; j++)
				{
					inputBits[(4*i)+j] = Integer.parseInt(s.charAt(j) + "");
				}
			}
			permute(inputBits);
			
		}
		
		private static void permute(int[] inputBits)
		{
			int newBits[] = new int[inputBits.length];
			for(int i=0 ; i < inputBits.length ; i++)
			{
				newBits[i] = inputBits[IP[i]-1];
			}
			
			String hex = new String();
			for(int i=0 ; i < 16 ; i++)
			{
				String bin = new String();
				for(int j=0 ; j < 4 ; j++)
				{
					bin += newBits[(4*i)+j];
				}
				int decimal = Integer.parseInt(bin, 2);
				hex += Integer.toHexString(decimal);
			}
			System.out.println(hex.toUpperCase());
		}
	}
