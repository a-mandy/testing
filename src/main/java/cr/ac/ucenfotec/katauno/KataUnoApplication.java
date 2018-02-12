package cr.ac.ucenfotec.katauno;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KataUnoApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(KataUnoApplication.class, args);

//		int resultado = add("1,2,6,9");
		List<Integer> resul = generate(5);
		
		for(int i = 0; i < resul.size(); i += 1) {
			int value = resul.get(i);
			
			System.out.print(value + " ");
		}
		
		System.out.println();
	}
	


	public static int add(String numbers) throws Exception {
		String[] nums = numbers.split(",");
		int suma = 0;
		if (nums.length > 3) {
			throw new Exception("Muchos numeros en la hilerita");
		}
		for (int i = 0; i < nums.length; i++) {
			suma += Integer.parseInt(nums[i]);
		}
		return suma;
	}

	public static ArrayList<Integer> generate(int n) {
		ArrayList<Integer> numeros = new ArrayList<Integer>();

		while (n % 2 == 0) {
			numeros.add(2);
			n /= 2;
		}
		
		for(int i = 3; i < Math.sqrt(n);i+=2) {
			while(n%i == 0) {
				numeros.add(i);
				n /= i;
			}
		}
		
		if(n > 2) {
			numeros.add(n);
		}

		return numeros;
	}
}
