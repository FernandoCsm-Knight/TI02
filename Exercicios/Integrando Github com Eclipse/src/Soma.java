import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Soma {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int a = Integer.parseInt(br.readLine()),
			b = Integer.parseInt(br.readLine());
		System.out.println(soma(a, b));
	}
	
	public static int soma(int a, int b) {
		return a + b;
	}
	
}
