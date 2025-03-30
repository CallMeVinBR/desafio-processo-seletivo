import java.util.concurrent.ThreadLocalRandom;
import java.util.ArrayList;
import java.util.Random;

public class ProcessoSeletivo {
    private static Double salarioBase = 2000.0;
    public static void main(String[] args) {
        ArrayList<String> candidatosLigar = imprimirSelecionados();

        for(String candidato: candidatosLigar) {
            entrarEmContato(candidato);
        }
    }

    static boolean atender() {
        return new Random().nextInt(3)==1;
    }

    static void entrarEmContato(String candidato) {
        int tentativas = 1;
        boolean continuarTentando = true;
        boolean atendeu = false;

        do {
            atendeu = atender();
            continuarTentando = !atendeu;
            if(continuarTentando)
                tentativas++;
            else
                System.out.println("CONTATO REALIZADO COM SUCESSO");
        }while(continuarTentando && tentativas <= 3);

        if(atendeu)
            System.out.println("CONSEGUIMOS CONTATO COM " + candidato + " NA " + tentativas + "a TENTATIVA");
        else
            System.out.println("NÃO CONSEGUIMOS CONTATO COM " + candidato);
    }

    static ArrayList<String> imprimirSelecionados() {
        ArrayList<String> candidatosSelecionados = selecaoCandidatos();
        
        System.out.println("\nCANDIDATOS SELECIONADOS: ");
        for(int i = 0; i < candidatosSelecionados.size(); i++) {
            System.out.println(candidatosSelecionados.get(i));
        }
        System.out.println("\nENTRANDO EM CONTATO COM OS CANDIDATOS SELECIONADOS\n");

        return candidatosSelecionados;
    }

    static ArrayList<String> selecaoCandidatos() {
        ArrayList<String> candidatos = new ArrayList<>();
        candidatos.add("ANNA");
        candidatos.add("JULIO");
        candidatos.add("VINICIUS");
        candidatos.add("PAULA");
        candidatos.add("GABRIELA");
        candidatos.add("MARCIA");
        candidatos.add("JOAO");
        candidatos.add("VICTOR");
        candidatos.add("HENRIQUE");
        candidatos.add("MARCOS");

        int candidatosSelecionados = 0;
        int i = 0;
        ArrayList<String> selecionados = new ArrayList<>();

        while(candidatosSelecionados < 5 && i < candidatos.size()) {
            String candidato = candidatos.get(i);
            double salarioPretendido = valorPretendido();

            System.out.println("O candidato " + candidato + " tem a proposta de " + salarioPretendido);
            if(salarioBase >= salarioPretendido) {
                System.out.println("O candidato " + candidato + " foi selecionado para a vaga");
                selecionados.add(candidato);
                candidatosSelecionados++;
            }
            i++;
        }

        return selecionados;
    }
    
    static double valorPretendido() {
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }

    static void analisarCandidato(double salarioPretendido) {
        if(salarioBase > salarioPretendido) 
            System.out.println("LIGAR PARA O CANDIDATO");
        else if(salarioBase == salarioPretendido) 
            System.out.println("LIGAR PARA O CANDIDATO COM CONTRA PROPOSTA");
        else 
            System.out.println("AGUARDANDO O RESULTADO DOS DEMAIS CANDIDATOS");
    }
}