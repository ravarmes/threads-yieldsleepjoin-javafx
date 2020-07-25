/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thread.javafx;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.scene.control.Label;
import static thread.javafx.FXMLDocumentController.join;

/**
 *
 * @author ravar
 */
public class MinhaRunnableLabelFinal implements Runnable{
    
    Label label;
    Thread thread1;
    Thread thread2;
    boolean join;
    
    
    public MinhaRunnableLabelFinal(Label label, Thread thread1, Thread thread2) {
        this.label = label;   
        this.thread1 = thread1;
        this.thread2 = thread2;
        this.join = FXMLDocumentController.join;
    }
    
     @Override
    public void run() {
        if(join){
            try {
                thread1.join();
                thread2.join();
            } catch (InterruptedException ex) {
                Logger.getLogger(MinhaRunnableLabelFinal.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
        Platform.runLater(() -> this.label.setStyle("-fx-background-color: red;"));
    }
    
    
}
