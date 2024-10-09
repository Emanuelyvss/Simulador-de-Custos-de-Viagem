package gasolina;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

public class FXMLDocumentController {

    @FXML
    private ComboBox<String> comboBoxFrom;
    @FXML
    private ComboBox<String> comboBoxTo;
    @FXML
    private Label lblDistance;
    @FXML
    private Label lblCost;
    @FXML
    private Label lblConsumption;

    private GasolinaDAO dao = new GasolinaDAO();
    
    private static final double PRICE_PER_LITER = 6.0; // Preço do litro de gasolina
    private static final double CONSUMPTION = 8.0; // Consumo em L/100km

    @FXML
    private void initialize() {
        comboBoxFrom.getItems().addAll("Porto Alegre", "Natal", "Rio de Janeiro", "Fortaleza", "Foz do Iguaçu", "Curitiba", "Fernando de Noronha", "Gramado", "Florianópolis", "Holambra");
        comboBoxTo.getItems().addAll("Porto Alegre", "Natal", "Rio de Janeiro", "Fortaleza", "Foz do Iguaçu", "Curitiba", "Fernando de Noronha", "Gramado", "Florianópolis", "Holambra");
    }

    @FXML
    private void calculate() {
        String fromCity = comboBoxFrom.getValue();
        String toCity = comboBoxTo.getValue();
        
        if (fromCity == null || toCity == null) {
            lblDistance.setText("Selecione as cidades.");
            lblCost.setText("");
            lblConsumption.setText("");
            return;
        }
        
        double distance = dao.getDistance(fromCity, toCity);
        if (distance == 0) {
            lblDistance.setText("Distância não encontrada entre " + fromCity + " e " + toCity + ".");
            lblCost.setText("");
            lblConsumption.setText("");
            return;
        }
        
        double cost = (distance / 100) * PRICE_PER_LITER * CONSUMPTION; // Cálculo de custo
        double consumption = (cost / PRICE_PER_LITER) * 100 / distance; // Cálculo de consumo em L/100km

        lblDistance.setText(String.format("%.2f km", distance));
        lblCost.setText(String.format("R$ %.2f", cost));
        lblConsumption.setText(String.format("Consumo: %.2f L/100km", consumption));
    }
}

