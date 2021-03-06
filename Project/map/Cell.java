package map;

import characters.*;
import items.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.Serializable;

public class Cell extends JPanel implements Serializable {
    // ATTRIBUTES
    private EquipmentItem item;
    private Enemy enemy;
    private boolean restore;

    // CONSTRUCTOR
    // Empty cell
    public Cell() {
        this.item = null;
        this.enemy = null;
        this.restore = false;
    }

    // Cell with an item
    public Cell(EquipmentItem item) {
        this.item = item;
        this.enemy = null;
        this.restore = false;
    }

    // Cell with an enemy
    public Cell(Enemy enemy) {
        this.enemy = enemy;
        this.item = null;
        this.restore = false;
    }

    // Cell that restores
    public Cell(boolean restore) {
        this.restore = restore;
        this.item = null;
        this.enemy = null;
    }

    // GETTERS AND SETTERS
    public EquipmentItem getItem() {
        return item;
    }

    public void setItem(EquipmentItem item) {
        this.item = item;
    }

    public Enemy getEnemy() {
        return enemy;
    }

    public void setEnemy(Enemy enemy) {
        this.enemy = enemy;
    }

    public boolean getRestore() {
        return restore;
    }

    public void setRestore(boolean restore) {
        this.restore = restore;
    }

    // METHODS
    public void restore(Hero hero, Window window) throws NoRiverException {
        if (window.getCells()[hero.getPosY()][hero.getPosX()].getRestore()) {
            hero.getHealingFlask().setCharges(hero.getHealingFlask().getMaxCharges());
            hero.setHp(hero.getMaxHp());
            hero.setEther(hero.getMaxEther());
        } else {
            throw new NoRiverException();
        }
    }
}