import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        final int MAXNIVEL = 10;
        Scanner sc = new Scanner(System.in);
        int [] recursos = {90000, 90000};
        int ayuntamiento = 1, canion = 1;
        int costeAyuntamiento = 60000, costeCanion = 60000;
        int opcion, opcionMejora;
        int probabilidadGanar, tirada;
        String pulsador;
        char continuar;

        System.out.println("----BIENVENIDO A CLASH OF JAVA----");
        do { 
            System.out.println("--------MENU PRINCIPAL--------");
            System.out.println("1. Ver recursos");
            System.out.println("2. Ver niveles");
            System.out.println("3. Mejoras");
            System.out.println("4. Recolectar Oro");
            System.out.println("5. Recolectar Elixir");
            System.out.println("6. Batalla");
            System.out.println("7. Salir");
            System.out.print("Elige una opción: ");
            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {
                case 1:
                    System.out.println("Oro: "+recursos[0]);
                    System.out.println("Elixir: "+recursos[1]);
                    sc.nextLine(); // Estos nextLine() son para que el usuario pueda ver los recursos antes de volver al menu principal
                break;
                case 2:
                    System.out.println("Ayuntamiento: "+ayuntamiento);
                    System.out.println("Cañon: "+canion);
                    sc.nextLine();
                break;
                case 3:
                    do {
                        System.out.println("----MENU MEJORAS----");
                        System.out.println("1. Mejorar Ayuntamiento");
                        System.out.println("2. Mejorar Cañon");
                        System.out.println("3. Menu Principal");
                        opcionMejora = sc.nextInt();
                        sc.nextLine(); // Limpiar buffer

                        switch (opcionMejora) {
                            case 1:
                                if (ayuntamiento >= MAXNIVEL) {
                                    System.out.println("Has llegado al nivel máximo!");
                                }
                                else {
                                    if ((costeAyuntamiento + (ayuntamiento * 30000)) > recursos[0]){ //El (ayuntamiento * 30000) es para que el coste aumente en 30000 por cada nivel que suba
                                        System.out.println("Mejorar el ayuntamiento cuesta "+(costeAyuntamiento + (ayuntamiento * 30000))+" de Oro y solo tienes "+recursos[0]+", no puedes hacer esto");
                                        sc.nextLine(); // Limpiar buffer
                                    }
                                    else {
                                        do {
                                            System.out.println("El coste será de "+(costeAyuntamiento + (ayuntamiento * 30000))+" de Oro");
                                            System.out.println("Tienes "+recursos[0]+" de Oro");
                                            System.out.println("Seguro que quieres continuar? (S/N)");
                                            continuar = sc.next().charAt(0);

                                            if (continuar == 'S') {
                                                recursos[0] = recursos[0] - (costeAyuntamiento + (ayuntamiento * 30000));
                                                ayuntamiento++;
                                                System.out.println("Tu ayuntamiento se ha mejorado al nivel "+ayuntamiento);
                                                sc.nextLine();
                                            }
                                            else if (continuar == 'N') {
                                                System.out.println("Otra vez será...");
                                                sc.nextLine();
                                            }
                                            else {
                                                System.out.println("Esa opción no es válida, prueba otra...");
                                                sc.nextLine();
                                            }
                                        } while (continuar != 'S' && continuar != 'N');
                                    }
                                }
                            break;
                            case 2:
                                if (canion >= MAXNIVEL) {
                                    System.out.println("Has llegado al nivel máximo!");
                                }
                                else {
                                    if ((costeCanion + (canion * 30000)) > recursos[1]){
                                        System.out.println("Mejorar el cañon cuesta "+(costeCanion + (canion * 30000))+" de Elixir y solo tienes "+recursos[1]+", no puedes hacer esto");
                                        sc.nextLine();
                                    }
                                    else {
                                        do {
                                            System.out.println("El coste será de "+costeCanion+" de Elixir");
                                            System.out.println("Tienes "+recursos[1]+" de Elixir");
                                            System.out.println("Seguro que quieres continuar? (S/N)");
                                            continuar = sc.next().charAt(0);

                                            if (continuar == 'S') {
                                                recursos[1] = recursos[1] - costeCanion;
                                                canion++;
                                                System.out.println("Tu cañon se ha mejorado al nivel "+canion);
                                                sc.nextLine();
                                            }
                                            else if (continuar == 'N') {
                                                System.out.println("Otra vez será...");
                                                sc.nextLine();
                                            }
                                            else {
                                                System.out.println("Esa opción no es válida, prueba otra...");
                                                sc.nextLine();
                                            }
                                        } while (continuar != 'S' && continuar != 'N');
                                    }
                                }
                            break;
                            case 3:
                                System.out.println("Has salido al Menu Principal");
                                sc.nextLine();
                                break;
                            default:
                                System.out.println("Esa opción no es válida, pruebe otra");
                                sc.nextLine();
                            break;
                        }
                    } while (opcionMejora != 3);
                break;
                case 4: // Al pulsar intro se recolecta oro, al pulsar 1 se sale al menu principal
                    System.out.println("Pulsa intro para recolectar Oro");
                    System.out.println("Escribe 1 para salir al Menu Principal");
                    do {
                        pulsador = sc.nextLine();
                        if (pulsador.equals("1")) {
                            System.out.println("Has salido al Menú Principal...");
                            sc.nextLine();
                        }
                        else if (pulsador.isEmpty()) { // Uso el isEmpty() para que el usuario pueda pulsar intro sin escribir nada y así recolectar oro
                            System.out.println("+2500 de Oro");
                            System.out.println("Tienes "+recursos[0]+" de Oro");
                            recursos[0] = recursos[0] + 2500;
                        }
                    } while (!pulsador.equals("1"));
                break;
                case 5:
                    System.out.println("Pulsa intro para recolectar Elixir");
                    System.out.println("Escribe 1 para salir al Menu Principal");
                    do {
                        pulsador = sc.nextLine();
                        if (pulsador.equals("1")) {
                            System.out.println("Has salido al Menú Principal...");
                            sc.nextLine();
                        }
                        else if (pulsador.isEmpty()) {
                            System.out.println("+2500 de Elixir");
                            recursos[1] = recursos[1] + 2500;
                            System.out.println("Tienes "+recursos[1]+" de Elixir");
                        }
                    } while (!pulsador.equals("1"));
                break;
                case 6:
                    System.out.println("--------BATALLA--------");
                    if (recursos[1] < 10000) {
                            System.out.println("No tienes suficiente Elixir para jugar, necesitas 10000 de Elixir");
                            System.out.println("Tienes "+recursos[1]+" de Elixir");
                            System.out.println("Pulsa INTRO para volver al Menu Principal...");
                            sc.nextLine();
                        }
                    else {
                        do {
                            System.out.println("Necesitas pagar 10000 de Elixir para poder jugar");
                            System.out.println("Tienes "+recursos[1]+" de Elixir");
                            System.out.println("¿Quieres continuar? (S/N)");
                            continuar = sc.next().charAt(0);
                            sc.nextLine();
                            if (continuar == 'S') {
                                probabilidadGanar = 30 + (canion * 5); // La probabilidad de ganar es 30% + 5% por cada nivel de cañon
                                recursos[1] = recursos[1] - 10000;
                                System.out.println("Tu cañon es nivel "+canion+". Tienes un "+probabilidadGanar+"% de ganar");
                                System.out.println("Haz tu tirada...");
                                sc.nextLine();
                                tirada = (int)(Math.random() * 101);
                                if (tirada <= probabilidadGanar) {
                                    System.out.println("¡HAS GANADO!");
                                    System.out.println("Has conseguido 90000 de Oro y 90000 de Elixir");
                                    recursos[0] = recursos[0] + 90000;
                                    recursos[1] = recursos[1] + 90000;
                                }
                                else {
                                    System.out.println("Has perdido esta vez...");
                                    System.out.println("Vuelve a intenatrlo cuando quieras!!");
                                }
                                System.out.println("Pulsa INTRO para volver al Menu Principal...");
                                sc.nextLine();
                            }
                            else if (continuar == 'N') {
                                System.out.println("Otra vez será...");
                                sc.nextLine();
                            }
                            else {
                                System.out.println("Esa opción no es válida, pruebe otra...");
                                sc.nextLine();
                            }
                        } while (continuar != 'S' && continuar != 'N');
                    }  
                break;
                case 7:
                    System.out.println("Has salido del juego...");
                    sc.nextLine();
                break;
                default: //Por si pone un número que no esté en el menú principal
                    System.out.println("Esa opción no es válida, prueba otra...");
                    sc.nextLine();
                break;
            }

        } while (opcion != 7);


        sc.close();
    }
}
