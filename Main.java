import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Elevador ambiente1 = new Elevador((byte) 1, true);

        while (true){
            ambiente1.getStatusAndar();

            System.out.print("Você deseja:\n1 - Subir\n2 - Descer\n3 - Abrir a porta\n4 - Fechar a porta\n: ");

            try {
                byte opcaoEscolhida = scanner.nextByte();

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

                    default: // OPÇÃO NÃO EXISTENTE
                        System.out.println("Opção inválida.");
                        break;
                }

            } catch (Exception E) {
                scanner.next(); // Limpa buffer
                System.out.println("O valor precisa ser um numero inteiro");
            }
        }
    }
}

class Elevador {
    byte andar;
    boolean portaAberta;


    public Elevador(byte andar, boolean portaAberta) {
        this.andar = andar;
        this.portaAberta = portaAberta;
    }

    // ANDAR - METODOS

    public byte getAndar(){
        return andar;
    }

    public void getStatusAndar(){
        System.out.println("O elevador está no andar de numero "+ getAndar());
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
            this.andar++;
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
            this.andar--;
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
        if (!getStatusPortaAberta()){
            System.out.println("(OPERACÃO CANCELADA) - A porta já está fechada.");
        } else {
            System.out.println("(SUCESSO) - A porta foi fechada!");
            this.portaAberta = false;
        }
    }
}

