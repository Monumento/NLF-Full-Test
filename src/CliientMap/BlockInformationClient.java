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

    public void AddCenter(int centerX, int centerY, int centerZ, int size) {
        for (int i = 0; i < 2 * size; i++) {
            for (int j = 0; j < 2 * size; j++) {
                for (int k = 0; k < 2 * size; k++) {
                    position.add(new Vector3f(centerX - size + i, centerY - size + j, centerZ - size + k));
                    elementNumber.add(1);
                }
            }
        }
    }

    public void AddCenterSizeXY(int centerX, int centerY, int centerZ, int sizeX, int sizeY) {
        for (int i = 0; i < 2 * sizeX; i++) {
            for (int j = 0; j < 2 * sizeY; j++) {
                for (int k = 0; k < 2 * sizeX; k++) {
                    position.add(new Vector3f(centerX - sizeX + i, centerY - sizeY + j, centerZ - sizeX + k));
                    elementNumber.add(1);
                }
            }
        }
    }

    public int getSize() {
        return size;
    }

    public void calculateSize() {
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
