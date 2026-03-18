import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Elevador ambiente1 = new Elevador((byte) 1, true);

        while (true){
            ambiente1.statusAndar();

            System.out.print("Você deseja:\n1 - Subir\n2 - Descer\n3 - Abrir a porta\n4 - Fechar a porta\n: ");

            byte funcao = scanner.nextByte();

            switch (funcao){

                case 1: // SUBIR
                    ambiente1.subirAndar();
                    break;

                case 2: // DESCER
                    ambiente1.descerAndar();
                    break;

                case 3: // ABRIR A PORTA
                    ambiente1.abrirPorta();
                    break;

                case 4: // FECHAR A PORTA
                    ambiente1.fecharPorta();
                    break;

                case 6: // MOSTRAR O ANDAR ATUAL
                    break;

                default: // OPÇÃO NÃO EXISTENTE
                    System.out.println("Opção inválida.");
                    break;
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

    public byte getAndar(){
        return andar;
    }

    public void statusAndar(){
        System.out.println("Você está no andar: "+ getAndar());
    }


    public void subirAndar() {
        this.andar = (byte) (this.andar + 1);
    }

    public void descerAndar(){
        this.andar = (byte)(this.andar - 1);
    }

    public boolean getStatusPortaAberta(){
        return this.portaAberta;
    }

    public void abrirPorta(){
        if (getStatusPortaAberta()){
            System.out.println("A porta já está aberta.");
        } else {
            System.out.println("A porta foi aberta!");
            this.portaAberta = true;
        }
    }

    public void fecharPorta(){
        if (getStatusPortaAberta()){
            System.out.println("A porta já está fechada.");
        } else {
            System.out.println("A porta foi fechada!");
            this.portaAberta = false;
        }
    }


    // ABRIR A PORTA
    // FECHAR A PORTA
    // INDICAR SE A PORTA ESTÁ ABERTA OU FECHADA
    // MOSTRAR O ANDAR ATUAL

}

/*
* O elevador não pode subir mais andares do que o está disponível
* O elevador não pode descer mais andares do que o está disponível
* DO elevador não pode subir ou descer algum andar se a porta estiver aberta
* */
