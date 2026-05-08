package org.example;

import com.jme3.app.SimpleApplication;
import com.jme3.material.Material;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.Spatial;
import com.jme3.scene.shape.Box;
import com.jme3.util.SkyFactory;

import javax.swing.*;
import java.awt.*;

public class Simulation extends SimpleApplication {
    private static final int WINDOW_WIDTH = 800, WINDOW_HEIGHT = 800;
    private com.jme3.scene.shape.Box floor;
    public Simulation() throws HeadlessException {
    }

    @Override
    public void simpleInitApp() {
//        Spatial sky = SkyFactory.createSky(assetManager,"Textures/Cubemap_Sky_24-512x512.dds",SkyFactory.EnvMapType.CubeMap);
//
//        rootNode.attachChild(sky);

        floor = new Box(10, 0.1f, 10);
        Geometry floorGeo = new Geometry("floor",floor);
        Material mat = new Material(assetManager,
                "Common/MatDefs/Misc/Unshaded.j3md");
        floorGeo.setMaterial(mat);
        rootNode.attachChild(floorGeo);

        cam.setLocation(new Vector3f(0, 2, 5));
        cam.lookAt(Vector3f.ZERO, Vector3f.UNIT_Y);
    }
}
