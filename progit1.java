package Actprog1;

import java.security.SecureRandom;
import java.util.Scanner;

public class progit1 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        SecureRandom random = new SecureRandom();

        while (true) {
            int nivel = 0;
            int aritm = 0;
            int correctAnswers = 0;
            int totalQuestions = 0;
            String[] listabuena = {"Muy bien!", "Excelente!", "Buen trabajo!", "Sigue asi!"};
            String[] listamala = {"No. Por favor, intenta de nuevo.", "Incorrecto. Intenta una vez mas.", "No te rindas.", "No. Sigue intentando."};

            System.out.println("Bienvenido");
            System.out.println("Niveles de dificultad");
            System.out.println("Nivel 1");
            System.out.println("Nivel 2");
            System.out.println("Nivel 3");
            System.out.println("Nivel 4");
            System.out.println("Nivel 5");

            System.out.println("Ingrese el nivel de dificultad: ");
            nivel = entrada.nextInt();

            System.out.println("Seleccione el tipo de problema aritmetico");
            System.out.println("1. Suma");
            System.out.println("2. Resta");
            System.out.println("3. Multiplicacion");
            System.out.println("4. Division");
            System.out.println("5. Aleatorio");

            aritm = entrada.nextInt();

            String type = getProblemType(aritm);
            if (type.equals("Desconocido")) {
                System.out.println("Tipo de problema desconocido");
                return;
            }

            System.out.println("Usted ha seleccionado el nivel: " + nivel + " del tipo: " + type);

            while (totalQuestions < 10) {
                if (aritm == 5) {
                    aritm = random.nextInt(4) + 1;
                }

                int num1 = generateNumber(nivel, random);
                int num2 = generateNumber(nivel, random);

                int answer = getAnswer(aritm, num1, num2);
                String operatorSymbol = getOperatorSymbol(aritm);

                System.out.println("Ingrese el resultado de: " + num1 + " " + operatorSymbol + " " + num2 + "?");
                int userAnswer = entrada.nextInt();

                if (userAnswer == answer) {
                    System.out.println(listabuena[random.nextInt(listabuena.length)]);
                    correctAnswers++;
                } else {
                    System.out.println(listamala[random.nextInt(listamala.length)]);
                }

                totalQuestions++;
            }

            double porcen = (double) correctAnswers / totalQuestions * 100;
            System.out.println("Rendimiento actual: " + porcen + "%");

            if (porcen < 75) {
                System.out.println("Por favor, pide ayuda adicional a tu instructor.");
            } else {
                System.out.println("Felicidades, estas listo para pasar al siguiente nivel!");
            }

            System.out.println("Deseas continuar? (s/n)");
            String continueOption = entrada.next();

            if (!continueOption.equalsIgnoreCase("s")) {
                break;
            }
        }
    }

    public static int generateNumber(int level, SecureRandom random) {
        int max = (int) Math.pow(10, level) - 1;
        int min = (int) Math.pow(10, level - 1);
        return random.nextInt(max - min + 1) + min;
    }

    public static String getOperatorSymbol(int aritm) {
        switch (aritm) {
            case 1:
                return "+";
            case 2:
                return "-";
            case 3:
                return "*";
            case 4:
                return "/";
        }
        return "";
    }

    public static int getAnswer(int aritm, int num1, int num2) {
        switch (aritm) {
            case 1:
                return num1 + num2;
            case 2:
                return num1 - num2;
            case 3:
                return num1 * num2;
            case 4:
                return num1 / num2;
        }
        return 0;
    }

    public static String getProblemType(int aritm) {
        switch (aritm) {
            case 1:
                return "Suma";
            case 2:
                return "Resta";
            case 3:
                return "Multiplicacion";
            case 4:
                return "Division";
            case 5:
                return "Aleatorio";
            default:
                return "Desconocido";
        }
    }
}