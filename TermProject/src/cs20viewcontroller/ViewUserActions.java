/*
 * The controller classes (like the ViewUserActions class) provides actions
 * that the user can trigger through the view classes.  Those actions are 
 * written in this class as private inner classes (i.e. classes 
 * declared inside another class).
 *
 * You can use all the public instance variables you defined in AllModelsForView, 
 * DrawnView, and ViewOutputs as though they were part of this class! This is 
 * due to the magic of subclassing (i.e. using the extends keyword).
 */
package cs20viewcontroller;

import cs20models.AllModelsForView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * ViewUserActions is a class that contains actions users can trigger.
 *
 * User actions are written as private inner classes that implements the
 * ActionListener interface. These actions must be "wired" into the DrawnView in
 * the ViewUserActions constructor, or else they won't be triggered by the user.
 *
 * Actions that the user can trigger are meant to manipulate some model classes
 * by sending messages to them to tell them to update their data members.
 *
 * Actions that the user can trigger can also be used to manipulate the GUI by
 * sending messages to the view classes (e.g. the DrawnView class) to tell them
 * to update themselves (e.g. to redraw themselves on the screen).
 *
 * @author cheng
 */
public class ViewUserActions extends ViewOutputs {

    /*
     * Step 1 of 2 for writing user actions.
     * -------------------------------------
     *
     * User actions are written as private inner classes that implement
     * ActionListener, and override the actionPerformed method.
     *
     * Use the following as a template for writting more user actions.
     */
    private class Submit implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            displayOutput();
        }
    }

    private class Clear implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            clearDisplay();
        }
    }

    private class Format implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            format();
        }
    }

    private class DeFormat implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            deFormat();
        }
    }

    private class OpenFile implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                String pathToFile = showOpenDialog();
                if (pathToFile == null) {
                    return;
                }

                clearDisplay();
                aGeneticMaterialModel.openFromFile(pathToFile);
                openOutput();

            } catch (IOException ex) {
                Logger.getLogger(ViewUserActions.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private class SaveFile implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                String pathToFile = showSaveDialog();
                if (pathToFile == null) {
                    return;
                }
                aGeneticMaterialModel.saveToFile(pathToFile);
            } catch (IOException ex) {
                Logger.getLogger(ViewUserActions.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private class Error implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            handleError();
        }
    }

    private class Key implements KeyListener {

        @Override
        public void keyPressed(KeyEvent e) {

        }

        @Override
        public void keyTyped(KeyEvent e) {
            if (e.getKeyChar() != 'a' && e.getKeyChar() != 'A' && e.getKeyChar() != 'u' && e.getKeyChar() != 'U' && e.getKeyChar() != 't' && e.getKeyChar() != 'T' && e.getKeyChar() != 'c' && e.getKeyChar() != 'C' && e.getKeyChar() != 'g' && e.getKeyChar() != 'G') {
                delete();
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }

    private class GoToScreen2 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            AllModelsForView.goToScreen(2);
        }
    }

    /*
     * ViewUserActions constructor used for wiring user actions to GUI elements
     */
    public ViewUserActions() {
        /*
         * Step 2 of 2 for writing user actions.
         * -------------------------------------
         *
         * Once a private inner class has been written for a user action, you
         * can wire it to a GUI element (i.e. one of GUI elements you drew in
         * the DrawnView class and which you gave a memorable public variable
         * name!).
         *
         * Use the following as a template for wiring more user actions.
         */
        submitButton.addActionListener(new Submit());
        clearButton.addActionListener(new Clear());
        openButton.addActionListener(new OpenFile());
        saveButton.addActionListener(new SaveFile());
        formatButton.addActionListener(new Format());
        deFormatButton.addActionListener(new DeFormat());
        inputField.addKeyListener(new Key());
        infoButton.addActionListener(new GoToScreen2());
        errorButton.addActionListener(new Error());
//        typeSelectorField.
        AllModelsForView.mainFrame = this;
        AllModelsForView.mainContentPane = this.getContentPane();
    }
}
