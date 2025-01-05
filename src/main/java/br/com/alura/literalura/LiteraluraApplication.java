package br.com.alura.literalura;

import br.com.alura.literalura.principal.Principal;
import br.com.alura.literalura.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import br.com.alura.literalura.repository.LivroRepository;

@SpringBootApplication
public class LiteraluraApplication implements CommandLineRunner{

	@Autowired
	private LivroRepository repositorio;
	@Autowired
	private AutorRepository autorRepositorio;
	public static void main(String[] args) {
		SpringApplication.run(LiteraluraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal(repositorio, autorRepositorio);
		principal.exibeMenu();
	}

//	@Override
//	public void run(String... args) throws Exception {
//		Principal principal = new Principal();
//		principal.exibeMenu();
//	}

}