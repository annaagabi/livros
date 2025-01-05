package br.com.alura.literalura.model;

public enum Idioma {
    en ("Ingês"),
    pt ("Português"),
    zh ("Chinês"),
    fr ("Francês"),
    es ("Espanhol"),
    nd ("Não está disponível");

    private String todosOsIdiomas;

    Idioma(String todosOsIdiomas) {
        this.todosOsIdiomas = todosOsIdiomas;
    }

    public static Idioma fromString(String text) {

        for (Idioma idioma : Idioma.values()) {

            if (idioma.todosOsIdiomas.equalsIgnoreCase(text)) {

                return idioma; // Se encontrar uma correspondência, retorna a constante do enum correspondente
            }
        }
        throw new IllegalArgumentException("Nenhuma Idioma encontrada para a string fornecida: " + text);
    }
}
