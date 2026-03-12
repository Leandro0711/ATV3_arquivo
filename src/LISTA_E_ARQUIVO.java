import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
public class LISTA_E_ARQUIVO {
	public static void main(String[] args) {
		Scanner leitura = new Scanner(System.in);
		ArrayList<String> listaN = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			System.out.println("Digite o nome "+(i+1)+": ");
			listaN.add(leitura.nextLine());
			}
		
		 File pasta = new File("arquivo");
		 
		 if(!pasta.exists()){
			 pasta.mkdir();
			 }
		try {
			FileWriter arquivoTxt = new FileWriter("arquivo/meus_nomes.txt");
			PrintWriter gravador = new PrintWriter(arquivoTxt);
			for(String nome : listaN) {
				gravador.println(nome);
				gravador.close();
			}
			System.out.println("Os nomes foram salvos");
		
		}catch(IOException ex){
			System.out.println("Os nomes nao foram salvos" + ex.getMessage());
		}
		
	}
}
