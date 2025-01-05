package br.com.alura.literalura.principal;

import br.com.alura.literalura.dto.LivroDTO;
import br.com.alura.literalura.model.*;
import br.com.alura.literalura.repository.AutorRepository;
import br.com.alura.literalura.repository.LivroRepository;
import br.com.alura.literalura.service.ConsumoApi;
import br.com.alura.literalura.service.ConverteDados;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Principal { // Remove abstract keyword if it exists
    private Scanner leitura = new Scanner(System.in);
    private ConsumoApi consumo = new ConsumoApi();
    private ConverteDados conversor = new ConverteDados();
    private final String ENDERECO = "https://gutendex.com/books?search=";
    private List<DadosLivros> dadosLivros = new ArrayList<>();
    private List<DadosAutor> dadosAutores = new ArrayList<>();
    private LivroRepository repositorio;
    private AutorRepository autorRepositorio;

    private List<Livros> livros;
    private List<Autor> autores;

    public Principal(LivroRepository repositorio, AutorRepository autorRepositorio) {
        this.repositorio = repositorio;
        this.autorRepositorio = autorRepositorio;
    }

    public void exibeMenu() { // Implement the method here
        var opcao = -1;

        while (opcao != 0) {

            var menu = """
                        1 - Buscar livro pelo titulo
                        2 - Listar livros registrados
                        3 - Listar autores registrados
                        4 - Listar autores vivos em um determinado ano
                        5 - Listar livros em um determinado idioma
                        
                        0 - Sair
                                
                    """;

            System.out.println(menu);
            opcao = leitura.nextInt();
            leitura.nextLine();

            switch (opcao) {
                case 1:
                     buscarLivroPeloTitulo();
                    break;
                case 2:
                    // Implement logic for case 2 (listarLivros)
                    break;
                case 3:
                    listarAutores();
                    break;
                case 4:
                    // Implement logic for case 4 (listarAutoresVivos)
                    break;
                case 5:
                    // Implement logic for case 5 (listarLivrosEmIdioma)
                    break;
                case 0:
                    System.out.println("\nSaindo...");
                    break;
                default:
                    System.out.println("\nOpção inválida");
            }
        }
    }

    private Autor salvarAutor(DadosAutor dadosAutor) {
        return autorRepositorio.findByNomeContainingIgnoreCase(dadosAutor.nome())
                .orElseGet(() -> {
                    Autor novoAutor = new Autor(dadosAutor);
                    return autorRepositorio.save(novoAutor); // Aqui salvamos o Autor
                });
    }
//
//    private void listarAutores() {
//        DadosAutor dados = getDadosAutor();
//        Autor autor = new Autor(dados);
//        repositorio.save(autor);
//        System.out.println(dados);
//    }
//
//    private DadosAutor getDadosAutor() {
//        System.out.println("\nDigite o nome do autor para busca: ");
//        var nomeAutor = leitura.nextLine();
//        var json = consumo.obterDados(ENDERECO + nomeAutor.replace(" ", "%20"));
//        DadosAutor dados = conversor.obterDados(json, DadosAutor.class);
//        return dados;
//    }
//
//    private DadosLivros buscarLivroPeloTitulo(){
//        System.out.println("\nDigite o nome do livro: ");
//        var nomeLivro = leitura.nextLine();
//
//        var json = consumo.obterDados(ENDERECO + nomeLivro.replace(" ", "%20"));
//        DadosLivros dados = conversor.obterDados(json, DadosLivros.class);
//        return dados;
//
//    }

//    private void buscarLivroPeloTitulo() {
//        System.out.println("\nDigite o nome do livro: ");
//        var nomeLivro = leitura.nextLine();
//
//        var json = consumo.obterDados(ENDERECO + "?search=" + nomeLivro.replace(" ", "%20"));
//        DadosLivros dados = conversor.obterDados(json, DadosLivros.class);
//
//        if (dados != null) {
//            Livros livro = new Livros(dados);
//            repositorio.save(livro); // Usando a instância 'repositorio' para salvar
//            System.out.println("\nLivro salvo com sucesso: " + livro);
//        } else {
//            System.out.println("\nLivro não encontrado.");
//        }
//    }

//    private void buscarLivroPeloTitulo() {
//        System.out.println("\nDigite o nome do livro: ");
//        var nomeLivro = leitura.nextLine();
//        try {
//            // Buscar si el libro ya existe en la base de datos
//            List<Livros> livro = repositorio.findByTituloContainingIgnoreCase(nomeLivro);
//
////            if (livro.isPresent()) {
////                System.out.println("Livro já cadastrado!");
////            }
//
//            var json = consumo.obterDados(ENDERECO + nomeLivro.replace(" ", "%20"));
//            System.out.println(json);
//
//            LivroDTO dados = conversor.obterDados(json, LivroDTO.class);
//
//            Optional<Autor> autorExistente = autorRepositorio.findByNomeContainingIgnoreCase(dados);
//            Autor autor;
//            if (autorExistente.isPresent()) {
//                autor = autorExistente.get();
//            } else {
//                autor = new Autor(dados.autores().get(0)); // Certifique-se de que `autores()` está disponível no DTO
//                autor = autorRepositorio.save(autor);
//            }
//
//            Livros livros = new Livros(dados);
//
//            livros.setAutor(autor);
//
//            // Guardar el libro en la base de datos (el autor se guarda automáticamente por cascada)
//            repositorio.save(livro);
//            System.out.println("Libro guardado con éxito.");
//
////        } catch (LibroDuplicadoException e) {
////            System.out.println(e.getMessage());
//        } catch (Exception e) {
//            System.out.println("Ha ocurrido un error: " + e.getMessage());
//        }
//    }

    private void buscarLivroPeloTitulo(){
        System.out.println("Ingrese el nombre del libro que desea agregar:");
        var tituloLibro = leitura.nextLine();
        var json = consumo.obterDados(ENDERECO + tituloLibro.replace(" ", "%20"));
        guardarDados(json);
    }

    private void guardarDados(String json) {
        try {
            DadosAutor dadosAutor = conversor.obterDados(json, DadosAutor.class);
            DadosLivros dadosLivro = conversor.obterDados(json, DadosLivros.class);

            Autor autor = autorRepositorio.findByNomeContainingIgnoreCase(dadosAutor.nome())
                    .orElseGet(() -> autorRepositorio.save(new Autor(dadosAutor)));
            //Verifica si el libro ya existe
            if (repositorio.findByTituloContainingIgnoreCase(dadosLivro.titulo()).isEmpty()) {
                Livros livro = new Livros(dadosLivro);
                livro.setAutor(autor);
                repositorio.save(livro);
                System.out.println(livro);
                System.out.println("Libro agregado con exito");

            }else {
                System.out.printf("---------------------------------------------\n");
                System.out.println("El libro ya se encuntra registrado");
            }
        }catch (NullPointerException e) {
            System.out.printf("---------------------------------------------\n");
            System.out.println("Libro no encontrado");
        }
    }

    private void listaLivros() {
        livros = repositorio.findAll();
        livros.stream().forEach(System.out::println);
    }

//private DadosLivros buscarLivroPeloTitulo() {
//    System.out.println("\nDigite o nome do livro: ");
//        var nomeLivro = leitura.nextLine();
//
//        var json = consumo.obterDados(ENDERECO + "?search=" + nomeLivro.replace(" ", "%20"));
//        DadosLivros dados = conversor.obterDados(json, DadosLivros.class);
//        return dados;
//
//}

    private void listarLivros() {
        var livros = repositorio.findAll(); // Usando a instância 'repositorio' para buscar
        if (livros.isEmpty()) {
            System.out.println("\nNenhum livro encontrado.");
        } else {
            livros.forEach(System.out::println);
        }
    }


//    private void listarAutoresVivos() {
//        System.out.println("\nDigite o ano: ");
//        var ano = leitura.nextInt();
//        leitura.nextLine();
//
//        var autores = autorRepositorio.findByDataMorteIsNullAndDataNascimentoIsNotNull();
//        autores.stream()
//                .filter(autor -> autor.getDataNascimento().getYear() <= ano)
//                .forEach(System.out::println);
//    }

    private void listarAutores() {
        var autores = autorRepositorio.findAll(); // Usando a instância 'autorRepositorio' para buscar
        if (autores.isEmpty()) {
            System.out.println("\nNenhum autor encontrado.");
        } else {
            autores.forEach(System.out::println);
        }
    }

    private void listarAutoresVivos() {
        var autores = autorRepositorio.findByDataMorteIsNullAndDataNascimentoIsNotNull();
        if (autores.isEmpty()) {
            System.out.println("\nNenhum autor vivo encontrado.");
        } else {
            autores.forEach(System.out::println);
        }
    }

    private void listarLivrosEmIdioma() {
        System.out.println("\nDigite o idioma (en, pt, zh, fr, es): ");
        var idiomaStr = leitura.nextLine();
        try {
            var idioma = Idioma.valueOf(idiomaStr.toUpperCase());
            var livros = repositorio.findByIdioma(idioma); // Usando a instância 'repositorio' para buscar
            if (livros.isEmpty()) {
                System.out.println("\nNenhum livro encontrado para o idioma: " + idiomaStr);
            } else {
                livros.forEach(System.out::println);
            }
        } catch (IllegalArgumentException e) {
            System.out.println("\nIdioma inválido.");
        }
    }
}