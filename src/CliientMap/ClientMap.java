/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CliientMap;

import Connection.ServerPart;
import Welt.NLFWelt;
import com.jme3.math.Vector3f;
import java.util.ArrayList;
import java.util.HashMap;
import mygame.MainClientScript;
import stringToObjectHelper.StringToMapClient;

/**
 *
 * @author jonas
 */
public class ClientMap {

    public ServerPart[] map;
    ArrayList<Vector3f> playerPositions;
    private MainClientScript mainClient;
    public int viewDistance, currentMapPart;
    public String[] mapAsString;
    HashMap<Integer, Integer> startValues;

    public void setMainCLient(MainClientScript client) {
        this.mainClient = client;
    }

    public ClientMap(int size) {
        map = new ServerPart[size];
    }

    public void addPlayerPosition(Vector3f position) {

        playerPositions.add(new Vector3f((int) position.x, (int) position.y, (int) position.z));

    }

    public ClientMap() {
        map = new ServerPart[8];
        map[0] = new ServerPart(1);
        viewDistance = 5;
        playerPositions = new ArrayList<Vector3f>();
        mapAsString = new String[1000];
        currentMapPart = 0;
        startValues = new HashMap<Integer, Integer>();
    }

    public void displayPartsAround(Vector3f position) {
        int x, y, z;

        int startValue = (int) position.y * 10;

        BlockInformationClient blockInformation = new BlockInformationClient();
        System.out.println(playerPositions.size());
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 1; j++) {

                if (playerPositions != null && playerPositions.size() >= 990) {

                    x = (int) playerPositions.get(startValue - 1).x;
                    y = (int) playerPositions.get(startValue).y;
                    z = (int) playerPositions.get(startValue + 1).z;
                    // System.out.println(x + " " + y + " " + z);
                    blockInformation.addInformation(x, y, z, 1);
                    blockInformation.addInformation(x + 1, y, z, 1);
                    blockInformation.addInformation(x + 2, y, z, 1);
                    blockInformation.addInformation(x, y + 1, z, 1);
                    blockInformation.addInformation(x, y + 2, z, 1);
                    blockInformation.addInformation(x, y, z + 1, 1);
                    blockInformation.addInformation(x, y, z + 2, 1);
                    blockInformation.addInformation(x + 1, y + 1, z, 1);
                    blockInformation.addInformation(x + 2, y + 2, z, 1);
                    blockInformation.addInformation(x, y + 1, z+1, 1);
                    blockInformation.addInformation(x, y + 2, z+2, 1);
                    blockInformation.addInformation(x+1, y, z + 1, 1);
                    blockInformation.addInformation(x+2, y, z + 2, 1);
                }
            }
        }
        blockInformation.calculateSize();
        try {
            blockInformation.getSize();
        } catch (Exception e) {
        }
        mainClient.displayParts(blockInformation);
    }

    public void displayParts() {
        int x, y, z;
        x = (int) playerPositions.get(0).x;
        y = (int) playerPositions.get(0).y;
        z = (int) playerPositions.get(0).z;
        BlockInformationClient blockInformation = new BlockInformationClient();
        playerPositions.remove(0);
        for (int i = 0; i < 2 * viewDistance; i++) {
            for (int j = 0; j < 2 * viewDistance; j++) {
                for (int k = 0; k < 2 * viewDistance; k++) {
                    blockInformation.addInformation(i + x - viewDistance, j + y - viewDistance, z + k - viewDistance, map[0].welt.worldBlocks.weltElemente[i + x - viewDistance][j + y - viewDistance][k + z - viewDistance].elementNumber);
                }
            }
        }
        blockInformation.calculateSize();
        mainClient.displayParts(blockInformation);
    }

    public void updateMap(String map) {
        int x, y, z;
        x = (int) playerPositions.get(playerPositions.size() - 1).x;
        y = (int) playerPositions.get(playerPositions.size() - 1).y;
        z = (int) playerPositions.get(playerPositions.size() - 1).z;
        StringToMapClient.mapStringToServerpart(viewDistance, x, y, z, map, this.map[0].welt.worldBlocks);

    }
}
