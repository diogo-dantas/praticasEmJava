package br.com.git.javaDiogo.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

public class TesteDefaultMethods {

	public static void main(String[] args) {

		List<String> cursos = new ArrayList<>();

		cursos.add("POO - Herança e Polimorfismo");
		cursos.add("Java 8 e implementações");
		cursos.add("API's");
		cursos.add("POO - Encapsulamento");

		Collections.sort(cursos);

//		for (String c : cursos) {
//			System.out.println(c);
//		}
// melhor prática aplicando consumer...

		Consumer<String> curso = new imprimeLinha();
		cursos.forEach(curso);

	}

}

class imprimeLinha implements Consumer<String> {

	@Override
	public void accept(String s) {
		System.out.println(s);

	}
}
