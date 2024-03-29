package br.com.git.javaDiogo.test;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
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

	public static void demarca() {
		System.out.println("-----------------------------");
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
		demarca();

//		lista de cursos com mais de 50 alunos
		cursos.stream().filter(c -> c.getAlunos() > 50).forEach(c -> System.out.println(c.getNome()));

		Stream<String> nomes = cursos.stream().map(Curso::getNome);

		nomes.forEach(System.out::println);
		demarca();

//		soma de total de matriculados em cursos com classe acima de 100 alunos		

		int soma = cursos.stream().filter(c -> c.getAlunos() > 100).mapToInt(Curso::getAlunos).sum();

		System.out.println(soma);
		demarca();

//		lista de cursos com mais de 50 alunos, mostra quantidade de alunos
		cursos.stream().filter(c -> c.getAlunos() > 50).map(Curso::getAlunos).forEach(System.out::println);
		demarca();

// 		pegando o primeiro curso da lista filtrada de cursos com mais de 50 alunos
		Optional<Curso> primeiroCurso = cursos.stream().filter(c -> c.getAlunos() > 50).findFirst();
		System.out.println(primeiroCurso.get().nome);
		demarca();

// 		calculando a media de alunos de todos os cursos da lista
		OptionalDouble mediaAlunos = cursos.stream().mapToInt(c -> c.getAlunos()).average();
		System.out.println(" A média de alunos matriculados é de " + Math.round(mediaAlunos.getAsDouble()));
		demarca();

//		transformando um filtro stream em lista
		List<Curso> acimaDe50 = cursos.stream().filter(c -> c.getAlunos() > 50).collect(Collectors.toList());
		System.out.println("Cursos acima de 50 alunos matriculados: ");
		acimaDe50.forEach(c -> System.out.println(c.nome));
		demarca();

//		transformando um filtro stream em map
		Map<String, Integer> acimaDe100 = cursos.stream().filter(c -> c.getAlunos() > 100)
				.collect(Collectors.toMap(c -> c.getNome(), c -> c.getAlunos()));

		acimaDe100.forEach((nome, alunos) -> System.out.println("Curso: " + nome + ", possui: " + alunos + " alunos."));
		demarca();

//		ordenado por valor
		List<Entry<String, Integer>> list = new LinkedList<>(acimaDe100.entrySet());
		list.sort(Entry.comparingByValue());
		list.forEach(System.out::println);
		demarca();

		LocalDate hoje = LocalDate.now();
		System.out.println(hoje);

		LocalDate diaSolicitado = LocalDate.of(2099, 01, 25);
		System.out.println(diaSolicitado);

		Period periodo = Period.between(hoje, diaSolicitado);
		System.out.println(periodo);

		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String dataFormatada = hoje.format(formatador);
		System.out.println(dataFormatada);

	}
}
