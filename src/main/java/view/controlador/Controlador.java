package view.controlador;

import controller.ControlGaleria;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;


public class Controlador {

    private ControlGaleria controlGaleria = new ControlGaleria();

    @FXML
    private TextField IngPid;

    @FXML
    private Button IngMaterial;

    @FXML
    private TextField IngDescripM;

    @FXML
    private TextField IngPeso;

    @FXML
    private Button IngObra;

    @FXML
    private TextField IngDescripcion;

    @FXML
    private TextField IngMNombre;

    @FXML
    private TextField IngMdescrip;

    @FXML
    private ChoiceBox<?> IngClasificacion;

    @FXML
    private TextField IngTecnica;

    @FXML
    private TextField IngTema;

    @FXML
    private TableView<Long> IngLista;

    @FXML
    private TextField IngDimenciones;

    @FXML
    private TextField IngTitulo;

    @FXML
    private TextField IngAnno;

    @FXML
    private TextField IngPrecio;

    @FXML
    private TextField ModPid;

    @FXML
    private Button ModBuscar;

    @FXML
    private SplitMenuButton ModTipoDato;

    @FXML
    private TextField ModNuevoD;

    @FXML
    private Button ModGuardar;

    @FXML
    private TextField ElimPid;

    @FXML
    private Button ElimBuscar;

    @FXML
    private Button Eliminar;

    @FXML
    private TextField BusPid;

    @FXML
    private Button BusBuscar;

    @FXML
    void ingresarObra(ActionEvent event) {
        System.out.println("pero que pasa chavales");
        actualizarLArtistas();
        controlGaleria.opcion3(Long.valueOf(IngPid.getText()), String.valueOf(IngDimenciones.getText()), String.valueOf(IngTitulo.getText()), Integer.valueOf(IngAnno.getText()), Double.valueOf(IngPrecio.getText()));
    }

    public void actualizarLArtistas(){
        IngLista.getItems().clear();
        for(Long llave: controlGaleria.getListaArtistas().keySet()){
            IngLista.getItems().add(llave);
        }
    }

}
