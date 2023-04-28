package novedadesjava;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import novedadesjava.interfaces.IDefaultMetodo;
import novedadesjava.interfaces.IMetodoStatic;
import novedadesjava.interfaces.IServicesNovedades;
import novedadesjava.interfaces.IStatictInf;
import novedadesjava.services.ServicesApiFecha;
import novedadesjava.services.ServicesNovedades;

/**
 *
 * @author kgalarza
 */
public class NovedadesJava {

    public static void main(String[] args) {

        try {
            ServicesNovedades serviceNo = new ServicesNovedades();
            Scanner entrada = new Scanner(System.in);
            int op;
            do {
                System.out.println("=============================================");
                System.out.println("Menu");
                System.out.println("1.-Api de fecha");
                System.out.println("2.-Manejo con optional");
                System.out.println("3.-Motor de js");
                System.out.println("4.-Demo Programación Reactiva");
                System.out.println("5.-Interfaz funcional");
                System.out.println("6.-Uso de Stream");
                System.out.println("7.-Prueba de ejecuciones al futuro");
                System.out.println("8.-Metodos Default Interface");
                System.out.println("9.-Información de la licencia de Java 17 (Método Static)");
                System.out.println("10.-Información Wildfly vs JDK 8(Método Static)");
                System.out.println("0.-Salir");
                op = entrada.nextInt();
                switch (op) {
                    case 0:
                        System.out.println("Chao");
                        break;
                    case 1:
                        System.out.println("-------------INIT----------------");
                        System.out.println("Api de fecha");
                        ServicesApiFecha apiFecha = new ServicesApiFecha();
                        System.out.println("Fecha actual: " + apiFecha.getFechaActual());
                        System.out.println("Fecha Hora actual: " + apiFecha.getFechaHoraActual());
                        System.out.println("Día de la semana de hoy: " + apiFecha.getDiaSemanaActual());
                        System.out.println("-------------FIN------------------");
                        break;
                    case 2:
                        System.out.println("-------------INIT----------------");
                        System.out.println("Manejo con optional");
                        IServicesNovedades serviceNo2 = new ServicesNovedades();
                        System.out.println("resp data " + serviceNo2.getRepoData());
                        System.out.println("resp no data (null)" + serviceNo2.getRepoNoData());
                        System.out.println("-------------FIN------------------");
                        break;
                    case 3:
                        System.out.println("-------------INIT----------------");
                        System.out.println("motor de js:");
                        serviceNo.useNashorn();
                        System.out.println("-------------FIN------------------");
                        break;
                    case 4:
                        System.out.println("-------------INIT----------------");
                        System.out.println("Demo Programación Reactiva");
                        serviceNo.getDemoProgramacionReactiva();
                        System.out.println("-------------FIN------------------");
                        break;
                    case 5:
                        System.out.println("-------------INIT----------------");
                        System.out.println("Interfaz funcional " + serviceNo.calcular(550, 15));
                        System.out.println("-------------FIN------------------");
                        break;
                    case 6:
                        System.out.println("-------------INIT----------------");
                        System.out.println("Uso de Stream");
                        serviceNo.getUseStream();
                        System.out.println("-------------FIN------------------");
                        break;
                    case 7:
                        System.out.println("-------------INIT----------------");
                        System.out.println("Prueba de ejecuciones al futuro");
                        CompletableFuture<String> future = serviceNo.CompletableFuture();

                        // Continuar haciendo otras tareas mientras esperamos el resultado de longRunningOperation()
                        System.out.println("Continuando con otras tareas...");

                        // Obtener el resultado de longRunningOperation() cuando esté listo
                        try {
                            String resultado = future.get();
                            System.out.println("El resultado es: " + resultado);
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                        System.out.println("-------------FIN------------------");
                        break;
                    case 8:
                        System.out.println("-------------INIT----------------");
                        System.out.println("Metodo por default");
                        IDefaultMetodo service = new ServicesNovedades();
                        service.defResultado("S", 10, 15);
                        service.defResultado("R", 20, 15);
                        System.out.println("-------------FIN------------------");
                        break;
                    case 9:
                        System.out.println("-------------INIT----------------");
                        IMetodoStatic.getInfLicenciaJdk17();
                        System.out.println("-------------FIN------------------");
                        break;
                    case 10:
                        System.out.println("-------------INIT----------------");
                        IStatictInf.getInfWildflyVesrion();
                        System.out.println("-------------FIN------------------");
                        break;
                    default:
                        System.out.println("-------------INIT----------------");
                        System.out.println("No existe la opción");
                }
            } while (op != 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
