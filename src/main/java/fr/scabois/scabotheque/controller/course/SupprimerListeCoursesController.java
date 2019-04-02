package fr.scabois.scabotheque.controller.course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fr.scabois.scabotheque.bean.Course;
import fr.scabois.scabotheque.enums.PageType;
import fr.scabois.scabotheque.services.IServiceListeCourses;

@Controller
public class SupprimerListeCoursesController {

    @Autowired
    private IServiceListeCourses service;

    @RequestMapping(value="/afficherSuppressionListeCourses", method = RequestMethod.GET)
    public String afficher(final ModelMap pModel) {
        final List<Course> lListeCourses = service.rechercherCourses();
        
        pModel.addAttribute("pageType", PageType.SUPPRESSION_COURSES);
        pModel.addAttribute("listeCourses", lListeCourses);
        return "suppression";
    }

    @RequestMapping(value="/supprimerSuppressionListeCourses", method = RequestMethod.GET)
    public String supprimer(@RequestParam(value="idCourse") final Integer pIdCourse, final ModelMap pModel) {

        service.supprimerCourse(pIdCourse);
        
        pModel.addAttribute("pageType", PageType.SUPPRESSION_COURSES);
        return afficher(pModel);
    }
}