package org.example;

import com.jme3.app.SimpleApplication;
import com.jme3.light.DirectionalLight;
import com.jme3.material.Material;
import com.jme3.math.Vector2f;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.Spatial;
import com.jme3.scene.shape.Box;
import com.jme3.texture.Texture;
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
        Texture west = assetManager.loadTexture("Textures/west.png");
        Texture east = assetManager.loadTexture("Textures/east.png");
        Texture north = assetManager.loadTexture("Textures/front.png");
        Texture south = assetManager.loadTexture("Textures/back.png");
        Texture up = assetManager.loadTexture("Textures/up.png");
        Texture down = assetManager.loadTexture("Textures/down.png");

        Spatial sky = SkyFactory.createSky(
                assetManager,
                west, east,
                north, south,
                up, down
        );

        rootNode.attachChild(sky);

        floor = new Box(10, 0.1f, 10);
        floor.scaleTextureCoordinates(new Vector2f(10, 10));
        Geometry floorGeo = new Geometry("floor",floor);
        Texture floorTex =
                assetManager.loadTexture("Textures/lush-green-grass-texture-from.png.png");
        Material mat = new Material(assetManager,
                "Common/MatDefs/Light/Lighting.j3md");
        mat.setTexture("DiffuseMap", floorTex);
        floorTex.setWrap(Texture.WrapMode.Repeat);
        floorGeo.setMaterial(mat);
        rootNode.attachChild(floorGeo);


        DirectionalLight sun = new DirectionalLight();

        sun.setDirection(
                new Vector3f(-0.5f, -1f, -0.5f).normalizeLocal()
        );

        rootNode.addLight(sun);

        cam.setLocation(new Vector3f(0, 2, 5));
        cam.lookAt(Vector3f.ZERO, Vector3f.UNIT_Y);
    }
}
