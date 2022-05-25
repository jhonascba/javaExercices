package exercices.lists;

/*Faça um programa que receba a temperatura média os 6 primeiros meses do ano e armazene-as em uma lista.
Após isto, calcule a média semestral das temperaturas e mostre todas as temperaturas acima desta média,
e em que mês elas ocorreram (mostrar o mês por extenso: 1 – Janeiro, 2 – Fevereiro e etc).
*/

import java.util.ArrayList;
import java.util.List;

public class Exercicio01 {

    public static void main(String[] args) {
        Temperatura temp1 = new Temperatura("Jan", 35.6);
        Temperatura temp2 = new Temperatura("Fev", 32.0);
        Temperatura temp3 = new Temperatura("Mar", 30d);
        Temperatura temp4 = new Temperatura("Abr", 28.2);
        Temperatura temp5 = new Temperatura("Mai", 15.3);
        Temperatura temp6 = new Temperatura("Jun", 12.0);

        List<Temperatura> temperaturas = new ArrayList<>();

        temperaturas.add(temp1);
        temperaturas.add(temp2);
        temperaturas.add(temp3);
        temperaturas.add(temp4);
        temperaturas.add(temp5);
        temperaturas.add(temp6);

        double media = TemperaturaFerramentas.media(temperaturas);

        System.out.println(media);

        TemperaturaFerramentas.acimaMedia(temperaturas, media);
    }


}

class Temperatura {

    private String mes;
    private double temperatura;

    public Temperatura(String mes, double temperatura) {
        this.mes = mes;
        this.temperatura = temperatura;
    }

    public String getMes() {
        return mes;
    }

    public double getTemperatura() {
        return temperatura;
    }

    @Override
    public String toString() {
        return "\nMês: " + this.mes + " - Temperatura: " + this.temperatura + "\n";
    }
}

class TemperaturaFerramentas {

    public static double media(List<Temperatura> temperaturas) {
        return temperaturas.stream()
                .mapToDouble(Temperatura::getTemperatura)
                .average()
                .orElse(0d);
    }

    public static void acimaMedia(List<Temperatura> temperaturas, double media) {
        temperaturas.stream()
                .filter(temperatura -> temperatura.getTemperatura() > media)
                .forEach(System.out::println);
    }
}
