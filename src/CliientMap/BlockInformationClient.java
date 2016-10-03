/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CliientMap;

import com.jme3.math.Vector3f;
import helpClasses.*;
import java.util.ArrayList;

/**
 *
 * @author jonas
 */
public class BlockInformationClient {

    public ArrayList<Vector3f> position;
    public ArrayList<Integer> elementNumber;

    public int size;
    
    public BlockInformationClient() {
        position = new ArrayList<Vector3f>();
        elementNumber = new ArrayList<Integer>();
    }

    public int getSize(){
        return size;
    }
    
    public void calculateSize(){
        size = position.size();
    }
    
    public void addInformation(int x, int y, int z, int elementNumber) {
        position.add(new Vector3f(x, y, z));
        this.elementNumber.add(elementNumber);
    }

    public Vector3f getNextPos() {
        return position.remove(0);
    }

    public int getNextElementNumber() {
        return elementNumber.remove(0);
    }
}
