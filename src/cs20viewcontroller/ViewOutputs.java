package cs20viewcontroller;

import java.io.File;
import javax.swing.JFileChooser;


/**
 * Write methods in this class for displaying data in the DrawnView.
 *
 * You can use all the public instance variables you defined in AllModelsForView
 * and DrawnView as though they were part of this class! This is due to the
 * magic of subclassing (i.e. using the extends keyword).
 *
 * The methods for displaying data in the DrawnView are written as methods in
 * this class.
 *
 * Make sure to use these methods in the ViewUserActions class though, or else
 * they will be defined but never used!
 *
 * @author cheng
 */
public class ViewOutputs extends DrawnView {

    public void displayOutput() {
        updateBackend();
        aGeneticMaterialModel.doConversion();
        if (!aGeneticMaterialModel.getOutput().contains("sequence is invalid")) {
            aGeneticMaterialModel.deFormat();
        }
        this.inputField.setText(aGeneticMaterialModel.getInput());
        this.outputField.setText(aGeneticMaterialModel.getOutput());
    }

    public void openOutput() {
        this.typeSelectorField.setSelectedItem(aGeneticMaterialModel.getInputType());
        this.typeSelectorField1.setSelectedItem(aGeneticMaterialModel.getOutputType());
        aGeneticMaterialModel.deFormat();
        aGeneticMaterialModel.doConversion();
        this.inputField.setText(aGeneticMaterialModel.getInput());
        this.outputField.setText(aGeneticMaterialModel.getOutput());
    }

    public void updateBackend() {
        aGeneticMaterialModel.reset();
        aGeneticMaterialModel.setInput(this.inputField.getText());
        aGeneticMaterialModel.setInputType(this.typeSelectorField.getSelectedItem().toString());
        aGeneticMaterialModel.setOutputType(this.typeSelectorField1.getSelectedItem().toString());
        System.out.println(this.typeSelectorField1.getSelectedItem().toString());
    }

    public void clearDisplay() {
        aGeneticMaterialModel.reset();
        this.inputField.setText("");
        this.outputField.setText("");
        aGeneticMaterialModel.setInput("");
        aGeneticMaterialModel.setOutput("");
    }

    public void deFormat() {
        aGeneticMaterialModel.deFormat();
        this.inputField.setText(aGeneticMaterialModel.getInput());
        this.outputField.setText(aGeneticMaterialModel.getOutput());
    }

    public void format() {
        displayOutput();
        aGeneticMaterialModel.deFormat();
        aGeneticMaterialModel.formatInputAndOutput();
        this.inputField.setText(aGeneticMaterialModel.getInput());
        this.outputField.setText(aGeneticMaterialModel.getOutput());
    }

    public void delete() {
        // this code will inevitably throw a StringIndexOutOfBoundsException but it is the only way to make a filter work 100% of the time I have found.
        String inputText = this.inputField.getText();
        String newStr = inputText.substring(0, -1);
        this.inputField.setText(newStr);
    }
    
    public void handleError() {
        // This error handler is only for if the user inputs an incorrect U or T. 
        if (aGeneticMaterialModel.getError()) { 
            aGeneticMaterialModel.resolveError(); 
            this.inputField.setText(aGeneticMaterialModel.getInput());
            displayOutput();
        } 
    }

    public String showSaveDialog() {
        JFileChooser jfc = new JFileChooser();
        int status = jfc.showSaveDialog(this);
        if (status == JFileChooser.APPROVE_OPTION) {
            File theFile = jfc.getSelectedFile();
            String thePath = theFile.getAbsolutePath();
            return thePath;
        }
        return null;
    }

    public String showOpenDialog() {
        JFileChooser jfc = new JFileChooser();
        int status = jfc.showOpenDialog(this);
        if (status == JFileChooser.APPROVE_OPTION) {
            File theFile = jfc.getSelectedFile();
            String thePath = theFile.getAbsolutePath();
            return thePath;
        }
        return null;
    }
}
