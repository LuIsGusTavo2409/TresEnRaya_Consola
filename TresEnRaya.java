import java.util.Scanner;

public class TresEnRaya {
  public static void miTablero(String[][] tablero){
    System.out.printf("%s | %s | %s\n", tablero[0][0], tablero[0][1], tablero[0][2]);
    System.out.println("_________");
    System.out.printf("%s | %s | %s\n", tablero[1][0], tablero[1][1], tablero[1][2]);
    System.out.println("_________");
    System.out.printf("%s | %s | %s\n", tablero[2][0], tablero[2][1], tablero[2][2]);
  }

  public static int ingresarJugada(Scanner sc){
    int jugada = sc.nextInt();
    while(jugada < 0 || jugada > 9){
      System.out.println("Ingrese una jugada adecuada (1-9)");
      jugada = sc.nextInt();
    }
    return jugada;
  }
  public static boolean heGanado(String[][] tablero, String skinIA){
    //comprobamos para filas
    int tresEnRayaCircleF = 0;
    for(int i = 0; i < 3; i++){
      boolean vacio = false, unSoloVacio = false;
      int[] paraGanar = new int[2];
      for(int u = 0; u < 3; u++){
        vacio = tablero[i][u].equals("");
        if(tablero[i][u].equals(skinIA)){
          tresEnRayaCircleF++;
        }
        if(vacio){
          paraGanar[0] = i;
          paraGanar[1] = u;
          unSoloVacio = true;
        }
      }
      if(unSoloVacio && tresEnRayaCircleF == 2){
        tablero[paraGanar[0]][paraGanar[1]] = skinIA;
        tresEnRayaCircleF++;
        break;
      }
      tresEnRayaCircleF = 0;
    }
    if(tresEnRayaCircleF == 3){
      System.out.println("He ganado humano tonto");
      return true;
    }
    //comprobamos para columnas
    int tresEnRayaCircleC = 0;
    for(int i = 0; i < 3; i++){
      boolean vacio = false, unSoloVacio = false;
      int[] paraGanar = new int[2];
      for(int u = 0; u < 3; u++){
        vacio = tablero[u][i].equals("");
        if(tablero[u][i].equals(skinIA)){
          tresEnRayaCircleC++;
        }
        if(vacio){
          paraGanar[0] = u;
          paraGanar[1] = i;
          unSoloVacio = true;
        }
      }
      if(unSoloVacio && tresEnRayaCircleC == 2){
        tablero[paraGanar[0]][paraGanar[1]] = skinIA;
        tresEnRayaCircleC++;
        break;
      }
      tresEnRayaCircleC = 0;
    }
    if(tresEnRayaCircleC == 3){
      System.out.println("He ganado humano tonto");
      return true;
    }
    //comprobamos para diagonal
    int tresEnRayaD = 0;
    boolean unSoloVacio = false;
    int[] paraGanar = new int[2];
    for(int i = 0; i < 3; i++){
      boolean vacio = tablero[i][i].equals("");
      if(tablero[i][i].equals(skinIA)){
        tresEnRayaD++;
      }
      if(vacio){
        paraGanar[0] = i;
        paraGanar[1] = i;
        unSoloVacio = true;
      }
    }
    if(unSoloVacio && tresEnRayaD == 2){
      tablero[paraGanar[0]][paraGanar[1]] = skinIA;
      System.out.println("He ganado humano tonto");
      return true;
    }
    //para segunda diagonal
    int tresEnRayaD1 = 0;
    int[] paraGanarD1 = new int[2];
    boolean vacio = false;
    if(tablero[0][2].equals(skinIA)){
      tresEnRayaD1++;
    }
    if(tablero[0][2].equals("")){
      vacio = true;
      paraGanarD1[0] = 0;
      paraGanarD1[1] = 2;
    }
    if(tablero[1][1].equals(skinIA)){
      tresEnRayaD1++;
    }
    if(tablero[1][1].equals("")){
      vacio = true;
      paraGanarD1[0] = 1;
      paraGanarD1[1] = 1;
    }
    if(tablero[2][0].equals(skinIA)){
      tresEnRayaD1++;
    }
    if(tablero[2][0].equals("")){
      vacio = true;
      paraGanarD1[0] = 2;
      paraGanarD1[1] = 0;
    }
    if(vacio && tresEnRayaD1 == 2){
      tablero[paraGanarD1[0]][paraGanarD1[1]] = skinIA;
      System.out.println("He ganado humano tonto");
      return true;
    }
    return false;
  }
  public static boolean heEvitado(String[][] tablero, String skinJugador, String skinIA){
    //comprobamos para filas
    int listoParaGanarF = 0;
    for(int i = 0; i < 3; i++){
      boolean vacio = false, unSoloVacio = false;
      int[] evitar = new int[2];
      for(int u = 0; u < 3; u++){
        vacio = tablero[i][u].equals("");
        if(tablero[i][u].equals(skinJugador)){
          listoParaGanarF++;
        }
        if(vacio){
          evitar[0] = i;
          evitar[1] = u;
          unSoloVacio = true;
        }
      }
      if(unSoloVacio && listoParaGanarF == 2){
        tablero[evitar[0]][evitar[1]] = skinIA;
        return true;
      }
      listoParaGanarF = 0;
    }
    //comprobamos para columnas
    int listoParaGanarC = 0;
    for(int i = 0; i < 3; i++){
      boolean vacio = false, unSoloVacio = false;
      int[] evitar = new int[2];
      for(int u = 0; u < 3; u++){
        vacio = tablero[u][i].equals("");
        if(tablero[u][i].equals(skinJugador)){
          listoParaGanarC++;
        }
        if(vacio){
          evitar[0] = u;
          evitar[1] = i;
          unSoloVacio = true;
        }
      }
      if(unSoloVacio && listoParaGanarC == 2){
        tablero[evitar[0]][evitar[1]] = skinIA;
        return true;
      }
      listoParaGanarC = 0;
    }
    //para la diagonal principal
    int listoParaGanarD = 0;
    boolean unSoloVacio = false;
    int[] evitar = new int[2];
    for(int i = 0; i < 3; i++){
      boolean vacio = tablero[i][i].equals("");
      if(tablero[i][i].equals(skinJugador)){
        listoParaGanarD++;
      }
      if(vacio){
        evitar[0] = i;
        evitar[1] = i;
        unSoloVacio = true;
      }
    }
    if(unSoloVacio && listoParaGanarD == 2){
      tablero[evitar[0]][evitar[1]] = skinIA;;
      return true;
    }
    //para segunda diagonal
    int listoParaGanarD1 = 0;
    int[] evitarD1 = new int[2];
    boolean vacio = false;
    if(tablero[0][2].equals(skinJugador)){
      listoParaGanarD1++;
    }
    if(tablero[0][2].equals("")){
      vacio = true;
      evitarD1[0] = 0;
      evitarD1[1] = 2;
    }
    if(tablero[1][1].equals(skinJugador)){
      listoParaGanarD1++;
    }
    if(tablero[1][1].equals("")){
      vacio = true;
      evitarD1[0] = 1;
      evitarD1[1] = 1;
    }
    if(tablero[2][0].equals(skinJugador)){
      listoParaGanarD1++;
    }
    if(tablero[2][0].equals("")){
      vacio = true;
      evitarD1[0] = 2;
      evitarD1[1] = 0;
    }
    if(vacio && listoParaGanarD1 == 2){
      tablero[evitarD1[0]][evitarD1[1]] = skinIA;
      return true;
    }
    return false;
  }
  public static boolean loPuseEsquina(String[][] tablero, String skinIA){
    if(tablero[0][0].equals("")){
      tablero[0][0] = skinIA;
      return true;
    }
    if(tablero[0][2].equals("")){
      tablero[0][2] = skinIA;
      return true;
    }
    if(tablero[2][0].equals("")){
      tablero[2][0] = skinIA;
      return true;
    }
    if(tablero[2][2].equals("")){
      tablero[2][2] = skinIA;
      return true;
    }
    return false;
  }
  public static boolean loPuseCentro(String[][] tablero, String skinIA){
    if(tablero[1][1].equals("")){
      tablero[1][1] = skinIA;
      return true;
    }
    return false;
  }
  public static boolean loPuseLado(String[][] tablero, String skinIA){
    if(tablero[0][1].equals("")){
      tablero[0][1] = skinIA;
      return true;
    }
    if(tablero[1][0].equals("")){
      tablero[1][0] = skinIA;
      return true;
    }
    if(tablero[1][2].equals("")){
      tablero[1][2] = skinIA;
      return true;
    }
    if(tablero[2][1].equals("")){
      tablero[2][1] = skinIA;
      return true;
    }
    return false;
  }

  public static boolean juegoTerminado(String[][] tablero, String skinIA, String skinJugador){
    boolean gane = heGanado(tablero, skinIA);
    if(gane)
      return true;
    boolean evitado = heEvitado(tablero, skinJugador, skinIA);
    if(evitado)
      return false;
    boolean esquinaLibre = loPuseEsquina(tablero, skinIA);
    if(esquinaLibre)
      return false;
    boolean centroVacio = loPuseCentro(tablero, skinIA);
    if(centroVacio)
      return false;
    boolean ladoLibre = loPuseLado(tablero, skinIA);
    if(ladoLibre)
      return false;
    System.out.println("Es un empate! Sabes pensar humano");
    return true;
  }
  public static boolean recibiJugada(Scanner sc, String[][] tablero, String skinJugador){
    int jugada = ingresarJugada(sc) - 1;
    if(tablero[jugada / 3][jugada % 3].equals(""))
      tablero[jugada / 3][jugada % 3] = skinJugador;
    else{
      miTablero(tablero);
      System.out.println("Ingresa una posicion adecuada");
      return recibiJugada(sc, tablero, skinJugador);
    }
    return true;
  }
  public static String elegirSkin(Scanner sc){
    System.out.println("Ingrese su skin (X / O)");
    String skin = sc.next().toUpperCase();
    while(!skin.equals("X") && !skin.equals("O")){
      System.out.println("Ingrese una skin correcta");
      skin = sc.next().toUpperCase();
    }
    return skin;
  }
  public static void jugar(){
    System.out.println("Juguemos tres en raya!!");
    Scanner sc = new Scanner(System.in);
    String[][] tablero = {{"", "", ""}, {"", "", ""}, {"", "", ""}};
    System.out.println("Escoge tu skin");
    String skinJugador = elegirSkin(sc);
    String skinIA = "";
    if(skinJugador.equals("X")){
      skinIA = "O";
    }else{
      skinIA = "X";
    }
    do{
      miTablero(tablero);
      System.out.println("Ingresa tu jugada");
      recibiJugada(sc, tablero, skinJugador);
    }while(!juegoTerminado(tablero, skinIA, skinJugador));
    miTablero(tablero);
    System.out.println("GRACIAS POR JUGAR!!");
  }
  public static void main(String[] args){
    jugar();
  }
}
