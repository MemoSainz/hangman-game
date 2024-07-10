import java.util.Scanner;

public class Hangman {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        String palabraSecreta = "favorable";
        int intentosMaximos = 10;
        int intentos = 0;
        boolean palabraAdivinada = false;

        char[] letrasAdivinadas = new char[palabraSecreta.length()];

        for (int i = 0; i < letrasAdivinadas.length; i++) {
            letrasAdivinadas[i] = '_';
        }

        while (!palabraAdivinada && intentos < intentosMaximos) {
            System.out.println("Palabra a adivinar: " + String.valueOf(letrasAdivinadas) + " ("
                    + palabraSecreta.length() + " letras)" + "   /   Word to guess:  "
                    + String.valueOf(letrasAdivinadas) + " (" + palabraSecreta.length() + " letters)");

            System.out.println("Introduce una letra.                       /   Introduce a letter.");

            char letra = Character.toLowerCase(scanner.next().charAt(0));

            boolean letraCorrecta = false;

            for (int i = 0; i < palabraSecreta.length(); i++) {
                if (palabraSecreta.charAt(i) == letra) {
                    System.out.println("");

                    letrasAdivinadas[i] = letra;
                    letraCorrecta = true;
                }
            }

            if (!letraCorrecta) {
                intentos++;
                System.out.println("");

                System.out.println("¡Incorrecto! Te quedan " + (intentosMaximos - intentos) + " intentos."
                        + "         /   " + "Wrong! You have " + (intentosMaximos - intentos) + " chances left.");
            }
            if (String.valueOf(letrasAdivinadas).equals(palabraSecreta)) {
                palabraAdivinada = true;
                System.out.println("");
                System.out.println("¡Felicidades! Haz adivinado la palabra:  " + palabraSecreta);
                System.out.println("");
                System.out.println("Congratulations! You have guessed the word:  " + palabraSecreta);
                System.out.println("");

            }

        }
        if (!palabraAdivinada) {
            System.out.println("GAME OVER");
        }

        scanner.close();
    }
}
