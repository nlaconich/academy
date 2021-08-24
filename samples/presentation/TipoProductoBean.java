/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import business.productos.boundary.TipoProductoManager;
import business.productos.entity.TipoProducto;
import business.utils.UtilLogger;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author pinchi
 */
@Model
@ViewScoped
public class TipoProductoBean implements Serializable {

    private List<TipoProducto> tipoProductoList;
    private boolean bloquearBotones = true;
    private TipoProducto tipoProducto;

    @Inject
    TipoProductoManager tipoProductosMgr;

    public TipoProductoBean() {
    }

    @PostConstruct
    public void init() {
        UtilLogger.info("TipoProducto init: obteniendo lista de tipoProductos ");
        limpVariable();
        UtilLogger.info("TipoProducto init: se econtranron " + tipoProductoList.size());
    }

    public void limpVariable() {

        tipoProducto = new TipoProducto();
        tipoProductoList = tipoProductosMgr.getAll();
    }

    public String agregarTipoProducto() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            if (null != tipoProducto) {
                for (TipoProducto prod : tipoProductoList) {
                    if (prod.getTipoProducto().trim().equalsIgnoreCase(tipoProducto.getTipoProducto().trim())
                            && (tipoProducto.getTipoId() == null || tipoProducto.getTipoId() == 0)) {
                        context.addMessage(null, new FacesMessage("Advertencia",
                                "El tipo de producto " + tipoProducto.getTipoProducto()
                                + " ya se encuentra registrado"));
                         RequestContext.getCurrentInstance().execute("PF('dlgTipoProductoAdd').hide()");
                        return "";
                        
                    }
                }
            }

            if (tipoProducto != null & tipoProducto.getTipoId() == null) {
                tipoProducto = tipoProductosMgr.add(tipoProducto);
                
            } else if (tipoProducto != null & tipoProducto.getTipoId() > 0) {
                tipoProducto = tipoProductosMgr.update(tipoProducto);
            }

        } catch (Exception e) {
            context.addMessage(null, new FacesMessage("Error",
                    "Ocurrió un error al intentar guardar el tipo producto "));
            UtilLogger.error("Problemas al insertar la ciudad", e);
        }

        return "tipoProducto";
    }

    public String update() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {

            tipoProductosMgr.update(tipoProducto);
        } catch (Exception e) {

            context.addMessage(null, new FacesMessage("Error",
                    "Ocurrió un error al intentar actualizar tipo productos "));
            UtilLogger.error("Problemas al insertar la ciudad", e);
        }

        return "tipoProducto";
    }

    public String eliminarTipoProducto() {
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            tipoProductosMgr.delete(tipoProducto);

        } catch (Exception e) {
            context.addMessage(null, new FacesMessage("Error",
                    "Ocurrió un error al intentar eliminar tipo productos "));
            UtilLogger.error("Problemas al insertar la ciudad", e);
        }
        return "tipoProducto";
    }

    public void alSeleccionarFila(SelectEvent event) {
        this.tipoProducto = (TipoProducto) event.getObject();

        this.bloquearBotones = false;
        RequestContext.getCurrentInstance().update("tipoProducto-form:dtTipoProducto");
        RequestContext.getCurrentInstance().update("tipoProducto-form:dtTipoProducto:botonEditar");

    }

    public void actionClean(ActionEvent actionEvent) {

        this.tipoProducto = new TipoProducto();
        RequestContext.getCurrentInstance().update("tipoProducto-form:dtTipoProducto");
    }

    public List<TipoProducto> getTipoProductoList() {
        return tipoProductoList;
    }

    public void setTipoProductoList(List<TipoProducto> tipoProductoList) {
        this.tipoProductoList = tipoProductoList;
    }

    public boolean isBloquearBotones() {
        return bloquearBotones;
    }

    public void setBloquearBotones(boolean bloquearBotones) {
        this.bloquearBotones = bloquearBotones;
    }

    public TipoProducto getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(TipoProducto tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    public TipoProductoManager getTipoProductoMgr() {
        return tipoProductosMgr;
    }

    public void setTipoProductoMgr(TipoProductoManager tipoProductosMgr) {
        this.tipoProductosMgr = tipoProductosMgr;
    }
    
}
