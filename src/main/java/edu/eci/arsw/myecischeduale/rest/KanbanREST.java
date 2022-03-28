package edu.eci.arsw.myecischeduale.rest;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import edu.eci.arsw.myecischeduale.model.KanbanColumn;
import edu.eci.arsw.myecischeduale.service.KanbanService;

@RestController
@RequestMapping("/api/kanban")
public class KanbanREST {
    
    @Autowired
    private KanbanService kanbanService;

    @RequestMapping(value ="/pagina")
    public ModelAndView index (){
        System.out.println("ENTRO");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("kanbanView.html");
        return modelAndView;
    }

    @RequestMapping(value = "/{kanbanId}",method = RequestMethod.GET)
    private ResponseEntity<?> getKanbanById(@PathVariable("kanbanId") String kanbanId){
        try {
            ArrayList<KanbanColumn> defaultData = new ArrayList<>();
            String[] pendienteItems = {"Terminar drag & drop", "Implementar concurrencia"};
            String[] enProgresoItems = {"Crear controlador rest", "Crear vista"};
            String[] terminadoItems = {"Crear modelo y tablas"};
            KanbanColumn pendiente = new KanbanColumn(Long.valueOf("1"), "pendiente", pendienteItems);
            KanbanColumn enProgreso = new KanbanColumn(Long.valueOf("2"), "enProgreso", enProgresoItems);
            KanbanColumn terminado = new KanbanColumn(Long.valueOf("3"), "terminado", terminadoItems);
            defaultData.add(pendiente);
            defaultData.add(enProgreso);
            defaultData.add(terminado);
            return new ResponseEntity<>(defaultData, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
