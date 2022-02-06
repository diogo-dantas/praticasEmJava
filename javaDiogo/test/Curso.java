package br.com.git.javaDiogo.test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Curso {

	private String nome;
	private int alunos;

	public Curso(String nome, int alunos) {
		this.nome = nome;
		this.alunos = alunos;
	}

	public String getNome() {
		return nome;
	}

	public int getAlunos() {
		return alunos;
	}

	public static void main(String[] args) {

		List<Curso> cursos = new ArrayList<Curso>();
		cursos.add(new Curso("Python", 45));
		cursos.add(new Curso("JavaScript", 150));
		cursos.add(new Curso("Java 8", 113));
		cursos.add(new Curso("C", 55));

//		ordem decrescente de alunos 
//		cursos.sort(Comparator.comparingInt(c -> c.getAlunos()));
		cursos.sort(Comparator.comparingInt(Curso::getAlunos));

		cursos.forEach(c -> System.out.println(c.getNome()));

//		lista de cursos com mais de 50 alunos
		cursos.stream().filter(c -> c.getAlunos() > 50).forEach(c -> System.out.println(c.getNome()));

		Stream<String> nomes = cursos.stream().map(Curso::getNome);
		
		nomes.forEach(System.out::println);

//		soma de total de matriculados em cursos com classe acima de 100 alunos		

		int soma = cursos.stream().filter(c -> c.getAlunos() > 100).mapToInt(Curso::getAlunos).sum();

		System.out.println(soma);

//		lista de cursos com mais de 50 alunos, mostra quantidade de alunos
		cursos.stream().filter(c -> c.getAlunos() > 50).map(Curso::getAlunos).forEach(System.out::println);

	}
}
