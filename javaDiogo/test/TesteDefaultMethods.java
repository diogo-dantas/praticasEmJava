package br.com.git.javaDiogo.test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class TesteDefaultMethods {

	public static void main(String[] args) {

		List<String> cursos = new ArrayList<>();

		cursos.add("POO - Herança e Polimorfismo");
		cursos.add("Java 8 e implementações");
		cursos.add("API's");
		cursos.add("POO - Encapsulamento");

//		Collections.sort(cursos);
// método sort da biblioteca collections ordena por ordem alfabética		
// melhor prática aplicando um comparator ao método da lista cursos
// alterado a classificação por tamanho da string.

		Comparator<String> comparador = new comparaPorTamanho();
		cursos.sort(comparador);

//		for (String c : cursos) {
//			System.out.println(c);
//		}
// melhor prática aplicando consumer ao método de cursos...

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


class comparaPorTamanho implements Comparator<String> {

	@Override
	public int compare(String s, String s2) {
		if (s.length() > s2.length()) {
			return 1;
		}
		if (s.length() < s2.length()) {
			return -1;
		}

		return 0;

	}
}