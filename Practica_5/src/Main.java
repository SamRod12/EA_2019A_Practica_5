import data.Processing;
import java.io.File;
import java.io.IOException;
import templates.Persona;
import org.apache.commons.io.input.ReversedLinesFileReader;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws IOException {

    ArrayList<Persona> personas = new ArrayList<>();
    ArrayList<Persona> outPersonas = new ArrayList<>();

        personas.add(new Persona(
                "Leonardo Samuel",
                19,
                1.76,
                80
        ));
        personas.add(new Persona(
                "Miguel Treviño",
                19,
                1.60,
                75
        ));
        personas.add(new Persona(
                "Blanca Paloma",
                21,
                1.65,
                60
        ));

        Processing processing = new Processing();
//        processing.guardarPersonasEnArchivo(personas, "personas.txt");
        outPersonas = processing.leerPersonasDeArchivo("personas.txt");
        for (int i=0; i< outPersonas.size(); i++){
            System.out.println(
                    outPersonas.get(i).getNombre() + " | " +
                            outPersonas.get(i).getEdad() + " | " +
                            outPersonas.get(i).getEstatura() + " | " +
                            outPersonas.get(i).getPeso() + " | "
            );
        }
        
        File file = new File("personas.txt");
        ReversedLinesFileReader object = new ReversedLinesFileReader(file);
        String line = object.readLine();
        System.out.println(line);
        String pattern = "\\(([^)]+)\\)\\(([^)]+)\\)\\(([^)]+)\\)\\(([^)]+)\\)";
        Matcher matcher = Pattern.compile(pattern).matcher(line);
        Persona personaUltima = null;
        if (matcher.find()) {
            personaUltima = new Persona(
                                matcher.group(1),
                                Integer.parseInt( matcher.group(2) ),
                                Double.parseDouble( matcher.group(3) ),
                                Integer.parseInt( matcher.group(4) )
                        );
        }
        System.out.println(personaUltima.toString());
        

    }
}
