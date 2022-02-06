package br.com.git.javaDiogo.test;

import java.util.ArrayList;
import java.util.List;

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

		cursos.sort((s, s2) -> Integer.compare(s.length(), s2.length()));

//		for (String c : cursos) {
//			System.out.println(c);
//		}
// melhor prática aplicando consumer ao método de cursos...

		cursos.forEach(s -> System.out.println(s));

	}

}
