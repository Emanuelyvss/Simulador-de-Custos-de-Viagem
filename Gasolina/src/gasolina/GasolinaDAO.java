package gasolina;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GasolinaDAO {

    private Map<String, Double> distances;
    private Set<String> cities;

    public GasolinaDAO() {
        distances = new HashMap<>();
        cities = new HashSet<>();

        // Adicionando cidades
        addCity("Porto Alegre");
        addCity("Rio de Janeiro");
        addCity("Natal");
        addCity("Fortaleza");
        addCity("Foz do Iguaçu");
        addCity("Curitiba");
        addCity("Fernando de Noronha");
        addCity("Gramado");
        addCity("Florianópolis");
        addCity("Holambra");

        // Definindo as distâncias entre as cidades
        addDistance("Porto Alegre", "Rio de Janeiro", 1150.0);
        addDistance("Porto Alegre", "Natal", 3000.0);
        addDistance("Porto Alegre", "Fortaleza", 2800.0);
        addDistance("Porto Alegre", "Foz do Iguaçu", 640.0);
        addDistance("Porto Alegre", "Curitiba", 700.0);
        addDistance("Porto Alegre", "Fernando de Noronha", 3500.0);
        addDistance("Porto Alegre", "Gramado", 130.0);
        addDistance("Porto Alegre", "Florianópolis", 480.0);
        addDistance("Porto Alegre", "Holambra", 1100.0);

        addDistance("Natal", "Rio de Janeiro", 2700.0);
        addDistance("Natal", "Fortaleza", 540.0);
        addDistance("Natal", "Foz do Iguaçu", 3800.0);
        addDistance("Natal", "Curitiba", 3100.0);
        addDistance("Natal", "Fernando de Noronha", 350.0);
        addDistance("Natal", "Gramado", 2900.0);
        addDistance("Natal", "Florianópolis", 2900.0);
        addDistance("Natal", "Holambra", 3100.0);

        addDistance("Rio de Janeiro", "Fortaleza", 2600.0);
        addDistance("Rio de Janeiro", "Foz do Iguaçu", 1000.0);
        addDistance("Rio de Janeiro", "Curitiba", 800.0);
        addDistance("Rio de Janeiro", "Fernando de Noronha", 2400.0);
        addDistance("Rio de Janeiro", "Gramado", 1300.0);
        addDistance("Rio de Janeiro", "Florianópolis", 1200.0);
        addDistance("Rio de Janeiro", "Holambra", 2000.0);

        addDistance("Fortaleza", "Foz do Iguaçu", 3300.0);
        addDistance("Fortaleza", "Curitiba", 2900.0);
        addDistance("Fortaleza", "Fernando de Noronha", 540.0);
        addDistance("Fortaleza", "Gramado", 3000.0);
        addDistance("Fortaleza", "Florianópolis", 2900.0);
        addDistance("Fortaleza", "Holambra", 3100.0);

        addDistance("Foz do Iguaçu", "Curitiba", 630.0);
        addDistance("Foz do Iguaçu", "Fernando de Noronha", 3800.0);
        addDistance("Foz do Iguaçu", "Gramado", 300.0);
        addDistance("Foz do Iguaçu", "Florianópolis", 900.0);
        addDistance("Foz do Iguaçu", "Holambra", 1200.0);

        addDistance("Curitiba", "Fernando de Noronha", 3000.0);
        addDistance("Curitiba", "Gramado", 280.0);
        addDistance("Curitiba", "Florianópolis", 300.0);
        addDistance("Curitiba", "Holambra", 120.0);

        addDistance("Fernando de Noronha", "Gramado", 3800.0);
        addDistance("Fernando de Noronha", "Florianópolis", 4000.0);
        addDistance("Fernando de Noronha", "Holambra", 3600.0);

        addDistance("Gramado", "Florianópolis", 400.0);
        addDistance("Gramado", "Holambra", 1500.0);

        addDistance("Florianópolis", "Holambra", 1600.0);
    }

    private void addCity(String city) {
        cities.add(city);
    }

    private void addDistance(String fromCity, String toCity, double distance) {
        distances.put(fromCity + "-" + toCity, distance);
        distances.put(toCity + "-" + fromCity, distance); 
    }

    public double getDistance(String fromCity, String toCity) {
       
        String key = fromCity + "-" + toCity;
        return distances.getOrDefault(key, 0.0);
    }

    public Set<String> getCities() {
        return cities; 
    }
}
