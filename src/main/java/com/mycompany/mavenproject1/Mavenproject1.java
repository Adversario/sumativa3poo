package com.mycompany.mavenproject1;

import java.util.Scanner;

public class Mavenproject1 {
    static int CANTIDAD_PROMOCION_5 = 5;
    static int CANTIDAD_PROMOCION_10 = 10;
    static double DESCUENTO_PROMOCION_5 = 0.05;
    static double DESCUENTO_PROMOCION_10 = 0.10;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String opcion;

        do {
            System.out.println("Bienvenido al Teatro Moro!");
            System.out.println("Venga a disfrutar de nuestra funcion");
            System.out.println("Que desea hacer? (1/2/3)");
            System.out.println("1. Comprar Entrada");
            System.out.println("2. Promociones");
            System.out.println("3. Salir");
            opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    comprarEntrada(scanner);
                    break;
                case "2":
                    mostrarPromociones(scanner);
                    break;
                case "3":
                    System.out.println("Gracias por visitar el Teatro Moro.");
                    break;
                default:
                    System.out.println("Opcion no válida. Por favor, elija una opción del menú.");
            }
        } while (!opcion.equals("3"));
    }

    public static void comprarEntrada(Scanner scanner) {
        String entrada, categoria, pago, continuar;
        int vip = 0, plateabaja = 0, plateaalta = 0, palcos = 0, total = 0;
        double descuento = 0;
        String ubicacion = "";
        int precioBase = 0;

        do {
            pago = "";

            System.out.println("Por favor ingresar su edad:");
            int edad = Integer.parseInt(scanner.nextLine());

            if (edad < 18) {
                entrada = "estudiante";
            } else if (edad >= 60) {
                entrada = "tercera edad";
            } else {
                entrada = "general";
            }

            System.out.println("Su edad califica como" + entrada + " para la entrada.");

            System.out.println("Que categoria necesitas?");
            System.out.println("Por favor escribir la opcion en minuscula");
            System.out.println("- Vip");
            System.out.println("- Platea baja");
            System.out.println("- Platea alta");
            System.out.println("- Palcos");

            categoria = scanner.nextLine();
            switch (categoria.toLowerCase()) {
                case "vip":
                    vip = entrada.equalsIgnoreCase("estudiante") ? 13000 : 25000;
                    total += vip;
                    ubicacion = "Zona A - Vip";
                    precioBase = entrada.equalsIgnoreCase("estudiante") ? 13000 : 25000;
                    break;
                case "platea baja":
                    plateabaja = entrada.equalsIgnoreCase("estudiante") ? 10000 : 19000;
                    total += plateabaja;
                    ubicacion = "Zona B - Platea baja";
                    precioBase = entrada.equalsIgnoreCase("estudiante") ? 10000 : 19000;
                    break;
                case "platea alta":
                    plateaalta = entrada.equalsIgnoreCase("estudiante") ? 9000 : 11000;
                    total += plateaalta;
                    ubicacion = "Zona C - Platea alta";
                    precioBase = entrada.equalsIgnoreCase("estudiante") ? 9000 : 11000;
                    break;
                case "palcos":
                    palcos = entrada.equalsIgnoreCase("estudiante") ? 6500 : 7200;
                    total += palcos;
                    ubicacion = "Zona D - Palcos";
                    precioBase = entrada.equalsIgnoreCase("estudiante") ? 6500 : 7200;
                    break;
                default:
                    System.out.println("Categoria invalida.");
                    return;
            }

            // Descuentos según edad
            if (entrada.equalsIgnoreCase("estudiante")) {
                descuento = 0.10; // Descuento estudiante
            } else if (entrada.equalsIgnoreCase("tercera edad")) {
                descuento = 0.15; // Descuento tercera edad
            }
            
            double descuentoAplicado = total * descuento;
            total -= descuentoAplicado;

            //Resumen de compra
            System.out.println("Resumen de la compra:");
            System.out.println("Ubicación del asiento: " + ubicacion);
            System.out.println("Precio base de la entrada: $" + precioBase);
            System.out.println("Descuento aplicado: " + (descuento * 100) + "%");
            System.out.println("Precio final a pagar: $" + total);

            System.out.println("Desea comprar otra entrada? (si/no)");
            continuar = scanner.nextLine();

        } while (continuar.equalsIgnoreCase("si"));

        System.out.println("Gracias por visitar el Teatro Moro.");
    }

    public static void mostrarPromociones(Scanner scanner) {
        System.out.println("Promociones disponibles:");
        System.out.println("1. 5 entradas con un 5% de descuento extra");
        System.out.println("2. 10 entradas con un 10% de descuento extra");

        System.out.println("Que descuento desea aplicar? (1/2)");
        String opcion = scanner.nextLine();

        switch (opcion) {
            case "1":
                aplicarPromocion(CANTIDAD_PROMOCION_5, DESCUENTO_PROMOCION_5);
                break;
            case "2":
                aplicarPromocion(CANTIDAD_PROMOCION_10, DESCUENTO_PROMOCION_10);
                break;
            default:
                System.out.println("Opción no válida.");
        }
    }

    public static void aplicarPromocion(int cantidad, double descuentoExtra) {
        System.out.println("Se aplicara un descuento extra del " + (descuentoExtra * 100) + "% a la compra de " + cantidad + " entradas.");
        
        //Aplicar descuentos, pendiente
    }
}
