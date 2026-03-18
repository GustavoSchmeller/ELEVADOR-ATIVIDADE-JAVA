import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Elevador ambiente1 = new Elevador((byte) 1, true);

        while (true){

            System.out.println("\n--------| 1 - Subir andar \n--------| 2 - Descer andar \n--------| 3 - Abrir a porta \n--------| 4 - Fechar a porta\n");
            ambiente1.getStatusAndar();
            System.out.print("\nOpção desejada: ");

            try {
                byte opcaoEscolhida = scanner.nextByte();
                System.out.println("\n-----------------\n");

                switch (opcaoEscolhida){

                    case 1:
                        ambiente1.subirAndar();
                        break;

                    case 2:
                        ambiente1.descerAndar();
                        break;

                    case 3:
                        ambiente1.abrirPorta();
                        break;

                    case 4:
                        ambiente1.fecharPorta();
                        break;

                    default:
                        System.out.println("(OPERACÃO CANCELADA) - Opção inválida.");
                        break;
                }

            } catch (Exception E) {
                scanner.next();
                System.out.println("(OPERACÃO CANCELADA) - O valor precisa ser um numero inteiro e ser composto de no máximo 1 byte");
            }
        }
    }
}

class Elevador {
    private byte elevadorAndar;
    private boolean portaAberta;

    // CONSTRUCTOR

    public Elevador(byte andar, boolean portaAberta) {
        this.elevadorAndar = andar;
        this.portaAberta = portaAberta;
    }

    // ANDAR - METODOS

    public byte getAndar(){
        return elevadorAndar;
    }

    public void getStatusAndar(){
        System.out.println("ANDAR ATUAL = "+ getAndar());
    }


    public void subirAndar() {
        if (getStatusPortaAberta()){
            System.out.println("(OPERACÃO CANCELADA) - Não é possível subir, pois a porta está aberta.");
            return;
        }

        if (getAndar() == 10) {
            System.out.println("(OPERACÃO CANCELADA) - O elevador só pode ir até o décimo andar (10)." );
            return;
        } else {
            this.elevadorAndar++;
            System.out.println("(SUCESSO) - O elevador subiu de andar.");
        }
    }

    public void descerAndar(){
        if (getStatusPortaAberta()){
            System.out.println("(OPERACÃO CANCELADA) - Não é possível descer, pois a porta está aberta.");;
            return;
        }

        if (getAndar() == 0) {
            System.out.println("(OPERACÃO CANCELADA) - O elevador só pode ir até o térreo (0)." );
            return;
        } else {
            this.elevadorAndar--;
            System.out.println("(SUCESSO) - O elevador desceu de andar.");
        }
    }

    // PORTA - METODOS

    public boolean getStatusPortaAberta(){
        return this.portaAberta;
    }

    public void abrirPorta(){
        if (getStatusPortaAberta()){
            System.out.println("(OPERACÃO CANCELADA) - A porta já está aberta.");
        } else {
            System.out.println("(SUCESSO) - A porta foi aberta!");
            this.portaAberta = true;
        }
    }

    public void fecharPorta(){
        Random random = new Random();
        boolean portaTravada = random.nextBoolean();

        if (!getStatusPortaAberta()){
            System.out.println("(OPERACÃO CANCELADA) - A porta já está fechada.");
            return;
        } else if (portaTravada) {
            System.out.println("(TENTE NOVAMENTE) Não é possível fechar, pois há pessoas entrando no elevador.");
            return;
        } else {
            System.out.println("(SUCESSO) - A porta foi fechada!");
            this.portaAberta = false;
            return;
        }
    }
}
