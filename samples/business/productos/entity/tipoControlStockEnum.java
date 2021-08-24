/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.productos.entity;

/**
 *
 * @author cbustamante
 */
public enum tipoControlStockEnum {
    UNITARIO("Unitario"), PARCIAL("Control parcial"), OTROS("otros"), MENUDEO("Menudeo");

    private String tipo;

    tipoControlStockEnum(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return this.tipo;
    }
}
