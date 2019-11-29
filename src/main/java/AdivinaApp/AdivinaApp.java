package AdivinaApp;

import java.util.Random;

import com.sun.javafx.binding.StringFormatter;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AdivinaApp extends Application {

	private TextField nombreText;
	private Button saludarButton;
	private Label saludoLabel;
	private int intento = 0;
	int numeroAleatorio = (int) (Math.random() * 100 + 1);

	@Override
	public void start(Stage primaryStage) throws Exception {

		nombreText = new TextField();
		nombreText.setPromptText("Introduce un numero");
		nombreText.setMaxWidth(150);

		saludoLabel = new Label("Introduce un numero del 1 al 100");

		saludarButton = new Button("Comprobar");
		saludarButton.setDefaultButton(true);
		saludarButton.setOnAction(e -> onSaludarButtonAction(e));

		VBox root = new VBox();
		root.setSpacing(5);
		root.setAlignment(Pos.CENTER);
		root.getChildren().addAll(saludoLabel,nombreText, saludarButton);

		Scene scene = new Scene(root, 320, 200);

		primaryStage.setTitle("AdivinaApp");
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	private void onSaludarButtonAction(ActionEvent e) {
		try {
		String numero = nombreText.getText();
		int inumero = Integer.parseInt(numero);
		

		
			

		if (inumero == numeroAleatorio) {
			intento++;
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("AdivinaApp");
			alert.setHeaderText("¡Has ganado!");
			alert.setContentText(String.format("Sólo has necesitado %d \n\n Vuelve a jugar y hazlo mejor",intento));
			alert.showAndWait();
			numeroAleatorio = (int) (Math.random() * 100 + 1);
			intento = 0;

		} else {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("AdivinaApp");
			alert.setHeaderText("¡Has fallado!");
			intento++;
			
			if (numeroAleatorio > inumero) {
				alert.setContentText(String.format("El número a adivinar es mayor que %d \n\n Vuelve a intentarlo",inumero));
			} 
			else {
				alert.setContentText(String.format("El número a adivinar es menor que %d. \n\n Vuelve a intentarlo",inumero));
			}

			
			alert.showAndWait();
		}
		

	} catch (java.lang.NumberFormatException e2) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("AdivinaApp");
		alert.setHeaderText("¡Error!");
		alert.setContentText("El número introducido no es valido");
		alert.showAndWait();
	}
	}

	public static void main(String[] args) {
		launch(args);

	}

}
